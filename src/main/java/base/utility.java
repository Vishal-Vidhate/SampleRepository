package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class utility {
	public static String readExcelData(int rownum,int column) throws EncryptedDocumentException, IOException {
		FileInputStream fobj = new FileInputStream("C:\\Users\\vishal\\eclipse-workspace\\redbusFramework\\testData\\testdata.xlsx");
		Sheet data = WorkbookFactory.create(fobj).getSheet("Sheet1");
		return data.getRow(rownum).getCell(column).getStringCellValue();
		} 
	
	public static void takeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Drivers\\Selenium_Screenshots\\"+screenshotName+".jpeg");
		//FileHandler.copy(source, dest);
		FileUtils.copyFile(source, dest);
	}
	
	public static void full_screenshot(WebDriver driver,String screenshotName) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String path = "C:\\Drivers\\Selenium_Screenshots\\";
		ImageIO.write(screenshot.getImage(),"PNG",new File(path+screenshotName+".png"));
	}	
}

