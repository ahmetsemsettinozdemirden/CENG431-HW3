package presentation;

import business.TextCorrection;
import business.TextCounter;
import business.TextEditor;
import business.TextSaver;
import business.TextSearch;

import java.util.Scanner;

public class Console {

    private enum CommandState {
        MAIN_MENU,
        TEXT_SELECTED,
        TEXT_CORRECTED,
        TEXT_COUNTED,
        TEXT_SEARCHED,
        TEST_SAVE,
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
                    case TEXT_SELECTED:
                        savedMenu();
                        break;
                    case TEXT_CORRECTED:
                        textCorrect();
                        break;
                    case TEXT_COUNTED:
                        textCount();
                        break;
                    case TEXT_SEARCHED:
                        textSearchAndList();
                        break;
                    case TEST_SAVE:
                        saveFile();
                        break;
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage() + "\n");
            }
        }
    }

    private void mainMenu() {

        System.out.println("     TextEditor - MainMenu \n" +
                "1) Give a file\n" +
                "2) Write from console\n" +
                "3) Exit");

        System.out.println("Choose an option: ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                this.currentState = CommandState.TEXT_SELECTED;
                // TODO: take the file and save it; set it to userString
                System.out.println("File is saved.");
                break;
            case 2:
                this.currentState = CommandState.TEXT_SELECTED;
                textFromConsole();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.\n");
        }
    }

    private void savedMenu() {

        System.out.println("     TextEditor - Text selected menu \n" +
                "1) Automate text correction\n" +
                "2) Count number of paragraph, line, word and character\n" +
                "3) Search, list and count the words containing inputted characters\n" +
                "4) Save changes\n" +
                "5) Back to MainMenu\n" +
                "Choose operation to apply: ");

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
                    this.currentState = CommandState.TEST_SAVE;
                    break;
                case 5:
                    this.currentState = CommandState.MAIN_MENU;
                    break;
                default:
                    this.currentState = CommandState.MAIN_MENU;
                    System.out.println("Invalid choice.\n");
            }
        } catch (Exception e) {
            System.out.print("Please Enter A Number: ");
        }

    }

    private void textCorrect() {
        TextCorrection textCorrection = new TextCorrection();
        if (textEditor.getTextList().contains(textCorrection)) {
            System.out.println("Already corrected!");
        } else {
            textEditor.add(textCorrection);
            this.userString = textCorrection.operation(getString());
            System.out.println(userString + "\n\nCorrection is performed!");
        }
    }

    private void textCount() {
        TextCounter textCounter = new TextCounter();
        if (textEditor.getTextList().contains(textCounter)) {
            System.out.println("Already counted!");
        } else {
            textEditor.add(textCounter);
            String result = textCounter.operation(getString());
            System.out.println(result + "\n\nCounting is performed!");
        }
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void textSearchAndList() {
        TextSearch textSearch = new TextSearch(userString);
        if (!textEditor.getTextList().contains(textEditor)) {
            textEditor.add(textSearch);
        }

        System.out.println("Searched characters:");
        String result = textSearch.operation(scanner.nextLine()); // textSearch must have 2 inputs? one is searched word; second is where to search?
        System.out.println(result + "Searching is performed!");
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void saveFile() {
        System.out.println("Please enter file name: ");
        TextSaver textSaver = new TextSaver(scanner.nextLine());
        textSaver.operation(getString());
        System.out.println("\nSuccessfully saved!");
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void textFromConsole() {
        System.out.print("Please enter text to edit: ");
        this.userString = scanner.nextLine();
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private String getString() { // can string be an empty string?
        return userString;
    }
}
