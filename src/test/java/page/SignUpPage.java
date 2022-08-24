package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage {
	
	@FindBy(xpath="//span[text()='SIGN IN / JOIN']") 
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
	
	@FindBy(xpath="//span[text()='Sign me Up']/..")
	private WebElement SingMeUpBtn;
	
	@FindBy(xpath="/html//div[@id='join-in']/div[@class='modal-dialog modal-dialog-centered']//div[@class='Message_cupponMessage__DRXZ6 Message_success__acHdN']")
	private WebElement activationtxt;
	String emailtxt;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void signupJoinClick() {
		Singup_Join_Link.click();
	}
	
	public void joinClick() {
		Join_Link.click();
	}
	
	public boolean verifySignUpPopUpDisplay() {
		String Singuptxt;
		try
		{
			Singuptxt = Singup_Text.getText();
			System.out.println("Sing-Up Pop up displayed with "+ Singuptxt+ " Heading");
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
    }
    public boolean verifyActivationEmail() {
    	try {
    		emailtxt = activationtxt.getText();
    		System.out.println("SignUp successful... and Text " + emailtxt + " is getting displayed");
    		if(emailtxt.equals("Please check your email and press the activation link.")) {
    			System.out.println("Passed");
    			return true;
    		}
    		else {
    			System.out.println("Email verification text is not getting displayed to the customer");
    			return false;
    		}
    	}
    	catch(Exception e) {
    		System.err.println("Recheck the entered details on sign up page again: SIGNUP FAILED DUE TO INVALID DATA ENTRY");
    		return false;
    	}
    }
}
