package Stepdefination;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page_Repository.LoginPageRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginStepDefinitions {
	
		public WebDriver driver;
		public LoginPageRepo lp;
		
	//........................................Browser Open.........................................................//	
	
	@Given("the user is on the login page at {string}")
	public void the_user_is_on_the_login_page_at(String string) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://t1.affnetz.org/members");
	    
	}
	
	//........................................Browser close.........................................................//
	
	@Then("i close the browser")
	public void i_close_the_browser() {
	    driver.close();
	}
	
	//........................................Valid login check.........................................................//
	
	@When("the user enters a valid username {string}")
	public void the_user_enters_a_valid_username(String string) {
		lp=new LoginPageRepo(driver);
	    lp.setUserName(string);
	}
	@When("the user enters a valid password {string}")
	public void the_user_enters_a_valid_password(String string) {
		lp=new LoginPageRepo(driver);
	    lp.setPassword(string);
	}
	@When("clicks on the login button")
	public void clicks_on_the_login_button() throws IOException {
		lp=new LoginPageRepo(driver);
	   lp.clickLoginButton();
		
	}
	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() throws IOException {
		boolean flag=false;
		try {
			
			if(lp.getlogoutButton().isDisplayed())
			{
				assertTrue(true);
				flag=true;
			}
		} catch (Exception e) {
			
			if(flag==false)
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File trg=new File("C:\\Users\\Dell\\git\\repository\\com.affnetz\\FailedScreenShots\\LoginFun\\validLoginfailed.png");
				FileUtils.copyFile(src, trg);
				driver.close();
			}
			
			assertTrue(flag);	
		}
		

		
	}
	@When("i click on logout button")
	public void i_click_on_logout_button() throws IOException {
		
		
		try {
			lp=new LoginPageRepo(driver);
			lp.getlogoutButton().click();
		} catch (Exception e) {
			
		}
	}
	@Then("the user should logged out")
	public void the_use_should_logged_out() {
		
		if(lp.getLoginButtob().isDisplayed())
		{
			assertTrue(true);
		}
		
	}
	
	
	//........................................invalid login check.........................................................//
	
	
	@When("the user enters a invalid username {string}")
	public void the_user_enters_a_invalid_username(String string) {
		lp=new LoginPageRepo(driver);
		lp.setUserName(string);
	}
	@When("the user enters a invalid password {string}")
	public void the_user_enters_a_invalid_password(String string) {
		lp=new LoginPageRepo(driver);
		lp.setPassword(string);
	}
	@Then("the system should show error message to user")
	public void the_system_should_show_error_message_to_user() throws IOException {
		
		boolean flag=false;
		try {
			if(lp.getErrormessage().isDisplayed())
			{
				assertTrue(true);
				flag=true;
			}
		} catch (Exception e) {
			if(flag==false)
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File trg=new File("C:\\Users\\Dell\\Desktop\\Automation\\com.affnetz\\FailedScreenShots\\LoginFun\\InvalidLoginfailed.png");
				FileUtils.copyFile(src, trg);
				driver.close();
			}
			
			assertTrue(flag);
			
		}
		
		
			
			
		
	}


	
	    



}
