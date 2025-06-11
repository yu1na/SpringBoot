package com.edu.springboot.lombok;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.AllArgsConstructor;
import lombok.Data;

//@Getter
//@Setter
//@AllArgsConstructor
@Data
public class MemberDTO
{
	private String id;
	private String pass;
	private String name;
	private String regidate;
}
