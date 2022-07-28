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
        driver.get(BASE_URL_AUT);
        Assertions.assertTrue(true);
    }

}
