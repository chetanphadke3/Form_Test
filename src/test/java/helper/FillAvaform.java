package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillAvaform {

	// private WebDriver driver = null;
	public WebDriverWait wait = null;

	/***************** WebElements *****************/

	private static final String nameXpath = "//*[@id='avaform-name']";
	private static final String emailXpath = "//*[@id='avaform-email']";
	private static final String companyXpath = "//*[@id='avaform-company']";
	private static final String phoneXpath = "//*[@id='avaform-phone']";
	private static final String submitbtnXpath = "//*[@id='avaform-submit']";

	/***************** End of WebElements *****************/

	/*************** Filling the Form Fields **********************/
	// Filling Name
	public void fillName(WebDriver driver) {
		WebElement name = driver.findElement(By.xpath(nameXpath));
		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(name));

		clearName(name);

		name.sendKeys("Chetan P");

		System.out.println("Name Entered");

	}

	// Filling Email
	public void fillEmail(WebDriver driver) {
		WebElement email = driver.findElement(By.xpath(emailXpath));
		wait.until(ExpectedConditions.visibilityOf(email));

		clearEmail(email);

		email.sendKeys("cp@avlr.net");

		System.out.println("Email Entered");
	}

	// Filling Company name.
	public void fillCompany(WebDriver driver) {
		WebElement company = driver.findElement(By.xpath(companyXpath));
		wait.until(ExpectedConditions.visibilityOf(company));

		clearCompany(company);

		company.sendKeys("avlr");

		System.out.println("Company Entered");
	}

	// Filling phone number.
	public void fillPhone(WebDriver driver) {
		WebElement phone = driver.findElement(By.xpath(phoneXpath));
		wait.until(ExpectedConditions.visibilityOf(phone));

		clearPhone(phone);

		phone.sendKeys("9090909099");

		System.out.println("Phone Entered");
	}

	// Submitting the Form.
	public void submitAvaform(WebDriver driver) {
		WebElement submitBtn = driver.findElement(By.xpath(submitbtnXpath));
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		submitBtn.click();
		System.out.println("Form Submitted");
	}

	/*************** Clearing the Form Fields **********************/
	private void clearName(WebElement name) {
		try {
			name.clear();
			System.out.println("Name field got cleared");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void clearEmail(WebElement email) {
		try {
			email.clear();
			System.out.println("Email field got cleared");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void clearCompany(WebElement company) {
		try {
			company.clear();
			System.out.println("Company field got cleared");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void clearPhone(WebElement phone) {
		try {
			phone.clear();
			System.out.println("Phone field got cleared");
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
