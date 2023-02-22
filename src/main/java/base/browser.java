package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class browser {
	public static WebDriver driver;

	public void setup() throws Throwable {

		String browser = readPropertyFile("browser");

		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new EdgeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		} 
		else 
		{
			System.out.println("Invalid Browser");
		}

		driver.get(readPropertyFile("url"));

		driver.manage().window().maximize();

	}

	public void impWait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public String readPropertyFile(String value) throws Throwable 
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\vishal\\eclipse-workspace\\redbusFramework\\properties");
		prop.load(file);
		return prop.getProperty(value);
	}

	public void waitForElementToAppear(By findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void close() 
	{
		driver.close();
		System.out.println("Run Finished");
	}

}