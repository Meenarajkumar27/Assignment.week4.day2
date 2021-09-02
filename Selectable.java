package assignment.week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Launch URL
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("http://www.leafground.com/pages/selectable.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Actions builder = new Actions(driver);
				WebElement item3=driver.findElement(By.xpath("//li[text()='Item 3']"));
				WebElement item7=driver.findElement(By.xpath("//li[text()='Item 7']"));
				builder.clickAndHold(item3).moveToElement(item7).release().perform();
				
	}

}
