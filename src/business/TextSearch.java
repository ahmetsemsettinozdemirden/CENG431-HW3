package business;

import java.util.HashMap;
import java.util.Map;

public class TextSearch implements Text {

    private String text;

    public TextSearch(String text) {
        this.text = text;
    }

    @Override
    public String operation(String textStr) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : text.split(" ")) {
            word = word.replaceAll("\n", "");
            if (word.contains(textStr)) {
                if (result.get(word) != null) {
                    result.put(word, result.get(word) + 1);
                } else {
                    result.put(word, 1);
                }
            }
        }
        return mapToString(result);
    }

    private String mapToString(Map<String, Integer> map) {
        StringBuilder result = new StringBuilder();
        for (String key: map.keySet()) {
            result.append(key + "(" + map.get(key) + ")\n");
        }
        return result.toString();
    }

}
