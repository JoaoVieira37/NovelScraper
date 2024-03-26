package vieira.joao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Scraper {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://novelbin.org/");

    }
}