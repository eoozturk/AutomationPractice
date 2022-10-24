import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
public class TestCase{
    public WebDriver wdriver;
    @BeforeTest
    @Parameters("browser")
    public void startPage(String browser) throws Exception {

        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            wdriver  = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
            wdriver  = new FirefoxDriver();
        }
        else{
            throw new Exception("Browser is not correct");
        }
        String url ="http://automationpractice.com/";
        wdriver.get(url);
        wdriver.manage().deleteAllCookies();
        //wdriver.manage().window().maximize();
    }
    @Test
    public void testCase() throws InterruptedException {
        Random randNumb=new Random();
        int numb=randNumb.nextInt(1000);
        String mailTitle = "qatest";
        String mailOrder = String.valueOf(numb);
        String domain = "@gmail.com";
        String email = mailTitle+mailOrder+domain;
        //System.out.println(email);

        TestElements control = new TestElements(wdriver);
        control.register(email);
        Thread.sleep(3000);
        control.createAccount("Qa","Test","123456");
        control.yourAdress("Test Test","NY","Alabama","12345","12345678");
        control.register();
        Thread.sleep(2000);
        control.goHome();
    }
    @AfterTest
    public void quitPage() throws InterruptedException {
        Thread.sleep(2000);
        wdriver.close();
    }
}
