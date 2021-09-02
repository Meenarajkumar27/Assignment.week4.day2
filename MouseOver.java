package assignment.week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1. Launch URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// mouse over

		WebElement course = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(course).perform();
		// display the all the links
		List<WebElement> courselist = driver.findElements(By.xpath("//a[text()='TestLeaf Courses']/following-sibling::ul/li"));
		for (WebElement list : courselist) {
			System.out.println(list.getText());

		}
		//System.out.println(courselist.size());

		// clicking the value from the link list
		courselist.get(2).click();
		//Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}
}
