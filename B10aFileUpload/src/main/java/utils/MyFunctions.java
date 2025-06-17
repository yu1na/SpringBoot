package utils;

import java.io.File;
import java.util.UUID;

public class MyFunctions
{
	public static String getuuid()
	{
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된 UUID:" + uuid);
		return uuid;
	}
	
	public static String renameFile(String sDirectory, String fileName)
	{
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = getuuid();
		String newFileName = now + ext;
		
		File oldFile = 
				new File(sDirectory + File.separator + fileName);
		File newFile = 
				new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		return newFileName;
	}
}