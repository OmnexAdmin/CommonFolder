package TestCases;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class BasicSuiteFunctionality extends ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "DocProTestData";
		dataSheetName="TC001to5";
		test = startTestCase("Browser Invoked", "TC Execuion");
		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData")

	public void login(String TestcaseNumber,String Runmode,String Scenario, String userName, String passWord, String code,
			String fName, String lName, String eMail, String uName, String pwd, String confirmPassword)
			throws Throwable {

		testCaseName = Scenario  ;
		testDescription =TestcaseNumber ;
		test = startTestCase(testCaseName, testDescription);
		
		if(!Runmode.contains("Y")) {
			throw new SkipException("Run mode set as No");
		}
		
		
		switch (TestcaseNumber) {

		case "TC001":
		
			new LoginPage(driver, test).login(userName, passWord);
			break;

		case "TC002":
			new LoginPage(driver, test).invalidLogin(userName, passWord);
			break;

		case "TC003":
			new LoginPage(driver, test).login(userName, passWord).clickOnUersTab().clickOnUsersMenu().addUsers(code,
					fName, lName, eMail, uName, pwd, confirmPassword);
			break;

		case "TC004":
			new LoginPage(driver, test).login(userName, passWord).clickOnModuleAdminMenu().setUserAsModuleAdmin(code);
			break;
			
		case "TC004A":
			new LoginPage(driver, test).login(userName, passWord).clickOnSuiteAdminMenu().setUserAsSuiteAdmin(code);
			break;

		case "TC005":
			new LoginPage(driver, test).login(userName, passWord).clickOnUersTab().clickOnUserPrefrencesMenu()
					.setDocProasLandingPage();
			break;

		default:
			break;

		}

	}

}
