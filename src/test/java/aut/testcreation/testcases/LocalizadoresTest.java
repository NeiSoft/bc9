package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class LocalizadoresTest extends SeleniumTestBase {
    WebDriver driver;
    //Localizadores

    By btnEntendido = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");
    By btnEnviarA = By.cssSelector(".nav-menu-cp");
    By popElegirDonderRecibir = By.id("root-app");
    By cerrarPopElegir = By.className("andes-modal-dialog__button-close");

    @Test
    void localizandoElementos(){
        driver = DriverFactory.getDriver();
        driver.navigate().to(BASE_URL_AUT);

        if(driver.findElement(btnEntendido).isDisplayed())
            driver.findElement(btnEntendido).click();

        WebElement webElementBtnEnviar = driver.findElement(btnEnviarA);
        if(webElementBtnEnviar.isEnabled()) {
            String text = webElementBtnEnviar.getText();
            System.out.println(text);
            webElementBtnEnviar.click();
        }

        if(driver.findElement(popElegirDonderRecibir).isEnabled()){
            WebElement modal = driver.findElement(By.className("modal-iframe-cp")).findElement(By.tagName("iframe"));
            WebDriver documentModal = driver.switchTo().frame(modal);
            WebElement webElementCerrarPop =  documentModal.findElement(cerrarPopElegir);
            //String outer =  webElementCerrarPop.getAttribute("outerHTML");
            webElementCerrarPop.click();
        }
    }



}
