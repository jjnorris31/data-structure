public class SortArray {

    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n){
        for (int i = 0; i < n - 1; i++){
            int maximumIndex = getMaximumIndex(a, i, n);
            swap(a, i, maximumIndex);
        }
    }

    public static <T extends Comparable<? super T>> void recursiveSelectionSort(T[] a, int first, int n){
        if (first < n){
            int smallestIndex = getMinimumIndex(a, first, n);
            swap(a, first, smallestIndex);
            recursiveSelectionSort(a, first + 1, n);
        }
    }

    public static <T extends Comparable<? super T>> int getMinimumIndex(T[] a, int init, int n){
        int result = init;
        for (int i = init + 1; i < n; i++){
            if (a[i].compareTo(a[result]) < 0){
                result = i;
            }
        }
        return result;
    }

    public static <T extends Comparable<? super T>> int getMaximumIndex(T[] a, int init, int n){
        int result = init;
        for (int i = init + 1; i < n; i++){
            if (a[i].compareTo(a[result]) > 0){
                result = i;
            }
        }
        return result;
    }

    public static <T> void swap(T[] a, int greaterIndex, int smallestIndex){
        T firstEntry = a[greaterIndex];
        a[greaterIndex] = a[smallestIndex];
        a[smallestIndex] = firstEntry;
    }

    /**
     * Implementación del Insertion Sort
     * @param a el arreglo a ordenar
     * @param first el primer índice
     * @param <T> tipo de dato a ordenar
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first){
        for (int i = first + 1; i < a.length; i++){
            T nextToInsert = a[i];
            insertInOrder(nextToInsert, a, i);
        }
    }

    public static <T extends Comparable<? super T>> void insertInOrder(T anEntry, T[] a, int end){
        int index = end - 1;
        while((index >= 0) && (anEntry.compareTo(a[index]) < 0)){
            a[index + 1] = a[index];
            index--;
        }
        a[index + 1] = anEntry;
    }

    public static <T extends Comparable<? super T>> void recursiveInsertionSort(T[] a, int init, int last){
        if (init < last){
            recursiveSelectionSort(a, init, last - 1);
            insertInOrder(a[last], a, init, last - 1);
        }
    }

    public static <T extends Comparable<? super T>> void insertInOrder(T anEntry, T[] a, int init, int last){
        if (anEntry.compareTo(a[last]) > 0){
            a[last + 1] = anEntry;
            insertInOrder(anEntry, a, init, last - 1);
        } else if (init < last){
            a[last + 1] = a[last];
            insertInOrder(anEntry, a, init, last - 1);
        } else {
            a[last + 1] = a[last];
            a[last] = anEntry;
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(T[] a, int init, int last){
        int n = last - init + 1;
        for (int space = n / 2; space > 0; space = space / 2){
            for (int begin = init; begin < init + space; begin++){
                incrementalInsertionSort(a, begin, last, space);
            }
        }
    }

    public static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] a, int init, int last, int space){
        for (int i = init; i <= last; i += space){
            for (int j = i + space; j <= last; j += space){
                if (a[i].compareTo(a[j]) > 0){
                    swap(a, i, j);
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] a, int n){
        int indexAux = 0;
        while (indexAux < n - 1){
            boolean alreadyOrdered = bubbleSwap(a);
            if (alreadyOrdered){
                return;
            }
            indexAux++;
            System.out.println("Pass number: " + indexAux);
        }
    }

    public static <T extends Comparable<? super T>> boolean bubbleSwap(T[] a){
        int attempts = 0;
        for (int j = 1; j < a.length; j++){
            if (a[j - 1].compareTo(a[j]) > 0){
                attempts++;
                swap(a, j - 1, j);
            }
        }
        return attempts == 0;
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last){
        T[] tempArray = (T[]) new Comparable<?>[a.length];
        mergeSort(a, tempArray, first, last);
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempArray, int first, int last){

        if (first < last){
            int mid = (first + last) / 2;
            mergeSort(a, tempArray, first, mid);
            mergeSort(a, tempArray, mid + 1, last);
            merge(a, tempArray, first, mid, last);
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int first, int mid, int last){
        int beginHalf1 = first;
        int beginHalf2 = mid + 1;
        int index = 0;

        while ((beginHalf1 <= mid) && (beginHalf2 <= last)){
            if (a[beginHalf1].compareTo(a[beginHalf2]) <= 0){
                tempArray[index] = a[beginHalf1];
                beginHalf1++;
            } else {
                tempArray[index] = a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
    }

    /**
     * implementación de quickSort donde el pivote siempre será el indice que se encuentre justo a la mitad
     * @param a
     * @param first
     * @param last
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last){
        if (first < last){
            int pivot = (first + last) / 2;
            auxQuickSort(a, pivot, first, last);
            quickSort(a, first, pivot - 1);
            quickSort(a, pivot + 1, last);
        }
    }

    public static <T extends Comparable<? super T>> void auxQuickSort(T[] a, int pivot, int first, int last){
        while (first != pivot && pivot != last){
            if (a[first].compareTo(a[pivot]) > 0 && a[last].compareTo(a[pivot]) < 0){
                swap(a, first, last);
                first++;
                last--;
            } else if (a[first].compareTo(a[pivot]) > 0 && a[last].compareTo(a[pivot]) > 0){
                last--;
            } else if (a[first].compareTo(a[pivot]) < 0 && a[last].compareTo(a[pivot]) < 0) {
                first++;
            } else if (a[first].compareTo(a[pivot]) < 0 && a[last].compareTo(a[pivot]) > 0){
                first++;
                last--;
            }

            if (a[pivot - 1].compareTo(a[pivot]) > 0){
                swap(a, pivot, pivot - 1);
            } else if (a[pivot + 1].compareTo(a[pivot]) < 0){
                swap(a, pivot, pivot + 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] myArray = {8, 3, 6, 4, 2, 5, 7, 1};
        //recursiveSelectionSort(myArray, 0,  6);
        quickSort(myArray, 0, 7);
        for (Integer integer : myArray) {
            System.out.println(integer);
        }
    }
}
