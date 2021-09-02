package assignment.week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1. Launch URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement brand = driver.findElementByXPath("//a[text()='brands']");
		WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		builder.moveToElement(popular).perform();

		driver.findElement(By.xpath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']")).click();
		Thread.sleep(2000);
		Set<String> windowHandleset = driver.getWindowHandles();
		List<String> windowHandlelist = new ArrayList<String>(windowHandleset);
		driver.switchTo().window(windowHandlelist.get(1));
		// Go to the newly opened window and check the title contains L'Oreal Paris
		String title = driver.getTitle();
		if (title.contains("L'Oreal Paris")) {
			System.out.println("L'Oreal Paris window is opened");
		} else {
			System.out.println("L'Oreal Paris window is not  opened");
		}
		// Click sort By and select customer top rated
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");

		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		// click category and shampoo
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		String filtervalue = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		if (filtervalue.contains("Shampoo")) {
			System.out.println("filter value is shampoo");
		} else {
			System.out.println(" shampoo is not filtered");

		}
		driver.findElement(By.xpath("//div[text()='Concern']")).click();

		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(4000);
//				List<WebElement> add=driver.findElements(By.xpath("//div[@class='m-content__product-list__btn-wrap desktop-card-wrapper']"));
//			//System.out.println(add);
//			for(WebElement adds:add) {
//			
//			 System.out.println("Elements list"+adds.getText());
//			}
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,350)");
		WebElement addtobag = driver.findElement(By.xpath(
				"(//button[@class='primary-btn nk-btn combo-add-to-btn  atc-simple m-content__product-list__cart-btn  '])[1]"));
		WebElement movetoobj = driver.findElement(By.xpath("(//div[@class='product-list-box card desktop-cart'])[2]"));

		Actions builder1 = new Actions(driver);
		builder1.moveToElement(movetoobj).perform();
		addtobag.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(2000);
		String grandtotal = driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div"))
				.getText();
		String gt = grandtotal.replaceAll("[^0-9]", "");
		int grandTotal1 = Integer.parseInt(gt);

		System.out.println("Grandtotal" + grandTotal1);
		Thread.sleep(2000);
		WebElement proceed = driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']"));
		Actions act = new Actions(driver);
		act.doubleClick(proceed).perform();
		driver.findElement(By.xpath("//div[text()='Checkout as guest']/following-sibling::button")).click();
		Thread.sleep(2000);
		// Grandtotal inaddress
		String grandtotal2 = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span"))
				.getText();
		String gt2 = grandtotal2.replaceAll("[^0-9]", "");
		int grandTotal2 = Integer.parseInt(gt2);

		System.out.println("Grandtotal" + grandTotal2);

		if (grandTotal1 == grandTotal2) {
			System.out.println("Grand Total are same");
		} else

		{
			System.out.println("Grand Total are different");
		}
		driver.quit();

	}

}
