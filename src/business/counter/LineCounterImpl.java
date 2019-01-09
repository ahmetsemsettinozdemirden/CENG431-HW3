package business.counter;

public class LineCounterImpl implements LineCounter {

    private WordCounter wordCounter;

    public LineCounterImpl() {
        this.wordCounter = new WordCounterImpl();
    }

    @Override
    public int countWord(String text) {
        text = text.replaceAll("\n", "");
        if (text.isEmpty())
            return 0;
        else
            return text.split(" ").length;
    }

    @Override
    public int countChar(String text) {
        return wordCounter.countChar(text);
    }
}
