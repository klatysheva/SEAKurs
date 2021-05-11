package de.telekom.sea;

import java.io.*;
import java.util.ArrayList;

public class PersonsListReader {
    private PersonReader personReader;
    private FileReader fileReader;

    public PersonsListReader(FileReader fileReader, String separator) {
        this.fileReader = fileReader;
        this.personReader = new PersonReader(fileReader, separator);

    }

    IList read() throws IOException {
        IList persons = new PersonsList(2);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            ArrayList<Object> arrayList = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                if (!line.isEmpty()) {
                    //arrayList.add(personReader.read(line));
                    persons.add(personReader.read(line));
                }
                line = bufferedReader.readLine();
            }
            for (int i = 0; i <arrayList.size(); i++) {
                System.out.println(arrayList);
            }
//            Object [] personsArray = arrayList.toArray();
//            persons= new PersonsList((Person[]) personsArray);
        }
        return persons;
    }
}