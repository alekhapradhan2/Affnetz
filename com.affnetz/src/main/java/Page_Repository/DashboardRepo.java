package Page_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardRepo {
		
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[contains(@href,'month-donor-list')]")
	private WebElement monthDonorList;
	
	@FindBy(xpath = "//a[contains(@href,'donations-repor')]")
	private WebElement donationReport;
	
	@FindBy(id = "input-70")
	private WebElement searchNewDonor;
	
	@FindBy(xpath = "//span[contains(text(),'SEARCH')]")
	private WebElement searchButton;
	
	@FindBy(xpath = "(//tbody)[1]")
	private WebElement donorTable;
	
	@FindBy(xpath = "//div[@class='v-select__selections']")
	private WebElement sortingClick;
	
	@FindBy(xpath ="//div[contains(@id,'list-item-114')]" )
	private List<WebElement> sortingList;
	//COnstructor
	
	public DashboardRepo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickMonthDonorList()
	{
		monthDonorList.click();
	}
	
	public void clickDonationRepost() {
		donationReport.click();
	}
	
	public void setNewDonorName(String newDonor)
	{
		searchNewDonor.sendKeys(newDonor);
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public WebElement getDonorTable()
	{
		return donorTable;
	}
	
	public void clickOnSortingList()
	{
		sortingClick.click();
	}
	
	public List<WebElement> getsortingList()
	{
		return sortingList;
	}
}
