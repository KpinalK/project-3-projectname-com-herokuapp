package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Set up Multi browser.
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

public class MultiBrowserTest {
    static String browser = "Chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        //1.Set up Multi browser
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //2.Open URL
        driver.get(baseUrl);
        //Maximise the browser window
        driver.manage().window().maximize();
        //We give Implicit wait to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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
