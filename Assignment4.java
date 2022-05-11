package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		//Driver setup
				WebDriverManager.chromedriver().setup();
				//Opening Chrome Browser
				ChromeDriver driver = new ChromeDriver();
				//Loading the URL
				driver.get("http://www.leafground.com/pages/table.html");
				//Maximizing the browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				WebElement table = driver.findElement(By.xpath("//table"));
				List<WebElement> tableRows = table.findElements(By.tagName("tr"));
				System.out.println("No. of rows in the table: "+tableRows.size());
				
				List<WebElement> tableCols = tableRows.get(1).findElements(By.tagName("td"));
				System.out.println("No. of columns in the table: "+tableCols.size());
					
				String value="Learn to interact with";
				List<WebElement> progressValue = driver.findElements(By.xpath("//font[contains(text(),'Learn to interact with')]/following::font[1]"));
				for(WebElement each:progressValue )
				{
					System.out.println(each.getText());
				}
				
				table.findElement(By.xpath("(//input[@name='vital'])[5]")).click();
				System.out.println("Least vital role is clicked");
	}
}
