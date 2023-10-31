package com.example.oceandb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oceandb.model.FileUploadModel;

public interface FileUploadRepository extends JpaRepository<FileUploadModel, Long> {

}
