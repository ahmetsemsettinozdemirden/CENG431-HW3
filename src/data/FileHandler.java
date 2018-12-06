package data;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String directoryName = "files";
    private File storage;
    public FileHandler() {
        storage = new File(directoryName);
    }
    public void save(String text, String fileName) throws Exception {
        Path path = Paths.get(directoryName + "/" + fileName);
        Files.write(path, text.getBytes());
    }

    public List<String> getAllFiles() {
        List<String> files = new ArrayList<>();
        for (File file : storage.listFiles()) {
            files.add(file.getName());
        }
        return files;
    }
}
