package br.edu.cruzeirodosul.pri;

import br.edu.cruzeirodosul.selenium.Selenium;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PriCenarioNavegacao {

    @Test
    public void testAbrirSimulador() {
        Selenium selenium = Selenium.abrir("http://localhost:4200/pri/");
        selenium.maximizar();
        this.clicarEmTodosVerMaisDetalhes(selenium);

        selenium.clicarNoPrimeiroLinkComONome("button", "visualizar");

        this.clicarEmTodosVerMaisDetalhes(selenium);

        selenium.clicarNoPrimeiroLinkComONome("button", "visualizar recursos");
        selenium.clicarNoPrimeiroLinkComONome("a", "voltar");
        selenium.clicarNoPrimeiroLinkComONome("a", "voltar");
        selenium.fechar();
    }

    private void clicarEmTodosVerMaisDetalhes(Selenium selenium) {
        List<WebElement> webElements = selenium.pegaItensPelaTagENome("span", "ver mais detalhes");
        for (WebElement webElement : webElements) {
            webElement.click();
            selenium.esperarPor(1);
        }
    }
}

