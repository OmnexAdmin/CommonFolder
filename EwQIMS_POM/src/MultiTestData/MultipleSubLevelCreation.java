package MultiTestData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class MultipleSubLevelCreation extends ProjectMethods {
	
	@BeforeClass
	public void setData() {
		excelName = "MultipleTestData";
		dataSheetName = "SubLevelTestData";
		testCaseName = "Create Multiple Sub Levels";
		testDescription = "Create child Levels";
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData")
	
	public void createChildLevels(String userName, String passWord,String searchCriteria,String levelName,String subLevelName,String subPrefix,String subReviewDue) throws Throwable {
		

		new LoginPage(driver,test)
		.login(userName, passWord)
		
		.clickOnLevelsMenu()
		.createSubLevels(searchCriteria, levelName,subLevelName, subPrefix, subReviewDue);
		
		
		
	}
	

}
