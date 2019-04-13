public class LinkedQueue<T> implements QueueInterface<T> {

    private Node<T> frontNode;
    private Node<T> lastNode;

    void Queue(){
        lastNode = null;
        frontNode = null;
    }

    @Override
    public void enqueue(T newEntry) {
        Node<T> newNode = new Node<>(newEntry, null);
        if (isEmpty()){
            // si está vacío entonces el frontNode pasa a ser el nuevo nodo
            frontNode = newNode;
        }  else {
            // si no es así entonces el nuevo nodo sserá el siguiente del último nodo
            lastNode.setNext(newNode);
        }
        // el nuevo nodo será el último en la fila
        lastNode = newNode;
    }

    @Override
    public T dequeue() {

        T resultData = null;

        if (!isEmpty()){
            resultData = frontNode.getData();
            frontNode = frontNode.getNext();

            // si el primer ya no contiene nada, entonces la queue está vacía, setear lastNode a null también
            if (frontNode == null){
                lastNode = null;
            }
        }

        return resultData;
    }

    @Override
    public T getFrontNode() {
        return frontNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return frontNode == null && lastNode == null;
    }

    @Override
    public void clear() {
        frontNode = null;
        lastNode = null;
    }

    public static void main(String[] args){
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(10);
        linkedQueue.enqueue(10);
        linkedQueue.enqueue(10);
        linkedQueue.enqueue(10);
        linkedQueue.enqueue(10);
        linkedQueue.dequeue();
        linkedQueue.dequeue();
    }
}
