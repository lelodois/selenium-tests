package br.edu.cruzeirodosul.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Selenium {

    private SeleniumDriver driver;
    private SeleniumFinder finder;

    private Selenium() {
    }

    public static Selenium abrir(String url) {
        Selenium seleniumWebDriver = new Selenium();
        seleniumWebDriver.driver = new SeleniumDriver().abrir(url);
        seleniumWebDriver.finder = new SeleniumFinder(seleniumWebDriver.driver);
        return seleniumWebDriver;
    }

    public Selenium maximizar() {
        driver.maximizar();
        return this;
    }

    public Selenium clicarNoPrimeiroLinkComONome(String tag, String nome) {
        finder.pegaElementoPelaTagENome(tag, nome).click();
        this.esperarPor(1);
        return this;
    }

    public List<WebElement> pegaInputsNumericos() {
        return finder.pegaElementoPelaTagEType("input", "number");
    }

    public WebElement pegaElementoPeloTipoEClassesCss(String type, String classeCss) {
        return finder.getElementPeloTipoEClasseCss(type, classeCss);
    }

    public Selenium fechar() {
        driver.fechar();
        return this;
    }

    public Selenium esperarPor(int segundos) {
        finder.esperarPor(segundos);
        return this;
    }

    public Selenium removerFocus() {
        finder.pegaElementoPelaTag("body").click();
        return this;
    }

    public WebDriver getWebDriver() {
        return driver.getDriver();
    }
}