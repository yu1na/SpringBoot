package com.edu.springboot.bean1;

//데이터 저장 기능만 있는 일반적인 DTO클래스 
public class Person
{
	//멤버변수
	private String name;
	private int age;
	private NoteBook notebook;
	
	//생성자(디폴트, 인수)
	public Person(){}
	public Person(String name, int age, NoteBook notebook)
	{
		super();
		this.name = name;
		this.age = age;
		this.notebook = notebook;
	}
	
	//게터, 세터 
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public NoteBook getNotebook()
	{
		return notebook;
	}
	public void setNotebook(NoteBook notebook)
	{
		this.notebook = notebook;
	}
	
	//toString() 메서드 오버라이딩 
	@Override
	public String toString()
	{
		return "Person [name="+name+", age="+age+", notebook="+notebook+"]";
	}
	
	
}
