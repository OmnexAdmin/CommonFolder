package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class DummyTestcase extends ProjectMethods{
	
	@BeforeClass
	public void setData() {
		
		excelName = "TestingExcel";
		dataSheetName="TC009";

		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData",groups="regression")
	
	public void requestDraft(String userName, String passWord ,String levelName,String documentNumber,String attachment,String reasonForRequest, String changesRequired,String documentName,String revision,String docOwner) throws Throwable {
		
		testCaseName = "TC010 ";
		testDescription = "New draft request";
		test = startTestCase(testCaseName, testDescription);
		new LoginPage(driver,test)
		.moduleLandingPageLogin(userName, passWord)
		.clickonDocumentstab()
		.clickOnDocumentsMenu()
		.reviseDocument(levelName, documentNumber, attachment, reasonForRequest, changesRequired, documentName, revision, docOwner);
		
		
		
	}

}
