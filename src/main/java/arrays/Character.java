package arrays;

public class Character {
    char[] values = new char [8];

    void set(int index, char c) {
        this.values[index] = c;
    }
    char get(int index) {
        return values [index];
    }
}
