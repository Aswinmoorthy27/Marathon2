package AUT;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.nykaa.com/");

		WebElement Hover = driver.findElement(By.xpath("//a[text()='brands']"));

		// hover
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(Hover).perform();

		// Pass brand name "lorel"
		WebElement passvalue = driver.findElement(By.id("brandSearchBox"));
		passvalue.sendKeys("L'Oreal Paris", Keys.ENTER);
		driver.findElement(By.partialLinkText("L'Oreal Paris")).click();

		// loreal title
		String currentpagetitel = driver.getTitle();
		System.out.println(":Getting Curent page title " + currentpagetitel);

		// sort click toprated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@class='control-indicator radio '])[3]")).click();

		// Click Category and click Hair->Click haircare->Shampoo
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		// click on concern

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		// check whether the Filter is applied with Shampoo
		Thread.sleep(1000);
		WebElement Mousehvr = driver.findElement(By.xpath("//div[@class='css-43m2vm']"));

		// hvr to click
		Thread.sleep(1000);
		mousehover.click(Mousehvr).perform();

		// GO to the new window and select size as 175ml
		Set<String> WindoInt = driver.getWindowHandles();
		int size = WindoInt.size();
		System.out.println(size);

		List<String> Arr = new ArrayList<String>(WindoInt);
		System.out.println(Arr.get(1));

		// switch window
		driver.switchTo().window(Arr.get(1));
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();

		// Print the MRP of the product
		WebElement Mrp = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e'])[1]"));
		String Mrpvalue = Mrp.getText();

		System.out.println("Printing MRP value " + Mrpvalue);

		// Add to bag
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();

		// click shopping bag
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

		Thread.sleep(1000);
		// frame
		driver.switchTo().frame(0);
		System.out.println("eneterd into frame" + driver.getTitle());

		// print grand total
		WebElement Grandtotal = driver
				.findElement(By.xpath("(//div[@class='css-1o9rwmy e1xdieeb5']//following::span)[14]"));
		String Gdtotal = Grandtotal.getText();
		System.out.println("Printing Grandtotal value " + Gdtotal);

		// click on proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//verify total amount
		driver.findElement(By.xpath("(//div[@class='css-46b9vi efuv1qx0']/p[1])[3]")).click();
		
		WebElement Verfiytotalpay =	driver.findElement(By.xpath("(//div[@class='price-details-desktop css-10xc1u2 el5aqen7']//following::p)[5]"));
		String verifypay=Verfiytotalpay.getText();
		System.out.println(verifypay);
		
		
		if(verifypay.equalsIgnoreCase(Gdtotal)) 
		{
			System.out.println("Amount Correct");
		}
		else 
		{
			System.out.println("Amount Not-Correct");

		}
		
		driver.close();
	}

}
