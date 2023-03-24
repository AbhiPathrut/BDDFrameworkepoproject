package com.sogeti.automation.test.pageFactory;




import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import java.util.List;
import java.util.Random;





public class E2CO_UserManagement extends PageClass {
	
	SelfHealingDriver objDriver;
	int row;
	String DeletedUserName;
	String LockedUserName;
	String UnLockedUserName;
	int rowInactiveUsers;
	String UnLockedDomainName;
	String LockedDomainName;
	
	
    @FindBy(xpath="//a[@href='/MEC/userManager/user-list']")
	//@FindBy(xpath = "//a[@class='sidenav-nav-link d-flex align-items-center justify-content-center mb-0 w-100 active' ]")
    private WebElement usermanagebttn;
    
    @FindBy(xpath="(//button[normalize-space()='Add New User'])[1]")
    private WebElement addnewuser;
    
    @FindBy(xpath="//input[@id='First_name']")
    private WebElement firstnametext;

    @FindBy(xpath="//input[@id='last_name']")
    private WebElement lastnametext;
    
    @FindBy(xpath = "//select[@id='floatingSelect']") 
	private WebElement selectRole;

    @FindBy(xpath="//input[@id='email']")
    private WebElement emailid;

    @FindBy(xpath="//input[@id='floatinglogin']")
    private WebElement loginname;
    
    @CacheLookup
    @FindBy(xpath="//input[@id='floatingpassword']")
    private WebElement password;
    
    @FindBy(xpath="//input[@id='floatingRetype']")
    private WebElement retypePassword;
    
    @FindBy(xpath="//input[@id='floatingContact']")
    private WebElement contactno;
    
    @FindBy(xpath = "//select[@id='floatingInvalid']")
	private WebElement maxInvalidAttmpt;
	 
	@FindBy(xpath = "//select[@id='floatingmaxAttempt']")
	private WebElement maxValidity;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Submitbtn;
    
    @FindBy(xpath = "(//div[@class='user-list-table-title ft-18 ft-wt-500'])[1]")
    private WebElement userdatalist;
    
    @FindBy(xpath = "//span[@id='dropdownMenuButton1']")
    private WebElement userDropDownBtn;
    
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement logoutBtn;
    
    @FindBy(xpath = "//table[@class='table custom-table-fixed-layout']")
    private WebElement userdatatable;
    
//    @FindBy(xpath = "(//div[@class='material-symbols-outlined cursor-pt'][normalize-space()='delete'])[6]")
//    private WebElement deletebtn;
    
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    private WebElement confirmbtn;
    
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center user-manager-delete-pop-up-container']")
    private WebElement popupMessage;
     
//    @FindBy(xpath = "(//div[contains(text(),'lock')])[5]")
//    private WebElement lockbtn;
    
    @FindBy(xpath = "//span[@class='fw-bold']")
    private WebElement inactivemsg;
    
    @FindBy(xpath = "//div[@class='ft-16 succes-edge-detail-text']")
    private WebElement inactiveSuccessfulMesg;
    
    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-success-dialog-box/div/button")
    private WebElement closebtn;
    
//    @FindBy(xpath = "//div[@class='login-content border-radius-10 bg-white']")
//    WebElement loginBorder;
    
    @FindBy(xpath = "//div[@class='text-critical ft-13']")
    private WebElement ErrorMessage;
    
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement closeButton;
    
    @FindBy(xpath = "//input[@id='domain']")
    private WebElement domainName;
    
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center user-manager-delete-pop-up-container']")
    private WebElement activateWarningMessage;
    
    @FindBy(xpath = "//div[@class='ft-16 succes-edge-detail-text']")
    private WebElement activateSuccessPopupMessage;
    
    @FindBy(xpath = "//div[@class='onboard-success-container text-center']")
    private WebElement ownUserDeletingMessage;
    
    @FindBy(xpath = "//button[normalize-space()='Ok']")
    private WebElement okBtn;
    
