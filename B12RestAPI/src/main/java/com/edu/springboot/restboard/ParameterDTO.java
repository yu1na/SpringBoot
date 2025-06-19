package com.edu.springboot.restboard;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ParameterDTO
{
	//일련번호와 페이지번호
	private String num;
	private String pageNum;
	//검색어 관련 멤버변수 
	private String searchField;
	private ArrayList<String> searchWord;
	//각페이지 구간
	private int start;
	private int end;
	
}
