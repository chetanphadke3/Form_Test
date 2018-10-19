package helper;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FormInTestMode {

	public void putFormInTestMode(String url, WebDriver driver) throws IOException {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);

		String file = "C:\\chetan.phadke\\putForm1.js";
		FileRead fr = new FileRead();
		String script = fr.readFile(file);
		jse.executeScript(script);

		System.out.println("Avaform is in test mode now.");
	}

}
