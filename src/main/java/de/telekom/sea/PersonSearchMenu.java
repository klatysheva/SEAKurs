package de.telekom.sea;

import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class PersonSearchMenu extends BaseObject implements IMenu, IEventListener {
    private IList list;
    Scanner scanner = new Scanner(System.in);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREY = "\u001B[37m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public PersonSearchMenu(IList list) {
        this.list = list;
    }

    @Override
    public void setList(IList list) {
        this.list = list;
    }

    @Override
    public void receive(Event event) {

    }

    @Override
    public void selectOption() {
        String result = "";
        do {
            showMenu();
            result= checkMenu();
        }
        while (!result.equals("0"));
    }

    private void showMenu() {
        System.out.println(ANSI_BLUE + "Please select search option:" + ANSI_GREEN);
        System.out.println("1 - search by text (in name and surname)");
        System.out.println("2 - <option is in work>");
        System.out.println("0 - abort search;");
        System.out.println(ANSI_RESET);
    }

    public String checkMenu() {
        String option = inputLine();
        switch (option) {
            case "1":
                searchWithOptions();
                break;
            case "2":
                System.out.println("Not implemented yet. Sorry. We are working on it :) ");
                break;
            case "0":
                System.out.println("0. Exit.");
                break;
            default:
                System.out.println("Please chose an valid number. To exit input 0.");
        }
        return option;
    }

    private void searchWithOptions() {
        boolean isSearchFinished = false;
        IList sublist = list;
        String searchOption = "contains";
        boolean isCaseSensitive = true;

        while (!isSearchFinished) {
            showSearchSettings(searchOption, isCaseSensitive);
            System.out.println("Do you want change it? If yes input 'Y', if no - input any other character.");
            String changeOptions = inputLine();
            if (changeOptions.toUpperCase(Locale.ROOT).equals("Y")) {
                //change search option:
                SearchOptionsMenu searchOptionsMenu = new SearchOptionsMenu(searchOption);
                searchOptionsMenu.selectOption();
                searchOption = searchOptionsMenu.getSearchOption();
                //deactivate isCaseSensitive mode:
                isCaseSensitive = changeCaseSensitiveMode();

                showSearchSettings(searchOption, isCaseSensitive);
            }
            System.out.println();
            System.out.println("Enter the string you want to search for: ");
            String text = inputLine();
            sublist = sublist.searchByText(text, searchOption, isCaseSensitive);
            if (sublist.size() > 0) {
                isSearchFinished = isSearchFinished();
            } else {
                System.out.println("Do you want to try a new search? If yes please input 'Y'. To leave search menu input any other character.");
                String input = inputLine();
                if (input.toUpperCase(Locale.ROOT).equals("Y")) {
                    sublist = list;
                }
                else {
                    isSearchFinished = true;
                }
            }
        }
    }

    private void showSearchSettings(String searchOption, boolean isCaseSensitive) {
        System.out.println(ANSI_YELLOW + "Current settings: " + ANSI_RESET + searchOption + " option, isCaseSensitive = " + isCaseSensitive + ".");
    }

    private boolean changeCaseSensitiveMode() {
        boolean isCaseSensitive;
        System.out.println(ANSI_BLUE + "To deactivate case sensitive mode please input '1'.");
        System.out.println("Otherwise input any character (case sensitive option will be used by default)." + ANSI_RESET);
        if (inputLine().equals("1")) {
            isCaseSensitive = false;
            System.out.println("Case insensitive mode activated.");
        } else {
            isCaseSensitive = true;
        }
        return isCaseSensitive;
    }

    private boolean isSearchFinished() {
        System.out.println("Do you want to search further in this list? If yes input 'Y', to return to main menu input any other character or press enter.");
        String searchFurther = inputLine();
        if (searchFurther.equals("Y")) {
            return false;
        }
        return true;
    }

    public String inputLine() {
        String result = "";
        result = scanner.nextLine();
        return result;
    }

}
