package org.example.services;

import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FilesService {
    public Resource getFile(){
        return new AbstractResource() {
            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public InputStream getInputStream()  {
                return Thread.currentThread().getContextClassLoader().getResourceAsStream("files/PDF.pgd");
            }
        };
    }

}
