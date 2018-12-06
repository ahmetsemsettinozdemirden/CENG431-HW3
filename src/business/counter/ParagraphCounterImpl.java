package business.counter;

public class ParagraphCounterImpl implements ParagraphCounter {

    private LineCounter lineCounter;

    @Override
    public int countLine(String text) {

        return text.split("\n").length;
    }

    @Override
    public int countWord(String text) {

        return lineCounter.countWord(text);
    }

    @Override
    public int countChar(String text) {

        return lineCounter.countChar(text);
    }
}
