package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FileHandler {

    private final String directoryName = "files";
    private File storage;

    public FileHandler() {
        this.storage = new File(directoryName);
    }
    public void save(String text, String fileName) {

        // check if files folder exists
        if (!this.storage.exists()) {
            // if not create files folder
            if (this.storage.mkdirs()) {
                // TODO: throw io exception
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

	public String readFromFile(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
			// todo throw io exception file does not exists
		}

		return contentBuilder.toString();
	}
}
