package com.example.demo.helper;

import com.example.demo.models.Mahasiswa;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    static String[] HEADERs ={"id","nim","nama","alamat"};
    static String SHEET = "Mahasiswa";
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Mahasiswa> mahasiswas;

    private void writeHeaderRow(){
        Row headerRow = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont fontBold = workbook.createFont();
        fontBold.setBold(true);
        style.setFont(fontBold);

        for(int col=0;col<HEADERs.length;col++){
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(HEADERs[col]);
            cell.setCellStyle(style);
        }
    }

    private void writeDataRows(){
        int rowIdx =1;
        for(Mahasiswa mhs : mahasiswas){
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(mhs.getId());
            sheet.autoSizeColumn(0);
            row.createCell(1).setCellValue(mhs.getNim());
            sheet.autoSizeColumn(1);
            row.createCell(2).setCellValue(mhs.getNama());
            sheet.autoSizeColumn(2);
            row.createCell(3).setCellValue(mhs.getAlamat());
            sheet.autoSizeColumn(3);
        }
    }

    public void MahasiswaToExcel(HttpServletResponse response) throws IOException{
        writeHeaderRow();
        writeDataRows();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public ExcelHelper(List<Mahasiswa> mahasiswas) {
    this.mahasiswas = mahasiswas;
    workbook = new XSSFWorkbook();
    sheet = workbook.createSheet("Mahasiswa");
}
    public static boolean hasExcelFormat(MultipartFile file) {
        if(!TYPE.equals(file.getContentType())){
            return false;
        }
        return true;
    }

    public static List<Mahasiswa> excelToMahasiswa(InputStream is) {
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
            int rowNumber = 0;
            while(rows.hasNext()) {
                Row currentRow = rows.next();
                //Untuk skip header
                if (rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Mahasiswa mahasiswa = new Mahasiswa();
                int cellIdx = 0;
                while(cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            mahasiswa.setNim(currentCell.getStringCellValue());
                            break;
                        case 1:
                            mahasiswa.setNama(currentCell.getStringCellValue());
                            break;
                        case 2:
                            mahasiswa.setAlamat(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                mhs.add(mahasiswa);
            }
            workbook.close();
            return mhs;
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse Excel file: " + e.getMessage());
        }
    }
}
