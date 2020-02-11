package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;

public class UserCreationPage extends ProjectMethods {

	@FindBy(how=How.XPATH,using="//iframe[@id='Detailview']")
	private WebElement eleUsersFrame;

	@FindBy(how=How.XPATH,using="(//input[contains(@type,'submit')])[1]")
	private WebElement eleClickOnAddButton;

	@FindBy(how=How.ID,using="txtcode")
	private WebElement eleEnterCode;

	@FindBy(how=How.ID,using="txtfirstname")
	private WebElement eleEnterFirstName;

	@FindBy(how=How.ID,using="txtlastname")
	private WebElement eleEnterLastName;

	@FindBy(how=How.ID,using="txtbusinessmail")
	private WebElement eleEnterEmail;

	@FindBy(how=How.ID,using="txtusername")
	private WebElement eleEnterUserName;

	@FindBy(how=How.ID,using="txtpassword")
	private WebElement eleEnterPassword;

	@FindBy(how=How.ID,using="txtconfirmpassword")
	private WebElement eleEnterConfirmPassword;

	@FindBy(how=How.ID,using="Changelogin")
	private WebElement eleClickUserChgPwdatNextLoginCheckbox;


	@FindBy(how=How.ID,using="btnSaveval")
	private WebElement eleClickOnSaveButton;


	@FindBy(how=How.ID,using="popup_ok")
	private WebElement eleClickOktoAlertMessage;

	@FindBy(how=How.ID,using="gs_empcode")
	private WebElement eleEntertheCodetoVerify;

	

	public UserCreationPage(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
	}
	
	

	public UserCreationPage addUsers(String code,String fName,String lName,String eMail,String uName, String pwd,String confirmPassword ) throws Throwable {

		switchToFrame(eleUsersFrame);
		click(eleClickOnAddButton,"Add button");
		//Thread.sleep(6000);
		type(eleEnterCode, code);
		type(eleEnterFirstName, fName);
		type(eleEnterLastName, lName);
		type(eleEnterEmail, eMail);
		type(eleEnterUserName, uName);
		type(eleEnterPassword, pwd);
		type(eleEnterConfirmPassword, confirmPassword);
		click(eleClickUserChgPwdatNextLoginCheckbox,"User change password at next login checkbox");
		click(eleClickOnSaveButton,"Save button");
		click(eleClickOktoAlertMessage,"OK button ");
		type(eleEntertheCodetoVerify, code);
		eleEntertheCodetoVerify.sendKeys(Keys.ENTER);
		//Thread.sleep(2500);
		verifyDisplayed(eleEntertheCodetoVerify);
		


		return this;
	}



}
