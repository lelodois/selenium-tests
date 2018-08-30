package br.edu.cruzeirodosul.selenium;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class SeleniumWait {

    private SeleniumWait() {
    }

    public static FluentWait<WebDriver> wait(WebDriver driver, int segundos) {
        return new FluentWait<>(driver)
                .withTimeout(segundos, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .withMessage(() -> "A pesquisa está errada, elementos não encontrados")
                .ignoring(NoSuchElementException.class);
    }
}
