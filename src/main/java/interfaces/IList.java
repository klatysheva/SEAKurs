package interfaces;

public interface IList {
    /* object: reference to Object (null is not allowed)
     * duplicates not allowed
     * works when objects count < persons.length */
    boolean add(Object object);

    //set all array elements to null
    void clear();

    //works when 0 < i <= objects count
    Person get (int i);

    /* i: index of element
    removes the element at the specified position in this list */
    boolean remove(int i);

    /* object: reference to Object (null is not allowed),
    removes the first occurrence of the specified element from this list, if it is present */
    boolean remove(Object object);

    //returns the number of elements in this list
    int size ();

    // show all elements inkl. null +references
    void showFullList ();

    // show all not-null-elements
    void showList ();

    //show how many elements are in the list
    void showSize();


}
