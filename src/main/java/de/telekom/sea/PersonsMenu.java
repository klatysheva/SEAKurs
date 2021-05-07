package de.telekom.sea;

import java.io.Closeable;
import java.util.Locale;
import java.util.Scanner;

public class PersonsMenu extends BaseObject implements IMenu, IEventListener, Closeable {
    private IList list;
    Scanner scanner = new Scanner(System.in);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREY = "\u001B[37m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public PersonsMenu(IList list) {
        this.list = list;

    }

    public void receive(Event event) {
        System.out.println("Event: " + event.description);
        System.out.println();
        showList();
    }


    @Override
    public void setList(IList list) {
        this.list = list;
        System.out.println("setList successful. list: " + list);
    }

    public void showMenu() {
        System.out.println(ANSI_BLUE + "Select option:" + ANSI_GREEN);
        if (list.isFull()) {
            System.out.println(ANSI_GREY + "1 - (NOT ACTIVE) input person" + ANSI_GREEN);
        } else {
            System.out.println("1 - input person");
        }
        System.out.println("2 - show occupied places");
        System.out.println("3 - show free places");
        if (list.isEmpty()) {
            System.out.println(ANSI_GREY + "4 - (NOT ACTIVE) remove person by its index or name&surname");
            System.out.println("5 - (NOT ACTIVE) remove all" + ANSI_GREEN);
        } else {
            System.out.println("4 - remove person by its index or name&surname");
            System.out.println("5 - remove all");
            System.out.println("6 - search");
        }
        System.out.println("7 - list all persons");
        System.out.println("0 - exit");
        System.out.println(ANSI_RESET);

    }

    public String inputLine() {
        String result = "";
        result = scanner.nextLine();
        return result;
    }

    public int inputInt() {
        int result;
        Scanner scanner = new Scanner(System.in);
        result = scanner.nextInt();
        return result;
    }

    public void selectOption() { //keepAsking
        String result = "";
//        while (!result.equals("0")) {
//            showMenu();
//            result = checkMenu();
//        }

        do {
            showMenu();
            result = checkMenu();
        }
        while (!result.equals("0"));
    }

    private String checkMenu() {
        String result;
        result = inputLine();
        switch (result) {
            case "1":
                if (list.isFull()) {
                    System.out.println("Please chose an valid number. To exit input 0.");
                    break;
                }
                System.out.println("1. Input person.");
                inputPerson();
                break;
            case "2":
                System.out.println("2. Show size.");
                showSize();
                break;
            case "3":
                System.out.println("3. Show free places.");
                showFreePlaces();
                break;
            case "4":
                if (list.isEmpty()) {
                    System.out.println("Please chose an valid number. To exit input 0.");
                    break;
                }
                System.out.println("4. Remove person.");
                removePerson();
                break;
            case "5":
                if (list.isEmpty()) {
                    System.out.println("Please chose an valid number. To exit input 0.");
                    break;
                }
                System.out.println("5. Remove all.");
                removeAll();
                break;
            case "6":
                if (list.isEmpty()) {
                    System.out.println("Please chose an valid number. To exit input 0.");
                    break;
                }
                System.out.println("6. Search person.");
                boolean continueSearch = true;
                while (continueSearch ==true) {
                    searchPerson();
                    System.out.println("Do you want to try a new search? If yes input 'Y' or any other character to quit search.");
                    String newSearch = inputLine();
                    if (!(newSearch.toUpperCase(Locale.ROOT).equals("Y"))) {
                        continueSearch = false;
                    }
                }
                break;
            case "7":
                System.out.println("6. List all persons.");
                showList(); //listAllPerson
                break;
            case "0":
                System.out.println("0. Exit.");
                break;
            default:
                System.out.println("Please chose an valid number. To exit input 0.");
        }
        return result;
    }

    public void inputPerson() {
        if (list.isFull()) {
            System.out.println("List is full. Please chose another option.");
            return;
        }
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        System.out.println("############### Add person #########################");
        list.add(person);
        System.out.println(person.getSurname() + " " + person.getName() + " added to the list under #" + list.size() + ".");//should be deleted when listeners are fixed
        showList(); //should be deleted when listeners are fixed

    }

    @Override
    public void close() {
        scanner.close();
        System.out.println("Scanner is closed!");
    }

    public void removeAll() {
        list.clear();
    }

    public void removePerson() {
        System.out.println("To delete person by element's index input '1', by name&surname - '2' ");
        String option = inputLine();
        switch (option) {
            case "1":
                System.out.println("Input person's index: ");
                int i = Integer.parseInt(inputLine());
                list.remove(i);
                break;
            case "2":
                System.out.println("Input person's name: ");
                String name = inputLine();
                System.out.println("Input person's surname: ");
                String surname = inputLine();
                list.remove(name, surname);
                break;
            default:
                System.out.println("Invalid option. Returned to main menu.");
                break;
        }
    }

    public void searchPerson() {
        showSearchMenu();
        String option = inputLine();
        switch (option) {
            case "1":
                searchWithOptions();

                break;
            case "2":
                System.out.println("Not implemented yet. Sorry. We are working on it :) ");
                break;
            case "0":
                System.out.println("0. Return to main menu");
                break;
            default:
                System.out.println("Invalid option. Returned to main menu.");
                break;
        }
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
                searchOption = changeSearchOptionMenu(searchOption);
                isCaseSensitive = changeCaseSensitiveMode();
            }
            System.out.println("Enter the string you want to search for: ");
            String text = inputLine();
            sublist = sublist.searchByText(text, searchOption, isCaseSensitive);
            if (sublist.size() > 0) {
                isSearchFinished = isSearchFinished();
            }
            else {
                isSearchFinished = true;
            }
        }
    }

    private void showSearchSettings(String searchOption, boolean isCaseSensitive) {
        System.out.println(ANSI_YELLOW + "Current settings: " + ANSI_RESET + searchOption + " option, isCaseSensitive = " + isCaseSensitive + ".");
    }

    private void showSearchMenu() {
        System.out.println(ANSI_BLUE + "Please select search option:" + ANSI_GREEN);
        System.out.println("1 - search by text (in name and surname)");
        System.out.println("2 - <option is in work>");
        System.out.println("0 - return to main menu;");
        System.out.println(ANSI_RESET);
    }

    private String changeSearchOptionMenu(String searchOption) {
        showChangeSearchOptionMenu(searchOption);
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
            default:
                System.out.println("Search option hasn't been changed.");
                break;
        }
        return searchOption;
    }

    private boolean changeCaseSensitiveMode() {
        boolean isCaseSensitive;
        System.out.println("If you want to search with case insensitive mode input '1', otherwise press enter or input any character (case sensitive option will be used by default)");
        if (inputLine().equals("1")) {
            isCaseSensitive = false;
            System.out.println("Case insensitive mode activated.");
        } else {
            isCaseSensitive = true;
        }
        System.out.println("Case sensitive mode: " + isCaseSensitive + ".");
        return isCaseSensitive;
    }

    private boolean isSearchFinished() {
        System.out.println("Do you want to search further in this list? If yes input 'Y', to return to main menu input any other character or press enter.");
        String searchFurther = inputLine();
        if (searchFurther.equals("Y")) {
            return true;
        }
        return false;
    }

    private void showChangeSearchOptionMenu(String searchOption) {
        System.out.println(ANSI_BLUE + "Select search option: " + ANSI_GREEN);
        System.out.println("1 - contains;");
        System.out.println("2 - startWith;");
        System.out.println("If you input any other character current option will be kept. " + ANSI_YELLOW + "Current option: " + ANSI_RESET + searchOption + ".");
        System.out.println(ANSI_RESET);
    }


    public void showList() { //listAllPerson doesn't show last element
        System.out.println("############### Persons List  #######################");
        for (int i = 0; i < list.size(); i++) {
            try {
                Object obj = list.get(i);
                if (obj != null) {
                    Person person = (Person) obj;
                    System.out.println((i + 1) + ". " + person.getSurname() + " " + person.getName());
                }
            } catch (WrongIndexException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-------------------");
        showSize();
        showFreePlaces();
    }

    public void showSize() {
        System.out.println("There are " + list.size() + " element(s) in the list.");
    }

    public void showFreePlaces() {
        System.out.println("There are " + list.freePlaces() + " free place(s) in the list.");
        System.out.println();
    }
}
