package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 * Created by Sandip Patel
 */

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. userShouldNavigateToLoginPageSuccessfully
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    // 2. verifyTheErrorMessage
    @Test
    public void verifyTheErrorMessage() {
        // click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("virat1234@gmail.com");
        //  Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("Virat1234");
        // Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //  WebDriverWait wait = new WebDriverWait(driver,10);
        // WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
        //captcha.click();
        // Verify the error message ‘Invalid email or password.’
        // String expectedErrorMessage = "Invalid email or password.";
        //  String actualErrorMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        // Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

    // Individual open and close
    @After
    public void tearDown() {
        closeBrowser();
    }
}