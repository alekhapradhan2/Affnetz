package Page_Repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostCreationRepo {
	
	@FindBy(linkText = "Home")
	private WebElement homeLink;
	
	@FindBy(xpath = "//a[@class='post-btn']")
	private WebElement createPostButton;
	
	@FindBy(xpath = "//input[@name='heading']")
	private WebElement headlineInput;
	
	@FindBy(id="postTag")
	private WebElement taginput;
	
	@FindBy(xpath = "//div[@class='v-select__selections']")
	private WebElement clickTag;
	
	@FindBy(id = "list-163")
	private WebElement tagList;
	
	@FindBy(xpath = "//div[contains(@id,'list-item-172')]")
	private List<WebElement> allTag;
	
	@FindBy(xpath = "//div[@class='ql-editor ql-blank']")
	private WebElement contentInput;
	
	@FindBy(xpath = "//button[@name='action']")
	private WebElement postButton;
	
	@FindBy(xpath = "//form[@class='v-form']")
	private WebElement form;
	
	@FindBy(xpath = "(//div[contains(@class,'gray-700')])[1]")
	private WebElement contentVerify;
	
	@FindBy(xpath = "(//div[contains(@class,'gray-900')])[1]")
	private WebElement headlinetVerify;
	
	@FindBy(xpath="(//div[contains(@class,'postlist')])[1]")
	private WebElement tagVerify;
	
	//Constructor
		public PostCreationRepo(WebDriver driver)
		{
			
			PageFactory.initElements(driver,this);
		}
		
	public void clickHomeLink() {
		homeLink.click();
	}
	
	public void clickCreatePost()
	
	{
		createPostButton.click();
	}
		
	public boolean verifyCreatPostPage() {
		if(headlineInput.isDisplayed()&& contentInput.isDisplayed())
		{
			return true;
		}else {
			return false;
		}
	}
	public void setHeadline(String heading)
	{
		headlineInput.sendKeys(heading);
	}
	
	public void selectTag(String tag) throws InterruptedException
	{
		clickTag.click();
		taginput.sendKeys(tag);
		
		headlineInput.click();
	}
	
	public void setContent(String cont) throws InterruptedException
	{
		
		contentInput.sendKeys(cont);
		Thread.sleep(1000);
	}
	
	public void clickPostButton() throws InterruptedException
	{
		Thread.sleep(1000);
		postButton.click();
	}
	public void submitForm()
	{
		form.submit();
	}
	public boolean verifyHeadingName(String heading)
	{
		String h=headlinetVerify.getText();
		if(h.equals(heading))
		{
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifyContentName(String content)
	{
		String h=contentVerify.getText();
		if(h.equals(content))
		{
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifyTagName(String tag)
	{
		String t=tagVerify.getText();
		if(t.contains(tag))
		{
			return true;
		}else {
			return false;
		}
	}
	
	
}
