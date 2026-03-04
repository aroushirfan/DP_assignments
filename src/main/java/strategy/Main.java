package strategy;

import java.util.Random;

public class Main {

    public static int[] generateArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = r.nextInt(100000);
        return arr;
    }

    public static void testStrategy(SortStrategy strategy, int[] arr) {
        int[] copy = arr.clone();
        long start = System.nanoTime();
        strategy.sort(copy);
        long end = System.nanoTime();
        System.out.println(strategy.getClass().getSimpleName() + ": " + (end - start) + " ns");
    }

    public static void main(String[] args) {

        int[] small = generateArray(30);
        int[] large = generateArray(100000);

        SortStrategy bubble = new BubbleSort();
        SortStrategy quick = new QuickSort();
        SortStrategy merge = new MergeSort();

        System.out.println("=== Small Array ===");
        testStrategy(bubble, small);
        testStrategy(quick, small);
        testStrategy(merge, small);

        System.out.println("\n=== Large Array ===");
        testStrategy(bubble, large);
        testStrategy(quick, large);
        testStrategy(merge, large);
    }
}