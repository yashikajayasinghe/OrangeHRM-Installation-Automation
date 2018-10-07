package pageObjects;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;
import selenium.Wait;

public class Installer {
	
	WebDriver driver;
	
	public Installer(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//WebElements List
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"next\"]") 
	private WebElement btnWelcomeNext;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"content\"]/input[2]")
	private WebElement  btnLicenseNext;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"dbHostPort\"]")
	private WebElement txtDbConfigPort;
		
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/table/tbody/tr[3]/td[2]/input")
	private WebElement txtDbHostName;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"content\"]/table/tbody/tr[5]/td[2]/input")
	private WebElement txtDbConfigDbName;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"content\"]/table/tbody/tr[6]/td[2]/input")
	private WebElement  txtDbConfigDbUsername;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"content\"]/table/tbody/tr[7]/td[2]/input")
	private WebElement txtDbConfigDbPassword;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"content\"]/table/tbody/tr[8]/td[2]/input")
	private WebElement checkDbConfigOhrmSameDbUser;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"content\"]/input[3]")
	private WebElement btnDbConfigNext;
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"nextButton\"]")
	private WebElement btnSystemConfigNext;
	
	@FindBy(how=How.XPATH, using ="//*[@id=\"organizationName\"]" )
	private WebElement txtSysConfigOrgName;
	
	@FindBy(how=How.ID, using = "country")
	private WebElement selectSysConfigOrgCountry;
	
	@FindBy(how=How.ID , using = "language")
	private WebElement selectSysConfigOrgLanguage;
	
	@FindBy(how=How.ID, using ="timezone" )
	private WebElement selectSysConfigOrgTimeZone;
	
	@FindBy(how=How.ID, using ="adminEmployeeFirstName" )
	private WebElement txtAdminFirstName; 
	
	@FindBy(how=How.ID, using ="adminEmployeeLastName" )
	private WebElement txtAdminLastName;
	
	@FindBy(how=How.ID, using ="organizationEmailAddress" )
	private WebElement txtOrgAdminEmail; 
	
	@FindBy(how=How.ID, using ="contactNumber" )
	private WebElement txtAdminContactNumber;
	
	@FindBy(how=How.ID, using ="OHRMAdminUserName" )
	private WebElement txtAdminUsername; 
	
	@FindBy(how=How.ID, using ="OHRMAdminPassword" )
	private WebElement txtAdminPassword;
	
	@FindBy(how=How.ID, using ="OHRMAdminPasswordConfirm" )
	private WebElement txtAdminConfirmPassword;
	
	@FindBy(how=How.ID, using ="systemConfigReg" )
	private WebElement btnSubmitSysConfigData;
	
	@FindBy(how=How.XPATH, using ="//*[@id=\"content\"]/input[3]" )
	private WebElement btnTriggerInstallation;
	
	//OrangeHRM Login Page WebElements
	
	@FindBy(how=How.XPATH, using ="//*[@id=\"txtUsername\"]" )
 	private WebElement txtOhrmLoginUsername;
	
 	@FindBy(how=How.XPATH, using = "//*[@id=\"txtPassword\"]")
 	private WebElement txtOhrmLoginPassword;
 	
 	@FindBy(how=How.XPATH, using = "//*[@id=\"btnLogin\"]" )
 	private WebElement btnOhrmLogin;
	
	
 	
 	@SuppressWarnings("deprecation")
	public void installationSteps(){
		
	//Load OHRM Installation
 		
 		driver.get(FileReaderManager.getInstance().getConfigFileReader().getPathToInstaller());
		Wait.untilJqueryIsDone(driver);
		
	//In Welcome Page
		btnWelcomeNext.click();
		Wait.untilJqueryIsDone(driver);
		System.out.println("In Welcome Page..");
		
	//In License Page
		btnLicenseNext.click();
	    Wait.untilJqueryIsDone(driver);
	    System.out.println("In License Page..");
	    
	    
	//In Database Configuration Page
	    
	     //db host name
	    txtDbHostName.clear();
	    txtDbHostName.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getDatabaseHostName());
	    System.out.println("In Database Configuration Page..");
	    
	     //db host port
	    txtDbConfigPort.clear();
	    txtDbConfigPort.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getDatabasePort());
	    	     
	     //db name
	    txtDbConfigDbName.clear();
	    txtDbConfigDbName.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getDatabaseName()); 
	    
	     //db username
	    txtDbConfigDbUsername.clear();
	    txtDbConfigDbUsername.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getDatabaseUsername());
	     
	     //db password
	   
	    txtDbConfigDbPassword.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getDatabasePassword());
	     
	     //Config Use Same Db User_checkBox
	    if(FileReaderManager.getInstance().getConfigFileReader().getDatabaseSameDbUser()) 
	    	{
	    		checkDbConfigOhrmSameDbUser.click();	    	
	    	}
	     
	     //Next button	     
	     btnDbConfigNext.click();
	     Wait.untilJqueryIsDone(driver);

	//System Check page
	     
	     //Next Button
	   System.out.println("In System Check Page..");
	   btnSystemConfigNext.click();
	     
 //System Configuration page	     
	   
	     Wait.untilJqueryIsDone(driver);
	     System.out.println("In System Configuration page");
	     
	     //Organization Name_txt
	     txtSysConfigOrgName.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getOrganizationName());
	    
	     //Country_select	     
	     Select countryDropDown = new Select(selectSysConfigOrgCountry);
	     countryDropDown.selectByValue(FileReaderManager.getInstance().getConfigFileReader().getOrganizationCountry());

	     //Language select
	     Select languageDropDown = new Select(selectSysConfigOrgLanguage);
	     languageDropDown.selectByValue(FileReaderManager.getInstance().getConfigFileReader().getOrganizationLanguage());
	     
	     //TimeZone
	     Select timeZoneDropDown = new Select(selectSysConfigOrgTimeZone);
	     timeZoneDropDown.selectByValue(FileReaderManager.getInstance().getConfigFileReader().getOrganizationTimeZone());
	   //FileReaderManager.getInstance().getConfigFileReader().	     
	  
	     //Admin First Name
			txtAdminFirstName.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminFirstName());
	     
	     //Admin Last Name
			txtAdminLastName.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminLastName());
	     
	     //Admin Email
			txtOrgAdminEmail.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminEmail());
	     
	     //Admin Contact No
			txtAdminContactNumber.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminContact());
	     
	     //Admin OHRM username		
			txtAdminUsername.clear();
			txtAdminUsername.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminUserName());
	     
	     //Admin password
			txtAdminPassword.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminPassowrd());
	     
	     //Admin repeat password
			txtAdminConfirmPassword.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminPassowrd());
	     
	     //System Configuration Registration Button
			btnSubmitSysConfigData.click();
	     
	//Confirmation page
	     System.out.println("In Confirmation page");
	     Wait.untilPageLoadComplete(driver);
	     
	     //Install button	     
	     btnTriggerInstallation.click();
	     
	//Installing Page
	     
	    
	     System.out.println("In Installing Page");
	     Wait.untilPageLoadComplete(driver);
	     
	     WebDriverWait wait = new WebDriverWait(driver, 3600);
	     wait.pollingEvery(30, TimeUnit.SECONDS);
	     
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/input[2]")));
	     
	     //Next button
	     driver.findElement(By.xpath("//*[@id=\"content\"]/input[2]")).click();
	
	     
	 //Login Page
	     
	     System.out.println("In OrangeHRM Login Page");
	     Wait.untilPageLoadComplete(driver);
	     
	     //Username  
	     txtOhrmLoginUsername.click();
	     txtOhrmLoginUsername.clear();
	     txtOhrmLoginUsername.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminUserName());    
	      
	     //password
	     txtOhrmLoginPassword.click();
	     txtOhrmLoginPassword.clear();		     
	     txtOhrmLoginPassword.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getAdminPassowrd());
	     
	     //login button
	     btnOhrmLogin.click();	     
	     Wait.untilPageLoadComplete(driver);
		
	     //welcome
	     String welcomeText = "Welcome " + FileReaderManager.getInstance().getConfigFileReader().getAdminFirstName();
	     	     
	     if(driver.findElement(By.id("welcome")).getText().equals(welcomeText))
	     {
	    	 System.out.println("Installation Successful!");
	     }
	     
	}
	

}
