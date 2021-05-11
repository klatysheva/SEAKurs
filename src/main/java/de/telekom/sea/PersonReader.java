package de.telekom.sea;

import java.io.FileReader;

public class PersonReader {

    private String separator = ";";
    private FileReader fileReader;
    private Person person;

    public PersonReader (FileReader fileReader, String separator)  {
        this.fileReader = fileReader;
        this.separator = separator;
    }

    public Person read(String line) {
        if (!line.isEmpty()) {
            String[] splitLine= line.split(separator);
            String surname = splitLine[1];
            String name = splitLine[2];
//            for (int i = 0; i <splitLine.length; i ++) {
//                System.out.print(splitLine[i]);
//            }
//            System.out.println();
//            System.out.println(splitLine[0]);
//            System.out.println(splitLine[1]);
//            System.out.println(splitLine[2]);
            try {
                Long id = Long.parseLong(splitLine[0]);
                person = new Person(id, surname, name);
            } catch (NumberFormatException nfe) {
                person = new Person(surname, name);
                System.out.println("NumberFormatException: wrong id format. New id was assigned for " + person.getSurname() + " " + person.getName() + ": "+ person.getId() + ".");
            }
        }
        return person;
    }

}
