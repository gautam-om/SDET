package com.crm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUnit.WebDriverUtility;

public class CreateOrganizationPage {
	
	public class CreateOrganisationPage extends WebDriverUtility{
		
		public CreateOrganisationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="accountname")
		private WebElement organiName;
		
		@FindBy(name="industry")
		private WebElement indusDropdown;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButt;

		
		
		
		public WebElement getOrganiName() {
			return organiName;
		}


		public WebElement getIndusDropdown() {
			return indusDropdown;
		}


		public WebElement getSaveButt() {
			return saveButt;
		}


		public void createOrganization(String orgName, String industryType)
		{
			organiName.sendKeys(orgName);
		    selectOption(indusDropdown, industryType);
		    saveButt.click();
		}

	}

}
