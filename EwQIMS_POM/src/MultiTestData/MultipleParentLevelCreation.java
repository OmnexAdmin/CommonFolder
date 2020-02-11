package MultiTestData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class MultipleParentLevelCreation extends ProjectMethods {
	
	@BeforeClass
	public void setData() {
		excelName = "MultipleTestData";
		dataSheetName = "ParentLevelTestData";
		testCaseName = "Multiple Parent level creation";
		testDescription = "Create parent Levels";
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData")
	
	public void createParentLevels( String userName, String passWord,String levelName,String prefix,String reviewDue) throws Throwable {
		
		
	
		
	
		new LoginPage(driver,test)
		.login(userName, passWord)
		.clickOnLevelsMenu()
		.createParentLevels( levelName, prefix, reviewDue);
		
		
		
		
	}
	

}
