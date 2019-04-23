

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddShowing {
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
  public void testAddShowing() throws Exception {
    driver.get("http://ec2-18-219-8-122.us-east-2.compute.amazonaws.com/");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Welcome!'])[1]/following::a[1]")).click();
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys("user33");
    driver.findElement(By.id("id_password")).click();
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("letmeinside");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Theaters'])[1]/following::a[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Add Showing")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("id_room")).click();
    new Select(driver.findElement(By.id("id_room"))).selectByVisibleText("Room #20");
    driver.findElement(By.id("id_room")).click();
    driver.findElement(By.id("id_movie")).click();
    new Select(driver.findElement(By.id("id_movie"))).selectByVisibleText("Captain Marvel");
    driver.findElement(By.id("id_movie")).click();
    driver.findElement(By.id("id_time")).click();
    driver.findElement(By.id("id_time")).clear();
    driver.findElement(By.id("id_time")).sendKeys("05/11/2019 11:30");
    driver.findElement(By.id("id_pricing")).click();
    new Select(driver.findElement(By.id("id_pricing"))).selectByVisibleText("Children");
    driver.findElement(By.id("id_pricing")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pricing'])[1]/following::input[1]")).click();
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
