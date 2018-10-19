package testcases;

import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.FillAvaform;
import utility.OpenURL;

public class Test1 {
	public WebDriver driver = null;

	//Launching a browser using parameter annotations and executing the script sequencially.
	@BeforeClass
	@Parameters("browser")
	public void beforeTest(String browser) {
	//Checking if the Chrome browser is mentioned in the testng.xml and if it exists then assigning to the webdriver.	
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\chetan.phadke\\Backup\\Data from D\\software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else {
			System.out.println("not working");
		}
	}

	@Test
	public void firstRun() throws IOException {
		OpenURL ou = new OpenURL();
		/*driver = ou.openURL(driver);*/
		driver.get("http://localhost:8080/Avaform-develop/Avaform-develop/marvar-calculator");

	}

	@AfterTest
	@Parameters("browser")
	public void afterTest(String browser) {

		// Printing the Browser and Closing the driver.
		System.out.println("Test case completed successfully!" + "\n Closing the browser-" + browser);
		driver.quit();

	}
}
