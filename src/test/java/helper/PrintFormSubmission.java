package helper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PrintFormSubmission {

	private JavascriptExecutor jse = null;
	private Map<String, Object> map = null;

	public void printData(WebDriver driver) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map = new HashMap<>();
		jse = ((JavascriptExecutor) driver);
		map = (Map<String, Object>) jse.executeScript("return ava.marketingapi.payload;");
		// map = (Map<String, Object>) jse.executeScript("return
		// ava.form.fields.opp_subtype;");

		for (String key : map.keySet()) {
			System.out.println(key + "" + map.values());
		}

		System.out.println("Printing the key set" + map.keySet());

		System.out.println("Transaction id-> " + map.get("transaction_id"));

		Map data = (Map) map.get("data");
		System.out.println(data.get("email"));
	}
}
