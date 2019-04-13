import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T> {

    private static final int INITIAL_SIZE = 25;
    private T[] array;
    private int numberOfEntries;

    public ArrayStack(){
        numberOfEntries = -1;
        @SuppressWarnings("unchecked") T[] tempArray = (T[]) new Object[INITIAL_SIZE];
        array = tempArray;
    }

    @Override
    public void push(T newEntry) {
        checkSize();
        numberOfEntries++;
        array[numberOfEntries] = newEntry;
    }

    @Override
    public T pop() {
        T tempEntry = null;
        if (!isEmpty()){
            tempEntry = array[numberOfEntries];
            numberOfEntries--;
        }
        return tempEntry;
    }

    @Override
    public T peek() {
        T tempEntry = null;
        if (!isEmpty()){
            tempEntry = array[numberOfEntries];
        }
        return tempEntry;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == -1;
    }

    @Override
    public void clear() {
       numberOfEntries = -1;
    }

    private void checkSize(){
        if ((numberOfEntries + 1) == array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public static void main(String[] args){
        ArrayStack<Integer> newStack = new ArrayStack<>();
        newStack.push(1);
        for (int i = 0; i < 50; i++){
            newStack.push(i);
            System.out.println(newStack.peek());
        }

    }
}
