

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddMovie {
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
  public void testAddMovie() throws Exception {
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
    Thread.sleep(2000);
    driver.findElement(By.linkText("Add a Movie")).click();
    driver.findElement(By.id("id_movietitle")).click();
    driver.findElement(By.id("id_movietitle")).click();
    driver.findElement(By.id("id_movietitle")).clear();
    driver.findElement(By.id("id_movietitle")).sendKeys("Princess Disney");
    driver.findElement(By.id("id_movieruntime")).click();
    driver.findElement(By.id("id_movieruntime")).clear();
    driver.findElement(By.id("id_movieruntime")).sendKeys("60");
    driver.findElement(By.id("id_movierating")).click();
    driver.findElement(By.id("id_movierating")).clear();
    driver.findElement(By.id("id_movierating")).sendKeys("E");
    driver.findElement(By.id("id_moviereleasedate_day")).click();
    new Select(driver.findElement(By.id("id_moviereleasedate_day"))).selectByVisibleText("27");
    driver.findElement(By.id("id_moviereleasedate_day")).click();
    driver.findElement(By.id("id_moviegenre")).click();
    driver.findElement(By.id("id_moviegenre")).clear();
    driver.findElement(By.id("id_moviegenre")).sendKeys("Family");
    driver.findElement(By.id("id_moviedescription")).click();
    driver.findElement(By.id("id_moviedescription")).clear();
    driver.findElement(By.id("id_moviedescription")).sendKeys("Disney");
    Thread.sleep(3000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Poster'])[1]/following::input[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("All Movies")).click();
    Thread.sleep(3000);
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
