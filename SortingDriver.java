import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SortingDriver {

    public static void main(String[] args) throws FileNotFoundException {

        final int MAX_ITEMS = 10000;
        int[] numbers = new int[MAX_ITEMS];

        if (args.length == 0) {
            System.out.println("Error: must pass file in");
        } else {
            File file = new File(args[0]);
            Scanner scan = new Scanner(file);
            int i = 0;
            while (scan.hasNextInt()) {
                int number = scan.nextInt();
                numbers[i] = number;
                i++;
            } // while
        } // if

        Sorting values = new Sorting(numbers);
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        System.out.print("selection-sort (s)  merge-sort (m)  heap-sort (h)  quick-sort-fp");
        System.out.println(" (q)  quick-sort-rp (r)");
        System.out.print("Enter the algorithm: ");
        command = keyboard.nextLine();
        if (command.equals("s")) {
            long result = values.selectionSort();
            values.print();
            System.out.print("#Selection-sort comparisons: ");
            System.out.println(result);
        } else if (command.equals("m")) {
            long result = values.mergeSort(0, values.getLength() - 1);
            values.print();
            System.out.print("#Merge-sort comparisons: ");
            System.out.println(result);
        } else if (command.equals("h")) {
            long result = values.heapSort();
            values.print();
            System.out.print("#Heap-sort comparisons: ");
            System.out.println(result);
        } else if (command.equals("q")) {
            long result = values.quickSortFirst(0, values.getLength() - 1);
            values.print();
            System.out.print("#Quick-sort-fp comparisons: ");
            System.out.println(result);
        } else if (command.equals("r")) {
            long result = values.quickSortRandom(0, values.getLength() - 1);
            values.print();
            System.out.print("#Quick-sort-rp comparisons: ");
            System.out.println(result);
        } else {
            System.out.println("Invalid input");
        } // if

    } // main

} // SortingDriver
