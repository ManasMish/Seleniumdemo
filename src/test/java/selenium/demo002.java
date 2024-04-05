package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class demo002 {
    ChromeDriver driver;
    @BeforeTest
    public void openbrowser(){
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void testcase() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));


        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
        driver.findElement(By.linkText("PIM")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee")));
        driver.findElement(By.linkText("Add Employee")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("firstName")));
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("mkmis");
        driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Mishra");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("ji");
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("2358");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
        driver.findElement(By.linkText("PIM")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("mkmis Mishra ji");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-table orangehrm-employee-list']")));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='oxd-table orangehrm-employee-list']")));



        driver.findElement(By.xpath("(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[2]")).click();
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();



        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
    @AfterTest
    public void closebrowser(){
        driver.close();
    }
}
