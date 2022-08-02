package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import static aut.engine.utils.Constants.BASE_URL_AUT;

public class TestGoogle extends SeleniumTestBase {

    WebDriver driver;

    @Test
    @Description ("Test en googleChrome")

    public void testgoogle() throws InterruptedException{
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //respuesta
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        String pageSource = driver.getPageSource();
        String handle= driver.getWindowHandle();

        //find
        //driver.findElement(By.className("gLFyf")).sendKeys("zapatos");
        driver.findElement(By.tagName("input")).sendKeys("poleras");
        //driver.findElement(By.className("RNNXgb")).findElement(By.tagName("input")).sendKeys("poleras");
        driver.findElement(By.name("btnK")).click();

        //navegar
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.navigate().to("https://translate.google.cl");
        Thread.sleep(5000);
        //driver.close();//cerrar todas las pestañas del navegador
        driver.quit();//cerrar de forma segura
    }

}
