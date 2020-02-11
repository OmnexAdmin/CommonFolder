package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class Actions extends ProjectMethods{

	@FindBy(how=How.ID,using="GENpendingdftreq")
	private WebElement  eleClickOnPendingDocumentDrafts;
	
	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private  WebElement  eleLHSFrame;
	
	
	@FindBy(how=How.XPATH,using="//iframe[@id='iframeActions']")
	private  WebElement  eleActionsFrame;
	
	@FindBy(how=How.ID,using="gs_name")
	private WebElement  eleClickOndocumentName;
	
	@FindBy(how=How.LINK_TEXT,using="In Process")
	private WebElement  eleClickOnInprocessLink;
	
	@FindBy(how=How.ID,using="btnChangeRequest")
	private WebElement  eleClickOnChangeRequestButton;
	
	@FindBy(how=How.ID,using="attachdoc")
	private WebElement  eleClickOnAttachDocumentButton;
	
	@FindBy(how=How.ID,using="reasonforreq")
	private WebElement  eleEnterReasonforRequest;
	
	@FindBy(how=How.ID,using="changesrequired")
	private WebElement  eleEnterChangesRequired;
	

	@FindBy(how=How.ID,using="btcontinue")
	private WebElement  eleClickOnSubmitButton;
	
	@FindBy(how=How.ID,using="GENdftneedview")
	private WebElement  eleClickOnDraftRequestNeedingViewing;
	
	

	@FindBy(how=How.ID,using="attchcheck")
	private WebElement  eleChecktheAttachDocumentCheckbox;
	
	@FindBy(how=How.LINK_TEXT,using="Reply")
	private WebElement  eleClickOnReply;

	@FindBy(how=How.XPATH,using="(//input[@id='attachfile'])[1]")
	private WebElement  eleclickonchooseButton;
	

	@FindBy(how=How.ID,using="commentsedtr")
	private WebElement  eleEnterDraftComments;
	
	@FindBy(how=How.ID,using="drfsub")
	private WebElement  eleClickOnSubmit;
	
	
	
	
	
	public Actions(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
				
		PageFactory.initElements(driver, this);		
		
		}
	
	public Actions pendingDocumentDrafts(String documentName,String attachment,String reasonForRequest,String changesRequired) throws Throwable {
		
		switchToFrame(eleLHSFrame);
		click(eleClickOnPendingDocumentDrafts,"Pending Document Drafts tab");
		switchToFrame(eleActionsFrame);
		click(eleClickOndocumentName,"Document Name");
		type(eleClickOndocumentName, documentName);
		pressEnterKey(eleClickOndocumentName);
		click(eleClickOnInprocessLink,"Clicked on Inprocess Link");
		click(eleClickOnChangeRequestButton,"Change request button");
		eleClickOnAttachDocumentButton.sendKeys(attachment);
		//click(eleClickOnAttachDocumentButton);
		//uploadDocument(attachment);
		type(eleEnterReasonforRequest, reasonForRequest);
		type(eleEnterChangesRequired, changesRequired);
		click(eleClickOnSubmitButton,"Submit button");
		return this;
		
		}
	
	public Actions draftRequestsNeedingViewing(String documentName,String attachment,String draftComments) throws Throwable {
		
		switchToFrame(eleLHSFrame);
		click(eleClickOnDraftRequestNeedingViewing,"Draft requests needing viewing");
		switchToFrame(eleActionsFrame);
		//Thread.sleep(2000);
		click(eleClickOndocumentName,"Document Name");
		type(eleClickOndocumentName, documentName);
		pressEnterKey(eleClickOndocumentName);
		click(eleClickOnReply,"Reply link");
		Thread.sleep(3000);
		click(eleChecktheAttachDocumentCheckbox,"Attach document checkbox");
		Thread.sleep(3000);
		eleclickonchooseButton.sendKeys(attachment);
		//click(eleclickonchooseButton);
		//uploadDocument(attachment);
		//Thread.sleep(3000);
		type(eleEnterDraftComments, draftComments);
		click(eleClickOnSubmit,"Submit button");
		Thread.sleep(3000);
		return this;
		
		
	}
	
}
