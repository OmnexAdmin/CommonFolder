package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class UserPreferencePage extends ProjectMethods{
	

	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private WebElement eleUserPrefFrame;

	@FindBy(how=How.ID,using="ddlListModule")
	private WebElement eleSelectDocProModule;

	@FindBy(how=How.ID,using="btnsave")
	private WebElement eleClickOnSave;

	
	public UserPreferencePage(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
	}
	
	
	public UserPreferencePage setDocProasLandingPage(){
		//String value="Document Pro";
		switchToFrame(eleUserPrefFrame);
		selectDropDownUsingText(eleSelectDocProModule, "Document Pro");
		click(eleClickOnSave,"Save button");
		return this;
		
		
	}
	
}
