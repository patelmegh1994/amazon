package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	//@FindBy(id = "a-autoid-7-announce")
	//WebElement sort;
	
	@FindBy(xpath = "//div[@id='brandsRefinements']/ul/li")
	WebElement brand;
	
	@FindBy(xpath= "//div[@id='departments']/ul/li")
	List<WebElement>department;
	
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
	
	@FindBy(xpath="//div[@id='priceRefinements']/ul[1]/li" )
	List<WebElement> price;
	
	@FindBy(xpath="//img[@alt='DualSense Wireless Controller - White']")
	WebElement ProdPic;
	
	@FindBy(xpath="//span[text()='DualSense Wireless Controller - White']")
	WebElement ProdLink;
	
	@FindBy(id="low-price")
	WebElement min;
	
	@FindBy(id = "high-price")
	WebElement max;
	
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement go;
	
	@FindBy(xpath ="//input[@id='add-to-cart-button']")
	WebElement addToCart;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public int proPrice() {
		// add the price limit 
		for(WebElement data: price) {
			System.out.println(data.getText());
			
			if(data.getText().equals("$50 to $100")) {
				data.click();
				break;
			}
		}
		return price.size();
	}
	
	public boolean prodLogo() {
		return logo.isDisplayed();
	}
	
	public int proBrand() {
		
		// click on the any categories from the department 
		for(WebElement name: department) {
			System.out.println(name.getText());
			
			if(name.getText().equals("PlayStation 5 Accessories")) {
				System.out.println(driver.getTitle());
				name.click();
				break;
			}
		}
		return department.size();
	}
	
	public String productLink() throws InterruptedException {
		
		ProdLink.click();	
	
		WebElement prodColour = driver.findElement(By.xpath("//p[contains(text(),'Midnight Black Controller')]"));
		wait.until(ExpectedConditions.visibilityOf(prodColour));
		prodColour.click();
		
		//wait.until(ExpectedConditions.elementToBeSelected(prodColour));
			
		Thread.sleep(2000);
		
		WebElement quati = driver.findElement(By.xpath("//select[@id='quantity']"));
		//wait.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		Select qty =new Select(quati);
		qty.selectByValue("2");
		
		//wait.until(ExpectedConditions.elementToBeSelected(quati));
		
		Thread.sleep(2000);
		
		addToCart.click();
		
		Thread.sleep(2000);
		
		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);
		
		return actualTitle;
			
	}
}
