package com.example.oceandb.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.oceandb.model.FileUploadModel;
import com.example.oceandb.repository.FileUploadRepository;

@Service
public class FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepository;

    public void saveFile(MultipartFile file) throws IOException {
        // 파일 저장 로직
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileUploadModel fileModel = new FileUploadModel();
        fileUploadRepository.save(fileModel);
    }
}