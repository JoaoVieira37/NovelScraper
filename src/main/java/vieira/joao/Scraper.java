package vieira.joao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class Scraper {

    public static void scrape(Webnovel wn, WebDriver driver) {

        switch (wn.getWebsite().toLowerCase()) {
            case "novelbin" -> {
                System.out.println("Novelbin");
                Scraper.scrapeNovelbin(wn, driver);
            }
            case "mtlnovel" -> {

            }
            default -> {
                System.err.println("Website not supported");
            }
        }

        driver.quit();

    }

    public static void scrapeNovelbin(Webnovel wn, WebDriver driver) {

        while (wn.getCurrentChapter() <= wn.getTotalChapters()) {

            driver.get(wn.getCurrentChapterURL());
            String pageSource = driver.getPageSource();

            Document page = Jsoup.parse(pageSource);

            // Find the next chapter link (Can be empty)
            String nextChapterLink = page.getElementById("next_chap").attr("href");

            // Find the title of the chapter if there is one
            String title = page.getElementsByClass("chr-title").first().attr("title");

            // Find the Chapter Content
            Elements content = page.getElementsByTag("p");
            StringBuilder chapterBuilder = new StringBuilder();
            for (Element p : content) {
                chapterBuilder.append(p.data());
                chapterBuilder.append('\n');
            }
            String chapter = chapterBuilder.toString();

            // Write content to a file
            if (!Files.exists(Paths.get(wn.getDir() + "/"))) {
                try {
                    Files.createDirectories(Paths.get(wn.getDir() + "/"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                };
            }

            try {
                Files.write(
                        Paths.get(wn.getDir() + "/" + title + ".txt"),
                        chapter.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE);
            } catch (IOException e) {
                System.err.println("Exception: " + e.getMessage());
                throw new RuntimeException(e);
            }

            // Update webnovel information
            wn.setCurrentChapterURL(nextChapterLink);

            wn.incrementCurrentChapter();
        }


    }

}
