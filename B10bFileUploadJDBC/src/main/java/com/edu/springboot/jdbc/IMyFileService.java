package com.edu.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMyFileService
{
	public int insertFile(MyFileDTO myFileDTO);
	public List<MyFileDTO> selectFile();
}
