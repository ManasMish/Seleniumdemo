package selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demo001 {

    @Test(groups="QA")
    @Description("opening sdet.live")
    public void testsdetlivelogin() {
        WebDriver driver=new EdgeDriver();
        driver.get("https://sdet.live");
        Assert.assertEquals(driver.getCurrentUrl(),"https://sdet.live");
        driver.close();
    }
}
