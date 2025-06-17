package com.edu.springboot;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import utils.MyFunctions;

@Controller
public class MainController
{
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}

	@GetMapping("/fileUpload.do")
	public String fileUpload()
	{
		return "fileUpload";
	}

	@PostMapping("/uploadProcess.do")
	public String uploadProcess(HttpServletRequest req, Model model)
	{
		try
		{
			String uploadDir = ResourceUtils.getFile("classpath:static/uploads/").toPath().toString();
			System.out.println("물리적 경로:" + uploadDir);

			Part part = req.getPart("ofile");
			String partHeader = part.getHeader("content-disposition");
			System.out.println("partHeader=" + partHeader);
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			if (!originalFileName.isEmpty())
			{
				part.write(uploadDir + File.separator + originalFileName);
			}
			String savedFileName = MyFunctions.renameFile(uploadDir, originalFileName);

			model.addAttribute("originalFileName", originalFileName);
			model.addAttribute("savedFileName", savedFileName);
			model.addAttribute("title", req.getParameter("title"));
			model.addAttribute("cate", req.getParameterValues("cate"));
		} catch (Exception e)
		{
			System.out.println("업로드 실패");
		}

		return "fileUploadOk";
	}

		@GetMapping("/multiFileUpload.do") 
		public String multiFileUpload() 
		{ 
			return "multiFileUpload"; 
		}
	
   @PostMapping("/multiUploadProcess.do")
   public String multiUploadProcess(HttpServletRequest req, Model model)
   {
	try
	{
		String uploadDir = ResourceUtils
				.getFile("classpath:static/uploads/").toPath().toString();
		System.out.println("물리적 경로:" +uploadDir);
		
		Map<String, String> saveFileMaps = new HashMap<>();
		
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			if(!part.getName().equals("ofile"))
				continue;
			
			String partHeader = part.getHeader("content-disposition");
			System.out.println("partHeader="+ partHeader);
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			if (!originalFileName.isEmpty())
			{
				part.write(uploadDir+ File.separator +originalFileName);
			}
			String savedFileName = MyFunctions.renameFile(uploadDir,
					originalFileName);
			saveFileMaps.put(originalFileName, savedFileName);
		}
		model.addAttribute("saveFileMaps", saveFileMaps);
		model.addAttribute("title", req.getParameter("title"));
		model.addAttribute("cate", req.getParameterValues("cate"));
	} catch (Exception e)
	{
		System.out.println("업로드 실패");
	}
	   return "multiFileUploadOk";
   }
}
