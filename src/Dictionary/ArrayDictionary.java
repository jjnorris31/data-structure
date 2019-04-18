package Dictionary;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayDictionary<K, V> implements DictionaryInterface<K, V> {

    private int numberOfEntries;
    private Entry<K, V>[] dictionary;
    private final static int DEFAULT_CAPACITY = 25;

    ArrayDictionary(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayDictionary(int capacity){
        numberOfEntries = 0;
        @SuppressWarnings("unchecked") Entry<K, V>[] auxArray = (Entry<K, V>[]) new Entry[capacity];
        dictionary = auxArray;
    }

    @Override
    public V add(K key, V value) {

        V valueToReturn = null;
        int indexOfEntry = locateIndex(key);

        if (indexOfEntry == -1){
            ensureCapacity();
            Entry<K, V> entryToAdd = new Entry<>(key, value);
            dictionary[numberOfEntries] = entryToAdd;
            numberOfEntries++;
        } else {
            valueToReturn = dictionary[indexOfEntry].getValue();
            dictionary[indexOfEntry].setValue(value);
        }

        return valueToReturn;
    }

    private int locateIndex(K key){
        for (int i = 0; i < numberOfEntries; i++){
            if (dictionary[i].getKey().equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public V remove(K key) {

        int indexToErase = locateIndex(key);
        V valueToReturn = null;

        // Borrado secuencial, no seguir esta implementación
        /*if (indexToErase != -1 && !isEmpty()){
            valueToReturn = dictionary[indexToErase].getValue();
            if (numberOfEntries == 1){
                dictionary[0] = null;
            } else {
                for (int i = indexToErase; i < numberOfEntries; i++){
                    dictionary[i] = dictionary[i + 1];
                }
                dictionary[numberOfEntries - 1] = null;
            }
            numberOfEntries--;
        }*/

        // sustituye el último lugar con el índice a borrar y deja de hacer referencia al último nodo
        if (indexToErase != -1 && !isEmpty()){
            valueToReturn = dictionary[indexToErase].getValue();
            dictionary[indexToErase] = dictionary[numberOfEntries - 1];
            numberOfEntries--;
        }
        return valueToReturn;
    }

    @Override
    public V getValue(K key) {

        int indexToErase = locateIndex(key);
        V valueToReturn = null;

        if (indexToErase != -1 && !isEmpty()){
            valueToReturn = dictionary[indexToErase].getValue();
        }

        return valueToReturn;
    }

    @Override
    public boolean contains(K key) {
        return !(locateIndex(key) == -1);
    }

    @Override
    public Iterator<K> getKeyIterator() {
        return null;
    }

    @Override
    public Iterator<V> getValueIterator() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int getSize() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked") Entry<K, V>[] auxArray = (Entry<K, V>[]) new Entry[dictionary.length];
        dictionary = auxArray;
    }

    private void ensureCapacity(){
        if ((numberOfEntries + 1) == dictionary.length){
            dictionary = Arrays.copyOf(dictionary, dictionary.length * 2);
        }
    }

    public static void main(String[] args){
        ArrayDictionary<Integer, String> dictionary = new ArrayDictionary<>();
        dictionary.add(1, "Hola");
        dictionary.add(2, "mlp");
        dictionary.add(2, "mlpx2");
        System.out.println(dictionary.remove(1));
        System.out.println(dictionary.remove(1));
    }
}
