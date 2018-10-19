package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.eclipse.jetty.websocket.common.AcceptHash;
import org.openqa.selenium.WebDriver;

import helper.AvaformCheck;
import helper.FillAvaform;
import helper.FormInTestMode;
import helper.PrintFormSubmission;

public class OpenURL extends FillAvaform {
	private static Properties prop = null;
	static int avaFormFound = 0;
	static int avaFormNotFound = 0;

	static {
		File file = new File("config.properties");
		try {
			FileInputStream input = new FileInputStream(file);
			prop = new Properties();
			prop.load(input);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver openURL(WebDriver driver) throws IOException {
		driver.manage().deleteAllCookies();
		// Maximizing the window.
		driver.manage().window().maximize();

		// Opening the url from configuration file.
		int total_urls = prop.size();
		System.out.println("Total Number of URLs-> " + total_urls);

		for (int i = 1; i <= total_urls; i++) {
			driver.get(prop.getProperty("url" + i));
			System.out.println("------------Test Case" + i + "------------");
			String url = driver.getCurrentUrl();
			
			//Printing url for debugging purpose.
			System.out.println(driver.getCurrentUrl());
			AvaformCheck ac = new AvaformCheck();
		
			boolean x = ac.isFormAvailable(url, driver);
			String version = ac.avaFormVersion(url, driver);
			ac.avaConfiguration(url, driver);
			if (x == true) {
				System.out.println("Avaform exists on ->" + driver.getCurrentUrl());
				avaFormFound++;
				System.out.println("Avaform version is-> " + version);
				FillAvaform fa = new FillAvaform();
				System.out.println("Putting the form in Test mode->");
				FormInTestMode fitm = new FormInTestMode();
				PrintFormSubmission pfs = new PrintFormSubmission();

				fitm.putFormInTestMode(url, driver);
				// Filling the name.
				fa.fillName(driver);

				// Filling the email.
				fa.fillEmail(driver);

				// Filling the company.
				fa.fillCompany(driver);

				// Filling the company.
				fa.fillPhone(driver);

				// Commmenting for Testing the framework run..
				
				  //Submit the form 
				//fa.submitAvaform(driver);
				  
				  //Print Submitted data. pfs.printData(driver);
				 

			} else {
				System.out.println("Avaform doesn't exist->" + driver.getCurrentUrl());
				avaFormNotFound++;
			}
		}

		System.out.println("Avaform existed on " + avaFormFound + " pages.");
		System.out.println("Avaform was not found on " + avaFormNotFound + " pages.");
		return driver;
	}

}
