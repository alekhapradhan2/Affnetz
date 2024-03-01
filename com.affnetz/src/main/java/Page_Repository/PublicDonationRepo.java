package Page_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PublicDonationRepo {
	
	 public WebDriver driver;
	 
	 @FindBy(xpath = "(//div[@class='col'])[1]")
	 private WebElement donationText;
	 
	@FindBy(id = "input-11")
	private WebElement fname;
	
	@FindBy(id = "input-14")
	private WebElement lname;
	
	@FindBy(id = "input-17")
	private WebElement phoneNo;
	
	@FindBy(id = "input-20")
	private WebElement emailInput;
	
	@FindBy(id = "input-28")
	private WebElement donationAmount;
	
	@FindBy(id = "input-40")
	private WebElement addressOne;
	
	@FindBy(id = "input-46")
	private WebElement cityInput;
	
	@FindBy(id="input-49")
	private WebElement stateInput;
	
	@FindBy(xpath  = "//div[@role='listbox']")
	private WebElement stateListParent;
	
	@FindBy(xpath = "//div[contains(@id,'list-item-66')]")
	private List<WebElement> stateNameList;
	
	@FindBy(id="input-59")
	private WebElement zipcodeInput;
	
	@FindBy(xpath = "//iframe[contains(@name,'__privateStripeFram')]")
	private WebElement debitcardFrame;
	
	@FindBy(xpath = "//input[@name='cardnumber']")
	private WebElement debitCardNoInput;
	
	@FindBy(xpath = "//input[@name='exp-date']")
	private WebElement expDateInput;
	
	@FindBy(xpath = "//input[@name='cvc']")
	private WebElement cvcInput;
	
	@FindBy(xpath="//input[@name='postal']")
	private WebElement postalInput;
	
	@FindBy(xpath = "//button[@id='donate_btn']")
	private WebElement donateButton;
	
	@FindBy(xpath = "//p[contains(@class,'af-text-4xl')]")
	private WebElement donationCofirm;
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	
	//COnstructor
	public PublicDonationRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Methods
	
	public void setUserDetails(String firstname,String lastname,String ph,String mail)
	{
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		phoneNo.sendKeys(ph);
		emailInput.sendKeys(mail);
	}
	
	public void setDonationAmount(String amount)
	{
		donationAmount.sendKeys(amount);
	}
	
	public void setUserAddress(String add,String city,String state,String zip) throws InterruptedException
	{
		Thread.sleep(1000);
		addressOne.sendKeys(add);
		cityInput.sendKeys(city);
		stateInput.click();
		Thread.sleep(1000);
		List<WebElement> stateL=stateNameList;
		for(WebElement x:stateL)
		{
			String stateName=x.getText();
			if(stateName.equalsIgnoreCase(state))
			{
				x.click();
				break;
			}
			
		}
		
		zipcodeInput.sendKeys(zip);
	}
	
	public WebElement getFrame()
	{
		return debitcardFrame;
	}
	
	public void setDebitaCardDetails(String cardNo,String expDate,String cvv,String postal)
	{
		
		debitCardNoInput.sendKeys(cardNo);
		expDateInput.sendKeys(expDate);
		cvcInput.sendKeys(cvv);
		postalInput.sendKeys(postal);
		
	}
	public void clickDonateButton() {
		donateButton.click();
	}
	
	public WebElement getDonateButton() {
		return donateButton;
	}
	
	public String donationText()
	{
		String text=donationText.getText();
		return text;
	}
	
	public String getDonationCfnMsg()
	{
		String msg=donationCofirm.getText();
		return msg;
	}
	public void clickLogin()
	{
		loginLink.click();
	}
}

	
	
	
	
	
	
	
	

