package exceptions;

public class List {
    Object[] items = new Object[3];
    int count;

    public Object getItem(int index) {
        if (index >= 0 && index < count) {
            return items[index];
        } else {
            throw new RuntimeException("");
        }
    }

    public int getMaxIndex() {
        return (items.length-1);
    }

    public int size() {
        return count;
    }

}
