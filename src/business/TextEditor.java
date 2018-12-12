package business;

import java.util.ArrayList;
import java.util.List;

public class TextEditor implements Text {

    List<Text> textList;

    public TextEditor() {
        this.textList = new ArrayList<>();
    }

    @Override
    public String operation(String textStr) {
        StringBuilder result = new StringBuilder();
        for (Text text: textList)
            result.append(text.operation(textStr));
        return result.toString();
    }

    public boolean add(Text text) {
        return textList.add(text);
    }

    public boolean remove(Text text) {
        return textList.remove(text);
    }

    public List<Text> getTextList() {
        return textList;
    }
}
