package com.ms.reemplazos.Service.impl;

import com.ms.reemplazos.Models.response.DatosExcelReponse;
import com.ms.reemplazos.Service.RemplacementService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReemplacementImpl implements RemplacementService {

    @Override
    public List<DatosExcelReponse> upload(@RequestParam("file") MultipartFile file) throws IOException {

        List<DatosExcelReponse> excelDataList = new ArrayList<>();

        if (file.isEmpty()) {
            return excelDataList;
        }

        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // Ignorar la fila de encabezado
                    continue;
                }

                DatosExcelReponse excelData = new DatosExcelReponse();
                excelData.setApellidoNombreReemplazante(row.getCell(0).getStringCellValue());
                excelData.setCUIL(row.getCell(1).getStringCellValue());
                // Asigna otros campos según la estructura de tu archivo Excel

                excelDataList.add(excelData);
            }
        }

        return excelDataList;
    }

}
