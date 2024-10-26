package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="D:\\Debabrata Rout\\Eclipse Workplace\\AuditGeniusExternal\\testData\\loginData-AuditGenius.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);//32.15
		
		int totalRows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getColumnCount("Sheet1",1);
		
		String loginData[][]=new String[totalRows][totalcols];
		
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;i<totalRows;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

}
