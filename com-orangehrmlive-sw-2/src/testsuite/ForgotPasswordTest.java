package testsuite;
/*
4. Write down the following test into ‘ForgotPasswordTest’ class
1. userShouldNavigateToForgotPasswordPageSuccessfully
* click on the ‘Forgot your password’ link
* Verify the text ‘Reset Password’
*/

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        driver.findElement(By.xpath("//p[contains(@class,'orangehrm-login-forgot-header')]")).click();

        String expectedMessage = "Reset Password";
        WebElement message = driver.findElement(By.xpath("//h6[contains(@class,'h6 orangehrm-forgot-password')]"));
        String actualMessage = message.getText();

        //System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}