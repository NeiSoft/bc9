package aut.testcreation.testcases;

import aut.engine.selenium.SeleniumTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ManejoWebElement {
    static WebDriver driver;
    By dropdownLocator = By.id("dropdown");
    By checkbox1Locator = By.xpath("//form[@id='checkboxes']/input[1]");
    By checkbox2Locator = By.xpath("//form[@id='checkboxes']/input[2]");

    By enabledLocator = By.xpath("//li[@id=\"ui-id-3\"]/a");

    By dowloadLocator = By.xpath("//li[@id='ui-id-4']/a");

    By pdfLocator = By.xpath("//li[@id='ui-id-5']/a");

    By iframeText = By.id("tinymce");

    @BeforeAll
    static void init(){
        WebDriverManager.edgedriver().setup();
    }
    @BeforeEach
    void setup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @Test
    void dropdown(){
        System.out.println("Test DropDown");
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(dropdownLocator);

        //Select

        Select select = new Select(dropdown);

        //

        select.selectByValue("1");
        select.selectByValue("2");

        select.selectByIndex(0);
        select.selectByIndex(1);



    }
    @Test
    void checkbox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(checkbox1Locator);
        WebElement checkbox2 = driver.findElement(checkbox2Locator);

        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        if(checkbox2.isSelected()){
            checkbox2.click();
        }
    }
    @Test
    void menuDinamico() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu");
        WebElement btnEnabled = driver.findElement(enabledLocator);
        WebElement btnDowload = driver.findElement(dowloadLocator);
        WebElement btnPDF = driver.findElement(pdfLocator);

        if(btnPDF.isDisplayed()){
            btnPDF.click();
        }
        if(btnDowload.isDisplayed()){
            btnDowload.click();
        }

        if(btnEnabled.isDisplayed()){
            btnEnabled.click();
            //Thread.sleep(1000);
            btnDowload.click();
           // Thread.sleep(1000);
            btnPDF.click();
        }

    }
    @Test
    void iframes(){

        driver.navigate().to("https://the-internet.herokuapp.com/tinymce");
        //Traernos todos los iframes de la pagina
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframes.get(0));
        WebElement iframeTextElement = driver.findElement(iframeText);
        iframeTextElement.clear();
        iframeTextElement.sendKeys("Hola estoy enviando informacion desde el driver");

    }

    @AfterEach
    void close(){
        driver.quit();
    }
}
