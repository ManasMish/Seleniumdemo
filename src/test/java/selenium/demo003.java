package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.tta.util.extractint.extractInteger;

public class demo003 {
    ChromeDriver driver;
    Double total=0.0;
    @BeforeTest
    public void openbrowser(){
        driver=new ChromeDriver();
        driver.get(" https://demo.applitools.com");
    }
    @Test
    public void testcase(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//a[@id='log-in']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Account")));
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.applitools.com/app.html");

        WebElement table= driver.findElement(By.xpath("//table[@class='table table-padded']"));
        List<WebElement> rows_table=table.findElements(By.tagName("tr"));
        for (int i=1;i<rows_table.size();i++) {
            List<WebElement> column_table = rows_table.get(i).findElements(By.tagName("td"));
            for (WebElement e:column_table) {
                if ((e.getText().contains("+")==true)||(e.getText().contains("-")==true))
                {
                    if(e.getText().contains("+")==true){
                        total=total+Double.parseDouble(extractInteger(e.getText().toString()));
                    }
                    else{
                        total=total-Double.parseDouble(extractInteger(e.getText().toString()));
                    }
                }
            }
        }
        Assert.assertEquals(1996.22,total);
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}
