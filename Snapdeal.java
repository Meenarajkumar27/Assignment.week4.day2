package assignment.week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// launch url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		WebElement menFashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).perform();
		// Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		Thread.sleep(2000);
		// get the count
		String countofItem = driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		// countofItem
		String count = countofItem.replaceAll("[^0-9]", "");
		int shoeCount = Integer.parseInt(count);
		System.out.println("Count of the sports shoes: " + shoeCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,35000)");

		// js1.executeScript("window.scrollBy(0,-3000)");
		Thread.sleep(8000);

		WebElement end = driver.findElement(By.xpath("//span[@class='btn-yes js-yesFeedback']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", end);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -700)");

		Thread.sleep(5000);
		// Check if the items displayed are sorted correctly
		List<WebElement> pricelist = driver.findElementsByXPath("//span[@class='lfloat product-price']");
		JavascriptExecutor j4 = (JavascriptExecutor) driver;
		j4.executeScript("window.scrollBy(0,-15000)");
		Thread.sleep(2000);
		List<Integer> newval = new ArrayList<Integer>();

		for (int i = 0; i < pricelist.size(); i++) {
			String pl = pricelist.get(i).getText();
			String gt = pl.replaceAll("[^0-9]", "");
			int price = Integer.parseInt(gt);
			newval.add(price);
		}
		Thread.sleep(1000);
		System.out.println(newval.size());

//		int minvalue=Collections.min(newval);
//		int firstvalue=newval.get(0);
//		if(minvalue==firstvalue) {
//			System.out.println("Price are sorted");
//		} else {
//				System.out.println("Price not sorted");
//			}

		List<Integer> sortedlist = new ArrayList<Integer>(newval);
		Collections.sort(sortedlist);
		boolean b = false;
		for (int i = 0; i < newval.size(); i++) {
			if (newval.get(i) == sortedlist.get(i)) {
				b = true;

			} else {
				b = false;
				break;

			}
		}
		if (b == true) {
			System.out.println("Price are sorted");
		} else {
			System.out.println("Price not sorted");
		}

		js1.executeScript("window.scrollBy(0,-2000)");
		Thread.sleep(2000);
		// mouse over blue shoe
		driver.findElementByXPath("//label[@for='Color_s-Blue']").click();
		Thread.sleep(1000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)");
		WebElement buleShoe = driver.findElementByXPath("//img[@title='VSS Blue Training Shoes']");
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(buleShoe).perform();
		// click QuickView button
		driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();
		// Print the price of the shoe

		String shoePrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String sp = shoePrice.replaceAll("[^0-9]", "");
		int price = Integer.parseInt(sp);
		System.out.println("Cost of the shoe:" + price);
		// discount of the shoe
		String dis = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		String dis1 = dis.replaceAll("[^0-9]", "");
		int discount = Integer.parseInt(dis1);
		System.out.println("discount percentage" + discount + "%");

		// screenshot for the shoe
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/sanpdeal.png");
		FileUtils.copyFile(src1, dst);
		// Close the current window
		driver.findElementByXPath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]").click();

		// close the main window
		driver.close();

	}

}
