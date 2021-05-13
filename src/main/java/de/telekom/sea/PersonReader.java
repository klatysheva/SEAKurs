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
            String salutation = splitLine[1];
            Salutation salutationEnum = Salutation.fromString(salutation);
            String surname = splitLine[2];
            String name = splitLine[3];
            try {
                Long id = Long.parseLong(splitLine[0]);
                person = new Person(salutationEnum, id, surname, name);
            } catch (NumberFormatException nfe) {
                person = new Person(surname, name);
                System.out.println("NumberFormatException: wrong id format. New id was assigned for " + person.getSurname() + " " + person.getName() + ": "+ person.getId() + ".");
            }
        }
        return person;
    }

}
