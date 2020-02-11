package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class DocProGroups extends ProjectMethods {

	

	@FindBy(how=How.LINK_TEXT,using="Groups")
	private WebElement eleclickOnGroupsMenu;
	
	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private static WebElement  eleLHSFrame;
	
	@FindBy(how=How.ID,using="btn_SuGroupsGridViewControl_iladd")
	private WebElement eleclickOnAddButton;
	
	@FindBy(how=How.XPATH, using="(//input[@name='groupname'])[2]")
	private WebElement eleEnterGroupName;
	
	@FindBy(how=How.ID,using="btn_SuGroupsGridViewControl_ilsave")
	private WebElement eleclickOnSaveButton;
	
	@FindBy(how=How.ID,using="gs_groupname")
	private WebElement eleSearchGroupName;
	
	
	@FindBy(how=How.XPATH,using="//img[@title='Add Users']")
	private static WebElement  eleClickOnAddUsersIcon;
	

	
	@FindBy(how=How.XPATH,using="//iframe[@id='ifrUsers']")
	private WebElement eleUserFrame;
	
	@FindBy(how=How.XPATH,using="//iframe[@id='ifr-user']")
	private WebElement eleUserFrame1;
	

	@FindBy(how=How.XPATH,using="//input[@value='userBased']")
	private WebElement eleCLickOnUserBasedSearchRadioButton ;
	
	@FindBy(how=How.ID,using="gs_Empcode")
	private WebElement eleEnterCode ;
	
	@FindBy(how=How.XPATH,using="(//a[@class='soptclass']//img[1])[1]")
	private WebElement eleCLickOnSearchFilter ;
	
	@FindBy(how=How.XPATH,using="//td[text()='equal']")
	private WebElement eleCLickonEqualsfilter ;
	

	
	@FindBy(how=How.CLASS_NAME, using="cbox")
	private WebElement eleClickOnUserToSelect;
	
	//@FindBy(how=How.XPATH,using="//input[@value='4001']")
	//private WebElement eleCheckViewDocumentAccess;
	
	//@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	//private WebElement eleCheckViewDocumentAccess;
	
	@FindBy(how=How.XPATH,using="//input[@value='4003']")
	private WebElement eleCheckApprovalAccess;
	
	@FindBy(how=How.XPATH,using="//input[@value='4004']")
	private WebElement eleCheckRestrictedViewAccess;
	
	@FindBy(how=How.XPATH,using="//input[@value='4005']")
	private WebElement eleCheckCreatsSubFolderAccess;
	
	@FindBy(how=How.ID,using="save")
	private WebElement eleClickOnSave;
	

	
	@FindBy(how=How.XPATH,using="//iframe[@id='ifrUsers']")
	private WebElement eleRightsFrame;
	
	
	
	@FindBy(how=How.ID,using="popup_ok")
	private WebElement eleClickOktoAlert;
	
	
	
	
	public DocProGroups(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
				
		PageFactory.initElements(driver, this);		
	
	}
	
	public DocProGroups createAdminGroup(String groupName,String code) throws Throwable {
	
		switchToFrame(eleLHSFrame);
		click(eleclickOnAddButton,"Add button");
		//Thread.sleep(2000);
		type(eleEnterGroupName, groupName);
		click(eleclickOnSaveButton,"Save button");
		click(eleClickOktoAlert,"Ok button");
		//Thread.sleep(20000);
		type(eleSearchGroupName, groupName);
		click(eleCLickOnSearchFilter,"Search filter");
		click(eleCLickonEqualsfilter,"Equals filter in search criteria");
		driver.findElementById("gs_groupname").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		click(eleClickOnAddUsersIcon,"Add users icon");
		System.out.println("The number of frames in this pages is"+driver.findElements(By.xpath("//iframe")).size());
		String currentFrameName = (String)((JavascriptExecutor) driver).executeScript("return window.frameElement.name");
		System.out.println(currentFrameName);
	
		
		switchToMultipleFrames("ifrUsers","ifr-user");
		//driver.switchTo().frame("ifrUsers").switchTo().frame("ifr-user");
		

		//switchToFrame(eleUserFrame);
		//switchToFrame(eleUserFrame1);
		
		//click(eleCLickOnUserBasedSearchRadioButton);
		//boolean test=eleEnterCode.isDisplayed();
		//System.out.println(test);
		
		click(eleEnterCode,"Code textbox");
		
		type(eleEnterCode, code);
		click(eleCLickOnSearchFilter,"Search filter");
		click(eleCLickonEqualsfilter,"Equals filter in search criteria");
		driver.findElementById("gs_Empcode").sendKeys(Keys.ENTER);
		click(eleClickOnUserToSelect,"Select User Checkbox");
		System.out.println("The number of frames in this pages is"+driver.findElements(By.xpath("//iframe")).size());
		String currentFrameName1 = (String)((JavascriptExecutor) driver).executeScript("return window.frameElement.name");
		System.out.println(currentFrameName1);
		//Thread.sleep(15000);
		//driver.switchTo().defaultContent();
		driver.switchTo(). parentFrame();
		Thread.sleep(5000);
		//click(eleCheckViewDocumentAccess);
		click(eleCheckApprovalAccess,"Approval access rights");
		click(eleCheckRestrictedViewAccess,"Restricted view access rights");
		click(eleCheckCreatsSubFolderAccess,"create sub folder access rights");
		
		
		click(eleClickOnSave,"Save");
		click(eleClickOktoAlert,"OK button");
		
		return this;
		
	}
	
}
