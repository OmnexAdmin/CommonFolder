package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class NewDocumentsRequest extends ProjectMethods {
	


	
	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private WebElement eleFrame;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSelectLevel']")
	private WebElement eleClickOnSelectLevelButton;
	

	@FindBy(how=How.ID,using="ifrpopuplevel")
	private WebElement eleLevelPopupFrame;
	
	@FindBy(how=How.XPATH,using="//input[@id='txtSearchTree_tvDocument']")
	private WebElement eleEnterSearchCriteria;
	
	@FindBy(how=How.ID,using="dpSearch")
	private WebElement eleClickonSearchIcon;
	
	//@FindBy(how=How.XPATH,using="//span[text()='01.QCL']")
	//private WebElement eleClickOnLevel;
	
	@FindBy(how=How.ID,using="levelsubmit")
	private WebElement eleClickonDoneButton;
	

	@FindBy(how=How.ID,using="txtDocNumberValue")
	private WebElement eleEnterDocNum;
	
	@FindBy(how=How.ID,using="txtName")
	private WebElement eleEnterDocName;
	
	

	@FindBy(how=How.ID,using="txtCurrRevValue")
	private WebElement elePressTabkeyforRev;
	

	@FindBy(how=How.ID,using="txtKeyword")
	private WebElement elePressTabkeyforKW;
	
	@FindBy(how=How.ID,using="txtChangesMade")
	private WebElement elePressTabkeyforChangesReqd;
	
	@FindBy(how=How.ID,using="txtIssueNo")
	private WebElement elePressTabkeyforIssueNum;
	
	
	@FindBy(how=How.XPATH,using="//input[@type='file']")
	private WebElement eleAttachDoc;
	
	@FindBy(how=How.ID,using="btnAddDocument")
	private WebElement eleClickOnAddButton;
	

	
	
	public NewDocumentsRequest(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
				
		PageFactory.initElements(driver, this);		
	
	}

	public   NewDocumentsRequest uploadNewDocument(String searchCriteria,String documentNumber,String documentName,String attachment) throws Throwable{

	switchToFrame(eleFrame);
	click(eleClickOnSelectLevelButton,"Select Level button");
	Thread.sleep(3000);
	switchToFrame(eleLevelPopupFrame);
	System.out.println("switched successfully");
	Thread.sleep(20000);
    click(eleEnterSearchCriteria,"Search textbox ");
	
	type(eleEnterSearchCriteria, searchCriteria);
	click(eleClickonSearchIcon,"Search icon");
	WebElement eleClickOnLevel=driver.findElementByXPath("//span[text()='"+searchCriteria+"']");
	click(eleClickOnLevel,"level");
	click(eleClickonDoneButton,"Done button");
	//switchToWindow(1);
	switchToFrame(eleFrame);
	type(eleEnterDocNum, documentNumber);
	type(eleEnterDocName, documentName);
	//pressTabKey(elePressTabkeyforRev);
	//pressTabKey(elePressTabkeyforKW);
	//pressTabKey(elePressTabkeyforChangesReqd);
	//pressTabKey(elePressTabkeyforIssueNum);
	//pressTabKey(eleAttachDoc);
	//pressEnterKey(eleAttachDoc);
	//eleAttachDoc.sendKeys("D:\\Bhuvana\\Bhuvana 218 machine backup as of 2nd June 2017\\Bhuvana\\Documents\\Attachments for IC\\Sample Template.doc");
	eleAttachDoc.sendKeys(attachment);

	//type(eleAttachDoc, attachment);
			
	//click(eleAttachDoc);
	//System.out.println("clicked on browse");
	//uploadDocument(attachment);
	//System.out.println(filename);
	click(eleClickOnAddButton,"Add button");
	Thread.sleep(5000);
	
	return this;
	}

}
