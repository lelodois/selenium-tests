package br.edu.cruzeirodosul.pri;

import br.edu.cruzeirodosul.selenium.Selenium;
import org.junit.Test;

public class PriSimuladorCenarioNavegacao {

    @Test
    public void testAbrirSimulador() {
        Selenium selenium = Selenium
                .abrir("http://localhost:4200/pri/")
                .maximizar()
                .clicarNoPrimeiroLinkComONome("span", "ver mais detalhes")
                .clicarNoPrimeiroLinkComONome("button", "visualizar")
                .clicarNoPrimeiroLinkComONome("span", "ver mais detalhes")
                .clicarNoPrimeiroLinkComONome("a", "voltar");

        selenium.fechar();
    }
}
