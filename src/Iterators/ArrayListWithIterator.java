package Iterators;
import Lists.ArrayList;
import Lists.ListInterface;

import java.util.NoSuchElementException;

public class ArrayListWithIterator<T extends Comparable<? super T>> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;
    private enum Move {NEXT, PREVIOUS}

    ArrayListWithIterator() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    private ArrayListWithIterator(int capacity) {
        //noinspection unchecked
        T[] auxList = (T[]) new Object[capacity];
        list = auxList;
        numberOfEntries = 0;
    }

    @Override
    public void add(T newEntry) {
        this.list[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    @SuppressWarnings("ManualArrayCopy")
    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean result = false;
        if (newPosition < numberOfEntries) {
            for (int i = numberOfEntries; i >= newPosition; i--) {
                list[i] = list[i - 1];
            }
            list[newPosition] = newEntry;
            numberOfEntries++;
            result = true;
        }
        return result;
    }

    @SuppressWarnings("ManualArrayCopy")
    @Override
    public T remove(int givenPosition) {
        T result = null;
        if (!isEmpty() && givenPosition < numberOfEntries) {
            result = list[givenPosition];
            for (int i = givenPosition; i < numberOfEntries - 1; i++) {
                list[i] = list[i + 1];
            }
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        return false;
    }

    @Override
    public T getEntry(int givenPosition) {
        T entry = null;
        if (givenPosition < list.length) {
            entry = list[givenPosition];
        }
        return entry;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = false;
        for (int i = 0; i < numberOfEntries; i++) {
            if (list[i].equals(anEntry)) {
                result = true;
                break;
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

    @SuppressWarnings("ManualArrayCopy")
    @Override
    public T[] toArray() {
        @SuppressWarnings({"unchecked", "Duplicates"}) T[] auxArray = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            auxArray[i] = list[i];
        }
        return auxArray;
    }

    public ListIterator<T> getIterator(){
        return new IteratorForArrayList();
    }

    private class IteratorForArrayList implements ListIterator<T>{

        private int nextIndex;
        private boolean isRemoveOrSetLegal;
        private Move lastMove;

        private IteratorForArrayList(){
            nextIndex = 0;
            isRemoveOrSetLegal = false;
            lastMove = null;
        }


        @Override
        public boolean hasNext() {
            return nextIndex < numberOfEntries;
        }

        @Override
        public T next() {
            if (hasNext()){
                lastMove = Move.NEXT;
                isRemoveOrSetLegal = true;

                T nextEntry = list[nextIndex];
                nextIndex++;

                return nextEntry;
            } else {
                throw new NoSuchElementException("Illegal call to next(); " +
                                                 "iterator is after end of list");
            }
        }

        @Override
        public void remove() {
            if (isRemoveOrSetLegal){
                isRemoveOrSetLegal = false;
                if (lastMove.equals(Move.NEXT)){
                    ArrayListWithIterator.this.remove(nextIndex);
                    nextIndex--;
                } else {
                    assert lastMove.equals(Move.PREVIOUS);
                    ArrayListWithIterator.this.remove(nextIndex + 1);
                }
            } else {
                throw new IllegalStateException("Illegal call to remove();" +
                                                "next() or previous() was not called, " +
                                                "add() or remove() called since then.");
            }

        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0 && nextIndex <= numberOfEntries;
        }

        @Override
        public T previous() {
            if (hasPrevious()){
                lastMove = Move.PREVIOUS;
                isRemoveOrSetLegal = true;
                nextIndex--;
                return list[nextIndex];
            } else {
                throw new NoSuchElementException("Illegal call to previous(); " +
                        "iterator is before beginning of list");
            }
        }

        @Override
        public int nextIndex() {
            if (hasNext()){
                return nextIndex;
            } else {
                return numberOfEntries;
            }
        }

        @Override
        public int previousIndex() {
            if (hasPrevious()){
                return nextIndex - 1;
            } else {
                return -1;
            }
        }

        @Override
        public void add(T newEntry) {
            isRemoveOrSetLegal = false;
            nextIndex++;
            ArrayListWithIterator.this.add(nextIndex, newEntry);
        }
    }


    public static void main(String[] args) {
        ArrayListWithIterator<Integer> arrayList = new ArrayListWithIterator<>();
        ListIterator<Integer> iteratorArrayList = arrayList.getIterator();
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(3, 50);
        while(iteratorArrayList.hasNext()){
            System.out.println(iteratorArrayList.next());
        }

    }
}

