package com.nulp.course_work.itemwithDB;

public interface ItemDB<T> {

    /**
     * Method searches for an object with the specified id in the source
     * @param id The id of object
     * @return The object with the specified id
     */
    T getById(int id);

    /**
     * Method that deletes the specified object in the source
     * @param t The object to delete
     * @return The number of successful removal operations
     */

    int delete(T t);

    /**
     * Method that inserts the specified object to the source
     * @param t The object to insert
     * @return The number of successful inserting operations
     */
    int insert(T t);

    void insertWithEntering();

    void deleteFromFiltered();
}
