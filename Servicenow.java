package Marathon;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import io.github.sukgu.Shadow;

public class Servicenow {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Chromeoptions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// driver
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Url
		driver.get("https://dev31913.service-now.com/");

		// Username and Pwd
		driver.findElement(By.id("user_name")).sendKeys("admin");

		driver.findElement(By.id("user_password")).sendKeys("q+NozS5Qe8!E");

		driver.findElement(By.id("sysverb_login")).click();

		Thread.sleep(30000);
		// Click-All Enter Service catalog in filter navigator and press enter or Click
		// the ServiceCatalog
		Shadow shadow = new Shadow(driver);
		WebElement All = shadow.findElementByXPath("//div[@id='all']");

		Thread.sleep(2000);
		Actions Action = new Actions(driver);
		Action.moveToElement(All).click().perform();
		System.out.println(":Sucessfull");

		Thread.sleep(5000);
		WebElement Filter = shadow.findElementByXPath("//input[@id='filter']");
		System.out.println(":,.....");

		Thread.sleep(2000);
		Action.click(Filter).sendKeys("Service Catalog", Keys.ENTER).perform();
		System.out.println("Sucesfully Enter");

		// Click on mobiles
		Thread.sleep(5000);
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		System.out.println("switched to frame");
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();

		// selecting iphone 6s
		driver.findElement(By.xpath("//*[text()='iPhone 6s']")).click();

	

		// select color/128gp
		WebElement color = driver
				.findElement(By.xpath("(//select[contains(@class,'form-control ')])[1]"));
		Select select = new Select(color);
		select.selectByValue("white");
		
		WebElement variant = driver
				.findElement(By.xpath("(//select[contains(@class,'form-control ')])[2]"));
		Select selectVar = new Select(variant);
		selectVar.selectByValue("onehudred_twentyeight");
		
		//order
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		//verify
		WebElement verify=driver.findElement(By.xpath("//a[@id='requesturl']"));
		String Reqnno=verify.getText();
		
		if(Reqnno.equals(Reqnno)) 
		{
			System.out.println("Order placed");
		}else 
		{
			System.out.println("Not Order placed");

		}
		
		
		//snap
        	File Source=	driver.getScreenshotAs(OutputType.FILE);
        	File Target=new File("./snaps/request.png");
        	FileUtils.copyFile(Source, Target);

	}

}
