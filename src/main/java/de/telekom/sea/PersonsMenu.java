package de.telekom.sea;

import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersonsMenu extends BaseObject implements IMenu, IEventListener, Closeable {
    private IList list;
    Scanner scanner = new Scanner(System.in);

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
    }

    public void showMenu() {
        System.out.println(Color.ANSI_BLUE + "Select option:" + Color.ANSI_GREEN);
        if (list.isFull()) {
            System.out.println(Color.ANSI_GREY + "1 - (NOT ACTIVE) input person" + Color.ANSI_GREEN);
        } else {
            System.out.println("1 - input person");
        }
        System.out.println("2 - show occupied places");
        System.out.println("3 - show free places");
        if (list.isEmpty()) {
            System.out.println(Color.ANSI_GREY + "4 - (NOT ACTIVE) remove person by its index or name&surname");
            System.out.println("5 - (NOT ACTIVE) remove all" + Color.ANSI_GREEN);
        } else {
            System.out.println("4 - remove person by its index or name&surname");
            System.out.println("5 - remove all");
            System.out.println("6 - search");
        }
        System.out.println("7 - list all persons");
        System.out.println("8 - save list of all persons to a file .sea");
        System.out.println("9 - import list");
        System.out.println("0 - exit");
        System.out.println(Color.ANSI_RESET);

    }

    public String inputLine() {
        String result = "";
        result = scanner.nextLine();
        return result;
    }

    public void selectOption() throws IOException { //keepAsking
        String result = "";
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
                PersonSearchMenu personSearchMenu = new PersonSearchMenu(list);
                personSearchMenu.selectOption();
                break;
            case "7":
                System.out.println("7. List all persons.");
                showList();
                break;
            case "8":
                System.out.println("8. Save list of all person.");
                saveList();
                break;
            case "9":
                System.out.println("9. Import list.");
                try {
                    readList();
                } catch (IOException e) {
                    System.out.println(Color.ANSI_RED + "Error: file not found." + Color.ANSI_RESET);
                }
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
        //should be deleted when listeners are fixed:
        //System.out.println(person.getSurname() + " " + person.getName() + " added to the list under #" + list.size() + ".");
        //showList();

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

    public void saveList() {
        System.out.println("Please input file name (example: mylist.csv):");
        String outputFileName = "src/test/resources/" + inputLine();

//        try (FileWriter fileWriter = new FileWriter(outputFileName)) {
//            for (int i = 0; i < list.size(); i++) {
//                fileWriter.write( (i+1) + ". " + list.get(i).getSurname() + " " + list.get(i).getName()+ "\n");
//            }
//        }
        try (FileWriter fileWriter = new FileWriter(outputFileName)) {
            PersonsListWriter personsListWriter = new PersonsListWriter(fileWriter);
            personsListWriter.write((PersonsList) list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readList() throws IOException {
        System.out.println(Color.ANSI_BLUE + "Please input file name (should be in 'src/test/resources/' folder). Example: mylist.csv"+ Color.ANSI_RESET);
        System.out.println("Please notice: expected person's format id|surname|name");
        String inputFileName = "src/test/resources/" + inputLine();
        try (FileReader fileReader = new FileReader(inputFileName)) {
            PersonsListReader personsListReader = new PersonsListReader(fileReader, scanner);
            setList(personsListReader.read());
            showList();
        }

    }
}
