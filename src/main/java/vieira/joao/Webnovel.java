package vieira.joao;

import com.google.gson.Gson;

public class Webnovel {

    private String title;
    private String author;
    private String firstChapterURL;
    private String currentChapterURL;
    private int totalChapters;
    private int currentChapter;
    private String website;
    private String dir;

    public Webnovel() {
        this.title = "A";
        this.author = "A";
        this.firstChapterURL = "A";
        this.currentChapterURL = "A";
        this.totalChapters = 0;
        this.currentChapter = 0;
        this.website = "A";
        this.dir = "A";
    }

    public Webnovel(String title, String author, String firstChapterURL, String currentChapterURL, int totalChapters, int currentChapter, String website, String dir) {
        this.title = title;
        this.author = author;
        this.firstChapterURL = firstChapterURL;
        this.currentChapterURL = currentChapterURL;
        this.totalChapters = totalChapters;
        this.currentChapter = currentChapter;
        this.website = website;
        this.dir = dir;
    }

    public String getWebsite() {
        return website;
    }

    public int getTotalChapters() {
        return totalChapters;
    }

    public int getCurrentChapter() {
        return currentChapter;
    }

    public void setCurrentChapter(int currentChapter) {
        this.currentChapter = currentChapter;
    }

    public void setCurrentChapterURL(String currentChapterURL) {
        this.currentChapterURL = currentChapterURL;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDir() {
        return dir;
    }

    public String getFirstChapterURL() {
        return firstChapterURL;
    }

    public String getCurrentChapterURL() {
        return currentChapterURL;
    }

    public void incrementCurrentChapter() {
        this.currentChapter++;
    }

    public static Webnovel buildWebnovel(String json) {
        return new Gson().fromJson(json, Webnovel.class);
    }
    public String toJson() {
        return new Gson().toJson(this);
    }

}
