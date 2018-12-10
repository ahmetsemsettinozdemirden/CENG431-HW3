import autocorrection.AutoCorrect;

public class Main {

    public static void main(String[] args) {

        AutoCorrect autoCorrect = new AutoCorrect();
        autoCorrect.initialize();

        System.out.print(autoCorrect.autoCorrect("ah"));
    }
}
