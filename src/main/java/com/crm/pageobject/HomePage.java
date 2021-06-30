 package com.crm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUnit.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organiLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIMG;
	
	@FindBy(linkText="Sign Out")
	private WebElement sigout;
	

	public WebElement getOrganiLink() {
		return organiLink;
	}

	public WebElement getAdminIMG() {
		return adminIMG;
	}

	public WebElement getSigout() {
		return sigout;
	}
	
	public void clickOrganization() 
	{
		organiLink.click();
		
	}
	public void clickSign()
	{
		mouseOver(driver,adminIMG );
		sigout.click();
	}
	
	
}