package business;

import data.FileHandler;

public class TextSaver implements Text {

    @Override
    public String operation(String textStr) {
        FileHandler.getDefaultFileHandler().save(textStr);
        return "Saved!";
    }

}
