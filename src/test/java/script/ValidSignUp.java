package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BTExcel;
import generic.CommonBaseTest;
import page.SignUpPage;

public class ValidSignUp extends CommonBaseTest {

	@Test
	public void testValidSignUp() throws InterruptedException {
		
		String email = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 0);
		String firstname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 1);
		String lastname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 2);
		String password = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 3);
		
		SignUpPage signuppage = new SignUpPage(driver);
		signuppage.signupJoinClick();
		signuppage.joinClick();
		Thread.sleep(1000);
		boolean status1 = signuppage.verifySignUpPopUpDisplay();
		if (status1) {
		extentTest.log(Status.INFO, "SingUp pop is displaying properly");
		}
		else {
		extentTest.log(Status.INFO, "SignUp pop is not opening");
		}
		
		signuppage.enterEmail(email);
		extentTest.log(Status.INFO, "enterEmail:"+email);
		
		signuppage.enterFirstName(firstname);
		extentTest.log(Status.INFO, "enterFirstName:"+firstname);
		
		signuppage.enterLastName(lastname);
		extentTest.log(Status.INFO, "enterLastName"+lastname);
		
		signuppage.enterPassword(password);
		extentTest.log(Status.INFO, "enterPassword"+password);
		
		signuppage.clickTandC();
//		Thread.sleep(2000);
		signuppage.clickSingUpBtn();
		
		Thread.sleep(500);
		boolean status2 = signuppage.verifyActivationEmail();
		if(status2) {
		extentTest.log(Status.INFO, "Test is passed: Please check your email and press the activation link.");
		}
		else {
	    Assert.fail("Test is Failed: Recheck the entered details on sign up page again");
		}
		
	}
}
