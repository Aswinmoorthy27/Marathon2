package WindowsHandles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Index;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Enter UserName
		driver.findElement(By.id("username")).sendKeys("DemoCSR");

		// Enter Pwd
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click Login Button
		driver.findElement(By.className("decorativeSubmit")).click();

		// CRM button click
		driver.findElement(By.id("button")).click();

		// Click on contacts Button
		driver.findElement(By.partialLinkText("Contacts")).click();

		// click on Merge Contacts
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		Thread.sleep(2000);
		/// driver.findElement(By.id("ext-gen521")).click();

		// click button
		Thread.sleep(2000);

		// entry of table
		driver.findElement(By.xpath("//table[@class='twoColumnForm']")).click();
		Thread.sleep(2000);
		// taking list
		List<WebElement> Tt = driver.findElements(By.tagName("td"));
		System.out.println("getting size " + Tt.size());
		Thread.sleep(2000);

		// clicking widget (xpath needs to check)
		WebElement from = driver.findElement(By.id("ComboBox_partyIdFrom"));
		from.sendKeys("Abi kannah", Keys.ENTER);

		// To
		WebElement To = driver.findElement(By.id("ComboBox_partyIdTo"));
		To.sendKeys("Aish S", Keys.ENTER);

		// merge
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// Popup
		Alert alert = driver.switchTo().alert();
		String title = alert.getText();
		System.out.println("title of alert is " + title);

		// alert accept
		alert.accept();

		// verify title page
		String currenttitle = driver.getTitle();
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(currenttitle);

		if (!title.equalsIgnoreCase(currenttitle)) {
			System.out.println("Title is verified and passed");
		} else {
			System.out.println("Title is not verified and failed");
		}

	}

}
