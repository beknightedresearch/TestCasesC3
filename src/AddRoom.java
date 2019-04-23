

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddRoom {
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
  public void testAddRoom() throws Exception {
    driver.get("http://ec2-18-219-8-122.us-east-2.compute.amazonaws.com/");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Welcome!'])[1]/following::a[1]")).click();
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys("user33");
    driver.findElement(By.id("id_password")).click();
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("letmeinside");
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Theaters'])[1]/following::a[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("More Settings")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Add Room")).click();
    driver.findElement(By.id("id_roomnumber")).click();
    driver.findElement(By.id("id_roomnumber")).clear();
    driver.findElement(By.id("id_roomnumber")).sendKeys("222");
    driver.findElement(By.id("id_rows")).click();
    driver.findElement(By.id("id_rows")).clear();
    driver.findElement(By.id("id_rows")).sendKeys("15");
    driver.findElement(By.id("id_columns")).click();
    driver.findElement(By.id("id_columns")).clear();
    driver.findElement(By.id("id_columns")).sendKeys("15");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Number of Seats per Row'])[1]/following::input[2]")).click();
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
