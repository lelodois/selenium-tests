package br.edu.cruzeirodosul.pri;

import br.edu.cruzeirodosul.selenium.Selenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PriSimuladorCenarioPreencherValores {

    @Test
    public void testAbrirSimulador() {
        Selenium selenium = Selenium.abrir("http://localhost:4200/pri/");
        selenium.maximizar();
        selenium.clicarNoPrimeiroLinkComONome("button", "Simular nota");

        List<WebElement> inputs = selenium.pegaInputsNumericos();

        Assert.assertFalse("Não abriu o simulador", inputs.isEmpty());

        for (WebElement input : inputs) {
            input.click();
            input.sendKeys("0.9");
        }

        selenium.removerFocus();
        selenium.esperarPor(1);

        WebElement element = selenium
                .pegaItemPeloTipoEClasseCss("div", "col-xs-12 alert text-center alert-success no-margin");

        Assert.assertTrue(element.getText().contains("0,32"));

        selenium.clicarNoPrimeiroLinkComONome("a", "voltar");
        selenium.clicarNoPrimeiroLinkComONome("button", "fechar");
        selenium.fechar();
    }
}
