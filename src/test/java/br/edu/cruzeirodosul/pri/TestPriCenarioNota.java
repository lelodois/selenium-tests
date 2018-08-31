package br.edu.cruzeirodosul.pri;

import br.edu.cruzeirodosul.selenium.Selenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class TestPriCenarioNota {

    @Test
    public void verificarNota() {
        Selenium selenium = Selenium.abrir("http://localhost:4200/pri");

        selenium.esperarPor(1);
        selenium.clicarNoPrimeiroLinkComONome("span", "ver mais detalhes");

        WebElement element = selenium.pegarItemPeloXpath(
                "//*[@id=\"collapse-5\"]/div/div[1]/app-pri-disciplinas/table/tbody/tr[4]/td/div/span[4]/span/u"
        );

        Assert.assertTrue(element.getText().equalsIgnoreCase("C"));

        selenium.fechar();
    }
}
