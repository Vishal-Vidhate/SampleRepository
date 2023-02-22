package pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.browser;
import base.utility;

public class sortbyPrice extends browser {
	
	public sortbyPrice() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\"w-15 fl f-12 d-color\"]//a[text()=\"Fare\"]") WebElement fare;
	@FindBy(xpath="//span[@class=\"f-19 f-bold\" or @class=\"f-bold f-19\"]") List<WebElement> priceText;
	

	public void fareButton() {
		waitForWebElementToAppear(fare);
		fare.click();
	}
	
	public void scroll() throws InterruptedException, IOException {
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		int i=0;
		while(i<5) {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			i++;
		}*/
		
		utility.full_screenshot(driver, "sortByFare");
	}
	
	public void fareAscending() {
		int count =priceText.size();
		System.out.println(count);
		String[] priceArray = new String[count];
		
	    for (int i = 0; i <count; i++) {
	    	priceArray[i] = priceText.get(i).getText();
	    }

	    // Extracting the array outside the loop
	    String[] extractedArray = priceArray;
	    
	    int[] intArray = new int[count];
	    for(int i = 0; i < count; i++) {
	    intArray[i] = (int) Double.parseDouble(extractedArray[i].trim());
	    System.out.println(intArray[i]);
	    }
	    
	    int[] intExtractedArray = intArray;
	  
	    int[] sortedArray = intArray.clone();
	    Arrays.sort(sortedArray);
        Arrays.equals(sortedArray, intExtractedArray);
        System.out.println("Both arrays are equal");		
	}
}
