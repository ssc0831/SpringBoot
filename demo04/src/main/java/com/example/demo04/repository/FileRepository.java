package com.example.demo04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo04.model.FileBoard;

public interface FileRepository extends JpaRepository<FileBoard, Long> {

}
