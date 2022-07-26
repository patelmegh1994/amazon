package com.amazon.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.amazon.qa.base.TestBase;


public class SignInPage extends TestBase{
	
	static SignInPage t1 = new SignInPage();
	
	@FindBy(id = "nav-link-accountList")
	WebElement account;
	
	@FindBy(id = "nav-flyout-ya-signin")
	WebElement user;
	
	@FindBy(name ="email")
	WebElement name;
	
	@FindBy(id="continue")
	WebElement conti;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(id= "signInSubmit")
	WebElement submit;
	
	@FindBy(xpath= "//i[@class ='a-icon a-icon-logo']")
	WebElement logo;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	WebElement errMsg;
	
	@FindBy(xpath= "//span[@class='a-list-item']")
	WebElement passErr;
	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String SignInPageTitle() {
		return driver.getTitle();
	}
	
	public boolean pageLogo() {
		return logo.isDisplayed();
	}
	
	public String wrongEmail() {
		
		String mail = info.getCellData("Sheet1",0,2);
		name.sendKeys(mail);
		
		conti.click();
		
		String actualMailErr = errMsg.getText();
		System.out.println(actualMailErr);
		
		return actualMailErr;
		
	}
	
	public String wrongPass() {
	
		String mail = info.getCellData("Sheet1",0,3);
		name.sendKeys(mail);
		
		conti.click();
		
		wait.until(ExpectedConditions.visibilityOf(password));
		
		String pass1 = info.getCellData("Sheet1", "Password", 2);
		password.sendKeys(pass1);
		
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		
		submit.click();
		
		String passwordErr = passErr.getText();
		System.out.println(passwordErr);
		
		return passwordErr;
	
	}
	
	public HomePage correctsignIn() {
		
		String mail = info.getCellData("Sheet1",0,3);
		name.sendKeys(mail);
		
		conti.click();
		
		wait.until(ExpectedConditions.visibilityOf(password));
		
		String pass1 = info.getCellData("Sheet1", "Password", 3);
		password.sendKeys(pass1);
		
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		
		submit.click();
	
		return new HomePage();
	}
	
	

}
