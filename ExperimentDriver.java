import java.util.Scanner;
import java.util.Random;

public class ExperimentDriver {

    public static void main (String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String command = "";
        int size = 0;
        System.out.print("selection-sort (s)  merge-sort (m)  heap-sort (h)  ");
        System.out.println("quick-sort-fp (q)  quick-sort-rp (r)");
        System.out.print("Enter the algorithm: ");
        command = keyboard.nextLine();
        System.out.println("Size options: 100 500 1000 5000 10000 20000 25000 30000");
        System.out.print("Enter the size: ");
        size = keyboard.nextInt();

        int[] array = new int[size];
        Random rand = new Random();
        for (int k = 0; k < size; k++) {
            array[k] = k;
        } // for
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(size);
            int value = array[num];
            array[num] = array[i];
            array[i] = value;
        } // for

        Sorting values = new Sorting(array);
        if (command.equals("s")) {
            long result = values.selectionSort();
            System.out.print("#Selection-sort comparisons: ");
            System.out.println(result);
        } else if (command.equals("m")) {
            long result = values.mergeSort(0, values.getLength() - 1);
            System.out.print("#Merge-sort comparisons: ");
            System.out.println(result);
        } else if (command.equals("h")) {
            long result = values.heapSort();
            System.out.print("#Heap-sort comparisons: ");
            System.out.println(result);
        } else if (command.equals("q")) {
            long result = values.quickSortFirst(0, values.getLength() - 1);
            System.out.print("#Quick-sort-fp comparisons: ");
            System.out.println(result);
        } else if (command.equals("r")) {
            long result = values.quickSortRandom(0, values.getLength() - 1);
            System.out.print("#Quick-sort-rp comparisons: ");
            System.out.println(result);
        } else {
            System.out.println("Invalid input");
        } // if
    } // main
} // ExperimentDriver
