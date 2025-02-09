package testNGFW;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ExpectedConditionExample {
// created reference variable for WebDriver
WebDriver driver;

@BeforeMethod
public void setup() throws InterruptedException {

		// initializing driver variable using FirefoxDriver
		System.setProperty("webdriver.firefox.driver","C:\\Users\\aarav\\Downloads\\Tech Learning\\QA\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new FirefoxDriver();
		// launching gmail.com on the browser
		driver.get("https://gmail.com");
		// maximized the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
public void test() throws InterruptedException {
// saving the GUI element reference into a "element" variable of WebElement type
		WebElement element = driver.findElement(By.id("identifierId"));
		// entering username
		element.sendKeys("dummy@gmail.com");
		element.sendKeys(Keys.RETURN);
		// entering password
		driver.findElement(By.name("password")).sendKeys("password");
		// clicking signin button
		driver.findElement(By.id("signIn")).click();
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		
		
//		wait.until(ExpectedConditions.visibilityOf(By.xpath("//div[contains(text(),'COMPOSE')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
		
		
//		Wait waitd = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
//                .ignoring(NoSuchElementException.class);
}

@AfterMethod
public void teardown() {
// closes all the browser windows opened by web driver
driver.quit();
}

}