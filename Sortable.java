package assignment.week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Launch URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		//webElemnt xpath
		WebElement item1=driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2=driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3=driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4=driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5=driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item6=driver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement item7=driver.findElement(By.xpath("//li[text()='Item 7']"));
		Point location=item7.getLocation();
		int x=location.getX();
		int y=location.getY();
	
		builder.dragAndDropBy(item1, x, y).perform();
		
		//by elements
		
		builder.dragAndDrop(item2, item6).perform();
		
		

	}

}
