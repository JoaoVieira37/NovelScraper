package vieira.joao;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WebnovelFileHandler {

    public static ArrayList<Webnovel> readSaveFile(String path) {

        Path location = Paths.get(path);

        try {

            Type webnovelArrayList = new TypeToken<ArrayList<Webnovel>>() {}.getType();
            String fileContents = new String(Files.readAllBytes(location));

            if (fileContents.isEmpty())
                return new ArrayList<Webnovel>();

            return new Gson().fromJson(fileContents, webnovelArrayList);


        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void writeToSaveFile(String path, Webnovel wn) {

        Path location = Paths.get(path);

        // TODO: Need to check if the novel to write already exists and replace it

        ArrayList<Webnovel> oldData = WebnovelFileHandler.readSaveFile(path);
        Webnovel oldNovel = oldData.stream().filter(webnovel -> webnovel.getTitle().equals(wn.getTitle())).findFirst().orElse(null);
        if (oldNovel == null) {
            oldData.add(wn);
        } else {
            oldNovel.setCurrentChapterURL(wn.getCurrentChapterURL());
            oldNovel.setCurrentChapter(wn.getCurrentChapter());
        }

        try {

            Files.write(location, (new Gson().toJson(oldData)).getBytes());

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
