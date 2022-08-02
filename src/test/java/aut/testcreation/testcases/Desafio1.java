package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Desafio1 extends SeleniumTestBase {
    WebDriver driver;
    @Test
    public void testSpDigital() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.spdigital.cl/");

        By Buscador = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/input");
        By btnBuscar = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/button");

        WebElement webElementBuscador = driver.findElement(Buscador);
        WebElement webElementbtnBuscar = driver.findElement(btnBuscar);

        webElementBuscador.sendKeys("asdfgh");

        Thread.sleep(5000);

        webElementbtnBuscar.click();

        Thread.sleep(5000);
        By textoNoEncontrado = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div[4]/section[1]/div/div[2]/div[2]/span[1]");

        WebElement webElementTextoNoEncontrado = driver.findElement(textoNoEncontrado);

        String respuesta = webElementTextoNoEncontrado.getText();

        Assertions.assertEquals("0 - 0 de 0 productos para tu búsqueda: \"asdfgh\"",respuesta);
    }

}
