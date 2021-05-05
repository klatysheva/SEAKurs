package java_lang_Object;

import interfaces.Person;

public class Animal extends Person {
    private String species;

    public Animal(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
