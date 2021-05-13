package de.telekom.sea;

import java.io.FileWriter;
import java.io.IOException;

public class PersonWriter {
    FileWriter fileWriter;

    public PersonWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    void write(Person person) throws IOException {
        fileWriter.write(String.format("%s;%s;%s;%s\n", person.getId().toString(), person.getSalutation().toString(), person.getSurname(), person.getName()));

    }


}