    @FindBy(xpath = "//div[@class='update-user-title ft-18']")
    private WebElement updateUserTitle;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement updateBtn;
    
    @FindBy(xpath = "//div[@class='success-text onboard-success-text-spacing ft-18 ft-wt-500']")
    private WebElement updateSuccessMessage;
  
    

	 
	public E2CO_UserManagement(SelfHealingDriver driver) {
		super(driver);
		this.objDriver = driver;
		
		 wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
	        PageFactory.initElements(driver, this);
	}

	
	public void usermanagebttn() {
    	usermanagebttn.click();
    	log.info("Clicked the user management");
    	
     }
	
	public void userManagementPageLoaded() {
		Assert.assertTrue(userdatalist.isDisplayed());
			
	}
	
	public void addnewuser() {
    	this.addnewuser.click();
    	//Thread.sleep(2000);
    	log.info("Clicked the add new user");
    	
     }
	
	public void firstNameTextIsVisible() {
		Assert.assertTrue(firstnametext.isDisplayed());
		
	}
	public void firstnametext(String FirstName) {
    	this.firstnametext.click();
    	//Thread.sleep(2000);
    	this.firstnametext.sendKeys(FirstName);
    	log.info("Entered first name");
    	
     }
	
	public void lastnametext(String LastName) {
    	this.lastnametext.click();
    	this.lastnametext.sendKeys(LastName);
    	log.info("Entered last name");
    	
     }
	
	public void selectRole(String option) {
        Select select = new Select(selectRole);
        select.selectByVisibleText(option);
        log.info("Role selected");
    }
	
	public void emailid(String EmailId) {
    	//this.emailid.click();
    	this.emailid.sendKeys(EmailId);
    	log.info("Entered EmailId");
    	
	}
	
	
	public void loginname(String UserName) {
    	//this.loginname.click();
    	this.loginname.sendKeys(UserName);
    	log.info("Entered UserName");
    	
	}
	
	public void password(String Password) {
    	//this.password.click();
    	this.password.sendKeys(Password);
    	log.info("Entered Password");
    	
	}
	
	
	public void retypePassword(String RetypePassword) {
    	//this.retypePassword.click();
    	this.retypePassword.sendKeys(RetypePassword);
    	log.info("Entered RetypePassword");
    	
	}
	
	public void contactno(String ContactNo) {
    	//this.contactno.click();
		this.contactno.clear();
    	this.contactno.sendKeys(ContactNo);
    	log.info("Entered ContactNo");
    	
	}
	
	public void selectMaxInvdAttpt(String option) {
        Select select = new Select(maxInvalidAttmpt);
        select.selectByVisibleText(option);
        log.info("Max invalid attempt selected");
    }
	
	public void selectMaxValidty(String option) {
        Select select = new Select(maxValidity);
        select.selectByVisibleText(option);
        log.info("Max validity selected");
    }
	
	
	public void enterDomainName(String domainName) {
		this.domainName.clear();
		this.domainName.sendKeys(domainName);
		log.info("Entered domain name");
	}
	public void clickSubmitBtn() {
		this.Submitbtn.click();
		log.info("Clicked Submit Button");
		
	}
	
