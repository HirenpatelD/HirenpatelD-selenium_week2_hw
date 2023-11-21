package testsuite;
/*
Project-2 - ProjectName : com-orangehrmlive-sw-2
BaseUrl = https://opensource-demo.orangehrmlive.com/
1. Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the
‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.
2. Create the package ‘testsuite’ and create the following classes inside the ‘testsuite’ package.
1. LoginTest
2. ForgotPasswordTest
3. Write down the following test into ‘LoginTest’ class
1. userShouldLoginSuccessfullyWithValidCredentials
* Enter “Admin” username
* Enter “admin123 password
* Click on ‘LOGIN’ button
* Verify the ‘Dashboard’ text is display
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
