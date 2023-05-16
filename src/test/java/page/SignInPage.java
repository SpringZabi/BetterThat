package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	@FindBy(xpath="//span[@class='Header_userNameClass__nl8jn']") 
	private WebElement SingIn_Join_Link;
	
	@FindBy(xpath="//span[text()='SIGN IN']")
	private WebElement SingIn_Link;
	
	@FindBy(xpath="//*[@id=\"sign-in\"]//input[@name=\"email\"]") 
	private WebElement SignInEmail;
	
	@FindBy(xpath="//*[@id=\"sign-in\"]//input[@name=\"password\"]")
	private WebElement SignInPwd;
	
	@FindBy(xpath="//*[@id=\"sign-in\"]//button[@class='RegisterLogin_btnCustom__Yndqo overcastBtn']")
	private WebElement LogInBtn;
	
	@FindBy(xpath="//div[@class='Message_textDanger___OSCV ']")
	private WebElement emailvalidationtxt;
	
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void signinJoinMouseOver() {
		SingIn_Join_Link.click();
	}
	
	public void singInClick() {
		SingIn_Link.click();
	}
	
	public void enterSingInEmail(String email2) {
		SignInEmail.clear();
		SignInEmail.sendKeys(email2);
		}
	public void enterSingInPwd(String pwd2) {
		SignInPwd.clear();
		SignInPwd.sendKeys(pwd2);
	}
	
	public void btnClick() {
		LogInBtn.click();
	}
	public String emailerrortxt;
	public boolean validateemailerror() {
		
		emailerrortxt = emailvalidationtxt.getText();
		System.out.println("Incorrect email text is : "+emailerrortxt);
		
		if(emailerrortxt.equals("Enter email address in correct format, like name@example.com.")) {
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	}
	

