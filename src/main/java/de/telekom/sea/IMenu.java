package de.telekom.sea;

import java.io.IOException;

public interface IMenu {

    void setList(IList list);
    void selectOption() throws IOException; //keepAsking

//    void showMenu();
//    String inputMenu();
//    void checkMenu(String s);
//    void inputPerson();
//    void listAllPerson();
//    public void removeAll();
}
