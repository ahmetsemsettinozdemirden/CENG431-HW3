package business;

import business.counter.DocumentCounter;

public class TextCounter implements Text {

    private DocumentCounter documentCounter;

    @Override
    public String operation(String textStr) {

        int charCount = documentCounter.countChar(textStr);
        int wordCount = documentCounter.countWord(textStr);
        int lineCount = documentCounter.countLine(textStr);
        int paragraphCount = documentCounter.countParagraph(textStr);

        return null;
    }

}
