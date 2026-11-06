package exp01;

import java.io.PrintWriter;

public class TimeMeasurement {

    public static <T extends Comparable<T>> void measureAll(
            T[] original, String type, int repetition, PrintWriter file) {

        measureOne(original, new BubbleSortPassPerItem<T>(),
                "PassPerItem", type, repetition, file);

        measureOne(original, new BubbleSortUntilNoChange<T>(),
                "UntilNoChange", type, repetition, file);

        measureOne(original, new BubbleSortWhileNeeded<T>(),
                "WhileNeeded", type, repetition, file);
    }

    private static <T extends Comparable<T>> void measureOne(
            T[] original, Sorter<T> sorter, String name,
            String type, int repetition, PrintWriter file) {

        T[] copy = original.clone();

        long start = System.nanoTime();
        sorter.sort(copy);
        long time = System.nanoTime() - start;

        for (int i = 1; i < copy.length; i++) {
            if (copy[i - 1].compareTo(copy[i]) > 0) {
                throw new IllegalStateException("Sorting failed: " + name);
            }
        }

        file.println(name + "," + type + "," + repetition + "," + time);
    }
}
