package java_lang_Object;

public class TestCharacter {
    public static void main(String[] args) {
        Character character1 = new Character();
        Character character2 = new Character();
        Character character3 = new Character();
        Character character4 = character1;
        Character character5 = new Character();
        character1.setContent('f');
        character2.setContent('e');
        character3.setContent('f');
        character5.setContent('a');
        System.out.println(character1.hashCode());
        System.out.println(character2.hashCode());
        System.out.println(character3.hashCode());
        System.out.println(character4.hashCode());
        System.out.println(character5.hashCode());
        System.out.println("1 and 2 (false): " + character1.equals(character2));
        System.out.println("1 and 3 (true): " + character1.equals(character3));
        System.out.println("1 and 4 (true): " + character1.equals(character4));
        System.out.println("1 and 5 (false): " + character1.equals(character5));
        System.out.println(character2.equals(character1));
        System.out.println(character2.equals(character3));
        System.out.println(character2.equals(character4));
        System.out.println(character2.equals(character5));
        System.out.println(character3.equals(character1));
        System.out.println(character3.equals(character2));
        System.out.println(character3.equals(character4));
        System.out.println(character3.equals(character5));
        System.out.println(character4.equals(character1));
        System.out.println(character4.equals(character2));
        System.out.println(character4.equals(character3));
        System.out.println(character4.equals(character5));

    }



}
