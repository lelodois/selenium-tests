package br.edu.cruzeirodosul.selenium;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Selenium {

    private SeleniumDriver driver;
    private SeleniumFinder finder;

    private Selenium() {
    }

    public static Selenium abrir(SistemaOperacional so, String url) {
        Selenium seleniumWebDriver = new Selenium();
        seleniumWebDriver.driver = new SeleniumDriver(so).abrir(url);
        seleniumWebDriver.finder = new SeleniumFinder(seleniumWebDriver.driver);
        return seleniumWebDriver;
    }

    public void maximizar() {
        driver.maximizar();
    }

    public void clicarNoBotaoComONome(String nome) {
        finder
                .pegaElementoPelaTagENome("button", nome)
                .click();
    }

    public List<WebElement> pegaInputsNumericos() {
        return finder.pegaElementoPelaTagEType("input", "number");
    }

    public WebElement pegaElementoPeloTipoEClassesCss(String type, String classeCss) {
        return finder.getElementPeloTipoEClasseCss(type, classeCss);
    }

    public void fechar() {
        driver.fechar();
    }

    public void esperarPor(int segundos) {
        finder.esperarPor(segundos);
    }

    public void removerFocus() {
        finder.pegaElementoPelaTag("body").click();
    }
}