package com.veridoc.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "document")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntity 
{
	@Id
	private long id;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "verification_code")
	private String verificationCode;
	
	@Column(name = "hash_code")
	private String hashCode;
	
	@Column(name = "uploaded_at")
	private Date uploadedAt;
}
