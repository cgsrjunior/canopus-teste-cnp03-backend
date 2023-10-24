package com.example.uploadingfiles.service;

import com.example.uploadingfiles.entity.FileData;
import com.example.uploadingfiles.repo.FileDataRepository;
import com.example.uploadingfiles.util.FileUtil;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileDataService {

    @Autowired
    private FileDataRepository fileDataRepository;

    @SuppressWarnings("rawtypes")
    public FileUploadResponse uploadImage(MultipartFile file) throws IOException {
        fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(FileUtil.compressImage(file.getBytes())).build());

        return new FileUploadResponse("Image uploaded successfully: " +
                file.getOriginalFilename());

    }

    @Transactional
    public FileData getInfoByImageByName(String name) {
        Optional<FileData> dbImage = fileDataRepository.findByName(name);

        return FileData.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .fileData(FileUtil.decompressImage(dbImage.get().getFileData())).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<FileData> dbImage = fileDataRepository.findByName(name);
        byte[] image = FileUtil.decompressImage(dbImage.get().getFileData());
        return image;
    }


    public class FileUploadResponse<T> {
        public FileUploadResponse(String s) {
        }
    }
}