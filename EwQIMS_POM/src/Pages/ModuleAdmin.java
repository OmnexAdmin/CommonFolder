package Pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class ModuleAdmin extends ProjectMethods {
	
	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private WebElement eleFrame;

	@FindBy(how=How.XPATH,using="(//a[@class='chzn-single']//span[1])[2]")
	private WebElement eleClickOnModuleDropdown;
	
	
	@FindBy(how=How.XPATH,using="//li[text()='Document Pro']")
	private WebElement eleSelectDocProModule;
	

	@FindBy(how=How.XPATH,using="(//input[@title='Select User'])[1]")
	private WebElement eleClickOnSelectUserButton ;
	
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
	
	@FindBy(how=How.XPATH,using="//input[@value='Done']")
	private WebElement eleClickOnDone;
	
	@FindBy(how=How.XPATH,using="//td[text()='EMP295']")
	private WebElement eleValidateuser;
	
	
	
	public ModuleAdmin(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
	}
	
	public ModuleAdmin setUserAsModuleAdmin(String code) throws Throwable {
		switchToFrame(eleFrame);
		click(eleClickOnModuleDropdown,"Modules  dropdown");	
		click(eleSelectDocProModule,"Doc pro Module");
		click(eleClickOnSelectUserButton,"Select User button");
		Thread.sleep(5000);
		switchToFrame(eleUserFrame);
		
		System.out.println("Switched to frame successfully");
		//click(eleCLickOnUserBasedSearchRadioButton);
		switchToFrame(eleUserFrame1);
		//Thread.sleep(5000);
		System.out.println("Switched to frame1 successfully");
		type(eleEnterCode, code);
		click(eleCLickOnSearchFilter," Search filter");
		click(eleCLickonEqualsfilter,"Equals filter in search criteria");
		driver.findElementById("gs_Empcode").sendKeys(Keys.ENTER);
		click(eleClickOnUserToSelect,"Select USer Checkbox");
		click(eleClickOnDone,"Done button");
		//Thread.sleep(5000);
		switchToFrame(eleFrame);
		type(eleEnterCode, code);
		click(eleCLickOnSearchFilter,"Search filter");
		click(eleCLickonEqualsfilter,"Equals filter in search criteria");
		driver.findElementById("gs_Empcode").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
		verifyPartialText(eleValidateuser, code);
		
		
		Thread.sleep(2000);
		return this;
	}


}
