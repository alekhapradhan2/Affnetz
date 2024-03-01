package Stepdefination;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page_Repository.LoginPageRepo;
import Page_Repository.PublicDonationRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PublicDonation {
	
	
	public WebDriver driver;
	public PublicDonationRepo pd;
	public LoginPageRepo lp;
	
	
	
	@Given("the user is open public donation page")
	public void the_user_is_open_public_donation_page() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://t1.affnetz.org/donate");
	}
	@Then("the use should re-direct to public donation page")
	public void the_use_should_re_direct_to_public_donation_page() throws IOException {
		pd=new PublicDonationRepo(driver);
		boolean flag=false;
		try {
			String text=pd.donationText();
			if(text.equalsIgnoreCase("Make a donation"))
			{
				assertTrue(true);
				flag=true;
				
			}
		} catch (Exception e) {
			if(flag==false)
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File trg=new File("FailedScreenShots/LoginFun/publicdonationfailed.png");
				FileUtils.copyFile(src, trg);
				driver.close();
			}
			assertTrue(flag);
		}
	   
	}
	@When("i give user details {string} {string} {string} {string}")
	public void i_give_user_details(String string, String string2, String string3, String string4) {
		pd=new PublicDonationRepo(driver);
		pd.setUserDetails(string, string2, string3, string4);
	}
	@When("i give donation amount {string}")
	public void i_give_donation_amount(String string) {
		pd=new PublicDonationRepo(driver);
		pd.setDonationAmount(string);
	}
	@When("i give user address details {string} {string} {string} {string}")
	public void i_give_user_address_details(String string, String string2, String string3, String string4) throws InterruptedException {
		pd=new PublicDonationRepo(driver);
		
		pd.setUserAddress(string, string2, string3, string4);
		
	}
	@When("i give payment details {string} {string} {string} {string}")
	public void i_give_payment_details(String string, String string2, String string3, String string4) {
		pd=new PublicDonationRepo(driver);
		driver.switchTo().frame(pd.getFrame());
		pd.setDebitaCardDetails(string, string2, string3, string4);
		driver.switchTo().parentFrame();
		
		
	}
	@When("i click donate button")
	public void i_click_donate_button() throws InterruptedException {
		pd=new PublicDonationRepo(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", pd.getDonateButton());
		pd.clickDonateButton();

	}
	
	@Then("the form should submit and show cofirm message and user should download the receipt")
	public void the_form_should_submit_and_show_cofirm_message_and_user_should_download_the_receipt() throws IOException {
		pd=new PublicDonationRepo(driver);
		boolean flag=false;
		try {
			String text=pd.getDonationCfnMsg();
			if(text.contains("You will receive an email shortly confirming the donation"))
			{
				assertTrue(true);
				flag=true;
				
			}
		} catch (Exception e) {
			if(flag==false)
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File trg=new File("FailedScreenShots/LoginFun/donationfail.png");
				FileUtils.copyFile(src, trg);
				driver.close();
			}
			assertTrue(flag);
		}
	}
	@Then("the donor name should display to admin")
	public void the_donor_name_should_display_to_admin() {
		pd=new PublicDonationRepo(driver);
		pd.clickLogin();
		lp=new LoginPageRepo(driver);
		lp.setUserName("t1admin");
		lp.setPassword("%^&$T1Affnetz#$");
		lp.clickLoginButton();
	   
	}

}
