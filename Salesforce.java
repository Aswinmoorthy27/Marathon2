package Marathon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.utils.FileUtil;

import io.cucumber.java.de.Wenn;
import io.github.sukgu.Shadow;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Chromeoptions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// driver
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Url
		driver.get("https://login.salesforce.com/");

		// Username and Pwd
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");

		driver.findElement(By.id("password")).sendKeys("Leaf@1234");

		driver.findElement(By.id("Login")).click();

		// Click on Learn More link in Mobile Publisher
		Thread.sleep(10000);
		WebElement Learnmore = driver.findElement(By.xpath("//span[text()='Learn More']"));

		Actions Action = new Actions(driver);
		Action.moveToElement(Learnmore).click().perform();

		// switch window
		Set<String> Windows = driver.getWindowHandles();
		Windows.size();

		List<String> windowslist = new ArrayList<String>(Windows);
		String mobilewindow = windowslist.get(1);

		Thread.sleep(2000);
		driver.switchTo().window(mobilewindow);

		// window confirm
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		// Click Learning
		// shadow
		Shadow shadow = new Shadow(driver);
		WebElement Learning = shadow.findElementByXPath("//span[text()='Learning']");

		Thread.sleep(2000);
		Action.moveToElement(Learning).click().perform();

		// learning on trailhead

		WebElement trailhead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Thread.sleep(2000);
		Action.moveToElement(trailhead).perform();

		// And mouse hover on Learning On Trailhead
		Thread.sleep(2000);
		WebElement salesforce = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		Action.moveToElement(salesforce).click().perform();

		// Clilck on Salesforce Certifications
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])")).click();

		// verify title
		String Title = driver.getTitle();
		System.out.println(Title);

		String ActualTitel = "Certification - Administrator Overview";

		if (ActualTitel.equals(Title)) {
			System.out.println("Printed title is right");

		} else {
			System.out.println("Printed title is not-right");

		}

		// Print the certificate list
		List<WebElement> Certificatetitle = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));

		for (WebElement Certificate : Certificatetitle) {
			Certificate.getText();
			System.out.println("Printing certificate details" + Certificate.getText());
		}
		
		Thread.sleep(2000);
		WebElement Scroll = driver.findElement(By.xpath("//div[@class='credentials-card_title']"));
		Action.scrollToElement(Scroll).perform();

		// take a snap shot
		File Source = driver.getScreenshotAs(OutputType.FILE);
		File Target = new File("./seleniumMaven/target/screenshot/snap1.png");
		FileUtils.copyFile(Source, Target);
	}

}
