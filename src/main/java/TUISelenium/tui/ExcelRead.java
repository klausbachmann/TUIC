package TUISelenium.tui;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class ExcelRead {

	public static void readXLS() throws Exception{
		FileInputStream file = new FileInputStream(new File("testfile.xls"));
		
		HSSFWorkbook wb = new HSSFWorkbook(file);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		Iterator<Row> iterator = sheet.iterator();
		while( iterator.hasNext()){
			Row row = iterator.next();
			//Number i = row.getCell(0).getNumericCellValue();
			System.out.println("CELLTYPE:" + row.getCell(0).getCellType());
			
			int convertedNumber = 0;// i.intValue();
			System.out.println(convertedNumber+":"+row.getCell(1));
			//System.out.println(row.getCell(0).getNumericCellValue() +":"+ row.getCell(1).getStringCellValue());
		}
		
		wb.close();
		file.close();
	}
	
	public static void main(String[] args) {		
		try {
			readXLS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
