package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		//Opening Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		//Loading the URL
		driver.get("https://html.com/tags/table/");
		//Maximizing the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigating to table
		WebElement tableName = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		List<WebElement> tableRows = tableName.findElements(By.tagName("tr"));
		//Iterating the rows and column values
		for(int i=0;i<tableRows.size();i++)
		{
			
			List<WebElement> tableCols = tableRows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<tableCols.size();j++)
			{
				System.out.println(tableCols.get(j).getText());
			}
			
		}
		driver.close();

	}
}
