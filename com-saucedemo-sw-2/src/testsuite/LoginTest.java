package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on 'Login' button
        driver.findElement(By.id("login-button")).click();

        //verify the text 'Products'
        String expectedMessage = "Products";
        WebElement message = driver.findElement(By.xpath("//span[@Class='title']"));
        String actualMessage = message.getText();

        //System.out.println(actualMessage);
        //verifying using the assert method
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on 'Login' button
        driver.findElement(By.id("login-button")).click();

        //Verify that six products are displayed on page

        List<WebElement> count = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int totalCount = count.size();
        System.out.println("Total Product are : " + totalCount);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
