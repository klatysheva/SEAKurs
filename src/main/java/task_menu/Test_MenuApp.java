package task_menu;

public class Test_MenuApp {
    public static void main(String[] args) {
        PersonsMenu menu = new PersonsMenu();
        IList list = new PersonsList();

        Person person = new Person("Ann", "Walker");
        Person person1 = new Person("Alex", "Anderson");
        Person person2 = new Person("Anthony", "Clark");
        Person person3 = new Person("John", "Robinson");
        Person person4 = new Person("Sam", "Martin");

        Person person5 = new Person();
        person5.setName("Susi");
        person5.setSurname("White");

        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        menu.setList(list);
        menu.selectOption();
    }
}
