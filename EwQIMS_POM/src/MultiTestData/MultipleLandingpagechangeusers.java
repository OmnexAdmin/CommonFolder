package MultiTestData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class MultipleLandingpagechangeusers extends ProjectMethods {

	
	
	@BeforeClass
	 
	 public void setData() {
		
		excelName = "MultipleTestData";
		dataSheetName = "ParentLevelTestData";
		test = startTestCase("Smoketesttarts", "Brower launched successfully");
		//testCaseName = "TC008_UserPrefrenceChangeLandingPage";
		//testDescription = "Set Doc Pro module as landing page for the user";
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}
	
	 
	 
	@Test(dataProvider="fetchData")
  
	public void setDocAsLandingPage(String userName, String passWord) throws Throwable {
		
		new LoginPage(driver,test)
		.login(userName, passWord)
		.clickOnUersTab()
		.clickOnUserPrefrencesMenu()
		.setDocProasLandingPage();
	}
}
