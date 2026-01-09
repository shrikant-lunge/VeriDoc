package com.veridoc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veridoc.entity.DocumentEntity;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long>
{

	Optional<DocumentEntity> findByVerificationCode(String verificationCode);
}
