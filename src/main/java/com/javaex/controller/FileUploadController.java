package com.javaex.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;
import com.javaex.vo.FileVO;

@Controller
@RequestMapping(value = "/fileupload")
public class FileUploadController {

	@Autowired
	public FileUploadService fileUploadService;

	@RequestMapping(value = "/form", method = { RequestMethod.GET, RequestMethod.POST })
	public String form() {
		System.out.println("form()");

		return "/fileupload/form";
	}

	@RequestMapping(value = "/fileupload", method = { RequestMethod.GET, RequestMethod.POST })
	public String fileupload(@RequestParam("file") MultipartFile file) {
		System.out.println("fileupload()");
		if (!file.isEmpty()) {
			try {
				// 파일을 저장하거나 처리하는 로직을 구현합니다.
				// 예를 들어, 파일을 특정 경로에 저장할 수 있습니다.
				String filePath = "C:/javaStudy/workspace/mysite/src/main/webapp/assets/image/"
						+ file.getOriginalFilename();
				file.transferTo(new File(filePath));
				fileUploadService.fileUpload("/assets/image/" + file.getOriginalFilename());
				System.out.println("File uploaded successfully!");

				// 파일 업로드 후에 추가로 수행할 작업을 여기에 구현합니다.
				// 예를 들어, 업로드된 파일을 데이터베이스에 저장하거나 추가적인 로직을 수행할 수 있습니다.

				// 여기서는 업로드된 파일의 정보를 반환하도록 설정합니다.
				return "redirect:/fileupload/result";
			} catch (IOException e) {
				// 파일 처리 중 예외가 발생한 경우 예외 처리 로직을 추가합니다.
				System.out.println("Error occurred while uploading file.");
				e.printStackTrace();
			}
		} else {
			// 업로드된 파일이 없는 경우에 대한 처리를 수행합니다.
			System.out.println("No file uploaded.");
		}

		// 파일 업로드가 실패하거나 예외가 발생한 경우에는 적절한 응답을 반환합니다.
		return "upload-failure";
	}

	@RequestMapping(value = "/result", method = { RequestMethod.GET, RequestMethod.POST })
	public String result(Model model) {
		System.out.println("result()");

		// List<FileVO> fileList = fileUploadService.getFileList();
		List<String> fileList = new ArrayList<>();

		String filePath1 = "/assets/image/김지원.jpg";
		String filePath2 = "/assets/image/b.png";
		fileList.add(filePath1);
		fileList.add(filePath2);

		if (!fileList.isEmpty()) {
			// 파일이 존재하는 경우, 파일 객체를 생성하여 모델에 추가합니다.
			List<File> files = new ArrayList<>();
			for (String filePath : fileList) {
				File file = new File(filePath);
				files.add(file);
			}
			model.addAttribute("files", files);
		} else {
			// 파일이 존재하지 않는 경우, 오류 메시지 등을 모델에 추가할 수 있습니다.
			model.addAttribute("error", "File not found.");
		}

		return "/fileupload/result";
	}
}
