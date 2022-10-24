import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestElements {
    WebDriver driver;
    By login = new By.ByClassName("login");
    By signMail = new By.ById("email_create");
    By signBtn = new By.ById("SubmitCreate");
    By firstName = new By.ById("customer_firstname");
    By lastName = new By.ById("customer_lastname");
    By email = new By.ByName("email");
    By password = new By.ById("passwd");
    By address = new By.ById("address1");
    By city = new By.ById("city");
    By state = new By.ById("id_state");
    By zipcode = new By.ById("postcode");
    By phone = new By.ById("phone_mobile");
    By register = new By.ByName("submitAccount");
    By home = new By.ByLinkText("Home");

    public TestElements(WebDriver wdriver)
    {
        this.driver=wdriver;
    }
    public void register(String mail) {
        driver.findElement(login).click();
        driver.findElement(signMail).sendKeys(mail);
        driver.findElement(signBtn).click();
    }
    public void createAccount(String name,String name2,String paw){
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(name2);
        driver.findElement(password).sendKeys(paw);
    }
    public void yourAdress(String addr,String ci, String sta,String zip,String pho){
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(ci);
        driver.findElement(state).sendKeys(sta);
        driver.findElement(zipcode).sendKeys(zip);
        driver.findElement(phone).sendKeys(pho);
    }
    public void register(){ driver.findElement(register).click(); }
    public void goHome(){ driver.findElement(home).click(); }
}