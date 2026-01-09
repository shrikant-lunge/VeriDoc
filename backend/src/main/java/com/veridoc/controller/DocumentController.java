package com.veridoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.veridoc.entity.DocumentEntity;
import com.veridoc.service.DocumentService;

@RestController
@RequestMapping("/veridoc")
public class DocumentController 
{

	@Autowired 
	private DocumentService service;
	
	
	@PostMapping("/upload")
	public DocumentEntity upload(@RequestParam("document") MultipartFile file) throws Exception
	{
		return service.upload(file);
	}
	
	@PostMapping("/verify/{code}")
	public String verify(@RequestParam("document") MultipartFile file,@PathVariable String code) throws Exception
	{
		return service.verify(file, code) ? "Valid file":"Tampered file";
	}
	
}
