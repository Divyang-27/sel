package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Heoku_Login  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Set the path to the ChromeDriver executable

        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://rahulshettyacademy.com");

        // Print the title and current URL of the page
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // Close the browser
        driver.close();
	}

}
