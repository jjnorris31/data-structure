package BagPackage;

public class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity){
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
        boolean tempFlag = false;
        if (!isFull()){
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            tempFlag = true;
        } return tempFlag;

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

    public void display(){
        displayArray(0, numberOfEntries - 1);
    }

    public void displayArray(int first, int last){
        System.out.println(bag[first]);
        if (first < last){
            displayArray(first + 1, last);
        }
    }

    public T replace(T objectToReplace){

        T objectReplaced = null;

        if (!isEmpty()){
            objectReplaced = bag[0];
            bag[0] = objectToReplace;
        }
        return objectReplaced;
    }

    public static void main(String[] args){

        ArrayBag<String> tempBag = new ArrayBag<String>(10);

        tempBag.add("Hola");
        tempBag.add("Adiós");
        tempBag.add("Hasta la vista");

        System.out.println(tempBag.remove());
        System.out.println(tempBag.remove("Hola"));

    }
}
