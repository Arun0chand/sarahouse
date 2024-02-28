package apachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practicse {
	XSSFWorkbook workbook;
	

	String path="";
	
    public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException {
    	
    	//if file not exists then create the file
    	File xlfile=new File(path);
    	if(!xlfile.exists()) {
    		
    		workbook=new XSSFWorkbook();
    		FileOutputStream fo=new FileOutputStream(path);
    		workbook.write(fo);
    	}
    	
    	FileInputStream fi=new FileInputStream(path);
    	workbook=new XSSFWorkbook(fi);
    	
    	//If sheet not exists
    	
    	if(workbook.getSheetIndex(sheetName)==-1)
    		workbook.createSheet(sheetName);
    XSSFSheet	sheet=workbook.getSheet(sheetName);
     
    
    if(sheet.getRow(rownum)==null) {
    	sheet.createRow(rownum);
    	XSSFRow row=sheet.getRow(rownum);
    	
    }
    	
	
	
	
	}
}
	
