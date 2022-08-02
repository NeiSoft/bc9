package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Desafio2 extends SeleniumTestBase {
    WebDriver driver;
    By originalLocation = By.xpath("//textarea[@class=\"er8xn\"]");
    By finalLocation = By.xpath("");
    By btnDesplegar = By.xpath("(//button[@jsname='zumM6d'])[1]");
    By btnIngles = By.xpath("(//div[@jsname='rPx1uf']/div[@data-language-code='en'])[2]");
    By btnFrances =By.xpath("(//div[@jsname='rPx1uf']/div[@data-language-code='fr'])[2]");

    By btnPortugues = By.xpath("(//div[@jsname='rPx1uf']/div[@data-language-code='pt'])[2]");

    By resultadoLocator = By.xpath("//span[@class='VIiyi']/span");

    String resultado = "";
    String TextoIngles = "Chaos theory is the branch of mathematics, physics and other sciences (biology, meteorology, economy, among others) that deals with certain types of complex systems and non -linear dynamic systems very sensitive to variations in the initial conditions.";

    String TextoFrances = "La théorie du chaos est la branche des mathématiques, de la physique et d'autres sciences (biologie, météorologie, économie, entre autres) qui traite de certains types de systèmes complexes et de systèmes dynamiques non linéaires très sensibles aux variations dans les conditions initiales.";

    String TextoPortugues = "A teoria do caos é o ramo da matemática, física e outras ciências (biologia, meteorologia, economia, entre outros) que lida com certos tipos de sistemas complexos e sistemas dinâmicos não lineares muito sensíveis a variações nas condições iniciais.";
    By btnDialogo = By.xpath("//button[contains(text(),'NO, GRACIAS')]");
    @Test

    public void traduccionIngles() throws InterruptedException {
        System.out.println("Inicio Test");
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://translate.google.com.ar/?hl=es-419");
        Thread.sleep(5000);
        String ventana = driver.getWindowHandle();
        WebElement original = driver.findElement(originalLocation);
        WebElement desplegar = driver.findElement(btnDesplegar);
        WebElement ingles = driver.findElement(btnIngles);
        List<WebElement> iframesList = driver.findElements(By.name("callout"));
        driver.switchTo().frame(iframesList.get(0));
        WebElement dialogo = driver.findElement(btnDialogo);
        dialogo.click();
        driver.switchTo().window(ventana);

        if (original.isDisplayed()) {
            original.click();
            original.clear();
            original.sendKeys("La teoría del caos es la rama de la matemática, la física y otras ciencias (biología, meteorología, economía, entre otras) que trata ciertos tipos de sistemas complejos y sistemas dinámicos no lineales muy sensibles a las variaciones en las condiciones iniciales.");
            desplegar.click();
            Thread.sleep(2000);
            ingles.click();
            Thread.sleep(2000);
            WebElement resultadoElement = driver.findElement(resultadoLocator);
            resultado = resultadoElement.getText();

        }
        Assertions.assertEquals(TextoIngles, resultado);

    }

    @Test
    public void traduccionFrances() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://translate.google.com.ar/?hl=es-419");
        String ventana = driver.getWindowHandle();
        WebElement frances = driver.findElement(btnFrances);
        WebElement original = driver.findElement(originalLocation);
        WebElement desplegar = driver.findElement(btnDesplegar);
        List<WebElement> iframesList = driver.findElements(By.name("callout"));
        driver.switchTo().frame(iframesList.get(0));
        WebElement dialogo = driver.findElement(btnDialogo);
        dialogo.click();
        driver.switchTo().window(ventana);

        if (original.isDisplayed()) {
            original.click();
            original.clear();
            original.sendKeys("La teoría del caos es la rama de la matemática, la física y otras ciencias (biología, meteorología, economía, entre otras) que trata ciertos tipos de sistemas complejos y sistemas dinámicos no lineales muy sensibles a las variaciones en las condiciones iniciales.");
            desplegar.click();
            Thread.sleep(2000);
            frances.click();
            Thread.sleep(2000);
            WebElement resultadoElement = driver.findElement(resultadoLocator);
            resultado = resultadoElement.getText();

        }
        Assertions.assertEquals(TextoFrances, resultado);

    }

    @Test
    public void traduccionPortugues() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://translate.google.com.ar/?hl=es-419");
        String ventana = driver.getWindowHandle();
        WebElement portugues = driver.findElement(btnPortugues);
        WebElement original = driver.findElement(originalLocation);
        WebElement desplegar = driver.findElement(btnDesplegar);
        List<WebElement> iframesList = driver.findElements(By.name("callout"));
        driver.switchTo().frame(iframesList.get(0));
        WebElement dialogo = driver.findElement(btnDialogo);
        dialogo.click();
        driver.switchTo().window(ventana);

        if (original.isDisplayed()) {
            original.click();
            original.clear();
            original.sendKeys("La teoría del caos es la rama de la matemática, la física y otras ciencias (biología, meteorología, economía, entre otras) que trata ciertos tipos de sistemas complejos y sistemas dinámicos no lineales muy sensibles a las variaciones en las condiciones iniciales.");
            desplegar.click();
            Thread.sleep(2000);
            portugues.click();
            Thread.sleep(2000);
            WebElement resultadoElement = driver.findElement(resultadoLocator);
            resultado = resultadoElement.getText();

        }

        Assertions.assertEquals(TextoPortugues, resultado);


    }
}

