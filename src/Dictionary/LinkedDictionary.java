package Dictionary;
import java.util.Iterator;

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V> {

    int numberOfEntries;
    Node<K, V> firstNode;

    LinkedDictionary(){
        firstNode = null;
        numberOfEntries = 0;
    }

    @SuppressWarnings("TypeParameterHidesVisibleType")
    private class Node<K, V>{

        Node<K, V> next;
        K key;
        V value;

        Node(K key, V value){
            this(key, value, null);
        }

        private Node(K key, V value, Node<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public K getKey(){
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node<K, V> getNext(){
            return next;
        }
    }

    @Override
    public V add(K key, V value) {

        Node<K, V> newNode = new Node<>(key, value);

        if (isEmpty()){
            firstNode = newNode;
        } else {
            newNode.setNext(firstNode);
            firstNode = newNode;
        }
        numberOfEntries++;

        return value;
    }

    @Override
    public V remove(K key) {

        V valueToReturn = null;

        Node<K, V> currentNode;
        Node<K, V> nextNode;

        if (firstNode.getKey().equals(key)){
            valueToReturn = firstNode.getValue();
            firstNode = firstNode.getNext();
        } else {
            currentNode = firstNode;
            nextNode = firstNode.next;
            for (int i = 0; i < numberOfEntries; i++){
                if (nextNode.getKey().equals(key)) {
                    valueToReturn = nextNode.getValue();
                    currentNode.setNext(nextNode.getNext());
                    break;
                }
                currentNode = nextNode;
                nextNode = nextNode.getNext();
            }
        }
        return valueToReturn;
    }


    @Override
    public V getValue(K key) {

        V valueToReturn = null;
        Node<K, V> currentNode = firstNode;

        while (currentNode != null){
            if (currentNode.getKey().equals(key)){
                valueToReturn = currentNode.getValue();
                break;
            }
            currentNode = currentNode.getNext();
        }
        return valueToReturn;
    }

    @Override
    public boolean contains(K key) {

        boolean result = false;
        Node<K, V> currentNode = firstNode;

        while (currentNode != null){
            if (currentNode.getKey().equals(key)){
                result = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        return result;
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
        firstNode = null;
        numberOfEntries = 0;
    }

    public static void main(String[] args){
        LinkedDictionary<Integer, String> ld = new LinkedDictionary<>();
        ld.add(1, "hola");
        ld.add(2, "alv");
        ld.remove(2);
        System.out.println(ld.contains(2));
    }
}
