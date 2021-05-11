package de.telekom.sea;

import java.io.*;
import java.util.ArrayList;

public class PersonsListReader {
    private PersonReader personReader;
    private FileReader fileReader;

    public PersonsListReader(FileReader fileReader, String separator) {
        this.personReader = new PersonReader(fileReader, separator);
        this.fileReader = fileReader;
    }

    Person[] read() throws IOException {
        Person[] persons = new Person[0];
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            ArrayList<Person> list = new ArrayList<Person>();
            String line = bufferedReader.readLine();
            while (line != null) {
                if (!line.isEmpty()) {
                    list.add(personReader.read(line));
                    line = bufferedReader.readLine();
                }
                persons = list.toArray(new Person[0]);
            }
        }
        return persons;
    }
}