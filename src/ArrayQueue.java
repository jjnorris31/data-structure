public class ArrayQueue<T> implements QueueInterface<T> {

    private int frontIndex;
    private int lastIndex;
    private static final int DEFAULT_INITIAL_SIZE = 25;
    private T[] queueArray;

    ArrayQueue(){
        @SuppressWarnings("unchecked") T[] auxArray = (T[]) new Object[DEFAULT_INITIAL_SIZE];
        queueArray = auxArray;
        frontIndex = lastIndex = 10;
    }

    @Override
    public void enqueue(T newEntry) {
        queueArray[lastIndex] = newEntry;
        lastIndex++;
    }

    @Override
    public T dequeue() {
        T result = null;
        if (!isEmpty()){
            result = queueArray[frontIndex];
            frontIndex++;
        }
        return result;
    }

    @Override
    public T getFrontNode() {
        return null;
    }


    public T getFrontEntry() {
        return queueArray[frontIndex];
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == lastIndex && queueArray[frontIndex] == null;
    }

    @Override
    public void clear() {
        for (int i = frontIndex; i < lastIndex; i++){
            queueArray[frontIndex] = null;
        }

    }

    public static void main(String[] args){
        ArrayQueue<Integer> linkedQueue = new ArrayQueue<>();
        linkedQueue.enqueue(20);
        linkedQueue.enqueue(20);
        linkedQueue.enqueue(20);
        linkedQueue.enqueue(20);
        linkedQueue.enqueue(120);
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.getFrontEntry());
    }


}
