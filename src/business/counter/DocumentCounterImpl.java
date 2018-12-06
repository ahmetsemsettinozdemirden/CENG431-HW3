package business.counter;

public class DocumentCounterImpl implements DocumentCounter {

    @Override
    public int countParagraph(String text) {

        return text.split("\n\n").length;
    }

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
