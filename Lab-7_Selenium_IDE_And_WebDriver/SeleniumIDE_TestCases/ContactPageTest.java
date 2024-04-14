// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ContactPageTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void contactPage() {
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
    driver.findElement(By.cssSelector("*[data-test=\"message\"]")).sendKeys("Hi.Hello.BYEEE");
    driver.findElement(By.cssSelector("*[data-test=\"attachment\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"attachment\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"contact-submit\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"message\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"message\"]")).sendKeys("Hi.Hello.BYEEE.PEEEEEp peeeepepepepepapjfapcieponvapvn");
    driver.findElement(By.cssSelector(".row:nth-child(2)")).click();
    driver.findElement(By.cssSelector("*[data-test=\"contact-submit\"]")).click();
  }
}