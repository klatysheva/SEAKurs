package de.telekom.sea;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonsListReader {
    private PersonReader personReader;
    private FileReader fileReader;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private int listSize;

    public PersonsListReader(FileReader fileReader, Scanner scanner) {
        this.fileReader = fileReader;
        this.personReader = new PersonReader(fileReader, scanner);
        System.out.println(ANSI_BLUE + "Please input max count of persons in your list:" + ANSI_RESET);
        this.listSize = scanner.nextInt();

    }

    IList read() throws IOException {
        IList persons = new PersonsList(listSize);
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
//            for (int i = 0; i <arrayList.size(); i++) {
//                System.out.println(arrayList);
//            }
//            Object [] personsArray = arrayList.toArray();
//            persons= new PersonsList((Person[]) personsArray);
        }
        return persons;
    }
}