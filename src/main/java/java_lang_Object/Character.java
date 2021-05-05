package java_lang_Object;

import static java.lang.Character.getNumericValue;

public class Character {
    char content;

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public boolean equals(Character character) {
        if (character == null) // null check
        {
            return false;
        }
        if (this == character) // self check
        {
            return true;
        }
        if (getClass() != character.getClass()) {// class type check
            System.out.println("Objects of different classes");
            return false;
        }
        if (this.hashCode() != character.hashCode()) // hash code check
        {
            return false;
        }
        return content == character.content;
        // type check and cast
        //Character character = (Character) obj; // cast to
        //return Objects.equals(content, character.content);
    }

    public int hashCode () {
        return (getNumericValue(content));
        //return (content);
    }
}
