package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.browser;
import base.utility;

public class searchFunctionality extends browser {
	
	utility data = new utility();
	//constructor
	public searchFunctionality() {
		PageFactory.initElements(driver, this);
	}
	
	String fromCity = "PUNE";
	String reqFromSource="Shivaji Nagar";
	@FindBy(id="src") WebElement fromBox;
	@FindBy(xpath="//ul[@class=\"autoFill homeSearch\"]/li[contains(@select-id,\"results\")]") List<WebElement> fromCityText;
	@FindBy(xpath="//ul[@class=\"autoFill homeSearch\"]/li/i") List<WebElement> fromCityClick;
	
	String toCity = "MUMBAI";
	String reqToSource="Dadar";
	@FindBy(id="dest") WebElement toBox;
	@FindBy(xpath="//ul[@class=\"autoFill homeSearch\"]/li") List<WebElement> toCityText;
	@FindBy(xpath="//ul[@class=\"autoFill homeSearch\"]/li/i") List<WebElement> toCityClick;
	
	String monthYear="Mar 2023";
	String date="12";
	@FindBy(xpath="//label[text()=\"Date\"]") WebElement calenderClick;
	@FindBy(xpath="//div[@class=\"rb-calendar\"]/table/tbody/tr/td[2]") WebElement selectMonth;
	@FindBy(xpath="//div[@class=\"rb-calendar\"]/table/tbody/tr/td[3]") WebElement nextButton;
	@FindBy(xpath="//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]") List<WebElement> textMonth; 
	@FindBy(xpath="//td[@class=\"current day\" or @class=\"wd day\" or @class=\"we day\"]") List<WebElement> clickMonth;
	
	@FindBy(xpath="//div[@id=\"search_div\"]/section/div/button") WebElement searchButton;
	
	
	
	
		public void selectFromCity() throws InterruptedException  {		
			fromBox.sendKeys(fromCity);
			Thread.sleep(3000);
		    int count=fromCityText.size();
		    System.out.println(count);
		    Thread.sleep(3000);
			for (int i = 0; i < count; i++) {			
				String listValues = fromCityText.get(i).getText();
				System.out.println(listValues);
				if (listValues.contains(reqFromSource)) 
				{
					fromCityClick.get(i).click();
					System.out.println("Found in " + i + " iteration");
					break;
				}
				else 
				{
					System.out.println("Desired value is not found in iteration " + i + ", hence retrying");
				}
			} 
		}
		
		public void selectToCity() throws InterruptedException  {
			toBox.sendKeys(toCity);
			Thread.sleep(3000);
		    int count=toCityText.size();
		    System.out.println(count);
		    Thread.sleep(3000);
			for (int i = 0; i < count; i++) 
			{			
				String listValues = toCityText.get(i).getText();
				System.out.println(listValues);
				if (listValues.contains(reqToSource)) 
				{
					toCityClick.get(i).click();
					System.out.println("Found in " + i + " iteration");
					break;
				}
				else 
				{
					System.out.println("Desired value is not found in iteration " + i + " , hence retrying");
				}
			} 			
		}
		
		
		public void calender() throws InterruptedException  {
		calenderClick.click();
		
		while (true) {
		String month_year =	selectMonth.getText();
			if (month_year.equalsIgnoreCase(monthYear))
			{
				break;
			}
			else
			{
				System.out.println("Desired value of month & year is not found ,hence clicking on next Button");
				nextButton.click();
			}
		}
					
		List<WebElement> webelements_text = textMonth;
		List<WebElement> webelements_click = clickMonth;
		
		int count = webelements_text.size();
		System.out.println(count);
		
		   for (int i=0;i<count;i++)
		   {
			  String list_values = webelements_text.get(i).getText();
			  System.out.println(list_values);
			
			  if(list_values.equals(date))
			  {
				  webelements_click.get(i).click();
				  break;
			  }
			  else
			  {
		 	      System.out.println("Desired value is not found in iteration "+i+" ,hence retrying");
			  }
		   }
	    }
		
		
		public void searchBus() throws InterruptedException {

			Thread.sleep(2000);
			searchButton.click();

			// Verify that search results are displayed correctly
			String expectedTitle = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";

			String actualTitle = driver.getTitle();
			Thread.sleep(3000);
			System.out.println(actualTitle);
			if (expectedTitle.equalsIgnoreCase(actualTitle)) 
			{
				System.out.println("Test Passed!");
			} 
			else 
			{
				System.out.println("Test Failed");
			}
		}
	}

	

