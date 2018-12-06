package business.counter;

public class LineCounterImpl implements LineCounter {

    @Override
    public int countWord(String text) {

        return text.split(" ").length;
    }

    @Override
    public int countChar(String text) {

        return text.length();
    }
}
