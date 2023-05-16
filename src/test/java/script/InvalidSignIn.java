package script;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;
import page.SignInPage;

public class InvalidSignIn extends CommonBaseTest{
	
	@Test(priority = 5)
	public void testInvalidSignIn() throws InterruptedException {
		SignInPage signinpage2 = new SignInPage(driver);
		signinpage2.signinJoinMouseOver();
		signinpage2.singInClick();
		Thread.sleep(1000);
		//Invalid email verification
		String incorrectemail = "jisha";
		String signInPassword2 ="Bt@2023";
		signinpage2.enterSingInEmail(incorrectemail);
		extentTest.log(Status.INFO, "SinginEmail Entered:  "+incorrectemail);
		signinpage2.enterSingInPwd(signInPassword2);
		extentTest.log(Status.INFO, "Password:  "+"*******");
		signinpage2.btnClick();
		Thread.sleep(10000);
		boolean emailtxt = signinpage2.validateemailerror();
		String validationmsg1 = signinpage2.emailerrortxt;
		if(emailtxt) {
			
			extentTest.log(Status.INFO, "Test is pass: Incorrect email error is getting displayed as expected.");
			extentTest.log(Status.PASS, validationmsg1);
		}
		else
		{
			extentTest.log(Status.FAIL, validationmsg1);
		}
//		//Invalid password verification
//		String signInmail2 = "jisha@springdigital.com.au";
//		String incorrectPassword ="abcdefg";
//		signinpage2.enterSingInEmail(signInmail2);
//		extentTest.log(Status.INFO, "SinginEmail Entered:  "+signInmail2);
//		signinpage2.enterSingInPwd(incorrectPassword);
//		extentTest.log(Status.INFO, "Password:  "+"*******");
//		signinpage2.btnClick();
//		Thread.sleep(10000);
//		
//		//Blank fields verification
//		String blankemail = "";
//		String blankpassword ="";
//		signinpage2.enterSingInEmail(blankemail);
//		extentTest.log(Status.INFO, "SinginEmail Entered:  "+blankemail);
//		signinpage2.enterSingInPwd(blankpassword);
//		extentTest.log(Status.INFO, "Password:  "+"*******");
//		signinpage2.btnClick();
//		Thread.sleep(10000);
	}

}
