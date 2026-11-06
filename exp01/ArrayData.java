package exp01;

public class ArrayData {

    // CHANGE THESE TWO VALUES TO CUSTOMIZE THE EXPERIMENT
    public static final int ARRAY_SIZE = 1000;
    public static final int REPETITIONS = 30;

    public static Integer[] createIntegers() {
        Integer[] numbers = new Integer[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    public static Double[] createDoubles() {
        Double[] numbers = new Double[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = (double) (i + 1);
        }
        return numbers;
    }

    public static String[] createStrings() {
        String[] words = new String[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            words[i] = String.format("Word%010d", i + 1);
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println("Integer: " + createIntegers().length);
        System.out.println("Double: " + createDoubles().length);
        System.out.println("String: " + createStrings().length);
    }
}
