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
        String result = "";
        for (Text text: textList)
            result += text.operation(textStr);
        return result;
    }

    public boolean add(Text text) {
        return textList.add(text);
    }

    public boolean remove(Text text) {
        return textList.remove(text);
    }

}
