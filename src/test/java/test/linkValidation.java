package test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.browser;
import pages.linkPageValidation;


public class linkValidation extends browser {

	linkPageValidation act;
	
	@BeforeTest
	public void setupTest() throws Throwable {
		setup();
		impWait();	
		act=new linkPageValidation();
		
	}
	@Test(priority=-1)
	public void availableLinks() throws IOException {
		int expectedLink=120;
		int actualLinks=act.totalLinks();
		Assert.assertEquals(expectedLink, actualLinks,"Expect as per actual");
	}

	@Test(priority=0)
	public void availableFooterLinks() throws IOException {
		int expextedFooterLinks=28;
		int actualFooterLinks=act.footerLinkCount();
		Assert.assertEquals(expextedFooterLinks, actualFooterLinks,"Expect footer link count is as per actual");		
	}
	
	
	@Test(priority=1)
	public void firstColumnLinksInFooter() throws InterruptedException, IOException {
		act.footerColumnLink();		
	}
	
	@AfterTest
	public void close() {
		close();
	}
}