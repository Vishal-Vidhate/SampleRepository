package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.utility;
import base.browser;

public class linkPageValidation extends browser{
	
	utility data=new utility();
		
	public linkPageValidation(){
		PageFactory.initElements(driver,this);
	}	

	@FindBy(tagName="a") List<WebElement> allLinks;
	@FindBy(xpath="//div[@class='dib  foot-wrapper']") WebElement footerDriver;
	
	
	public int totalLinks() {		
		return allLinks.size();
		
	}
	
	// count of link present in footer section
	public int footerLinkCount() {		
		return footerDriver.findElements(By.tagName("a")).size();
		
		
	}	
	// Count link present in 1st column of footer
	public void footerColumnLink() throws InterruptedException, IOException {
		WebElement firstFColumn =footerDriver.findElement(By.xpath("(//div[@class='row fl'])[1]"));
		int firstColumnLink = firstFColumn.findElements(By.tagName("a")).size();
		

		for(
		int i = 1;i<firstColumnLink;i++)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // To open in new tab
			firstFColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			utility.takeScreenShot(driver, "links");
			

		}

		// To get title for all tabs
		Set<String> title = driver.getWindowHandles();
		Iterator<String> it = title.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			System.out.println("----------------------------------------------------");
		}
	}	
}

	


