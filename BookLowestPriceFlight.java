package JavaPractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookLowestPriceFlight {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Adding implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//getting the URL
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
		
		// Selecting To/From destination
		driver.findElement(By.xpath("//select[@name ='fromPort']")).click();
		driver.findElement(By.xpath("//option[@value='Philadelphia']")).click();
		
		driver.findElement(By.xpath("//select[@name ='toPort']")).click();
		driver.findElement(By.xpath("//option[@value='Rome']")).click();
		
		//Finding the available flights
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		
		double price [] =  new double[6];
		//Finding flight prices and adding it to an array
		for(int i=1; i<price.length; i++) {
			String s = driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
			String finalPrice = s.substring(1);
			
			price[i] =Double.parseDouble(finalPrice);
		}
		//Sorting to flight prices to find the lowest price
			Arrays.sort(price);
			for(int i=1; i<price.length; i++ ) {
				String s = driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
				String finalPrice = s.substring(1);
				//Once lowest flight price is found, selecting the flight
				if(price[1] ==Double.parseDouble(finalPrice) ) {
					driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[1]")).click();
					break;
				}
			
			}
			//Filling the flight user form
			driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Alok Tiwari");
			driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Test Address");
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys("New York");
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys("New York");
			driver.findElement(By.xpath("//input[@name='zipCode']")).sendKeys("10001");
			driver.findElement(By.xpath("//select[@name='cardType']")).click();
			driver.findElement(By.xpath("//option[@value='amex']")).click();
			driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("4242424242424242");
			driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("12");
			driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2032");
			driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("2032");
			driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
			//Submitting the form
			driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
			
			//Validating the final success message
			WebElement s = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']"));
			if(s.getText().equals("Thank you for your purchase today!")) {
				System.out.println("Test Passed");
			}
			
			
	}

}
