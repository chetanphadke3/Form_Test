package helper;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AvaformCheck {

	private boolean avaFormExist = false;

	public boolean isFormAvailable(String url, WebDriver driver) {

		String legacyForm = ".avaform-wrapper";
		String aemForm = "ava_tag_routing_product";

		String avaFormContainer = driver.getPageSource();
		if (avaFormContainer.contains(legacyForm)) {
			avaFormExist = true;
		} else if (avaFormContainer.contains(aemForm)) {
			avaFormExist = true;
		}
		return avaFormExist;

	}

	public String avaFormVersion(String url, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String command = "return ava.form.version;";
		String version = (String) jse.executeScript(command);
		return version;
	}

	public Map<Object, String> avaConfiguration(String url, WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String command = "return ava.util.config.getObject();";
		Map<Object, String> config = (Map) jse.executeScript(command);
		System.out.println(config.keySet());

		return config;
	}

}
