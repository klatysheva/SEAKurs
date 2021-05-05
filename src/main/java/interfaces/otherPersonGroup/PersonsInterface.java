package interfaces.otherPersonGroup;

import interfaces.Person;

public interface PersonsInterface {
    /* person: reference to Person (null is not allowed)
    * duplicated not allowed
    * works when personsCount < persons.length
    */
    boolean add(Person person); //

    int size();

    //works when 0 < i <= personsCount
    Person get(int i);

    /* person: reference to Person (null is not allowed)
     * works when person is present in persons[]
     */
    boolean remove(Person person);
}
