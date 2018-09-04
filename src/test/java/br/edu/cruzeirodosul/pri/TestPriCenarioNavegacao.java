package br.edu.cruzeirodosul.pri;

import br.edu.cruzeirodosul.selenium.Selenium;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebElement;

import java.util.List;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestPriCenarioNavegacao {

    @Test
    public void navegar() {
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
        List<WebElement> webElements = selenium.pegarItensPelaTagENome("span", "ver mais detalhes");
        for (WebElement webElement : webElements) {
            webElement.click();
            selenium.esperarPor(1);
        }
    }
}

