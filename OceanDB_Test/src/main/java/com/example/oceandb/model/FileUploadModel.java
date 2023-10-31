package com.example.oceandb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class FileUploadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    // 생성자, 게터, 세터
    
    @ManyToOne
    @JoinColumn(name = "ocean_id")
    private Ocean ocean;

    
}
