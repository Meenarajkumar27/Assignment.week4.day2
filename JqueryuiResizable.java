package assignment.week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryuiResizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//launch url
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://jqueryui.com/resizable");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement fram1=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
				driver.switchTo().frame(fram1);
				WebElement resizable=driver.findElement(By.id("resizable"));
				Point p=resizable.getLocation();
				int x=p.getX();
				int y=p.getY();
				System.out.println(x+":"+y);
				
				if(resizable.isDisplayed()) {
				Actions builder=new Actions(driver);
				WebElement icon=driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
				builder.clickAndHold(icon).moveToElement(resizable, 10, 10).release().perform();
				
				//builder.clickAndHold(resizable).moveByOffset(2, 2).release().build().perform();
				
				

	}
				else
					System.out.println("Element is not visible");

}
}
