package desafio.grupo2.rumbo.testcreation.testcases;

import desafio.grupo2.rumbo.testcreation.pages.RumboEsHomePage;
import desafio.grupo2.rumbo.testcreation.pages.RumboEsHotelesBusquedaPage;
import desafio.grupo2.rumbo.testcreation.pages.RumboEsHotelesPage;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CP003_Hoteles extends SeleniumTestBase {
    RumboEsHomePage rumboEsHomePage;
    RumboEsHotelesPage rumboEsHotelesPage;
    RumboEsHotelesBusquedaPage rumboEsHotelesBusquedaPage;
    @Test
    @Description("Test Caso CP003_Hoteles")
    void CP003_Hoteles() throws InterruptedException {
        rumboEsHomePage = new RumboEsHomePage(DriverFactory.getDriver());
        rumboEsHomePage.despegarARumbos();
        rumboEsHomePage.aceptarCookies();
        rumboEsHomePage.irAHoteles();

        Assertions.assertEquals("Hoteles | Ofertas de Hoteles baratos | Rumbo", rumboEsHomePage.getUrlTitle());

        rumboEsHotelesPage = new RumboEsHotelesPage(DriverFactory.getDriver());
        rumboEsHotelesPage.ingresarDestino("Chicago");
        rumboEsHotelesPage.FechaInicioVuelta();
        rumboEsHotelesPage.buscar();

        Assertions.assertEquals("Inspírate para tus viajes en 2022/2023 | lastminute.com", rumboEsHomePage.getUrlTitle());

        rumboEsHotelesBusquedaPage = new RumboEsHotelesBusquedaPage(DriverFactory.getDriver());
        rumboEsHotelesBusquedaPage.filtroTipoAlojamiento();
        rumboEsHotelesBusquedaPage.filtroTipoAlojamientoHotel();
        rumboEsHotelesBusquedaPage.aplicarFiltro();
        rumboEsHotelesBusquedaPage.seleccionarHotel();
    }
}

