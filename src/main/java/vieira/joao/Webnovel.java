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

    public static Webnovel buildWebnovel(String json) {
        return new Gson().fromJson(json, Webnovel.class);
    }
    public String toJson() {
        return new Gson().toJson(this);
    }

}
