package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	static Object[][] vv;
	static String[][] Values;
ArrayList<String> list=new ArrayList<String>();
	public static  Object[][] Getexcel(String filename,String sheetname,String testcase) throws IOException
	//public static void main(String args[]) throws IOException
	{
		FileInputStream fis=new FileInputStream(filename);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheetcount=workbook.getNumberOfSheets();
		int j=0;
		int column=0;
		for(int i=0;i<sheetcount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetname))
		 	{
				
				XSSFSheet sheetid=workbook.getSheetAt(i);
				Iterator<Row> firstrow=sheetid.rowIterator();
				Row firstrowvalue=firstrow.next();
				Iterator<Cell> cells=firstrowvalue.cellIterator();
				
				while(cells.hasNext())
				{
					Cell cellvalue=cells.next();
					if(cellvalue.getStringCellValue().equalsIgnoreCase("testcasename"))
					{
						column=j;
					}
					j++;
				}
			
				while(firstrow.hasNext())
				{
					Row rowvalue=firstrow.next();
					if(rowvalue.getCell(column).getStringCellValue().equalsIgnoreCase(testcase))
					{
						Iterator<Cell> cellvalues=rowvalue.cellIterator();
						Cell c=cellvalues.next();
						while(cellvalues.hasNext())
						{
							Cell cell=cellvalues.next();
							String Values=cell.getStringCellValue();
							String[] rows = Values.split(" ");
							String[][] matrix = new String[rows.length][]; 
						    int r = 0;
						    for (String row : rows) {
						        matrix[r++] = row.split("\\	");
						    }
						   Object vv=(Object) Arrays.deepToString(matrix);
							//a=(Object[][]) values;
						   // System.out.println(a);	
						
						}
					}
				}
				
			}
		}
		//return a;
		return vv;
		
		
	}
	
}
