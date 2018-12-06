package business.counter;

public class WordCounterImpl implements WordCounter {

    @Override
    public int countChar(String text) {

        return text.length();
    }
}
