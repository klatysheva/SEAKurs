package objects;

public class Test {
    public static void main(String[] args) {
        Integer int1 = new Integer();
        int1.setA(5);
        System.out.println(int1.getA() );
        int1.add(5);
        System.out.println(int1.getA() );
        int1.sub(2);
        System.out.println(int1.getA() );
        int1.multi(3);
        System.out.println(int1.getA() );
        int1.div(2);
        System.out.println(int1.getA() );
    }
}
