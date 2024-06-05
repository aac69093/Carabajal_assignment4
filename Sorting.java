import java.util.Random;

public class Sorting {

    private int[] values;
    private long count; // # of comparisons

    public Sorting(int[] array) { // constructor
        count = 0; // variable for # of comparisons
        int track = 0;
        for (int j = 0; j < array.length; j++) {
            track++; // gets the array length
        } // for
        this.values = new int[track];
        for (int i = 0; i < values.length; i++) {
            values[i] = array[i]; // putting valued from driver array into values
        } // for
    } // Sorting

    public int getLength() {
        return values.length;
    } // getLength

    public void print() {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " "); // printing out array values
        } // for
        System.out.println("");
    } // toString

    public long selectionSort() {
        int endIndex = values.length - 1;
        for (int current = 0; current < endIndex; current++) { // moving through values
            int min = current;
            for (int j = current + 1; j < endIndex; j++) { // moving through to find the minimum
                count++; // increasing comparisons
                if (values[j] < values[min]) { // setting the minimum
                    min = j;
                } // if
                if (min != current) { // swaping the minimum value and current value
                    swap(current, min);
                } // if
            } // for
        } // for
        return count;
    } // SelectionSort

    public long mergeSort(int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2; // finding the middle
            mergeSort(first, middle); //  recursive call to right side
            mergeSort(middle + 1, last); // recursive call to left side
            merge(first, middle, middle + 1, last); // merging right and left sides together
        } // if
        return count;
    } // mergeSort

    public void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
        int[] temp = new int[values.length]; // make a temporary array
        int index = leftFirst;
        int saveFirst = leftFirst;
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
            // moving through both left and right sides
            count++;
            if (values[leftFirst] < values[rightFirst]) { // left side is less than right side
                temp[index] = values[leftFirst];
                leftFirst++;
            } else { // right side is less than left side
                temp[index] = values[rightFirst];
                rightFirst++;
            } // if
            index++;
        } // while
        while (leftFirst <= leftLast) { // move through left side
            temp[index] = values[leftFirst];
            leftFirst++;
            index++;
        } // while
        while (rightFirst <= rightLast) {
            temp[index] = values[rightFirst];
            rightFirst++;
            index++;
        } // while
        for (index = saveFirst; index <= rightLast; index++) {
            values[index] = temp[index];
        } // for
    } // merge

    public long heapSort() {
        int length = values.length;
        int index = 0;
        for (index = length / 2 - 1; index >= 0; index--) { // reaheap down right side
            reheapDown(index, length - 1);
        } // for
        for (index = length - 1; index > 0; index--) { // reheap down left side
            swap(0, index);
            reheapDown(0, index - 1);
        } // for
        return count;
    } // heapSort

    public void reheapDown(int root, int bottom) {
        int maxChild = root;
        int rightChild = root * 2 + 2;
        int leftChild = root * 2 + 1;
        if (leftChild <= bottom) { // left child
            count++;
            if (leftChild == bottom) { // left child is max
                count++;
                maxChild = leftChild;
            } else { // left child is min
                if (values[leftChild] <= values[rightChild]) { // left is less than right
                    count++;
                    maxChild = rightChild;
                } else { // right is less than left
                    count++;
                    maxChild = leftChild;
                } // if
            } // if
            if (values[root] < values[maxChild]) { // root is less than max
                swap(root, maxChild);
                reheapDown(maxChild, bottom);
            } // if
        } // if
    } // reheapDown

    public long quickSortFirst(int first, int last) {
        if (first < last) {
            int splitPoint = splitFirst(first, last); // find the pivot
            quickSortFirst(first, splitPoint - 1); // recursive call to before split
            quickSortFirst(splitPoint + 1, last); // recursive call to after split
        } // if
        return count;
    } // quickSort

    public int splitFirst(int first, int last) {
        int pivot = values[first]; // pivot is first index
        int i = first + 1;
        for (int j = first + 1; j <= last; j++) { // look after the pivot
            count++;
            if (values[j] < pivot) { // min is less than the pivot
                swap(i, j); // swap min and pivot
                i++;
            } // if
        } // for
        swap(i - 1, first); // swap pivot and index
        return i - 1;
    } // split

    public long quickSortRandom(int first, int last) {
        if (first < last) {
            int splitPoint = splitRandom(first, last); // find the pivot
            quickSortRandom(first, splitPoint - 1); // recursive call to before pivot
            quickSortRandom(splitPoint + 1, last); // recursive call to after pivot
        } // if
        return count;
    } // quickSortRandom

    // From Geeks for Geeks Randomized Quick Sort
    public int splitRandom(int first, int last) {
        random(first, last); // find random value
        int pivot = values[first]; // pivot is first
        int i = first + 1;
        for (int j = first + 1; j <= last; j++) { // sort through array
            count++;
            if (values[j] < pivot) { // min is less than pivot
                swap(i, j);
                i++;
            } // if
        } // for
        swap(i - 1, first);
        return i - 1;
    } // splitRandom

    // From Geeks for Geeks Randomized Quick Sort
    public void random(int first, int last) {
        Random rand = new Random(); // random object
        int pivot = rand.nextInt(last - first) + first; // get random integer
        swap(pivot, first); // swap random integer with first index in array
    } // random

    public void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    } // swap

} // Sorting
