package de.telekom.sea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PersonsListReader {
    String inputFile;

    public PersonsListReader(String inputFile) {
        this.inputFile = inputFile;
    }

    Person[] read() throws IOException {
        Person[] persons = new Person[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            ArrayList<String> list = new ArrayList<String>();
            String line = reader.readLine();
            while (line != null) {
                if (!line.isEmpty()) {
                    list.add(line);
                    System.out.println(line);
                    line = reader.readLine();
                }
                String[] nameArray = list.toArray(new String[0]);
                persons = new Person[nameArray.length];
                for (int i = 0; i < nameArray.length; i++) {
                    persons[i] = new Person(nameArray[i]);
                }
            }
        }
        return persons;
    }

}