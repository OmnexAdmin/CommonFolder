package Utilities;



	import java.io.File;
import java.io.FileInputStream;

	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.DataProvider;

	public class ExcelDataProvider{
		@DataProvider(name="fetchData")

		public static String[][] getData(String excelName, String dataSheetName) {

			String[][] data = null ;
		

			try {
				//FileInputStream fis = new FileInputStream("D:\\Bhuvana\\Selenium\\EwQIMS_POM\\src\\main\\java\\data\\Book1.xlsx");
				
				String path = System.getProperty("user.dir");
				
				System.out.println("the path of the excel sheet is"+path);
				
				FileInputStream fis = new FileInputStream(path+"\\data\\"+excelName+".xlsx");
				
				System.out.println("the excel name is"+excelName);
				
				
				//FileInputStream fis = new FileInputStream("D:/Bhuvana/Bhuvana/Selenium/EwQIMS_POM/src/main/java/data/"+dataSheetName+".xlsx");
				
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				//XSSFSheet sheet = workbook.getSheetAt(0);	
				if (dataSheetName == null) {
					   throw new IllegalArgumentException("No sheet exists with name " + dataSheetName);
					}
				XSSFSheet sheet = workbook.getSheet(dataSheetName);
			
				
				System.out.println("the excel sheet name is "+dataSheetName);

				// get the number of rows
				int rowCount = sheet.getLastRowNum();
			
				// get the number of columns
				int columnCount = sheet.getRow(0).getLastCellNum();
				data = new String[rowCount][columnCount];


				// loop through the rows
				for(int i=1; i <rowCount+1; i++){
					try {
						XSSFRow row = sheet.getRow(i);
						for(int j=0; j <columnCount; j++){ // loop through the columns
							try {
								String cellValue = "";
								try{
									cellValue = row.getCell(j).getStringCellValue();
								}catch(NullPointerException e){

								}

								data[i-1][j]  = cellValue; // add to the data array
							} catch (Exception e) {
	 							e.printStackTrace();
							}				
						}

					} catch (Exception e) {
	 					e.printStackTrace();
					}
				}
				fis.close();
				workbook.close();
			} catch (Exception e) {
	 			e.printStackTrace();
			}

			return data;
		
			
		}

	}



