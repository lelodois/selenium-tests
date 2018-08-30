package br.edu.cruzeirodosul.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class SeleniumDriver {

    private ChromeDriverService service;
    private org.openqa.selenium.WebDriver driver;
    private SistemaOperacional so;

    public SeleniumDriver(SistemaOperacional so) {
        this.so = so;
    }

    public SeleniumDriver abrir(String url) {
        service =
                new ChromeDriverService.Builder()
                        .usingDriverExecutable(this.getDriverExecutavel())
                        .usingAnyFreePort()
                        .build();

        this.start();

        driver =
                new RemoteWebDriver(service.getUrl(),
                        DesiredCapabilities.chrome());

        driver.get(url);
        return this;
    }

    public void maximizar() {
        driver.manage().window().maximize();
    }

    public void fechar() {
        driver.quit();
        service.stop();
    }

    private void start() {
        try {
            service.start();
        } catch (Exception e) {
            throw new RuntimeException("Erro - Talvez o executável não está sendo carregado", e);
        }
    }

    private File getDriverExecutavel() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        return new File(classLoader
                .getResource(so.name().toLowerCase() + "/chromedriver")
                .getFile());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
