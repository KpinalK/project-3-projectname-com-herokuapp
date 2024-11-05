package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Set up Edge browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Enter the email in the email field.
 * 7. Enter the password in the password field.
 * 8. Click on the Login Button.
 * 9. Print the current URL.
 * 10. Refresh the page.
 * 11. Close the browser.
 */


public class EdgeBrowserTest {

    public static void main(String[] args) {
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //1.Set up Edge browser
        WebDriver driver = new EdgeDriver();

        //2.Open URL
        driver.get(baseUrl);
        //Maximise the browser window
        driver.manage().window().maximize();
        //We give Implicit wait to the driver

        //3.Print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //4.Print the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The Current URL " + currentUrl);

        //5.Print the page source
        System.out.println("The page source : " + driver.getPageSource());

        //6.Enter the email in the email field
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Pinal");

        //7.Enter the password in the password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("12345");

        //8.Click on the Login Button
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));
        loginButton.click();

        //9.Print the current URL
        System.out.println("The Current URL " + currentUrl);

        //10.Refresh the page
        driver.navigate().refresh();

        //11.Close the browser
        driver.quit();
    }
}
