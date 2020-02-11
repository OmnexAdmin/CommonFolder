package Pages;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import CommonMethods.ProjectMethods;


	public class HomePage extends ProjectMethods{
		
		@FindBy(how=How.XPATH,using="(//a[text()='Users'])[1]")
		private WebElement eleClickOnUsersTab;

		
		@FindBy(how=How.XPATH,using="//div[@id='div1']/table/tbody/tr/td/table/tbody/tr/td/a")
		private WebElement eleClickOnUsersMenu;

		@FindBy(how=How.XPATH,using="//img[@title='Levels']")
		private WebElement eleClickOnLevelsMenu;
		
		@FindBy(how=How.ID,using="imglistModules")
		private WebElement eleClickOnModulesIcon;
		
		@FindBy(how=How.XPATH,using="//a[@onclick='loadModule(4)']")
		private WebElement eleClickOnDocProModule;
		

		//@FindBy(how=How.XPATH,using="//img[@id='docpro']/following-sibling::img[1]")
		//private WebElement eleClickOnDocProModule;
		
		
		

		@FindBy(how=How.XPATH,using="(//img[@title='Document Pro'])[1]")
		private WebElement  eleClickOnDocProModule1;
		
		@FindBy(how=How.LINK_TEXT,using="Preferences")
		private WebElement  eleClickOnUserPrefrences;
		

		@FindBy(how=How.LINK_TEXT,using="Modules")
		private WebElement  eleClickOnModAdmMenu;
		
		@FindBy(how=How.LINK_TEXT,using="Suite Administrator")
		private WebElement eleClickOnSuiteAdmMenu;
		
		

		//@FindBy(how=How.XPATH,using="(//img[@title='Document Pro'])[2]")
		//private WebElement  eleClickOnDocProModule1;
		
		
		public HomePage(RemoteWebDriver driver,ExtentTest test) {
			this.driver = driver;
			this.test = test;
					
			PageFactory.initElements(driver, this);		
		
		}
		
		//Click on users tab
		public HomePage clickOnUersTab() throws Throwable{
			
		//WebDriverWait wait=new WebDriverWait(driver, 20);
	//wait.until(ExpectedConditions.visibilityOf(eleClickOnUsersTab));
		explicitWait(eleClickOnUsersTab);
		click(eleClickOnUsersTab,"Clicked on users tab");
		//Thread.sleep(2000);
		return this;
				}
		//Click on users menu
		
		public UserCreationPage clickOnUsersMenu() throws Throwable{
			
			click(eleClickOnUsersMenu,"User menu");
			//Thread.sleep(2000);
			return new UserCreationPage(driver, test);
		}
		
		public UserPreferencePage clickOnUserPrefrencesMenu() {
			
			click(eleClickOnUserPrefrences,"User preference menu");
			return new UserPreferencePage(driver,test);
			
		}
		
		public ModuleAdmin clickOnModuleAdminMenu() {
			click(eleClickOnModAdmMenu,"Module Admin menu");
			return new ModuleAdmin(driver, test);
		}
		
		public SuiteAdmin clickOnSuiteAdminMenu() {
			click(eleClickOnSuiteAdmMenu,"Suite Admin menu");
			return new SuiteAdmin(driver, test);
		}
		
		public LevelCreationPage clickOnLevelsMenu() throws Throwable {
			
			click(eleClickOnLevelsMenu,"Levles menu");
			//Thread.sleep(2000);
			return new LevelCreationPage(driver, test);
		}

			
			public DocProAdminHomePage goToDocProModule() throws Throwable {
				//Thread.sleep(5000);
				click(eleClickOnModulesIcon,"Modules icon");
				//Thread.sleep(5000);
				click(eleClickOnDocProModule1,"Doc pro module admin menu");
				//click(eleClickOnDocProModule);
				return new DocProAdminHomePage(driver, test);

			
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	



