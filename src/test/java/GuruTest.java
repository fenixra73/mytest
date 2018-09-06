import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GuruTest<driver> {
    WebDriver driver;

    @BeforeTest
    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/V2/webpages/addcustomerpage.php");
    }


    @Test

    public void guruTest() {
        /*тестируем поле Customer */
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys(Keys.TAB);
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equalsIgnoreCase("Customer name must not be blank"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys(" ");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equalsIgnoreCase("First character can not have space"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys("1234");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equalsIgnoreCase("Numbers are not allowed"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys("n124");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equalsIgnoreCase("Numbers are not allowed"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).clear();
         driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys("e!@#");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equalsIgnoreCase("Special characters are not allowed"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys("!@#");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equalsIgnoreCase("Special characters are not allowed"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).clear();

        /*тестируем поле Adress*/
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")).sendKeys(Keys.TAB);
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message3\"]")).getText().equalsIgnoreCase("Address Field must not be blank"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")).sendKeys(" ");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message3\"]")).getText().equalsIgnoreCase("First character can not have space"));

        /*тестируем поле city*/
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).sendKeys(Keys.TAB);
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message3\"]")).getText().equalsIgnoreCase("Address Field must not be blank"));
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).sendKeys(" ");
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message4\"]")).getText().equalsIgnoreCase("First character can not have space"));

    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
