import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class TC005PostmanAutomation {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Alernate way for opening app
		//		Runtime rt = Runtime.getRuntime();
		//		rt.exec("C://Users/Admin/AppData/Local/Postman/Postman.exe");

		// Setting path for postman
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C://Users/Admin/AppData/Local/Postman/Postman.exe");

		//Prereq - Double click on Winium Driver so that it runs on the default port 9999
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		Thread.sleep(25000);

		//Element identification is done by Inspect.exe or UIspy.exe
		//Hover on the element to get the property
		try {
			WebElement ele = driver.findElement(By.xpath("//*[@Name='RestLearning']"));
			Thread.sleep(15000);
			boolean displayed = ele.isDisplayed();
			if (displayed == true) {
				Actions act = new Actions(driver);
				act.contextClick(ele).perform();
				driver.findElement(By.name("Delete Del")).click();
				driver.findElement(By.xpath("//*[@Name='Delete']")).click();
			}
		}catch (Exception e) {
			System.out.println("Element not present");
		}
		driver.findElement(By.name("Collections")).click();
		driver.findElement(By.name("New Collection")).click();
		driver.findElement(By.xpath("//*[@Name='Collection Name']")).click();
		driver.findElement(By.xpath("//*[@Name='Collection Name']")).sendKeys("RestLearning");
		driver.findElement(By.name("Create")).click();
		driver.findElement(By.name("Close")).click();
	}
}
