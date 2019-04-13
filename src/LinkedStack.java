import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;

    public LinkedStack() {
        topNode = null;
    }

    @Override
    public void push(T newEntry) {
        topNode = new Node<>(newEntry, topNode);
    }

    @Override
    public T pop() {
        T tempData = null;
        if (!isEmpty()) {
            tempData = topNode.getData();
            topNode = topNode.getNext();
        }
        return tempData;
    }

    @Override
    public T peek() {
        T tempData = null;
        if (!isEmpty()) {
            tempData = topNode.getData();
        }
        return tempData;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    public void display() {
        Node<T> tempNode = topNode;
        while (tempNode != null) {
            System.out.print(tempNode.getData() + " --> ");
            tempNode = tempNode.getNext();
        }
        System.out.print("nothing to do here");
        System.out.println();
    }

    public void displayRecursive(){
        auxDisplay(topNode);
    }

    private void auxDisplay(Node<T> currentNode){
        System.out.println(currentNode.getData());
        if (currentNode.getNext() != null){
            auxDisplay(currentNode.getNext());
        }
    }

    public T[] toArray() {
        int size = 0;
        Node<T> tempNode = topNode;
        @SuppressWarnings("unchecked") T[] tempArray = (T[]) new Object[10];
        while (tempNode != null) {
            if (size == tempArray.length) {
                tempArray = Arrays.copyOf(tempArray, tempArray.length * 2);
            }
            tempArray[size] = tempNode.getData();
            tempNode = tempNode.getNext();
            size++;
        }
        return tempArray;
    }

    /**
     * Removes the topmost n entries from a stack
     *
     * @param n the number of entries to remove
     */
    public void remove(int n) {
        while (n != 0) {
            n--;
            pop();
        }
    }

    public void countUp(int n) {
        if (n > 1) {
            countUp(n - 1);
        }
        System.out.println(n);
    }

    public int sumOf(int n) {
        if (n == 1){
            return 1;
        }
        return sumOf(n - 1) + n;
    }

    public int productOf(int n){
        if (n == 1){
            return 1;
        }
        return productOf(n - 1) * n;
    }

    public static void main(String[] args){
        LinkedStack<Integer> newStack = new LinkedStack<>();
        for (int i = 0; i < 100; i++){
            newStack.push(i);
        }
        newStack.display();
        newStack.remove(10);
        newStack.display();
        newStack.displayRecursive();
        newStack.countUp(3);
        System.out.println(newStack.sumOf(100));
        System.out.println(newStack.productOf(4));
    }
}
