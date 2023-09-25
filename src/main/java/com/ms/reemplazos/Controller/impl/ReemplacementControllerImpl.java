package com.ms.reemplazos.Controller.impl;

import com.ms.reemplazos.Controller.ReemplacementController;
import com.ms.reemplazos.Models.response.DatosExcelReponse;
import com.ms.reemplazos.Service.RemplacementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ReemplacementControllerImpl implements ReemplacementController {
    private final RemplacementService service;

    public ReemplacementControllerImpl(RemplacementService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<List<DatosExcelReponse>> upload(MultipartFile file) throws IOException {

    List<DatosExcelReponse> datosExcelReponseList = service.upload(file);
    return new ResponseEntity<>(datosExcelReponseList, HttpStatus.OK);
    }
}
