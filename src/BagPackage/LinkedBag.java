package BagPackage;

/**
 * A class of bags whose entries are stored in a chain of linked nodes.
 * The bag is never full.
 * @author jjnorris31
 * @param <T>
 */
public class LinkedBag<T> implements BagInterface<T> {

    private Node<T> firstNode; // first node
    private int numberOfEntries;

    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    } // final del constructor por default

    public LinkedBag(T[] arrayOfEntries){
        if (arrayOfEntries[0] != null){
            for (T arrayOfEntry : arrayOfEntries) {
                this.add(arrayOfEntry);
            }
        }
    }

    @Override
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public T remove() {
        T tempItem = null;
        if (!isEmpty()){
            tempItem = firstNode.getData();
            firstNode = firstNode.getNext();
            numberOfEntries--;
        }
        return tempItem;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node<T> referenceTo = getReferenceTo(anEntry);
        if (referenceTo != null){
            referenceTo.setData(firstNode.getData());
            remove();
            result = true;
        }
        return result;
    } // end remove

    private Node getReferenceTo(T anEntry){
        Node<T> resultNode = null;
        Node<T> currentNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++){
            if (currentNode.getData().equals(anEntry)){
                resultNode = currentNode;
            } else {
                currentNode.setNext(currentNode.getNext());
            }
        }
        return resultNode;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frecuency = 0;
        Node currentNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++){
            if (currentNode.getData().equals(anEntry)){
                frecuency++;
            }
            currentNode = currentNode.getNext();
        }
        return frecuency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = false;
        Node<T> currentNode = firstNode;
        for (int i = 0; i < numberOfEntries; i++){
            if (currentNode.getData().equals(anEntry)){
                result = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return result;
    }

    @Override
    public T[] toArray() {
        Node<T> tempNode = firstNode;
        @SuppressWarnings("unchecked") T[] tempArray = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++){
            tempArray[i] = tempNode.getData();
            tempNode = tempNode.getNext();
        }
        return tempArray;
    }

    /*public static void main(String[] args){
        String[] myStrings = {"Chuty", "ACZINO", "KODIGO", "Papo"};
        LinkedBag<String> lb = new LinkedBag<>(myStrings);
        Object[] lbArray = lb.toArray();
        System.out.println(lb.numberOfEntries);
        for (int i = 0; i < lbArray.length; i++){
            System.out.println(lbArray[i].toString());
        }
    }*/
}