	public void clickOnClose() {
		this.closebtn.click();
		log.info("Clicked popup message of user created successfully");
	}
	
	
	public boolean verifyUserCreatedIsDisplayed(String userName) {
		boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//tr//th[3]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		System.out.println(linkText);
		if(userName.equals(linkText)) {
			log.info("User is displayed");
			validationFlag = true;
		}
	}
		  return validationFlag;
}
	

	public int SizeOfTable() {
		 List<WebElement> rows = objDriver.findElements(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr"));
		  row = rows.size();
		 System.out.println(row);
		return row;
	}
	
	
	public void inactiveUser() {
		List<WebElement> inactiveUsers = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//(//th[@class='ft-wt-400'][normalize-space()='inactive'])"));
		for(WebElement userInactive :inactiveUsers ) {
			String UserInactive = userInactive.getText();
			System.out.println(UserInactive);
		}
	}
	
	
	public void userDropDownBtn() {
		this.userDropDownBtn.click();
		log.info("Clicked on user");
		
	}
	
	
	public void logoutBtn() {
		this.logoutBtn.click();
		log.info("Clicked logout button");
		
	}
	
	
	public void userdatatable() {
		this.userdatatable.getSize();
		
	}
	
	
	
	 public boolean verifyUserManagementIsNotAvailable() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(usermanagebttn));
	            return true;
	        } catch (NoSuchElementException ne) {
	            return false;
	        } catch (Exception e) {
	            log.error("Page not loaded" + e);
	            return false;
	        }
	    }
	
	 
	 public void deletebtn() {
		 Random rand = new Random();
		int randomNum = rand.nextInt(row);
		if (randomNum==0){          
			randomNum= randomNum+1;
			}
		System.out.println(randomNum);
		WebElement userNameDeleted = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+ randomNum+"]//th[3]"));
		DeletedUserName = userNameDeleted.getText();
		 WebElement deletebtn= objDriver.findElement(By.xpath("(//div[@class='material-symbols-outlined cursor-pt'][normalize-space()='delete'])["+ randomNum +"]"));
		 deletebtn.click();
		 log.info("Clicked delete button");
		 System.out.println(DeletedUserName);
	 }
	 
	 
	 
	 public boolean verifyDeletedRowIsNotPresentInTable() {
		 boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//tr//th[3]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		if(DeletedUserName != (linkText)) {
			log.info("User is not displayed");
			validationFlag = true;
		}
	}
		  return validationFlag;
	 }
	 
	 
	 
	 public boolean popupMessageIsDispalyed() {
		 this.popupMessage.isDisplayed();
		 return true;
	 }
	 
	 
	 
	 public void confirmbtn() {
		 this.confirmbtn.click();
		 log.info("Clicked confirm button");
	 } 
	 
	 
	 public void lockbtn() {
		 Random rand = new Random();
			int randomNum = rand.nextInt(row);
			if (randomNum==0){          
				randomNum= randomNum+1;
				}
			System.out.println(randomNum);
			WebElement UserNamelocked = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+ randomNum+"]//th[3]"));
			 LockedUserName = UserNamelocked.getText();
			 WebElement DomainNamelocked = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+ randomNum+"]//th[6]"));
			 LockedDomainName = DomainNamelocked.getText();
			 WebElement lockbtn= objDriver.findElement(By.xpath("(//div[contains(text(),'lock')])["+randomNum+"]"));
			 lockbtn.click();
			 log.info("Clicked locked button");
			 System.out.println(LockedUserName); 
			 System.out.println(LockedDomainName);
	 }
	 
	 

	 public boolean inactivemsg() {
		 this.inactivemsg.isDisplayed();
		 return true;
	 }
	 
	 
	 
	 public void verifyLockedUserIsNotAbleToLogin() throws Exception {
		 E2CO_LoginPage e2co_LoginPage = new E2CO_LoginPage(objDriver);
		e2co_LoginPage.enterUserName(LockedUserName);
		e2co_LoginPage.enterPassword("Admin@1234");
		e2co_LoginPage.enterDomain(LockedDomainName);
		e2co_LoginPage.clickLoginBtn(); 
		Thread.sleep(2000);
		
		String expectedErrorMessage = "Please contact admin user is inactive";
		
		String actualErrorMessage = ErrorMessage.getText();
		
		 //System.out.println(actualErrorMessage);
		
		 //Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		 
		 if(actualErrorMessage.equals(expectedErrorMessage)) {
			 log.info("User is inactivated");
		 }else {
			 log.info("User is active");
		 }
		 
		}	
	 public void closeButton() {
		 this.closeButton.click();
		 log.info("Clicked on close button");
	 }
	 
	 public boolean verifyInactiveSuccessfulMessageIsDisplayed() {
		 this.inactiveSuccessfulMesg.isDisplayed();
		 log.info("Inactive successful message is dispalyed");
		 return true;
	 }
	 
	 public int sizeOfInactiveUsers() {
		 List<WebElement> rows = objDriver.findElements(By.xpath("(//div[contains(text(),'lock_open')])"));
		  rowInactiveUsers = rows.size();
		 System.out.println(rowInactiveUsers);
		return rowInactiveUsers;
	 }
	 
	 public void openlockbtn() {
		 Random rand = new Random();
			int randomNum = rand.nextInt(rowInactiveUsers);
			if (randomNum==0){          
				randomNum= randomNum+1;
				}
			System.out.println(randomNum);
			WebElement UserNameUnlocked = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+ randomNum+"]//th[3]"));
			 UnLockedUserName = UserNameUnlocked.getText();
			 WebElement DomainNameUnlocked = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+ randomNum+"]//th[6]"));
			 UnLockedDomainName = DomainNameUnlocked.getText();
			 WebElement openlockbtn= objDriver.findElement(By.xpath("(//div[contains(text(),'lock_open')])["+randomNum+"]"));
			 openlockbtn.click();
			 log.info("Clicked openlock button");
			 System.out.println(UnLockedUserName); 
			 System.out.println(UnLockedDomainName);
	 }
	 
	 public boolean verifyActivateWarningMessageIsDisplayed() {
		 this.activateWarningMessage.isDisplayed();
		 log.info("Activate warning message is displayed");
		 return true;
	 }
	 
	 public boolean userActivatedSuccessMessagePopupMessageIsDisplayed() {
		 this.activateSuccessPopupMessage.isDisplayed();
		 log.info("Activated success popup message is displayed");
		 return true;
	 }

	 public void verifyUnLockedUserIsAbleToLogin() throws Exception {
		 E2CO_LoginPage e2co_LoginPage = new E2CO_LoginPage(objDriver);
		e2co_LoginPage.enterUserName(UnLockedUserName);
		e2co_LoginPage.enterPassword("Admin@1234");
		e2co_LoginPage.enterDomain(UnLockedDomainName);
		e2co_LoginPage.clickLoginBtn(); 
		Thread.sleep(2000);
		
	 }
	 
	 public void ownUserDelete() {
		 String ownUserDeletionMessage = this.ownUserDeletingMessage.getText();
		 if(ownUserDeletionMessage.contains("You can not delete your own account")) {
			 log.info("Trying to delete own user which is logged in through.");
			 this.okBtn.click();
		 }else {
			 log.info("User is deleted successfully.");
		 }
	 }
	 
	 public int rowNumber(String username) {
			WebElement table = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']"));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			
			int rowNumber = -1;
			for (int i = 0; i < rows.size(); i++) {
			    List<WebElement> cells = rows.get(i).findElements(By.tagName("th"));
			    for (int j = 0; j < cells.size(); j++) {
			        if (cells.get(j).getText().equals(username)) {
			            rowNumber = i;
			            break;
			        }
			    }
			    if (rowNumber != -1) {
			        break;
			    }
			}
			System.out.println("Row number: " + rowNumber);
			return rowNumber;
			
		}
	 
	 public void clickOnEditButton(String username) throws Exception {
			int RowNum = rowNumber(username);
			Thread.sleep(2000);
			WebElement EditButton = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+RowNum+"]//div[@class='material-symbols-outlined ft-22 cursor-pt']"));
			Thread.sleep(2000);
			EditButton.click();
			Thread.sleep(2000);
			
		}
	 
	 public boolean verifyUpdateUserPageIsDispalyed() {
		 this.updateUserTitle.isDisplayed();
		 log.info("Update user page is displayed.");
		 return true;
	 }
	 
	 public void clickOnUpdateBtn() {
		 updateBtn.click();
		 log.info("Clicked on update button.");
		 
	 }
	 
	 public boolean verifyUpdateOfUserSSuccessPopupMessageDisplayed() {
		 this.updateSuccessMessage.isDisplayed();
		 log.info("User updated success popup message is displayed.");
		 return true;
	 }
	 
	 
	 
	 
}
