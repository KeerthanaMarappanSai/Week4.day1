package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTypes {
	public static void main(String[] args) {
		
		//Driver setup
				WebDriverManager.chromedriver().setup();
				//Opening Chrome Browser
				ChromeDriver driver = new ChromeDriver();
				//Loading the URL
				driver.get("http://leaftaps.com/opentaps/control/main");
				//Maximizing the browser
				driver.manage().window().maximize();
				//Login Credentials
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa",Keys.ENTER);
				//driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
				//Navigating to next page using linktext locator
				driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
				//Creating new Lead 
				driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
				//Sendkeys
				driver.findElement(By.id("createLeadForm_dataSourceId")).sendKeys("Conference");
				//Select by value
				WebElement element1 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
				Select select1=new Select(element1);
				select1.selectByValue("CATRQ_AUTOMOBILE");
				//Select by Index
				WebElement element2 = driver.findElement(By.id("createLeadForm_currencyUomId"));
				Select select2=new Select(element2);
				select2.selectByIndex(10);
				//Select by Visible text
				WebElement element3 = driver.findElement(By.id("createLeadForm_industryEnumId"));
				Select select3=new Select(element3);
				select3.selectByVisibleText("Distribution");
				//Get options
				List<WebElement> options1 = select3.getOptions();
				for(WebElement eachOption1:options1)
				{
					System.out.println("List of Distributions:"+eachOption1.getText());
				}
				//Getting last element
				WebElement element4 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
				Select select4=new Select(element4);
				List<WebElement> options2 = select4.getOptions();
				select4.selectByIndex(options2.size()-1);
				for(WebElement eachOption2:options2)
				{
					System.out.println("Last element in Ownership: "+eachOption2.getText());
					
				}
				
				
			
	}

}
