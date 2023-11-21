package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest{

    public static char x = (int) 215;
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).click();

        String expectedMessage = "Secure Area";
        WebElement message = driver.findElement(By.xpath("//div[@class='example']//h2"));
        String actualMessage = message.getText();

        //System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        //Find username and Enter username : 'tomsmith1'
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        //Enter invalid password in password field:SuperSecretPassword!
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).click();

        String expectedMsg = "Your username is invalid!\n" + x;
        //System.out.println(expectedMsg);
        WebElement msg = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMsg = msg.getText();
        //System.out.println(actualMsg);
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    @Test
    public void verifyThePasswordErrorMessages(){

        driver.findElement(By.id("username")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.className("radius")).click();

        String expectedMsg1 = "Your password is invalid!\n" + x;
        WebElement aMsg2 = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMsg1 = aMsg2.getText();
        //System.out.println(actualMsg1);
        Assert.assertEquals(expectedMsg1,actualMsg1);
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
