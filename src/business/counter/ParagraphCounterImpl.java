package business.counter;

public class ParagraphCounterImpl implements ParagraphCounter {

    @Override
    public int countLine(String text) {

        return text.split("\n").length;
    }

    @Override
    public int countWord(String text) {

        return text.split(" ").length;
    }

    @Override
    public int countChar(String text) {

        return text.length();
    }
}
