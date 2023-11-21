package testsuite;
/*
2. Create the package ‘testsuite’ and create the following classes inside the ‘testsuite’ package.
1. LoginTest
2. TopMenuTest
3. RegisterTest
3. Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Login’ link
* Verify the text ‘Welcome, Please Sign In!’
2. userShouldLoginSuccessfullyWithValidCredentials
* click on the ‘Login’ link
* Enter valid username
* Enter valid password
* Click on ‘LOGIN’ button
* Verify the ‘Log out’ text is display
3. verifyTheErrorMessage
* click on the ‘Login’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Login was unsuccessful.
Please correct the errors and try again. No customer account found’
*/
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on the ‘Login’ link
        WebElement logInLink = driver.findElement(By.xpath("//a[text()='Log in']"));
        logInLink.click();

        //Verify the text ‘Welcome, Please Sign In!’
        String exceptedText = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(exceptedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("ankptl12@gmail.com");

        //Enter valid password
        driver.findElement(By.name("Password")).sendKeys("ankptl12");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //Verify the ‘Log out’ text is display
        String exceptedText = "Log out";
        String actualText = driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).getText();
        Assert.assertEquals(actualText, exceptedText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        //Enter invalid username
        WebElement userNameField = driver.findElement(By.id("Email"));
        userNameField.sendKeys("abcd1234@gmail.com");

        //Enter invalid password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("ankptl12");

        //Click on ‘LOGIN’ button
        WebElement logInButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        logInButton.click();

        //Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found’
        String exceptedText = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[starts-with(@class, 'mes')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(exceptedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}