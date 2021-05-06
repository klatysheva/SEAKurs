package de.telekom.sea.classwork.exceptions;

public class UseObject  {
    //two options:
    //1: throws exception
    public void test() {
    //2:
        try {
            SomeObject so = new SomeObject();
            so.get(1);
        } catch (SomeException se) {
            System.out.println("Fix it!");
        }
    }
}
