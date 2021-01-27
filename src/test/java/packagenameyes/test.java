package packagenameyes;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageActions.LandingPage;
import testBase.Baseclass;

public class test extends Baseclass {
	/*@DataProvider(name="Zhunzar")
	public Object[][] gg() throws IOException
	{
		
		//s=s+data;
		return data;
	}*/
	Table_text t=new Table_text();
	
	
	
	  ArrayList<String> data;  	
	    //return data;
	String s="";
	@Test
	public void test12() throws IOException
	{
		LandingPage lp=new LandingPage(driver);
		
		data=t.Getexcel("C:\\testdata.xlsx","Sheet1","classmap");
		String d=data+s;
		/*//System.out.println(d);
		String[] a=d.split(",");
		System.out.println(a[2]);*/
		//t.display(d);
		System.out.println(d);
	}

}
