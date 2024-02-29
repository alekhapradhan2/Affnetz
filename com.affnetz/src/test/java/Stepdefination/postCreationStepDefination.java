package Stepdefination;

import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page_Repository.LoginPageRepo;
import Page_Repository.PostCreationRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class postCreationStepDefination {
	
	public WebDriver driver;
	public LoginPageRepo lp;
	public PostCreationRepo pc;
	
	String headline,content,tag;
	
	Random rm=new Random();
	int x=rm.nextInt(200);
	
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://t1.affnetz.org/login");
	   
	}
	@When("user enter the valid username {string} and password {string}")
	public void user_enter_the_valid_username_and_password(String string, String string2) {
		lp=new LoginPageRepo(driver);
	    lp.setUserName(string);
	    lp.setPassword(string2);
	}
	@When("click on login button")
	public void click_on_login_button() {
		lp.clickLoginButton();
	}
	@When("i click create a post")
	public void i_click_create_a_post() throws InterruptedException {
		pc=new PostCreationRepo(driver);
		pc.clickHomeLink();
		pc.clickCreatePost();
	   
	}
	@Then("system should open create post page")
	public void system_should_open_create_post_page() {
		
		pc=new PostCreationRepo(driver);
		boolean flag=pc.verifyCreatPostPage();
		assertTrue(flag);
		
	  
	}
	@When("user give headline {string}")
	public void user_give_headline(String string) {
		headline=string+x;
		pc=new PostCreationRepo(driver);
		pc.setHeadline(string+x);
		
	  
	}
	@When("select tag name from dropdwon {string}")
	public void select_tag_name_from_dropdwon(String string) throws InterruptedException {
		tag=string+x;
		pc=new PostCreationRepo(driver);
		pc.selectTag(string+x);
	   
	}
	@When("write content details {string}")
	public void write_content_details(String string) throws InterruptedException {
		content=string+x;
		pc=new PostCreationRepo(driver);
		pc.setContent(string+x);
	   
	}
	@When("click on post  button")
	public void click_on_post_button() throws InterruptedException {
		pc=new PostCreationRepo(driver);
		pc.submitForm();
	   
	}
	@Then("this post should be posted and shown in latest update section with all valid details")
	public void this_post_should_be_posted_and_shown_in_latest_update_section_with_all_valid_details() {
		pc=new PostCreationRepo(driver);
		boolean head=pc.verifyHeadingName(headline);
		System.out.println(headline);
		assertTrue(head);
		boolean tagN=pc.verifyTagName(tag);
		System.out.println(tag);
		assertTrue(tagN);
		boolean cont=pc.verifyContentName(content);
		assertTrue(cont);
	}
	
	@Then("i logout")
	public void i_logout() {
	   lp=new LoginPageRepo(driver);
	   lp.getlogoutButton().click();
	}
	@Then("close the browser")
	public void close_the_browser() {
	   driver.close();
	}

}
