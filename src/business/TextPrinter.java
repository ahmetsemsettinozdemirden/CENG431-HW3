package business;

public class TextPrinter implements Text {

    @Override
    public String operation(String textStr) {
        System.out.println(textStr);
        return "Text printed!";
    }
}
