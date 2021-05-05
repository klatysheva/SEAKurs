package task_Listeners;

import java.util.Scanner;

public class PersonsMenu extends BaseObject implements IMenu, IEventListener {
    private IList list;

    public PersonsMenu(IList list) {
        this.list = list;

    }

    public void receive(Event event ){
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
        System.out.println("Select option:");
        if (!list.isFull()) {
            System.out.println("1 - input person");
        }
        System.out.println("2 - show occupied places");
        System.out.println("3 - show free places");
        if (!list.isEmpty()) {
            System.out.println("4 - remove person by its index or name&surname");
            System.out.println("5 - remove all");
        }
        System.out.println("6 - list all persons");
        System.out.println("0 - exit");

    }

    public String inputLine() {
        String result = "";
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        list.add(person);

    }

    public void removeAll () {
        list.clear();
    }

    public void removePerson () {
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

    public  void showList() { //listAllPerson doesn't show last element
        System.out.println("############### Persons List  #######################");
        for (int i = 0; i < list.size();  i++){
            if (list.get(i) != null) {
                Person person = (Person) list.get(i);
                System.out.println((i+1) + ". " + person.getSurname() + " " + person.getName());
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

//    public  void showFullList() {
//        System.out.println("############### Persons List(+nulls and references) #");
//        for (int i = 0; i < list.size(); i++){
//            Person person = (Person) list.get(i);
//            System.out.print((i+1) + ". " + person);
//            if (list.get(i) != null) {
//                System.out.println(": " + person.getSurname() + " " + person.getName());
//            }
//            else {
//                System.out.println();
//            }
//        }
//        System.out.println("Persons count: " + list.size() + ".");
//        System.out.println();
//    }
}
