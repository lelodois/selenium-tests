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
        finder.pegarItensPelaTagENome(tag, nome).get(0).click();
        this.esperarPor(1);
        return this;
    }

    public List<WebElement> pegarInputsNumericos() {
        return finder.pegarItensPelaTagEType("input", "number");
    }

    public WebElement pegarItemPeloTipoEClasseCss(String type, String classeCss) {
        return finder.pegarItemPeloTipoEClasseCss(type, classeCss);
    }

    public WebElement pegarItemPeloXpath(String xpath) {
        return finder.pegarItemPeloXpath(xpath);
    }

    public List<WebElement> pegarItensPelaTagENome(String tagName, String nome) {
        return finder.pegarItensPelaTagENome(tagName, nome);
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
        finder.pegarItensPelaTag("body").get(0).click();
        return this;
    }

    public WebDriver pegarWebDriver() {
        return driver.pegarWebDriver();
    }
}