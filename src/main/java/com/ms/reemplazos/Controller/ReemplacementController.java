package com.ms.reemplazos.Controller;

import com.ms.reemplazos.Models.response.DatosExcelReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ReemplacementController {

    @PostMapping ("/reemplazos/upload")
    ResponseEntity<List<DatosExcelReponse>> upload (@RequestParam("file") MultipartFile file) throws IOException;
}
