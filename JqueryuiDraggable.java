package assignment.week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryuiDraggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//launch url
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://jqueryui.com/draggable");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement fram1=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
				driver.switchTo().frame(fram1);
				
				WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
				Actions  builder=new Actions(driver);
				builder.dragAndDropBy(drag, 100, 100).perform();
				
	}

}
