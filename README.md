# Bubble Sort Experiment 01

Simple Java experiment for comparing three provided bubble-sort algorithms.

## Files

# ArrayData.java; 
    *there is array size and repetitions variable that other clients can change the size and repetitions.
    *it chooses to produce Integer, Double and String array.
    *for the string array; "Word%010d" is used to produce  strings like "Word0000000001". Then these strings are shuffled to produce randomized input order. if it is produced like Word2 or Word10 that word10 is comes ahead of Word2. Random strings like "avbb" , "dvrnhhh" etc. not used because if it is used it has to produce one constant and fixed string list and it has to shuffle it or reverse it then measure it, but this time the experiment condition of randomizing will be strictly constrained or if it produce different strings each time the sorting algoritm performance can spoil the experiment target, because of this they are all prededermined and shuffled each time then measured.
# -BubbleSortPassPerItem.java;
    *Given before the experiment, untouched.
# -BubbleSortUntilNoChange.java;
    *Given before the experiment, untouched.
# -BubbleSortWhileNeeded.java; 
    *Given before the experiment, untouched.
# -Sorter.java; 
    *Given before the experiment, untouched.
# -ReversedExperiment.java;
    *it opens a csv file consist of "algorithm","data_type","repetition","time_ns" columns. 
    *for each repetitions(it starts with 30 as aforementioned) it produce Integer, Double, String arrays each length of 1000(can be changed later).
    *use Java Collection library to reverse sort them.
    *use TimeMeasurement.measureAll code (it will be explained belowe) to measure the sorting time and write the results to the "file" it sends from here.it sends for example (integers,"Integer",run,file); Integer array to be sorted, type name, at which repetition it is, and file for write.
# -ShuffledExperiment.java;
    *it opens a csv file consist of "algorithm","data_type","repetition","time_ns" columns. 
    *for each repetitions(it starts with 30 as aforementioned) it produce Integer, Double, String arrays each length of 1000(can be changed later).
    *use Java Collection library to shuffle them.
    *use TimeMeasurement.measureAll code (it will be explained belowe) to measure the sorting time and write the results to the "file" it sends from here.
# -TimeMeasurement.java;
    *it takes the input from Reversed and Shuffled java file and put those input to each PassPerItem,UntilNoChange and WhileNeeded java codes and measure its time for sorting and writes this time to csv file.
    *MeasureAll takes the parameter as (original,type,repetition,file); original is the array that was sent by Reversed or Shuffled java code. Then it calls the 3 different sorting algorithm for measuring and writes them to csv file.
    *MeasureOne takes the parameter as(original, sorter, name, type, repetition, file); original is the array sent by Reversed or Shuffled java, sorter is the real object of PassPerItem,UntilNoChange or WhileNeeded java classes. First it copies the original array each time and put the copy to the 3 different sorting algorithm each time, so it keeps the original array (if original is reversed keep it reversed or shuffled keep it shuffled).If it doesnt do it at first call original shuffled array will be sorted and other sorting algoritms will use sorted array and experiment will be spoiled.
    

## Change experiment settings

Open `exp01/ArrayData.java` and change only these two numbers:

```java
// CHANGE THESE TWO VALUES TO CUSTOMIZE THE EXPERIMENT
public static final int ARRAY_SIZE = 1000;
public static final int REPETITIONS = 30;
```

Both shuffled and reversed experiments use the same settings automatically. Do not change the three given sorting algorithms. If the settings are changed, rerun both experiments to refresh their CSV files.

## Run in VS Code

Open this folder in VS Code with a Java Development Kit (JDK) installed and the Java extension pack.
Run `ArrayData.java` first to check arrays, then run `ShuffledExperiment.java` and `ReversedExperiment.java` using **Run Java**. Run them with the project folder as the current directory so the CSV files appear here.


## Data format

Each CSV row contains `algorithm,data_type,repetition,time_ns`.
With the default settings, each experiment contains 3 algorithms × 3 data types × 30 repetitions = 270 measurements (plus a header row). Both experiments together produce 540 measurements. For example 100 repetitions, each experiment produces 900 measurements.

## Design notes

- The input length and repetiton is controlled by 'ARRAY_SIZE' and 'REPETITIONS' .
- For each repetition and data type, all three algorithms receive same input values in the same order, but on separate copies.
- Shuffles use a fixed random seed (42) so the generated permutations can be reproduced.
- Reversed inputs are the same descending arrays across repetitions.
- `System.nanoTime()` measures only the `sort` call; input creation, copying, correctness checking and CSV writing happen outside of the code block.
- Reversed order is a worst-case-style input for those bubble-sort algoritms, but shuffled inputs should not be called worst case.
- CSV files will be used in excel file to produce the descriptive data.
