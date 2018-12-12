package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileHandler {

    private final String directoryName = "files";
    private File storage;

    public FileHandler() {
        this.storage = new File(directoryName);
    }
    public void save(String text, String fileName) {

        // check if files folder exists
        if (!new File(directoryName).exists()) {
            // if not create files folder
            if (new File(directoryName).mkdirs()) {
                // TODO: throw io error
            }
        }
        Path path = Paths.get(this.directoryName + "/" + fileName);
        try {
            Files.write(path, text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllFiles() {
        List<String> files = new ArrayList<>();
        for (File file : Objects.requireNonNull(storage.listFiles())) {
            files.add(file.getName());
        }
        return files;
    }
}
