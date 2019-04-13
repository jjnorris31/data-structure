package BagPackage;

import java.util.Arrays;

public class ResizableBag<T> implements BagInterface<T> {

    private T[] bag;
    private static int DEFAULT_INITIAL_CAPACITY = 25;
    private int numberOfEntries;

    public ResizableBag() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    private ResizableBag(int capacity){
        numberOfEntries = 0;
        @SuppressWarnings("unchecked") T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        ensureCapacity();
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    private void ensureCapacity(){
        if (bag.length == numberOfEntries){
            bag = Arrays.copyOf(bag, 2 * bag.length);
        }
    }

    public T remove() {
        T tempEntry = null;
        if (!isEmpty()){
            numberOfEntries--;
            tempEntry = bag[numberOfEntries];
            bag[numberOfEntries] = null;
        } return tempEntry;
    }

    public boolean remove(T anEntry) {

        boolean tempFlag = false;

        if (!isEmpty()){
            for (int i = 0; i < numberOfEntries; i++){
                if (anEntry.equals(bag[i])){
                    numberOfEntries--;
                    bag[numberOfEntries] = null;
                    tempFlag = true;
                }
            }
        } return tempFlag;
    }

    public void clear() {
        while(!isEmpty()){
            clear();
        }
    }

    public int getFrequencyOf(T anEntry) {

        int counter = 0;

        if (!isEmpty()){
            for (int i  = 0; i < numberOfEntries; i++){
                if (anEntry.equals(bag[i])){
                    counter++;
                }
            }
        } return counter;
    }

    public boolean contains(T anEntry) {

        boolean tempFlag = false;

        if (!isEmpty()){
            for (int i  = 0; i < numberOfEntries; i++){
                if (anEntry.equals(bag[i])){
                    tempFlag = true;
                    break;
                }
            }
        } return tempFlag;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked") T[] result = (T[]) new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++){
            result[i] = bag[i];
        } return result;
    }
}
