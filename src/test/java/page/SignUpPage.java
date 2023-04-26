package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage {
	
	@FindBy(xpath="//span[@class='Header_userNameClass__nl8jn']") 
	private WebElement Singup_Join_Link;
	
	@FindBy(xpath="//span[text()='JOIN']")
	private WebElement Join_Link;
	
	@FindBy(xpath="//div[@class='RegisterLogin_joinPopRight__Tcr0T']/h2")
	private WebElement Singup_Text;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement Email_Address;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement First_Name;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement Last_Name;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	
	@FindBy(xpath="//label[@class='custom-check']/span[@class='checkmark']")
	private WebElement TandC_CB;
	
	@FindBy(xpath="//form//button[@class='RegisterLogin_btnCustom__Yndqo']")
	private WebElement SingMeUpBtn;
	
	@FindBy(xpath="//div/h2[contains(text(),'Thanks for registering!')]")
	private WebElement activationtxt;
	String emailtxt;
	
	@FindBy(xpath="//*[@id=\"join-in\"]/div/div/button")
	private WebElement CloseBtn;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validateClose() {
		
		CloseBtn.click();
	}
	
	public void signupJoinMouseOver() {
		Singup_Join_Link.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(Singup_Join_Link).perform();
//		action.click().perform();
	}
	
	public void joinClick() {
		Join_Link.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(Join_Link).click();
//		action.click();
	}
	
	public boolean verifySignUpPopUpDisplay() {
		String Singuptxt;
		try
		{
			Singuptxt = Singup_Text.getText();
			System.out.println("Sing-Up Pop up displayed with "+ Singuptxt+ " Heading");
			//System.out.println("Clicking close button in the SignUp PopUp");
			//Thread.sleep(3000);
			//CloseBtn.click();
			//System.out.println("SignUp PopUp Close button clicked");
			return true;
		}
		catch (Exception e) 
		{
			System.err.println("Sign-UP Pop up not opened");
			return false;
		}
	}
	
	public void enterEmail(String email) {
		Email_Address.sendKeys(email);
	}
	
	public void enterFirstName(String firstname) {
		First_Name.sendKeys(firstname);
	}
    public void enterLastName(String lastname) {
    	Last_Name.sendKeys(lastname);
    }
    public void enterPassword(String password) {
    	Password.sendKeys(password);
    }
    public void clickTandC() {
    	TandC_CB.click();
    }
    public void clickSingUpBtn() {
    	SingMeUpBtn.click();
    	//System.out.println("Button clicked: "+SingMeUpBtn.getText());
    }
    public boolean verifyActivationEmail() {
    	try {
    		emailtxt = activationtxt.getText();
    		System.out.println("SignUp successful... and Text " + emailtxt + " is getting displayed");
    		//emailtxt.contains("Thanks for registering!");
    		if(emailtxt.equals("Thanks for registering! Please check your email and click on the activation link.")) {
    			System.out.println("Passed");
    			return true;
    		}
    		else {
    			System.out.println("Test case Failed: Email verification text is not getting displayed to the customer");
    			return false;
    		}
    	}
    	catch(Exception e) {
    		System.err.println("Recheck the entered details on sign up page again: SIGNUP FAILED DUE TO INVALID DATA ENTRY");
    		return false;
    	}
    }
}
