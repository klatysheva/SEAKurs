package archive.task_menu;

public interface IList {
    /* object: reference to Object (null is not allowed)
     * duplicates not allowed
     * works when archive.objects count < persons.length */
    boolean add(Object object);

    //set all array elements to null
    void clear();

    //works when 0 < i <= archive.objects count
    Person get (int i);

    /* i: index of element
    removes the element at the specified position in this list */
    boolean remove(int i);

    /* i: index of element
    removes the element by two specified String arguments*/
    boolean remove(String firstArg, String secondArg);

    /* object: reference to Object (null is not allowed),
    removes the first occurrence of the specified element from this list, if it is present */
    boolean remove(Object object);

    //returns the number of elements in this list
    int size ();

}
