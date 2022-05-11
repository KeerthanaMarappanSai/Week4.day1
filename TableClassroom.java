package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Keys;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableClassroom {
public static void main(String[] args) {
	//Driver setup
	WebDriverManager.chromedriver().setup();
	//Opening Chrome Browser
	ChromeDriver driver = new ChromeDriver();
	//Loading the URL
	driver.get("https://erail.in/");
	//Maximizing the browser
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
	fromStation.clear();
	fromStation.sendKeys("MDU");
	fromStation.sendKeys(Keys.TAB);
	
	WebElement toStation = driver.findElement(By.id("txtStationTo"));
	toStation.clear();
	toStation.sendKeys("TPJ");
	toStation.sendKeys(Keys.TAB);
	
	driver.findElement(By.id("chkSelectDateOnly")).click();
	
	WebElement dataTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
	List<WebElement> tableRows = dataTable.findElements(By.tagName("tr"));
	
	for(int i=0; i<tableRows.size();i++)
	{
		List<WebElement> tableCols = tableRows.get(i).findElements(By.tagName("td"));
		System.out.println(tableCols.get(0).getText());
		System.out.println(tableCols.get(1).getText());
	}
	
	
}
}
