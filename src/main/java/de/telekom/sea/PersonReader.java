package de.telekom.sea;

import java.io.FileReader;
import java.util.Scanner;

public class PersonReader {

    private String separator;
    private FileReader fileReader;
    private Person person;

    public PersonReader (FileReader fileReader, Scanner scanner)  {
        this.fileReader = fileReader;
        System.out.println(Color.ANSI_BLUE + "Please input separator:" + Color.ANSI_RESET);
        this.separator = scanner.nextLine();
    }

    public Object read(String line) throws WrongIdException{
        if (!line.isEmpty()) {
            String[] splitLine= line.split(separator);
            String surname = splitLine[1];
            String name = splitLine[2];
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
