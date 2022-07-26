package com.amazon.qa.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.amazon.qa.base.TestBase;


public class HomePage extends TestBase{
	
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
	
	@FindBy(xpath = "//span[contains(text(),'Canada')]")
	WebElement glocation;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement button;
	
	@FindBy(id="nav-link-accountList")
	WebElement account;
	
	@FindBy(id ="icp-touch-link-language")
	WebElement langu;
	
//	@FindBy(xpath ="icp-touch-link-country")
//	WebElement country;
	
	@FindBy(xpath = "//div[@class='navFooterVerticalColumn navAccessibility']")
	List<WebElement> footer;
	
	@FindBy(xpath ="//div[@id='nav-xshop']/a")
	List<WebElement> header;
	
	@FindBy(id = "nav-flyout-ya-signin")
	WebElement user;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean pageLogo() {
		return logo.isDisplayed();
	}
	
	public String globalLocation() {
		return glocation.getText();
	}
	
	public ProductPage search() {
		
		String searchData = prop.getProperty("search");
		
		searchBox.sendKeys(searchData);
		
//		List<WebElement> searchLi = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div"));
//		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='autocomplete-results-container']/div"),10));
		//System.out.println("The Number of Suggestion Links are availble in Suggestion Box are:"+searchLi.size());
		
		button.click();
		
		
		return new ProductPage();
	}
	
	public String languages() {
		
		return langu.getText();
	}
	
	public int footerList() {
		
		for(WebElement a:footer) {
			System.out.println(a.getText());
		}
		
		return footer.size();
	}
	
	public int headerList() {
		
		for(WebElement a: header) {
			System.out.println(a.getText());	
		}
		return header.size();
	}
	
	public SignInPage signInacc() {
		
		Actions builder = new Actions(driver);
		builder.moveToElement(account).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(user));
		
		user.click();
		
		return new SignInPage();
		
	}
	
}
