package Lists;

import javax.management.NotificationEmitter;

public class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T>{

    private int numberOfEntries;
    private Node<T> firstNode;

    void SortedLinkedList(){
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public void add(T newEntry) {

        Node<T> newNode = new Node<>(newEntry);
        Node<T> nodeBefore = getNodeBefore(newEntry);

        if (isEmpty() || nodeBefore == null) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            newNode.setNext(nodeBefore.getNext());
            nodeBefore.setNext(newNode);
        }
        numberOfEntries++;
    }

    private Node<T> getNodeBefore(T newEntry){
        Node<T> currentNode = firstNode;
        Node<T> nodeBefore = null;
        while (currentNode != null && newEntry.compareTo(currentNode.getData()) > 0){
            nodeBefore = currentNode;
            currentNode = nodeBefore.getNext();
        }
        return nodeBefore;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public int getPosition(T anEntry) {

        int resultOfSearch = -1;
        int auxCount = 1;
        Node<T> auxNode = firstNode;

        while (auxNode != null){
            if (auxNode.getData().equals(anEntry)){
                resultOfSearch = auxCount;
                break;
            } else {
                auxCount++;
            }
            auxNode = auxNode.getNext();
        }
        return resultOfSearch;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public T getEntry(int givenPosition) {

        T anEntry =  null;
        Node<T> auxNode = firstNode;

        if (givenPosition < numberOfEntries){
            while (givenPosition > 0){
                auxNode = auxNode.getNext();
                givenPosition--;
            }
            anEntry = auxNode.getData();
        }
        return anEntry;
    }

    @Override
    public boolean contains(T anEntry) {

        boolean result = false;
        Node<T> auxNode = firstNode;

        while (auxNode != null){
            if (auxNode.getData().equals(anEntry)) {
                result = true;
                break;
            }
            auxNode = auxNode.getNext();
        }
        return result;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    public static void main(String[] args){
        SortedLinkedList<Integer> myList = new SortedLinkedList<>();
        myList.add(1);
        myList.add(5);
        myList.add(7);
        System.out.println(myList.getPosition(8));

    }
}
