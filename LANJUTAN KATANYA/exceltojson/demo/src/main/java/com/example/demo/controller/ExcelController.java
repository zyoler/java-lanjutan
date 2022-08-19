package com.example.demo.controller;

import com.example.demo.helper.ExcelHelper;
import com.example.demo.message.ResponseMessage;
import com.example.demo.models.Mahasiswa;
import com.example.demo.repositories.MahasiswaRepository;
import com.example.demo.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ExcelController {
    @Autowired
    ExcelService excelService;

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @PostMapping("/uploadExcel")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) {
        String message = "";
        if(ExcelHelper.hasExcelFormat(file)) {
            try {
                excelService.save(file);
                message = "Uploaded the file succesfully " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e){
                message = "Could not upload the file " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/downloadExcel")
    public void downloadExcel(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
        String headerKey= "Content-Disposition";
        String headerValue = "attachment;filename=mahasiswa.xlsx";
        response.setHeader(headerKey,headerValue);

        List<Mahasiswa> mhs = mahasiswaRepository.findAll();
        ExcelHelper excelHelper = new ExcelHelper(mhs);
        excelHelper.MahasiswaToExcel(response);
    }

}
