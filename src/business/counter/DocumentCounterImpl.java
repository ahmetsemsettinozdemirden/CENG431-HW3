package business.counter;

public class DocumentCounterImpl implements DocumentCounter {

    private ParagraphCounter paragraphCounter;

    @Override
    public int countParagraph(String text) {

        return text.split("\n\n").length;
    }

    @Override
    public int countLine(String text) {

        return paragraphCounter.countLine(text);
    }

    @Override
    public int countWord(String text) {

        return paragraphCounter.countWord(text);
    }

    @Override
    public int countChar(String text) {

        return paragraphCounter.countChar(text);
    }
}
