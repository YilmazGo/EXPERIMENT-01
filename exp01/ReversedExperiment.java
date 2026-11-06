package exp01;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class ReversedExperiment {

    public static void main(String[] args) throws Exception {

        try (PrintWriter file = new PrintWriter("reversed_results.csv")) {
            file.println("algorithm,data_type,repetition,time_ns");

            for (int run = 1; run <= ArrayData.REPETITIONS; run++) {
                Integer[] integers = ArrayData.createIntegers();
                Double[] doubles = ArrayData.createDoubles();
                String[] strings = ArrayData.createStrings();

                Collections.reverse(Arrays.asList(integers));
                Collections.reverse(Arrays.asList(doubles));
                Collections.reverse(Arrays.asList(strings));

                TimeMeasurement.measureAll(integers, "Integer", run, file);
                TimeMeasurement.measureAll(doubles, "Double", run, file);
                TimeMeasurement.measureAll(strings, "String", run, file);
            }
        }

    }
}
