package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.services.FilesService;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Tag(name = "работа с файлами")
@RequiredArgsConstructor
public class FileController {

    private FilesService filesService;

//    public FileController(FilesService filesService) {
//        this.filesService = filesService;
//    }
//
//    public FilesService getFilesService(){
//        return filesService;
//   }

    @Operation(summary = "Скачивание файла")
    @GetMapping(value = "files", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getFile() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(
                ContentDisposition.builder("inline")
                        .filename("pdf.pdf")
                        .build()
        );
        return ResponseEntity.ok().headers(headers).body(filesService.getFile());
    }

    @Operation(summary = "Загрузка файлов")
    @PostMapping(value = "files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFiles(@RequestPart("file1") MultipartFile file1, @RequestPart("file2") MultipartFile file2) {
        return "Загружены файлы" + file1.getResource().getFilename() + ", " + file2.getResource().getFilename();
    }
}

