package exp01;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ShuffledExperiment {

    public static void main(String[] args) throws Exception {

        Random random = new Random(42);

        try (PrintWriter file = new PrintWriter("shuffled_results.csv")) {
            file.println("algorithm,data_type,repetition,time_ns");

            for (int run = 1; run <= ArrayData.REPETITIONS; run++) {
                Integer[] integers = ArrayData.createIntegers();
                Double[] doubles = ArrayData.createDoubles();
                String[] strings = ArrayData.createStrings();

                Collections.shuffle(Arrays.asList(integers), random);
                Collections.shuffle(Arrays.asList(doubles), random);
                Collections.shuffle(Arrays.asList(strings), random);

                TimeMeasurement.measureAll(integers, "Integer", run, file);
                TimeMeasurement.measureAll(doubles, "Double", run, file);
                TimeMeasurement.measureAll(strings, "String", run, file);
            }
        }

    }
}
