package com.dailycodework.excel2database.service.impl;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.dailycodework.excel2database.service.servicexcel;

@Service
public class ServiceExcelImp implements servicexcel{

	@Override
	public void CreateExcelFile() {
		// TODO Auto-generated method stub
		try   
		{  
		String filename = "C:\\Users\\chris\\Desktop\\ELK$\\CustomersDetail.xlsx";  
		FileOutputStream fileOut = new FileOutputStream(filename);  
		fileOut.close();  
		System.out.println("Excel file has been generated successfully.");  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}
	}

	@Override
	public void CreateExcelFileWithCell() {
		// TODO Auto-generated method stub
		
		try   
		{  
			// déclare le nom du fichier à créer   
		String filename = "C:\\Users\\chris\\Desktop\\ELK$\\Balance.xlsx";  
		// création d'une instance de la classe HSSFWorkbook  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//invoquer la méthode creatSheet() et transmettre le nom de la feuille à créer   
		HSSFSheet sheet = workbook.createSheet("January");   
		// création de la 0ème ligne à l'aide de la méthode createRow()  
		HSSFRow rowhead = sheet.createRow((short)0);  
		// création de cellule à l'aide de la méthode createCell() et définition des valeurs de la cellule à l'aide de la méthode setCellValue()  
 
		rowhead.createCell(0).setCellValue("S.No.");  
		rowhead.createCell(1).setCellValue("Customer Name");  
		rowhead.createCell(2).setCellValue("Account Number");  
		rowhead.createCell(3).setCellValue("e-mail");  
		rowhead.createCell(4).setCellValue("Balance");  
		// création de la 1ère ligne   
		HSSFRow row = sheet.createRow((short)1);  
		//insertion de données dans la première ligne  
		row.createCell(0).setCellValue("1");  
		row.createCell(1).setCellValue("John William");  
		row.createCell(2).setCellValue("9999999");  
		row.createCell(3).setCellValue("william.john@gmail.com");  
		row.createCell(4).setCellValue("700000.00");  
		// création de la 2ème ligne   
		HSSFRow row1 = sheet.createRow((short)2);  
		//insertion de données dans la deuxième ligne   
		row1.createCell(0).setCellValue("2");  
		row1.createCell(1).setCellValue("Mathew Parker");  
		row1.createCell(2).setCellValue("22222222");  
		row1.createCell(3).setCellValue("parker.mathew@gmail.com");  
		row1.createCell(4).setCellValue("200000.00");  
		FileOutputStream fileOut = new FileOutputStream(filename);  
		workbook.write(fileOut);  
		//fermeture du flux  
		fileOut.close();  
		//fermeture du classeur
		workbook.close();  
		// imprime le message sur la console  
		System.out.println("Excel file has been generated successfully.");  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		} 
		
	}

}
