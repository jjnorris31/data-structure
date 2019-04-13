package Lists;

public class ArrayList<T> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    ArrayList(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    private ArrayList(int capacity){
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
        if (newPosition < numberOfEntries){
            for (int i = numberOfEntries; i >= newPosition; i--){
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
        if (!isEmpty() && givenPosition < numberOfEntries){
            result = list[givenPosition];
            for (int i = givenPosition; i < numberOfEntries - 1; i++){
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
        for(int i = 0; i < numberOfEntries; i ++){
            if (list[i].equals(anEntry)){
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
        for (int i = 0; i < numberOfEntries; i++){
            auxArray[i] = list[i];
        }
        return auxArray;
    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(3, 50);
        arrayList.remove(3);
        Object[] array = arrayList.toArray();
        for (Object integer : array) {
            System.out.println(integer);
        }

    }
}
