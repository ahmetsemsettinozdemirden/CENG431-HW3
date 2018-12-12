package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
				throw new RuntimeException("Error while creating " + directoryName + " folder.");
            }
        }
        Path path = Paths.get(this.directoryName + "/" + fileName);
        try {
            Files.write(path, text.getBytes());
        } catch (IOException e) {
			throw new RuntimeException(e);
		}
    }

	public String readFromFile(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append(" \n"));
		} catch (IOException e) {
			throw new RuntimeException("Error while reading file content at path: " + filePath);
		}

		return contentBuilder.toString();
	}
}
