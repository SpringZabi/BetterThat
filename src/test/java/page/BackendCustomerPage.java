package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackendCustomerPage {
	
	@FindBy(xpath ="//html/body/div/div[2]/div[1]/div[1]/div[1]/ul/li[4]/a/span")
	private WebElement custLink;
	
	public BackendCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomer() {
		custLink.click();
		}

}
