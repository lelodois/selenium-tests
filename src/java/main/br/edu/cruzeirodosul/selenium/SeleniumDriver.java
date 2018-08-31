package br.edu.cruzeirodosul.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class SeleniumDriver {

    private ChromeDriverService service;
    private org.openqa.selenium.WebDriver driver;

    public SeleniumDriver() {
    }

    public SeleniumDriver abrir(String url) {
        service =
                new ChromeDriverService.Builder()
                        .usingDriverExecutable(this.pegarDriverExecutavel())
                        .usingAnyFreePort()
                        .build();

        this.iniciar();

        driver =
                new RemoteWebDriver(service.getUrl(),
                        DesiredCapabilities.chrome());

        driver.get(url);
        return this;
    }

    public void maximizar() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
        }
    }

    public void fechar() {
        driver.quit();
        service.stop();
    }

    private void iniciar() {
        try {
            service.start();
        } catch (Exception e) {
            throw new RuntimeException("Erro - Talvez o executável não está sendo carregado", e);
        }
    }

    private File pegarDriverExecutavel() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        return new File(classLoader
                .getResource(pegarSo() + "/chromedriver")
                .getFile());
    }

    public WebDriver pegarWebDriver() {
        return driver;
    }

    private String pegarSo() {
        String so = System.getProperties().getProperty("os.name");
        return (so.indexOf("nux") >= 0) ? "linux" : "windows";
    }
}
