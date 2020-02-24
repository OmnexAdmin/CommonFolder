package CommonMethods;


	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Parameters;

	import Utilities.ExcelDataProvider;

	public class ProjectMethods extends SeMethods{
		
		public String browserName;
		public String dataSheetName;
		public String excelName;
		@BeforeSuite
		public void beforeSuite(){
			startResult();
			System.out.println("Before suite ");
		}

		@BeforeTest
		public void beforeTest(){
		}
		
	@BeforeMethod 
		public void beforeMethod(){
			//test = startTestCase(testCaseName, testDescription);
		System.out.println("before method1");	
		test.assignCategory(category);
			test.assignAuthor(authors);
			System.out.println("before method2");	
			startApp(browserName);
			
		}
			
		@AfterSuite
		public void afterSuite(){
			endResult();
		}

		@AfterTest
		public void afterTest(){
		}
		
	@AfterMethod
		public void afterMethod(){
			endTestcase();
			endResult();
			closeAllBrowsers();		
		}
		
		@DataProvider(name="fetchData")
		public  Object[][] getData(){
			//return ExcelDataProvider.getData(dataSheetName);
			//return ExcelDataProvider.getData(excelName);
			return ExcelDataProvider.getData(excelName,dataSheetName);
		}	
		
	}



