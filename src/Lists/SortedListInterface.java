package Lists;

public interface SortedListInterface<T extends Comparable<? super T>> {

    /**
     * Adds a new entry to this sorted list in its proper order
     * @param newEntry the object to be added as a new entry
     */
    void add(T newEntry);

    /**
     * Removes a specified entry from this sorted list
     * @param anEntry the object to be removed
     * @return true if anEntry was located an removed
     */
    boolean remove(T anEntry);

    /**
     * Gets the position of an entry in this sorted list
     * @param anEntry the object to be found
     * @return the position of the first or only occurrence of anEntry
     *         if it occurs in the list; otherwise returns the position
     *         where anEntry would occur in the list, but as a negative
     *         integer
     */
    int getPosition(T anEntry);

    /**
     * Removes all entries from this list
     */
    void clear();

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
