package packagenameyes;

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

public class Table_text {
	static Object[][] vv;
	static String[][] Values;
	String total;
	//static Object[][] total="";
	String value="";
	//String cellvalue;
    String cellvalue=null;
	public ArrayList<String> Getexcel(String filename,String sheetname,String tablename) throws IOException
	//public static void main(String args[]) throws IOException
	{
		
		ArrayList<String> list=new ArrayList<String>();
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
				sheetid.getLastRowNum();
		
				Iterator<Row> firstrow=sheetid.rowIterator();
				
				Row firstrowvalue=firstrow.next();
				Iterator<Cell> cells=firstrowvalue.cellIterator();
			
				while(cells.hasNext())
				{
					Cell cellvalue=cells.next();
					if(cellvalue.getStringCellValue().equalsIgnoreCase("FirstName"))
					{
						column=j;
					}
					j++;
				}
			
				while(firstrow.hasNext())
				{
					Row rowvalue=firstrow.next();
					//int rowcount=rowvalue.getRowNum();
					if(rowvalue.getCell(column).getStringCellValue().equalsIgnoreCase(tablename))
					{
						Iterator<Cell> cellvalues=rowvalue.cellIterator();
						
						Cell c=cellvalues.next();
						while(cellvalues.hasNext())
						{
							Cell cell=cellvalues.next();
							//Cell cell1=cellvalues.next();
				
							String cellvalue=cell.getStringCellValue();
							list.add(cellvalue);
							
						}
					
					}
				}
				
			}
		}
		
		return list;
		
		
	}

	public void display(String s)
	{
		String[] s1=s.split(",");
		System.out.println(s1[3]);
	}
	
	
}


