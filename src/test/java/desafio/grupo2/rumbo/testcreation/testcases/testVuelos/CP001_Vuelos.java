package desafio.grupo2.rumbo.testcreation.testcases.testVuelos;

import desafio.grupo2.rumbo.testcreation.pages.RumboEsHomePage;
import desafio.grupo2.rumbo.testcreation.pages.Vuelos.RumboEsVuelosBusquedaPage;
import desafio.grupo2.rumbo.testcreation.pages.Vuelos.RumboEsVuelosPage;
import desafio.grupo2.rumbo.testcreation.pages.Vuelos.RumboVuelosSecurePage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CP001_Vuelos extends SeleniumTestBase {

    RumboEsHomePage rumboEsHomePage;
    RumboEsVuelosPage rumboEsVuelosPage;

    RumboEsVuelosBusquedaPage rumboEsVuelosBusquedaPage;

    RumboVuelosSecurePage rumboVuelosSecurePage;

    @ParameterizedTest
    @MethodSource
   // @ValueSource(strings = {"MAD - FCO","MAD - LIS"})
    @Description("Realizando la prubea CP001 del RF01")
    void CP001_MultiplesVuelos(String origen,String destino,String esperado) throws InterruptedException {
        rumboEsHomePage = new RumboEsHomePage(DriverFactory.getDriver());
        rumboEsHomePage.despegarARumbos();
        rumboEsHomePage.aceptarCookies();
        rumboEsHomePage.irAVuelos();
        rumboEsVuelosPage = new RumboEsVuelosPage(DriverFactory.getDriver());
        rumboEsVuelosPage.ingresarOrigen(origen);
        rumboEsVuelosPage.ingresarDestino(destino);
        rumboEsVuelosPage.establecerFechaViaje();
        rumboEsVuelosPage.desplegarPasajeros();
        rumboEsVuelosPage.desplegarClases();
        rumboEsVuelosPage.buscarViaje();
        Thread.sleep(2000);
        ArrayList<String> pestañas = rumboEsVuelosPage.getWinndowHandleds();
        if (pestañas.size() > 1){
            rumboEsVuelosPage.SwitchTo(pestañas.get(1));
        }
        rumboEsVuelosBusquedaPage = new RumboEsVuelosBusquedaPage(DriverFactory.getDriver());
        String resultado = rumboEsVuelosBusquedaPage.obtenerRutaOri() + " - " + rumboEsVuelosBusquedaPage.obtenerRutaDes();

            System.out.println(resultado);

            Assertions.assertEquals(esperado,resultado);
        }


    static Stream<Arguments> CP001_MultiplesVuelos(){
        return Stream.of(
                Arguments.arguments("Madrid", "Roma", "MAD - FCO")
                //Arguments.arguments("Madrid", "Lisboa", "MAD - LIS"),
                //Arguments.arguments("Madrid", "Londres","MAD - LGW")
        );
    }

}
