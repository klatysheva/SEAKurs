package task_Listeners;

public class Child {
    private Object parent;

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        System.out.println("New value is set for parent: " + parent);
        this.parent = parent;
    }
}