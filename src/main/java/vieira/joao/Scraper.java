package vieira.joao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scraper {
    public static void main(String[] args) {

        String os = System.getProperty("os.name").toLowerCase();
        String geckoDriverPath;
        if (os.contains("win")) { geckoDriverPath = "src/main/resources/geckodriver.exe"; }
        else { geckoDriverPath = "src/main/resources/geckodriver"; }

        // Set the geckodriver property
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);

        // Start the driver
        WebDriver driver = new FirefoxDriver();

        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));


        //driver.navigate().to("https://novelbin.org/");

        //Webnovel wn = new Webnovel();

        // TODO: Create an object that reads/writes to the save file (WebnovelFileHandler)
        // While reading should return a list of webnovels present in the file
        // While writing should save a new webnovel to the list of webnovels that it already has



    }

}