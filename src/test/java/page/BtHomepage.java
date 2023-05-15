package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BtHomepage {
		
	@FindBy(xpath="//*[@id=\"top-header\"]//span[@class='Header_userNameClass__nl8jn']") 
	private WebElement My_Account_Txt;
	
	public BtHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyMyAccount() {
	
			
		String myaccttxt = My_Account_Txt.getText();
		System.out.println("myaccttxt = "+ myaccttxt);
		if(myaccttxt.equals("MY ACCOUNT")) 
		  {
		    System.out.println("myaccttxt"+ myaccttxt+"displaying properly.");
		    return true;
	      }
		else
		{
			System.err.println("Recheck the entered details on sign up page again: SIGNUP FAILED DUE TO INVALID DATA ENTRY");
			return false;
			
		}
		
//		catch(Exception e) {
//    		System.err.println("Recheck the entered details on sign up page again: SIGNUP FAILED DUE TO INVALID DATA ENTRY");
//    		return false;
//    	}
	    
		
    }
}