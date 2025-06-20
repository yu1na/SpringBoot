package com.edu.springboot.lombok;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Setter;
//import lombok.Getter;
import lombok.Data;

@Data
//@Getter
//@Setter
//@AllArgsConstructor
public class MemberDTO
{
	private String id;
	private String pass;
	private String name;
	private String regidate;
}
