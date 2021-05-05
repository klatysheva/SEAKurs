package arrays.task_persons;

public class Test {
    public static void main(String[] args) {
       PersonsGroup group1 = new PersonsGroup();
       group1.showPersonsCount();

       //persons creation:
       Person person1 =new Person();
       person1.setName("Alex");
       person1.setSurname("Anderson");
       Person person2 =new Person();
       person2.setName("Anthony ");
       person2.setSurname("Clark");
       Person person3 =new Person();
       person3.setName("John");
       person3.setSurname("Robinson");
       Person person4 =new Person();
       person4.setName("Jane");
       person4.setSurname("Wilson");
       Person person5 =new Person();
       person5.setName("Sam");
       person5.setSurname("Martin");
       Person person6 =new Person();
       person5.setName("Susi");
       person5.setSurname("White");

       //adding persons into the group:
       group1.addPerson(person1);
       group1.showPersonsCount();
       group1.addPerson(null);
       group1.deletePerson(null);
       group1.addPerson(person1);
       group1.showPersonsCount();
       group1.addPerson(person2);
       group1.showPersonsCount();
       group1.addPerson(person3);
       group1.showPersonsCount();
       group1.addPerson(person4);
       group1.showPersonsCount();
       group1.addPerson(person5);
       group1.showPersonsCount();
       group1.addPerson(person6);
       group1.showPersonsCount();
       //not relevant anymore, just to check if PersonsGroup.persons is private
       //group1.persons[4] = new Person();
       //group1.persons[4].setSurname("Sam");
       group1.showFullPersonsList();


       System.out.println("############### Test for method getPerson: ##########");
       group1.getPerson(1);
       group1.getPerson(2);
       group1.getPerson(3);
       group1.getPerson(4);
       group1.getPerson(5);

//       System.out.println("getSurname by getPerson:");
//       System.out.println(group1.getPerson(1).getSurname());
//       System.out.println(group1.getPerson(2).getSurname());
//       System.out.println(group1.getPerson(3).getSurname());
//       System.out.println(group1.getPerson(4).getSurname());
//       System.out.println(group1.getPerson(5).getSurname());

//       group1.showPersonsCount();
//       System.out.println(group1.persons[0].getSurname());
//       System.out.println(group1.persons[1].getSurname());
//       System.out.println(group1.persons[2].getSurname());
//       System.out.println(group1.persons[3].getSurname());
//       System.out.println(group1.persons[4].getSurname());

       group1.deletePerson(person1);
       group1.showPersonsCount();
       group1.showFullPersonsList();

       group1.deletePerson(person2);
       group1.deletePerson(person3);
       group1.showPersonsCount();
       group1.showFullPersonsList();

       group1.addPerson(person1);
       group1.showPersonsCount();
       group1.showFullPersonsList();
       group1.showPersonsList();
       group1.clearList();
       group1.showFullPersonsList();
    }
}
