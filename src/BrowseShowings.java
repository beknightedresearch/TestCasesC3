

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowseShowings {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String path = "D:\\Program Files\\Eclipse-Oxygen\\eclipse\\workspace_CSCI4830_0219\\project_webapp_testing\\lib\\win\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBrowseShowings() throws Exception {
    driver.get("http://ec2-18-219-8-122.us-east-2.compute.amazonaws.com/");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Find a Movie")).click();
    driver.findElement(By.id("mName")).click();
    driver.findElement(By.id("mName")).clear();
    driver.findElement(By.id("mName")).sendKeys("Avengers");
    Thread.sleep(2000);
    driver.findElement(By.id("theater_search_submit")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("tCity")).click();
    driver.findElement(By.id("tCity")).clear();
    driver.findElement(By.id("tCity")).sendKeys("Omaha");
    Thread.sleep(2000);
    driver.findElement(By.id("theater_search_submit")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("tState")).click();
    driver.findElement(By.id("tState")).clear();
    driver.findElement(By.id("tState")).sendKeys("NE");
    Thread.sleep(2000);
    driver.findElement(By.id("theater_search_submit")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    Thread.sleep(2000);
    driver.findElement(By.id("name")).sendKeys("Cinema");
    Thread.sleep(2000);
    driver.findElement(By.id("theater_search_submit")).click();
    driver.findElement(By.id("day")).click();
    driver.findElement(By.id("day")).clear();
    driver.findElement(By.id("day")).sendKeys("0002-12-12");
    driver.findElement(By.id("day")).clear();
    driver.findElement(By.id("day")).sendKeys("0020-12-12");
    driver.findElement(By.id("day")).clear();
    driver.findElement(By.id("day")).sendKeys("0201-12-12");
    driver.findElement(By.id("day")).clear();
    driver.findElement(By.id("day")).sendKeys("2019-12-12");
    Thread.sleep(2000);
    driver.findElement(By.id("theater_search_submit")).click();
    Thread.sleep(2000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
