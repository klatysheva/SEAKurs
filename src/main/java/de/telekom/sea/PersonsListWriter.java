package de.telekom.sea;

import java.io.FileWriter;
import java.io.IOException;

public class PersonsListWriter {
    PersonWriter personWriter;
    void write(PersonsList personsList) throws IOException {
        for (int i = 0; i < personsList.size(); i++) {
            personWriter.write(personsList.get(i));
        }
    }

    PersonsListWriter( FileWriter fileWriter) throws IOException {
        this.personWriter = new PersonWriter(fileWriter);
    }
}
