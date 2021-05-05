package task_Listeners;

public class BaseObject {

    private Object parent;
    private long id;
    private static long idCounter = 0;

    public BaseObject() {
        this.id = ++idCounter;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) // null check
        {
            //System.out.println("obj == null");
            return false;
        }
        if (this == obj) // self check
        {
            //System.out.println("this == obj");
            return true;
        }
        if (!(obj instanceof BaseObject)) {// type check
            //System.out.println("Objects of different classes");
            return false;
        }

        // type check and cast
        BaseObject baseObject = (BaseObject) obj; // cast to BaseObject
        return (baseObject.id == this.id);
    }

    @Override
    public String toString() {
        return ((Long)id).toString();
    }

}
