package com.crm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passEdt;

	@FindBy(id="submitButton")
	private WebElement subBtn;
	
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPassEdt() {
		return passEdt;
	}

	public WebElement getSubBtn() {
		return subBtn;
	}

	public void login(String username, String password) // Rule-5: In all testscripts Utilize the element using getter(), Business method.
	{
		usernameEdt.sendKeys(username);
		passEdt.sendKeys(password);
		subBtn.click();
	}
	

}
