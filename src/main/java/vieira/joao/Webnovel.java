package vieira.joao;

import com.google.gson.Gson;

public class Webnovel {

    private String title;
    private String author;
    private String firstChapterURL;
    private String currentChapterURL;
    private int totalChapters;
    private int currentChapter;

    public Webnovel() {
        this.title = null;
        this.author = null;
        this.firstChapterURL = null;
        this.currentChapterURL = null;
        this.totalChapters = 0;
        this.currentChapter = 0;
    }

    public static Webnovel buildWebnovel(String json) {
        return new Gson().fromJson(json, Webnovel.class);
    }
    public String toJson() {
        return new Gson().toJson(this);
    }

}
