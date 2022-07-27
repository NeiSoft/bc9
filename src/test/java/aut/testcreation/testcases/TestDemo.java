package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class TestDemo extends SeleniumTestBase {

    WebDriver driver; // navegador

    @Test
    @Description("Test creado para bootcamp 9 tsoft")
    public void testDemo() throws InterruptedException {
        //Inicializacion
        driver = DriverFactory.getDriver(); //crear el browser de la prueba
        driver.get(BASE_URL_AUT);
        WebElement bTnLucky = driver.findElement(By.name("btnI"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("console.log('Hola mundo')");
        js.executeScript("arguments[0].click()", bTnLucky);


        //Acciones de browser

        //Posicionamiento del Browser



        //System.out.println("El alto y tamaño de la ventana es: " + alto + " " + ancho);

        /*Dimension AltoAncho = driver.manage().window().getSize();

        int alto = AltoAncho.getHeight();
        int ancho = AltoAncho.getWidth();


        System.out.println("El alto y tamaño de la ventana es: " + alto + " " + ancho);


        driver.manage().window().setSize(new Dimension(800,600));

        int posicionX = driver.manage().window().getPosition().x;
        int posiciony = driver.manage().window().getPosition().y;

        Point PosicionDriver = driver.manage().window().getPosition();

        posicionX = PosicionDriver.getX();
        posiciony = PosicionDriver.getY();

        driver.manage().window().setPosition(new Point(0,0));*/

        //Ventanas y TABS - Como movernos

/*        driver.get(BASE_URL_AUT);
        String ventana1= driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);

        String ventana2 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        String pestaña = driver.getWindowHandle();

        driver.get(BASE_URL_AUT);

        driver.switchTo().window(ventana1);
        driver.get(BASE_URL_AUT);

        driver.switchTo().window(ventana2);
        driver.get(BASE_URL_AUT);*/

        //Navegacion basicas del driver


       /* String nombreUrlActual = driver.getCurrentUrl();
        String tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en :" + nombreUrlActual + "Y su titulo es: " + tituloWeb);
        Thread.sleep(3000);
        driver.navigate().to("https://selenium.dev");
        Thread.sleep(3000);
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en :" + nombreUrlActual + "Y su titulo es: " + tituloWeb);

        //Browser :: Back - Fordward - Refresh

        driver.navigate().back();

        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en :" + nombreUrlActual + "Y su titulo es: " + tituloWeb);

        driver.navigate().forward();

        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb = driver.getTitle();
        System.out.println("Me encuentro en :" + nombreUrlActual + "Y su titulo es: " + tituloWeb);

        driver.navigate().refresh();*/


        Assertions.assertTrue(true);
    }
}