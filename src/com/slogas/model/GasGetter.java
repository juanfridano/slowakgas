package com.slogas.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("gasGetter")
public class GasGetter {

	private String captionString;

	public String getCaptionString() {
		return captionString;
	}

	public GasEntity getData(String fullDate) {

		HtmlUnitDriver driver = driverStarter();

		GasEntity gasInst = instGetter(driver, fullDate);

		driverCloser(driver);

		return gasInst;

	}

	public GasEntity instGetter(HtmlUnitDriver driver, String fullDate) {
		String divider[] = fullDate.split("\\.");

		// Date Picker trigger
		WebElement trigger = driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
		// Tag showing Date corresponding to Data
		WebElement caption = driver.findElement(By.xpath("//th[@id='flows_aggregated_caption']"));

		//
		// Date selector begins
		//
		// select Month and Year

		Formatter forDate = new Formatter();
		trigger.click();
		Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
		year.selectByVisibleText(divider[2]);
		Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText(forDate.dateformatter(divider[1]));
		trigger.click();

		// select Day

		WebElement cal = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		List<WebElement> columns = cal.findElements(By.tagName("td"));

		// extra format for days
		// days 1-9 only one character long, remove "0"
		for (WebElement cell : columns) {

			String t = divider[0].substring(0, 1);
			String calDay = "";
			if (t.equals("0")) {
				calDay = divider[0].substring(1, 2);
			} else {
				calDay = divider[0];
			}

			// makes sure it belongs to the proper month
			// avoids mess-ups with last days prev. month || first days next
			// month
			if (cell.getText().equals(calDay)) {

				String cssClass = "ui-datepicker-other-month";
				String testClass = cell.getAttribute("class").toString();
				if (!testClass.contains(cssClass)) {

					cell.findElement(By.linkText(calDay)).click();
					break;

				}
			}
		}

		//
		// Date selector ends
		//
		// wait until loaded

		(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return caption.getText().toLowerCase().contains("day " + fullDate);
			}
		});

		captionString = caption.getText();

		System.out.println("Caption: " + captionString);

		// Amount of transmissions 4 main ones plus temporary ones
		// Domestics are not important
		WebElement table = driver.findElement(By.id("flows_aggregated_data"));
		List<WebElement> trCounter = table.findElements(By.xpath(".//tr"));
		int count = trCounter.size();

		System.out.println("\nSize of counter: " + count);

		// call the Object Constructor
		GasEntity gasTrans = new GasEntity(divider[2] + "-" + divider[1] + "-" + divider[0]);

		for (int i = 1; i <= count; i++) {

			String id = table.findElement(By.xpath(".//tr[" + i + "]/td[1]/a")).getAttribute("point_id");
			String value = table.findElement(By.xpath(".//tr[" + i + "]/td[2]")).getText();
			System.out.println(id + ": " + value);

			double v = Double.parseDouble(value.replaceAll("\\s+", ""));

			switch (id) {
			case "15":
				gasTrans.setBudince(v);
				break;
			case "1":
				gasTrans.setKapusany(v);
				break;
			case "9":
				gasTrans.setBaumgarten(v);
				break;
			case "11":
				gasTrans.setLanzhot(v);
				break;
			default:
				break;
			}

		}

		System.out.println("and the Bean is....: " + gasTrans.toString());

		// Persist it
		GasDAO persi = new GasDAO();
		persi.Persister(gasTrans);
		System.out.println("\n\n-------Persi Success!-------");

		


		return gasTrans;

	}

	public HtmlUnitDriver driverStarter() {
		final String url = "https://tis.eustream.sk/TIS/#/?nav=rd.flw";
		final HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.setJavascriptEnabled(true);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public void driverCloser(HtmlUnitDriver driver) {
		driver.close();
		System.out.println("Driver closure Success!");

	}

}
