package script;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;
import page.SignUpPage;

public class SignUp extends CommonBaseTest {
	
	@Test(priority = 1)
	public void testSignUpPopUp() throws InterruptedException {
		
		//System.out.println("SignUp class executing.............................");
		
		SignUpPage signuppage2 = new SignUpPage(driver);
		boolean status3 = signuppage2.verifySignUpPopUpDisplay();
		if (status3) {
		extentTest.log(Status.INFO, "SingUp pop-up loaded properly");
		Thread.sleep(3000);
		signuppage2.validateClose();
		}
		else {
		extentTest.log(Status.INFO, "SignUp pop-up is not opening");
		}
	}

}
