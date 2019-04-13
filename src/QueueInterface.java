public interface QueueInterface<T> {

    /** Adds a new entry to the back of the queue
     * @param newEntry an object to be added
     */
    void enqueue(T newEntry);

    /**
     * Removes and returns the entry at the front of this queue.
     * @return either the object at the front of the queue or, if the queue is empty, null
     */
    T dequeue();

    /**
     * Retrieves the entry at the front of this queue.
     * @return either the object at the front of the queue or, if the queue is empty, null
     */
    T getFrontNode();

    /**
     * Detects whether this queue is empty
     * @return true if the queue is empty, or false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all entries of this queue
     */
    void clear();
}
