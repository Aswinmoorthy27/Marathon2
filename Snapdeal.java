package AUT;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// driver
		driver.get("https://www.snapdeal.com/");

		WebElement mensfashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));

		// hover Actions class
		Actions Ac = new Actions(driver);
		Ac.moveToElement(mensfashion).perform();

		// click on sports shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();

		// get count
		Thread.sleep(1000);
		WebElement totalcount = driver
				.findElement(By.xpath("//*[@class='category-name category-count']//ancestor::span"));
		String Sportshoecount = totalcount.getText();

		System.out.println("Printing total count of sportshoe " + Sportshoecount);

		// click on training shoes
		driver.findElement(By.xpath("(//*[@class='child-cat-name ']//following::a)[2]")).click();

		// sort by click
		driver.findElement(By.xpath("//*[text()='Sort by:']")).click();

		// sort
		driver.findElement(By.xpath("(//*[@class='search-li'])[1]")).click();

		// print low to high amount

		/*
		 * List<WebElement> list =
		 * driver.findElements(By.xpath("//div[@class='lfloat marR10']"));
		 * Thread.sleep(1000);
		 * 
		 * for (WebElement lowtohigh : list) { Thread.sleep(1000); lowtohigh.getText();
		 * System.out.println("printing low to high value " + lowtohigh.getText());
		 * 
		 * }
		 */

		// from value (900-1200 not showing) (649)

		// driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-minus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-plus'])[1]")).click();
		Thread.sleep(2000);

		WebElement from = driver.findElement(By.xpath("(//div[@class='price-text-box'])[1]"));
		Ac.click(from).perform();
		Ac.clickAndHold(from).perform();
		Thread.sleep(1000);
		Ac.sendKeys("649").perform();

		Thread.sleep(1000);
		WebElement To = driver.findElement(By.xpath("(//div[@class='price-text-box'])[2]"));
		Ac.moveToElement(To).perform();
		Thread.sleep(1000);
		Ac.sendKeys("649").perform();

		driver.findElement(By.xpath("(//div[contains (@class, 'price')])[7]")).click();

		// White(not able to click navy)
		driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[1]")).click();

		// get text
		driver.findElement(By.xpath("(//div[@class='navFiltersPill']//following::a)[1]")).getText();

	}
}