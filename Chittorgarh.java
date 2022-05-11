package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		//Opening Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		//Loading the URL
		driver.get("https://www.chittorgarh.com/");
		//Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigating to Stock Market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		//Navigating to NSE Bulk deals
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		
		//Finding table
		WebElement dataTable = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));
		List<WebElement> securityName = dataTable.findElements(By.tagName("tr"));
		//Iterating rows to get the column names
		for(int i=1; i<securityName.size();i++)
		{
			List<WebElement> tableCols = securityName.get(i).findElements(By.tagName("td"));
			System.out.println("Security Name List:");
			System.out.println(tableCols.get(2).getText());
		}
	}

}
