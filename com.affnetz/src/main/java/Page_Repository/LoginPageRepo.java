package Page_Repository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageRepo {

	public  WebDriver driver;
	@FindBy(id = "txtEmail")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[@title='logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath="//div[contains(@style,'text-align: left')]")
	private WebElement errormessage;
	
	@FindBy(xpath="//div[text()=\"Password required.\"]")
	private WebElement passwordRequired;
	
	@FindBy(xpath="//div[text()=\"Username required.\"]")
	private WebElement usernameRequired;
	
	//Constructor
	public LoginPageRepo(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getErrormessage() {
		return errormessage;
	}



	public WebElement getPasswordRequired() {
		return passwordRequired;
	}


	public WebElement getUsernameRequired() {
		return usernameRequired;
	}

	public void setUserName(String uname)
	{
		username.sendKeys(uname);
	}
	 
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickLoginButton()
	{
		loginButton.click();
	}
	public WebElement getLoginButtob()
	{
		return loginButton;
	}
	
	public WebElement getlogoutButton()
	{
		return logoutButton;
	}

		


	    
	}

