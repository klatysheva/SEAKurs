package objects;

public class Integer {
    private int a;
    public void setA(int a) {
        this.a = a;
    }
    public int getA() {
        return a;
    }
    public int add (int b) {
        this.a = this.a + b;
        return this.a;
    }
    public int sub (int b) {
        this.a = this.a - b;
        return this.a;
    }
    public int multi (int b) {
        this.a = this.a * b;
        return this.a;
    }
    public int div (int b) {
        this.a = this.a / b;
        return this.a;
    }

}
