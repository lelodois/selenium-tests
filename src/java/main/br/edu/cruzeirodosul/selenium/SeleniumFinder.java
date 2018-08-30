package br.edu.cruzeirodosul.selenium;

import br.edu.cruzeirodosul.selenium.exception.NenhumItemEncontrado;
import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

public class SeleniumFinder {

    private final FluentWait<WebDriver> fluentWait;
    private final SeleniumDriver instance;

    public SeleniumFinder(SeleniumDriver instance) {
        this.instance = instance;
        this.fluentWait = SeleniumWait.wait(instance.getDriver(), 10);
    }

    public List<WebElement> pegaItensPelaTagENome(String tagName, String nome) {
        List<WebElement> elementsResult = Lists.newArrayList();

        for (WebElement element : this.pegaItensPelaTag(tagName)) {
            if (element.getText().equalsIgnoreCase(nome)) {
                elementsResult.add(element);
            }
        }

        if (elementsResult.isEmpty()) {
            throw new NenhumItemEncontrado("Com a tag: " + tagName + " e nome: " + nome);
        }

        return elementsResult;
    }

    public List<WebElement> pegaItemPelaTagEType(String tagName, String type) {
        List<WebElement> elementsByTag = this.pegaItensPelaTag(tagName);

        List<WebElement> elements = Lists.newArrayList();
        for (WebElement element : elementsByTag) {
            if (element.getAttribute("type").equalsIgnoreCase(type)) {
                elements.add(element);
            }
        }
        return elements;
    }

    public List<WebElement> pegaItensPelaTag(String tagName) {
        List<WebElement> elements = fluentWait.until(
                driver -> driver.findElements(By.tagName(tagName))
        );

        if (elements.isEmpty()) {
            throw new NenhumItemEncontrado("Com a tag: " + tagName);
        }
        return elements;
    }

    public WebElement pegaItemPeloTipoEClasseCss(String type, String cssClassName) {
        WebElement element = fluentWait.until(
                driver -> driver.findElement(
                        By.cssSelector(type + "[class*='" + cssClassName + "']")
                )
        );

        if (element == null) {
            throw new NenhumItemEncontrado("Com a css cass: " + cssClassName);
        }

        return element;
    }

    public WebElement pegaItemPeloXpath(String xpath) {
        WebElement element = fluentWait.until(
                driver -> driver.findElement(
                        By.xpath(xpath)
                )
        );

        if (element == null) {
            throw new NenhumItemEncontrado("Com o xpath: " + xpath);
        }

        return element;
    }

    public void esperarPor(int segundos) {
        try {
            SeleniumWait.wait(instance.getDriver(), segundos)
                    .until(w -> w.findElement(By.id("idnaodeveexistir")));
        } catch (Throwable e) {
        }
    }
}
