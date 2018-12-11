package business;

import business.counter.DocumentCounter;
import business.counter.DocumentCounterImpl;

public class TextCounter implements Text {

    private DocumentCounter documentCounter;

    public TextCounter() { this.documentCounter = new DocumentCounterImpl(); }

    @Override
    public String operation(String textStr) {

        int charCount = documentCounter.countChar(textStr);
        int wordCount = documentCounter.countWord(textStr);
        int lineCount = documentCounter.countLine(textStr);
        int paragraphCount = documentCounter.countParagraph(textStr);

        String result = "Counted char: " + charCount + "\n" +
                "Counted word: " + wordCount + "\n" +
                "Counted line: " + lineCount + "\n" +
                "Counted paragraph: " + paragraphCount + "\n";

        return result;
    }

}
