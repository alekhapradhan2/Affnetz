package Stepdefination;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Page_Repository.DashboardRepo;
import Page_Repository.LoginPageRepo;
import Page_Repository.PublicDonationRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PublicDonation {
	
	
	public WebDriver driver;
	public PublicDonationRepo pd;
	public LoginPageRepo lp;
	public DashboardRepo db;
	
	String donorName,Email,phNo,Amount;
	Random rm=new Random();
	int x=rm.nextInt(1000);
	
	
	@Given("the user is open public donation page")
	public void the_user_is_open_public_donation_page() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		String url="https://t1.affnetz.org/donate";
		driver.get(url);
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
	public void i_give_user_details(String fname, String lname, String No, String mailid) {
		fname=fname+x;
		lname=lname+x;
		mailid=mailid+x+"@affnetz.com";
		pd=new PublicDonationRepo(driver);
		donorName=fname+" "+lname;
		phNo=No;
		Email=mailid;
		
		pd.setUserDetails(fname, lname, No, mailid);
	}
	@When("i give donation amount {string}")
	public void i_give_donation_amount(String donateAmount) {
		donateAmount=donateAmount+x;
		pd=new PublicDonationRepo(driver);
		Amount=donateAmount;
		pd.setDonationAmount(donateAmount);
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
	
	@When("user click on Receipt download link")
	public void user_click_on_receipt_download_link() {
		pd=new PublicDonationRepo(driver);
		pd.clickOnReceiptDownload();
	}
	@Then("user should see the donation receipt")
	public void user_should_see_the_donation_receipt() throws IOException, InterruptedException {
	   Thread.sleep(3000);
	   String url=driver.getCurrentUrl();
	   boolean flag=false;
	   if(url.contains("donate/download-invoice"))
	   {
		   TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg=new File("FailedScreenShots/LoginFun/donateReceipt.png");
			FileUtils.copyFile(src, trg);
			
			flag=true;
	   }
	   assertTrue(flag);
	  
	}
	@Then("i login as a aadmin")
	public void i_login_as_a_aadmin() {
			
		driver.get("https://t1.affnetz.org/login");
		lp=new LoginPageRepo(driver);
		lp.setUserName("t1admin");
		lp.setPassword("%^&$T1Affnetz#$");
		lp.clickLoginButton();
	}
	
	@Then("the donation details should display to admin correctly")
	public void the_donation_details_should_display_to_admin_correctly() throws IOException, InterruptedException {
	  db=new DashboardRepo(driver);
	  db.clickMonthDonorList();
//	  db.setNewDonorName(donorName);
//	  db.clickOnSearchButton();
	  
	  db.clickOnSortingList();
	  Thread.sleep(2000);
	  List<WebElement> list=db.getsortingList();
	  list.get(2).click();
	  Thread.sleep(3000);
	  boolean flag=false;	
	 
			
			List<WebElement> row=db.getDonorTable().findElements(By.tagName("tr"));
			for(int i=1;i<row.size();i++)
			{
				  List<WebElement> col=row.get(i).findElements(By.tagName("td"));
				  String name=col.get(0).getText();
				  String mail=col.get(1).getText();
				  String amount=col.get(4).getText();
				  if(name.equals(donorName) )
				  {
					  flag=true;
					  
				  }
				  
			  }
			assertTrue(flag, "Donor Name Found");
	  	
		  
	  
	  
	  
	}
}
