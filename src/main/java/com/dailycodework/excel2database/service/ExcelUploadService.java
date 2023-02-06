package com.dailycodework.excel2database.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dailycodework.excel2database.domain.Customer;
import com.dailycodework.excel2database.domain.Users;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ExcelUploadService {
	

	
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
    }
   public static List<Users> getCustomersDataFromExcel(InputStream inputStream){
        List<Users> customers = new ArrayList<>();
       try {
           XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//           XSSFSheet sheet = workbook.getSheet("customers");
           XSSFSheet sheet = workbook.getSheetAt(0);
           int rowIndex =0;
           for (Row row : sheet){
               if (rowIndex ==0){
                   rowIndex++;
                   continue;
               }
               Iterator<Cell> cellIterator = row.iterator();
               int cellIndex = 0;
               Users customer = new Users();
               while (cellIterator.hasNext()){
                   Cell cell = cellIterator.next();
               
              
                  
                   switch (cellIndex){
                  
                   case 0 ->customer.setId((int) cell.getNumericCellValue());
                       case 1 -> customer.setUsername(cell.getStringCellValue());
                      
                       case 3 -> customer.setPassword(cell.getStringCellValue());
                     
                       default -> {
                       }
                   }
                   cellIndex++;
               }
         
            
               customers.add(customer);
           }
       } catch (IOException e) {
           e.getStackTrace();
       }
       return customers;
   }

}
