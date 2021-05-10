package de.telekom.sea;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class SearchOptionsMenu extends BaseObject implements IMenu {
    private String searchOption;
    Scanner scanner = new Scanner(System.in);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREY = "\u001B[37m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public SearchOptionsMenu(String searchOption) {
        this.searchOption = searchOption;
    }

    public String getSearchOption() {
        return searchOption;
    }

    @Override
    public void selectOption() {
        showMenu();
        checkMenu();

    }

    private String checkMenu() {
        String inputResult = inputLine();
        switch (inputResult) {
            case "1":
                if (searchOption.equals("contains")) {
                    System.out.println("Search option hasn't been changed.");
                } else {
                    searchOption = "contains";
                    System.out.println("Search option changed to " + searchOption + ".");
                }
                break;
            case "2":
                if (searchOption.equals("startWith")) {
                    System.out.println("Search option hasn't been changed.");
                } else {
                    searchOption = "startWith";
                    System.out.println("Search option changed to " + searchOption + ".");
                }
                break;
            case "0":
                System.out.println("0. Exit.");
                break;
            default:
                System.out.println("Select option hasn't been changed.");
                break;
        }
        System.out.println();
        return inputResult;
    }

    private void showMenu() {
        System.out.println(ANSI_BLUE + "Select search option: " + ANSI_GREEN);
        System.out.println("1 - contains;");
        System.out.println("2 - startWith;");
        System.out.println("If you input any other character current option will be kept.");
        System.out.println(ANSI_RESET);
    }

    public String inputLine() {
        String result = "";
        result = scanner.nextLine();
        return result;
    }

    @Override
    public void setList(IList list) {

    }
}
