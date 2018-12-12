package business;

import autocorrection.AutoCorrect;

public class TextCorrection implements Text {

    private AutoCorrect autoCorrect;

    public TextCorrection() {
        this.autoCorrect = new AutoCorrect();
        this.autoCorrect.initialize();
    }

    @Override
    public String operation(String textStr) {
        return autoCorrect.autoCorrect(textStr);
    }

}
