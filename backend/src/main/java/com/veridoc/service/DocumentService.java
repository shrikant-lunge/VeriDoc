package com.veridoc.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.veridoc.entity.DocumentEntity;
import com.veridoc.repository.DocumentRepository;
import com.veridoc.utility.HashCodeGenerator;

@Service
public class DocumentService 
{
	private final DocumentRepository repository;
	
	private DocumentEntity doc = new DocumentEntity();

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }
    
    public DocumentEntity upload (MultipartFile file) throws Exception
    {
  
    	String hashCode = HashCodeGenerator.sha256(file.getBytes());
    	String verificationCode = UUID.randomUUID().toString();
    	
    	doc.setFileName(file.getOriginalFilename());
    	doc.setHashCode(hashCode);
    	doc.setVerificationCode(verificationCode);
    	return repository.save(doc);
    }
    
    public boolean verify(MultipartFile file, String verificationCode) throws Exception
    {
    	DocumentEntity  doc = repository.findByVerificationCode(verificationCode).orElseThrow(()-> new RuntimeException("Error occured"));
    	String hashCode = HashCodeGenerator.sha256(file.getBytes());
    
    	return hashCode.equals(doc.getHashCode());
    }
}
