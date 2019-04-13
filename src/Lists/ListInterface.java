package Lists;

public interface ListInterface<T> {

    /**
     * Adds a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's is increased by 1.
     * @param newEntry the object to be added as a new entry
     */
    void add(T newEntry);

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position
     * are at the next higher position within the list.
     * The list's size is increased by 1
     * @param newPosition an integer that specifies the desired position of the new entry
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if newPosition < 1 or newPosition > getLength() + 1
     */
    boolean add(int newPosition, T newEntry);

    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given
     * position are at the next lowe position within the list,
     * and the list's size is decreased by 1.
     * @param givenPosition an integer that indicates the position of the entry to be removed
     * @return a reference to the removed entry or null, if either
     *         the list was empty, givenPosition < 1, or
     *         givenPosition > getLength()
     */
    T remove(int givenPosition);

    /**
     * Removes all entries from this list
     */
    void clear();

    /**
     * Replaces the entry at a given position in this list.
     * @param givenPosition an integer that indicates the position of the desired entry
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if newPosition < 1 or newPosition > getLength() +
     */
    boolean replace(int givenPosition, T newEntry);

    /**
     * Retrieves the entry at a given position in this list.
     * @param givenPosition an integer that indicates the position of the desired entry
     * @return a reference to the indicated entry or null, if newPosition < 1 or newPosition > getLength() + 1
     */
    T getEntry(int givenPosition);

    /**
     * Sees whether this list contains a given entry.
     * @param anEntry the object that is the desired entry
     * @return true if the list contains anEntry, or false if not
     */
    boolean contains(T anEntry);

    /**
     * Gets the length of this list
     * @return the integer number of entries currently in the list
     */
    int getLength();

    /**
     * Sees whether this list isEmpty.
     * @return true if the list is empty, or false if not
     */
    boolean isEmpty();

    /**
     * Retrieves all entries that are in this list in the order in which they occur in the lit
     * @return an array with all the entries in the list
     */
    T[] toArray();
}
