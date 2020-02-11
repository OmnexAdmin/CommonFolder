package TestCases;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CommonMethods.ProjectMethods;
import Pages.LoginPage;

public class DocProBasicFunctionality extends ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "DocProTestData";
		dataSheetName="TC006to17";
		test = startTestCase("Browser Invoked", "TC Execuion");
		category= "Smoke";
		authors	="Bhuvana";
		browserName ="chrome";
	}

	@Test(dataProvider="fetchData",groups="smoke")

	public void createParentLevels(String TestcaseNumber,String Runmode,String Scenario, String userName, String passWord,String levelName,String prefix,String reviewDue,String searchCriteria,String subLevelName,String subPrefix,String subReviewDue,String documentNumber,String documentName,String attachment,String code,String groupName,String draftComments, String reasonForRequest,String changesRequired, String revision, String docOwner  ) throws Throwable {

		testCaseName = Scenario;
		testDescription =TestcaseNumber;
		test = startTestCase(testCaseName, testDescription);
		
		if(!Runmode.contains("Y")) {
			throw new SkipException("Run mode set as No");
		}

		switch(TestcaseNumber) {

		case"TC006":


			new LoginPage(driver,test)
			.login(userName, passWord)
			.clickOnLevelsMenu()
			.createParentLevels( levelName, prefix, reviewDue);
			break;

		case"TC007":


			new LoginPage(driver,test)
			.login(userName, passWord)
			.clickOnLevelsMenu()
			.createSubLevels(searchCriteria, levelName,subLevelName, subPrefix, subReviewDue);
			break;

		case "TC008":


			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickOnFolderManagement() 
			.inUseFolder(searchCriteria);
			break;


		case "TC009":


			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickOnGroupsMenu()
			.createAdminGroup(groupName, code);
			break;


		case "TC010":


			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickOnFolderManagement() 
			.setFolderRights(searchCriteria,groupName);
			break;


		case "TC011":


			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickonDocumentstab()
			.clickonNewDocumentRequestmenu()
			.uploadNewDocument(searchCriteria,documentNumber,documentName,attachment);
			break;

		case "TC012":


			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickonDocumentstab()
			.clickOnNewDocDraftmenu()
			.uploadNewDraft(searchCriteria,documentNumber,documentName,attachment,code) ;
			break;

		case "TC013":
			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickonDocumentstab()
			.clickOnActionsMenu()
			.draftRequestsNeedingViewing(documentName, attachment, draftComments);
			break;

		case "TC014":
			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickonDocumentstab()
			.clickOnActionsMenu()
			.pendingDocumentDrafts(documentName, attachment, reasonForRequest, changesRequired);
			break;
			
		case "TC015":
			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickonDocumentstab()
			.clickOnDocumentsMenu()
			.reviseDocument(levelName, documentNumber, attachment, reasonForRequest, changesRequired);
			break;
			
		case "TC016":
			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickonDocumentstab()
			.clickOnDocumentsMenu()
			.validateDocISRevised(levelName, documentNumber, documentName, revision, docOwner);	
			break;
			
		case "TC017":
			new LoginPage(driver,test)
			.moduleLandingPageLogin(userName, passWord)
			.clickonDocumentstab()
			.clickOnDocumentsMenu()
			.deleteDocument(levelName, documentNumber, reasonForRequest, changesRequired);
			break;
			
		default:
			break;



		}

	}


}
