package assignment.week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//launch url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement fram1=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(fram1);
		
		//WebElements
		
		WebElement item2=driver.findElement(By.xpath("(//ul[@id='sortable'])/li[2]"));
		WebElement item4=driver.findElement(By.xpath("(//ul[@id='sortable'])/li[4]"));
		
		Actions builder=new Actions(driver);
		Point location = item4.getLocation(); 
		int x = location.getX();
		int y = location.getY();
		builder.dragAndDropBy(item2, x, y).perform();
		
		
		
		
	}

}
