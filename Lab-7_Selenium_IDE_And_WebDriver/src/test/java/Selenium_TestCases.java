import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Selenium_TestCases {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    @BeforeAll
    public static void setUp() {
        js = (JavascriptExecutor) driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TahlilMahfuz\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
    }
    @Test
    public void testSignup() {
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.id("password")).sendKeys("welcome01");
    }
    @Test
    public void testSorting() {
        driver.get("https://practicesoftwaretesting.com/");
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Name (A - Z)']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Name (Z - A)']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Price (High - Low)']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Price (Low - High)']")).click();
        }
    }
    @Test
    public void checkBox(){
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(1720, 934));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"filters\"]/div[2]/ul/div[1]/label/input")));
        driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/ul/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filters\"]/div[6]/label/input")).click();

        boolean en1=driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/ul/div[1]/label/input")).isEnabled();
        boolean en2=driver.findElement(By.xpath("//*[@id=\"filters\"]/div[6]/label/input")).isEnabled();

        assertTrue(en1);
        assertTrue(en2);
    }
    @Test
    public void searchBar(){
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector("*[data-test=\"search-query\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"search-query\"]")).sendKeys("Combination Pliers");
        driver.findElement(By.cssSelector("*[data-test=\"search-query\"]")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test=\"search_completed\"]")));

        String result=driver.findElement(By.cssSelector("[data-test=\"search_completed\"]")).getText();
        assertEquals("Combination Pliers\n" +
                "$14.15", result);
    }
    @Test
    public void testPriceRange(){
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector(".ngx-slider-full-bar > .ngx-slider-span")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".ngx-slider-pointer-max"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".ngx-slider-pointer-max"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".ngx-slider-pointer-max"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".ngx-slider-pointer-max")).click();
        driver.findElement(By.cssSelector(".ngx-slider-selection-bar")).click();
    }
    @Test
    public void testContactPage() {
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector("*[data-test=\"nav-contact\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).sendKeys("Tahlil");
        driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).sendKeys("Mahfuz");
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("practice@gmail.com");
        driver.findElement(By.cssSelector("*[data-test=\"subject\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"subject\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Webmaster']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"message\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"message\"]")).sendKeys(
                "আমার যমুনার জল দেখতে কালো,\n" +
                "চান করিতে লাগে ভালো,\n" +
                "যৌবন মিশিয়া গেলো জলে\n");
        driver.findElement(By.cssSelector(".row:nth-child(2)")).click();
        driver.findElement(By.cssSelector("*[data-test=\"contact-submit\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/app-root/div/app-contact/div/div/div/div"), "Thanks for your message! We will contact you shortly."));

        String message = driver.findElement(By.xpath("/html/body/app-root/div/app-contact/div/div/div/div")).getText();

        assertEquals("Thanks for your message! We will contact you shortly.", message);
    }
    @Test
    public void testLogin() {
        driver.get("https://practicesoftwaretesting.com/#/auth/register");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"first-name\"]")).sendKeys("Tahlil");
        driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"last-name\"]")).sendKeys("Mahfuz");
        driver.findElement(By.cssSelector("*[data-test=\"dob\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"dob\"]")).sendKeys("2"+"\t"+"2"+"\t"+"2021");
        driver.findElement(By.cssSelector("*[data-test=\"address\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"address\"]")).sendKeys("Dhaka");
        driver.findElement(By.cssSelector("*[data-test=\"postcode\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"postcode\"]")).sendKeys("1001");
        driver.findElement(By.cssSelector("*[data-test=\"city\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"city\"]")).sendKeys("Dhaka");
        driver.findElement(By.cssSelector("*[data-test=\"state\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"state\"]")).sendKeys("Dhaka");
        driver.findElement(By.cssSelector("*[data-test=\"country\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"country\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Bangladesh']")).click();
        }
        driver.findElement(By.cssSelector(".form-group:nth-child(9)")).click();
        driver.findElement(By.cssSelector(".form-group:nth-child(9)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".form-group:nth-child(9)"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.cssSelector("*[data-test=\"phone\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"phone\"]")).sendKeys("123421341241");
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("practice@gmail.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("12345314142ASDFWDW!@@Fa");
        driver.findElement(By.cssSelector("*[data-test=\"register-submit\"]")).click();
    }
    @Test
    public void testForgotPassword(){
        driver.get("https://practicesoftwaretesting.com/#/auth/forgot-password");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("practice@gmail.com");
        driver.findElement(By.cssSelector("*[data-test=\"forgot-password-submit\"]")).click();
    }
    @Test
    public void productDetails(){
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.manage().window().setSize(new Dimension(649, 789));
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-home\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"nav-home\"]")).click();
        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"increase-quantity\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector(".fa-minus")).click();
        driver.findElement(By.cssSelector(".fa-minus")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-favorites\"]")).click();
    }
    @Test
    public void testFavouritePage(){
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.manage().window().setSize(new Dimension(649, 789));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-favorites\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"nav-favorites\"]")).click();
    }
    @Test
    public void testProfilePage(){
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.manage().window().setSize(new Dimension(649, 789));
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-profile\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"nav-profile\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"phone\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"phone\"]")).sendKeys("1234");
        driver.findElement(By.cssSelector("*[data-test=\"update-profile-submit\"]")).click();
    }
    @Test
    public void testCheckOutBuyNowPayLater(){
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.manage().window().setSize(new Dimension(649, 789));
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-home\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"nav-home\"]")).click();
        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"increase-quantity\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/i")));
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/i")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-1\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"proceed-1\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-2\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"proceed-2\"]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector("*[data-test=\"address\"]"), "Test street 98"));
        driver.findElement(By.cssSelector("*[data-test=\"state\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"state\"]")).sendKeys("Dhaka");
        driver.findElement(By.cssSelector("*[data-test=\"postcode\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"postcode\"]")).sendKeys("1001");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-3\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"proceed-3\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"payment-method\"]")).click();

        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"payment-method\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Buy Now Pay Later']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"monthly_installments\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"monthly_installments\"]"));
            dropdown.findElement(By.xpath("//option[. = '3 monthly installments']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
    }
    @Test
    public void testCheckOutCreditCard(){
        driver.get("https://practicesoftwaretesting.com/#/auth/login");
        driver.manage().window().setSize(new Dimension(649, 789));
        driver.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome01");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-home\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"nav-home\"]")).click();
        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"increase-quantity\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/i")));
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/i")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-1\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"proceed-1\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-2\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"proceed-2\"]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector("*[data-test=\"address\"]"), "Test street 98"));
        driver.findElement(By.cssSelector("*[data-test=\"state\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"state\"]")).sendKeys("Dhaka");
        driver.findElement(By.cssSelector("*[data-test=\"postcode\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"postcode\"]")).sendKeys("1001");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-3\"]")));
        driver.findElement(By.cssSelector("*[data-test=\"proceed-3\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"payment-method\"]")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("*[data-test=\"payment-method\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Credit Card']")).click();
        }
        driver.findElement(By.cssSelector("*[data-test=\"credit_card_number\"]")).click();
        driver.findElement(By.id("credit_card_number_help")).click();
        driver.findElement(By.cssSelector("*[data-test=\"credit_card_number\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"credit_card_number\"]")).sendKeys("0000-0000-0000-0000");
        driver.findElement(By.cssSelector("*[data-test=\"expiration_date\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"expiration_date\"]")).sendKeys("10/2025");
        driver.findElement(By.cssSelector("*[data-test=\"cvv\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"cvv\"]")).sendKeys("1233");
        driver.findElement(By.cssSelector("*[data-test=\"card_holder_name\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"card_holder_name\"]")).sendKeys("tahlil");
        driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
