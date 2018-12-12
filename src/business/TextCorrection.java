package business;

import autocorrection.AutoCorrect;

import java.util.HashMap;
import java.util.Map;

public class TextCorrection implements Text {

    private AutoCorrect autoCorrect;

    public TextCorrection() {
        this.autoCorrect = new AutoCorrect();
        this.autoCorrect.initialize();
    }

    @Override
    public String operation(String textStr) {
        Map<String, String> result = new HashMap<>();
        String correction;
        for (String textToCorrect : textStr.split(" ")) {
            textToCorrect = textToCorrect.replaceAll("\n", "");
            correction = autoCorrect.autoCorrect(textToCorrect);
            if (!correction.equals(textToCorrect)) {
                result.put(textToCorrect, correction);
            }
        }
        return mapToString(result);
    }

    private String mapToString(Map<String, String> map) {
        StringBuilder result = new StringBuilder();
        for (String key: map.keySet()) {
            result.append(key + ": " + map.get(key) + "\n");
        }
        return result.toString();
    }
}
