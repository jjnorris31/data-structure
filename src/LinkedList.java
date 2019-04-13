import Lists.ListInterface;

public class LinkedList<T> implements ListInterface<T> {

    private int numberOfEntries;
    private Node<T> firstNode;

    LinkedList(){
        numberOfEntries = 0;
        firstNode = null;
    }

    @Override
    public void add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (!isEmpty()){
            newNode.setNext(firstNode);
        }
        firstNode = newNode;
        numberOfEntries++;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean result = false;
        if (newPosition > 0 && newPosition <= numberOfEntries && !isEmpty()){
            if (newPosition == 1){
                add(newEntry);
            } else {
                Node<T> auxNode = firstNode;
                Node<T> newNode = new Node<>(newEntry);
                for (int i = 1; i < numberOfEntries; i++){
                    if (i + 1 == newPosition){
                        newNode.setNext(auxNode.getNext());
                        auxNode.setNext(newNode);
                        break;
                    }
                    auxNode = auxNode.getNext();
                }
            }
            result = true;
            numberOfEntries++;
        }
        return result;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if (givenPosition > 0 && givenPosition <= numberOfEntries && !isEmpty()) {
            if (givenPosition == 1) {
                result = firstNode.getData();
                firstNode = firstNode.getNext();
            } else {
                Node<T> auxNode = firstNode;
                for (int i = 1; i < numberOfEntries; i++) {
                    if (i + 1 == givenPosition) {
                        result = auxNode.getNext().getData();
                        auxNode.setNext(auxNode.getNext().getNext());
                        break;
                    }
                    auxNode = auxNode.getNext();
                }
            }
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
        firstNode = null;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean result = false;
        if (givenPosition > 0 && givenPosition <= numberOfEntries && !isEmpty()) {
            Node<T> auxNode = firstNode;
            for (int i = 0; i < numberOfEntries; i++) {
                if (i + 1 == givenPosition) {
                    auxNode.setData(newEntry);
                    result = true;
                    break;
                }
                auxNode = auxNode.getNext();
            }
        }
        return result;
    }

    @Override
    public T getEntry(int givenPosition){
        T result = null;
        if (givenPosition > 0 && givenPosition <= numberOfEntries && !isEmpty()) {
            if (givenPosition == 1) {
                result = firstNode.getData();
                firstNode = firstNode.getNext();
            } else {
                Node<T> auxNode = firstNode;
                for (int i = 1; i < numberOfEntries; i++) {
                    if (i + 1 == givenPosition) {
                        result = auxNode.getNext().getData();
                        break;
                    }
                    auxNode = auxNode.getNext();
                }
            }
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = false;
        if (!isEmpty()){
            Node<T> auxNode = firstNode;
            for (int i = 0; i < numberOfEntries; i++) {
                if (auxNode.getData().equals(anEntry)) {
                    result = true;
                    break;
                }
                auxNode = auxNode.getNext();
            }
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
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i  = 1; i < 10; i++){
            ll.add(i);
        }
        ll.add(3, 100);
        ll.remove(1);
        ll.replace(3, 10000);
        System.out.println(ll.contains(8));

    }
}
