package interfaces;

public class Test {
    public static void main(String[] args) {
      IList personsList = (IList) new PersonsList();

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
      person4.setName("Sam");
      person4.setSurname("Martin");
      Person person5 =new Person();
      person5.setName("Susi");
      person5.setSurname("White");

      Animal cat1 = new Animal("F. catus");

      personsList.showSize();
      personsList.add(person1);
      personsList.add(person2);
      personsList.add(person3);
      personsList.add(person3);
      personsList.add(cat1);
      personsList.add(person4);
      personsList.showSize();
      personsList.add(person5);
      personsList.showSize();

      personsList.showList();
      personsList.remove(person1);
      personsList.remove(person1);
      personsList.remove(cat1);
      personsList.remove(0);
      personsList.showList();

      personsList.showList();
      personsList.showFullList();
      personsList.remove(0);
      personsList.showFullList();
      personsList.clear();
      personsList.showFullList();
      personsList.clear();

    }
}
