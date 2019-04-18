package Dictionary;

import java.util.Iterator;

public interface DictionaryInterface<K, V> {

    /**
     * Adds a new entry to this dictionary. If the given search
     * key already exist in the dictionary, replaces the
     * corresponding value.
     * @param key an object search key of the new entry
     * @param value an object associated with the search key
     * @return either null if the new entry was added to the dictionary
     *         of the value that was associated with key if that value
     *         was replaced
     */
    V add(K key, V value);

    /**
     * Removes a specific entry from this dictionary
     * @param key an object search key of the entry to be removed
     * @return either the value that was associated with the search key
     *         or null if no such object exist
     */
    V remove(K key);

    /**
     * Retrieves from this dictionary the value associated with a given
     * search key
     * @param key an object search key of the entry to be retrieved
     * @return either the value that is associated with the search key
     *         or null if no such object exists
     */
    V getValue(K key);

    /**
     * Sees whether a specific entry is in this dictionary.
     * @param key an object search key of the desired entry
     * @return true if key is associated with an entry in the
     *         dictionary
     */
    boolean contains(K key);

    /**
     * Created an iterator that traverses all search keys in this dictionary.
     * @return an iterator that provides sequential access to the search
     *         keys in the dictionary
     */
    Iterator<K> getKeyIterator();

    /**
     * Creates an iterator that traverses all values in this dictionary.
     * @return an iterator that provides sequential access to the values
     *         in this dictionary
     */
    Iterator<V> getValueIterator();

    /**
     * Sees whether this dictionary is empty
     * @return true if the dictionary is empty
     */
    boolean isEmpty();

    /**
     * Gets the size of this dictionary
     * @return the number of entres (key-value pairs) currently in the dictionary
     */
    int getSize();

    /**
     * Removes all entries from this dictionary
     */
    void clear();


}
