public class CircularLinkedChain<T> implements QueueInterface<T>{

    private Node<T> lastNode;

    CircularLinkedChain(){
        lastNode = null;
    }

    @Override
    public void enqueue(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (isEmpty()){
            newNode.setNext(newNode);
        } else {
            newNode.setNext(lastNode.getNext());
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        T entryToReturn = null;
        if (!isEmpty()){
            Node<T> frontEntry = lastNode.getNext();
            entryToReturn = frontEntry.getData();
            if (lastNode == lastNode.getNext()){
                lastNode = null;
            } else {
                lastNode.setNext(frontEntry.getNext());
            }
        }
        return entryToReturn;
    }

    @Override
    public T getFrontNode() {
        T entryToReturn = null;
        if (!isEmpty()){
            Node<T> frontEntry = lastNode.getNext();
            entryToReturn = frontEntry.getData();
        }
        return entryToReturn;
    }

    @Override
    public boolean isEmpty() {
        return lastNode == null;
    }

    @Override
    public void clear() {
        lastNode = null;
    }

    public static void main(String[] args){
        CircularLinkedChain<Integer> circularQueueNode = new CircularLinkedChain<>();
    }
}
