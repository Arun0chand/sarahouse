package apachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	String path="";
	
	Utility(String path){
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException {
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		XSSFRow row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
	}
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException {
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		XSSFRow row=sheet.getRow(rownum);
		XSSFCell cell=row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e){
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		
	}
	
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException {
		
		File xlfile=new File(path);
		if(!xlfile.exists()) {
			System.out.println("File not found");
			workbook =new XSSFWorkbook();
			FileOutputStream fo=new FileOutputStream(path);//If file not exist then create new file
			workbook.write(fo);
			}
			
			FileInputStream fi=new FileInputStream(path);
			 workbook=new XSSFWorkbook(fi);
			 
		if(workbook.getSheetIndex(sheetName)==-1) //if sheet not exists then create new sheet
		   workbook.createSheet(sheetName);
		   XSSFSheet sheet =workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null) //if row not exist then create the new row
			sheet.createRow(rownum);
			row=sheet.getRow(rownum);
			
		
		XSSFCell cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		FileOutputStream fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
	}
	

}
