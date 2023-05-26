package com.javaex.vo;

import java.sql.Date;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class GuestBookVO {

	private String name;
	private String pwd;
	private String content;
	private Date regDate;
	private int boardId;
}
