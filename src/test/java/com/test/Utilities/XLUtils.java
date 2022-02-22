package com.test.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFRow r;
	public static XSSFWorkbook wb;
	public static XSSFCell cell;
	public static XSSFSheet Sheet;
	
	public static int getRowCount(String file,String sheet) throws IOException {
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		Sheet=wb.getSheet(sheet);
		int rc=Sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rc;		
	}
	public static int getCellCount(String file,String sheet,int rc) throws IOException {
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		Sheet=wb.getSheet(sheet);
		r=Sheet.getRow(rc);
		int cc=r.getLastCellNum();
		wb.close();
		fi.close();
		return cc;		
	}
	public static String getCellData(String file,String sheet,int rc,int cc) throws IOException{
		String data;
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		Sheet=wb.getSheet(sheet);
		r=Sheet.getRow(rc);
		cell=r.getCell(cc);
		DataFormatter formatter=new DataFormatter();
		data=formatter.formatCellValue(cell);
		return data;
		
	}
}
