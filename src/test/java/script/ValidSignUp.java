package script;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BTExcel;
import generic.CommonBaseTest;
import page.BackendCustomerPage;
import page.BackendLoginPage;
import page.SignUpPage;

public class ValidSignUp extends CommonBaseTest {

	@Test(priority = 2)
	public void testValidSignUp() throws InterruptedException {
		
		SignUpPage signuppage = new SignUpPage(driver);
		
		signuppage.signupJoinMouseOver();
		signuppage.joinClick();
		Thread.sleep(1000);
		boolean status1 = signuppage.verifySignUpPopUpDisplay();
		if (status1) {
		extentTest.log(Status.INFO, "SingUp pop-up loaded properly");
		}
		else {
		extentTest.log(Status.INFO, "SignUp pop-up is not opening");
		}
		
		String email = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 0);
		String firstname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 1);
		String lastname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 2);
		String password = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 3);
		
		signuppage.enterEmail(email);
		extentTest.log(Status.INFO, "Email:  "+email);
		
		signuppage.enterFirstName(firstname);
		extentTest.log(Status.INFO, "FirstName:  "+firstname);
		
		signuppage.enterLastName(lastname);
		extentTest.log(Status.INFO, "LastName:  "+lastname);
		
		signuppage.enterPassword(password);
		extentTest.log(Status.INFO, "Password:  "+password);
		
		signuppage.clickTandC();
		Thread.sleep(2000);
		signuppage.clickSingUpBtn();
    	Thread.sleep(500);
		boolean status2 = signuppage.verifyActivationEmail();
		if(status2) {
		extentTest.log(Status.INFO, "Test is passed. Message displayed: Please check your email and press the activation link.");
			
//		driver.switchTo().newWindow(WindowType.TAB);    
//        driver.get("https://dev.betterthat.com/login");   //Open new browser
//        Thread.sleep(1000);
//		driver.manage().window().maximize();
//		
//        BackendLoginPage blp = new BackendLoginPage(driver);
// //       BackendCustomerPage bcp = new BackendCustomerPage(driver);
//        
//		System.out.println("Open a new window..................");
//		blp.enterBackendEmail("sreeja+admin@springdigital.com.au");
//		
//		System.out.println("Entered username.................");
//		
//		blp.enterBackendPw("testers@SD");
//		
//		System.out.println("Entered password.................");
//		//Thread.sleep(1000);
//		
////		blp.loginBtnClick();
//		System.out.println("Backend login button clicked");
//		Thread.sleep(1000);
////		bcp.clickCustomer();
//		
//		//driver.findElement(By.linkText("")).click(); 
		
		}
		else {
	    Assert.fail("Test is Failed: Recheck the entered details on sign up page again.  Sucessful signup message is not getting displayed");
		}
		
	}
}
