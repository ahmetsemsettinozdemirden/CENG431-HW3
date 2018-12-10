package presentation;

import business.TextCorrection;
import business.TextCounter;
import business.TextEditor;

import java.util.List;
import java.util.Scanner;

public class Console {

    private enum CommandState {
        MAIN_MENU,
        TEXT_SAVED,
        TEXT_CORRECTED,
        TEXT_COUNTED,
        TEXT_SEARCHED,
    }

    private CommandState currentState;
    private Scanner scanner;
    private TextEditor textEditor;
    private String userString;

    public Console() {
        this.scanner = new Scanner(System.in);
        this.textEditor = new TextEditor();
        this.userString = "";
    }

    public void start() {
        this.currentState = CommandState.MAIN_MENU;
        while (true) {
            try {
                switch (currentState) {
                    case MAIN_MENU:
                        mainMenu();
                        break;
                    case TEXT_SAVED:
                        savedMenu();
                        break;
                    case TEXT_CORRECTED:
                        textCorrect();
                        break;
                    case TEXT_COUNTED:
                        textCount();
                        break;
                    case TEXT_SEARCHED:
                        textSearch();
                        break;
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage() + "\n");
            }
        }
    }

    private void mainMenu() {

        System.out.print("     TextEditor - MainMenu \n" +
                "1) Give a file\n" +
                "2) Write from console\n" +
                "3) Exit");

        System.out.print("Choose an option: ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                this.currentState = CommandState.TEXT_SAVED;
                // TODO: take the file and save it; set it to userString
                System.out.print("File is saved.");
                break;
            case 2:
                this.currentState = CommandState.TEXT_SAVED;
                // TODO: take the input and save it; set it to userString
                System.out.print("Text is saved.");
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.print("Invalid choice.\n");
        }
    }

    private void savedMenu() {

        System.out.print("     TextEditor - SavedMenu \n" +
                "1) Automate text correction\n" +
                "2) Count number of paragraph, line, word and character\n" +
                "3) Search, list and count the words containing inputted characters\n" +
                "4) Back to MainMenu");

        System.out.print("Choose operation to apply: ");

        while (true) {
            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        this.currentState = CommandState.TEXT_CORRECTED;
                        break;
                    case 2:
                        this.currentState = CommandState.TEXT_COUNTED;
                        break;
                    case 3:
                        this.currentState = CommandState.TEXT_SEARCHED;
                        break;
                    case 4:
                        this.currentState = CommandState.MAIN_MENU;
                        break;
                    default:
                        System.out.print("Invalid choice.\n");
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage() + "\n");
            }
        }
    }

    private void textCorrect() {

    }

    private void textCount() {

    }

    private void textSearch() {

    }

    private void getString() {

    }


}
