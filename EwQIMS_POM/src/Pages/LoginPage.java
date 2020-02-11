package Pages;



	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
	import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;


	public class LoginPage extends ProjectMethods{
		
		@FindBy(how=How.ID,using="txtUsername")
		private WebElement eleUserName;
		
		@FindBy(how=How.ID,using="txtPassword")
		private WebElement elePassWord;
		
		@FindBy(how=How.XPATH,using="//input[@value='Login']")
		private WebElement eleLogin;
		
		@FindBy(how=How.ID,using="divWaring")
		private WebElement eleErrorMsg;
		
		
		
		public LoginPage(RemoteWebDriver driver, ExtentTest test) {
			this.driver = driver;
			
			this.test = test;
			PageFactory.initElements(driver, this);				
		}
		
		public HomePage login(String userName, String passWord) {
			
			type(eleUserName, userName);
			type(elePassWord, passWord);
            click(eleLogin,"Login button");
          	
            return new HomePage(driver,test);
			}
		
		public LoginPage invalidLogin(String userName, String passWord) {
			String expectedText="Wrong Username / Password. Try again";
			type(eleUserName, userName);
			type(elePassWord, passWord);
			click(eleLogin,"Login button");
			verifyPartialText(eleErrorMsg, expectedText);
			return this;
		}
		
		
		public DocProAdminHomePage moduleLandingPageLogin(String userName, String passWord) {
			
			type(eleUserName, userName);
			type(elePassWord, passWord);
            click(eleLogin,"Login button");
			return new DocProAdminHomePage(driver,test);
			
			
		}
		
	public TOC TOCPage(String userName, String passWord) {
			
			type(eleUserName, userName);
			type(elePassWord, passWord);
            click(eleLogin,"Login button");
			return new TOC(driver,test);
			
			
		}
		
		
		
		
		
		
		
		
		
		

	}

	
	
	

