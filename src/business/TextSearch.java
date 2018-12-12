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
            if (word.contains(textStr)) {
                result.merge(word, 1, (a, b) -> a + b);
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
