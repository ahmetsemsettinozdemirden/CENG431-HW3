package business;

import data.FileHandler;

public class TextSaver implements Text {

    private String fileName;

    public TextSaver(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String operation(String textStr) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(textStr, fileName);
        return "Saved!";
    }

}
