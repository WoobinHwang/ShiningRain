package com.mysite.sr.Board;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BoardList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boardNum;
	
	private Integer writerNum;
	
	private String boardTitle;
	
	private String boardContent;
	
	
	
}
