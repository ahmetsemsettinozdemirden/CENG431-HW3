package presentation;

import business.TextCorrection;
import business.TextCounter;
import business.TextEditor;
import business.TextPrinter;
import business.TextSaver;
import business.TextSearch;
import data.FileHandler;
import business.Text;

import java.util.Scanner;

public class Console {

    private enum CommandState {
        MAIN_MENU,
        TEXT_SELECTED,
        TEXT_CORRECTED,
        TEXT_COUNTED,
        TEXT_SEARCHED,
        TEXT_SAVE,
        TEXT_PRINT,
    }

    private CommandState currentState;
    private Scanner scanner;
    private TextEditor textEditor;
    private String userString;
    private FileHandler fileHandler;

    public Console() {
        this.scanner = new Scanner(System.in);
        this.userString = "";
        this.fileHandler = new FileHandler();
    }

    public void start() {
        this.currentState = CommandState.MAIN_MENU;
        while (true) {
            try {
                switch (currentState) {
                    case MAIN_MENU:
                        this.textEditor = new TextEditor();
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
                    case TEXT_SAVE:
                        saveFile();
                        break;
                    case TEXT_PRINT:
                        printText();
                        break;
                }
            } catch (Exception e) {
                this.currentState = CommandState.MAIN_MENU;
                System.out.println("[ERROR] " + e.getMessage() + "\n");
            }
        }
    }

    private void mainMenu() {
        this.textEditor.getTextList().clear();

        System.out.println("     TextEditor - MainMenu \n" +
                "1) Give a file\n" +
                "2) Write from console\n" +
                "3) Exit");
        System.out.println("Choose an option: ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                this.currentState = CommandState.TEXT_SELECTED;
                textFromFile();
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
                "1) Print current text\n" +
                "2) Automate text correction\n" +
                "3) Count number of paragraph, line, word and character\n" +
                "4) Search, list and count the words containing inputted characters\n" +
                "5) Save changes\n" +
                "6) Back to MainMenu\n" +
                "Choose an operation to apply: ");

        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    this.currentState = CommandState.TEXT_PRINT;
                    break;
                case 2:
                    this.currentState = CommandState.TEXT_CORRECTED;
                    break;
                case 3:
                    this.currentState = CommandState.TEXT_COUNTED;
                    break;
                case 4:
                    this.currentState = CommandState.TEXT_SEARCHED;
                    break;
                case 5:
                    this.currentState = CommandState.TEXT_SAVE;
                    break;
                case 6:
                    this.currentState = CommandState.MAIN_MENU;
                    break;
                default:
                    this.currentState = CommandState.MAIN_MENU;
                    System.out.println("Invalid choice.\n");
            }
        } catch (Exception e) {
            System.out.print("Please enter a number: ");
        }
    }

    private void textCorrect() {
        Text textCorrection = new TextCorrection();
//        if (textEditor.hasClass(TextCorrection.class)) {
//            System.out.println("Already corrected!");
//        } else {
            textEditor.add(textCorrection);
            System.out.println(textCorrection.operation(getString()) + "\nCorrection is performed!");
//        }
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void textCount() {
        Text textCounter = new TextCounter();
        if (!textEditor.hasClass(TextCounter.class))
            textEditor.add(textCounter);
        String result = textCounter.operation(getString());
        System.out.println(result + "\nCounting is performed!");
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void textSearchAndList() {
        Text textSearch = new TextSearch(userString);
        if (!textEditor.hasClass(TextSearch.class))
            textEditor.add(textSearch);
        System.out.println("Searched characters:");
        String result = textSearch.operation(scanner.nextLine());
        System.out.println(result + "Searching is performed!");
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void printText() {
        System.out.println("Your text: ");
        Text printText = new TextPrinter();
        System.out.println(printText.operation(this.userString));
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void saveFile() {
		System.out.println("Please enter full file name (with file extension): ");
        String fileName = scanner.nextLine();
        if (fileName.equals("")) {
            System.out.println("File name can't be empty.");
            return;
        }
        Text textSaver = new TextSaver(fileName);
        textSaver.operation(getString());
        System.out.println("\nSuccessfully saved!");
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void textFromConsole() {
        System.out.print("Please enter text to edit: ");
        this.userString = scanner.nextLine();
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private void textFromFile() {
        System.out.print("Please enter file path to get text (absolute or relative path): ");
        String filePath = scanner.nextLine();
        this.userString = fileHandler.readFromFile(filePath);
        this.currentState = CommandState.TEXT_SELECTED;
    }

    private String getString() {
        return userString;
    }
}
