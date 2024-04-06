package vieira.joao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {

        String os = System.getProperty("os.name").toLowerCase();
        String geckoDriverPath;
        if (os.contains("win")) { geckoDriverPath = "src/main/resources/geckodriver.exe"; }
        else { geckoDriverPath = "src/main/resources/geckodriver"; }

        // Set the geckodriver property
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        // Start the driver
        WebDriver driver = new FirefoxDriver(options);

        //Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));

//        driver.get("https://novelbin.novel-online.org/novel/versatile-mage/chapter-1");
//
//        String source = driver.getPageSource();
//        Document page = Jsoup.parse(source);
//
//        Element element = page.getElementById("next_chap");
//
//        System.out.println(page.getElementById("next_chap").attr("href"));
//
//        Files.write(Paths.get("test.txt"), new String(page.toString()).getBytes());


        //Document doc = Jsoup.parse(source);
        //Elements paragraphs = doc.getElementsByTag("p");

        /*try {
            for (Element p : paragraphs) {
                Files.write(Paths.get("test.txt"), p.html().getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get("test.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //driver.close();
        //driver.navigate().to("https://novelbin.org/");

//        Webnovel wn = new Webnovel();
//
//        try {
//            Files.write(Paths.get("saveFile.json"), wn.toJson().getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Webnovel wn = new Webnovel("Versatile Mage", "Chaos",
                "https://novelbin.novel-online.org/novel/versatile-mage/chapter-1",
                "https://novelbin.novel-online.org/novel/versatile-mage/chapter-1",
                10,
                1,
                "novelbin",
                "Versatile Mage");

        WebnovelFileHandler.writeToSaveFile("saveFile.json", wn);

        Scraper.scrape(wn, driver);

        WebnovelFileHandler.writeToSaveFile("saveFile.json", wn);
        //WebnovelFileHandler.writeToSaveFile("saveFile.json", wn);

        ArrayList<Webnovel> webnovels = WebnovelFileHandler.readSaveFile("saveFile.json");
        System.out.println(webnovels.size());

        // TODO: Create an object that reads/writes to the save file (WebnovelFileHandler)
        // While reading should return a list of webnovels present in the file
        // While writing should save a new webnovel to the list of webnovels that it already has


        return;
    }

}