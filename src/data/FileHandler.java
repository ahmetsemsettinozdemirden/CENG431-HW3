package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String directoryName = "files";
    private File storage;
    private String fileName;
    private static FileHandler fileHandler;

    public FileHandler() {
        this.storage = new File(directoryName);
        this.fileName = "defoult";
    }
    public void save(String text) {
        Path path = Paths.get(this.directoryName + "/" + this.fileName);
        try {
            Files.write(path, text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllFiles() {
        List<String> files = new ArrayList<>();
        for (File file : storage.listFiles()) {
            files.add(file.getName());
        }
        return files;
    }

    public void setFileName(String file) {
        this.fileName = file;
    }

    public static FileHandler getDefaultFileHandler() {
        if (FileHandler.fileHandler != null) {
            return FileHandler.fileHandler;
        }
        return new FileHandler();
    }
}
