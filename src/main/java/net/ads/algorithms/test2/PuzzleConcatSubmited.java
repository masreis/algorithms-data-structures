package net.ads.algorithms.test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PuzzleConcatSubmited {
    public static void main(String[] args) throws IOException {

        PuzzleConcatSubmited clazz = new PuzzleConcatSubmited();
        clazz.doProcess();

    }

    private List<String[]> lines;

    public void doProcess() throws IOException {

        // Prod
//        Scanner scan = new Scanner(System.in);

        // Test
        InputStream is = new FileInputStream("/home/marco/Downloads/sample-01.in");
//        InputStream is = new FileInputStream("/home/marco/Downloads/sample-02.in");
        Scanner scan = new Scanner(is);

        List<List<String>> cases = new ArrayList<>();
        List<String> textLine = null;

        while (scan.hasNextLine()) {

            String line = scan.nextLine();

            if (Character.isDigit(line.charAt(0))) {
                if (textLine != null) {
                    cases.add(textLine);
                }
                textLine = new ArrayList<>();
            } else {
                textLine.add(line);
            }

            // Add the last case at the last line
            if (!scan.hasNextLine()) {
                cases.add(textLine);
            }

        }

        scan.close();
//        is.close();

        for (int i = 0; i < cases.size(); i++) {
            List<String> linesOfCase = cases.get(i);
            processCase(linesOfCase, "Case " + (i + 1));
        }

    }

    // Process each case from file
    private void processCase(List<String> lines, String whichCase) {

        int[] list = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            list[i] = i;
        }

        this.lines = lines.stream().map(line -> line.split(" ")).collect(Collectors.toList());

        Set<String> combined = new TreeSet<>();

        // Generate all possible combinations for the lines
        List<int[]> combinations = combine(list);
        combinations.sort((a, b) -> Integer.compare(a.length, b.length));
        Map<Object, List<int[]>> map = combinations.stream().collect(Collectors.groupingBy(val -> val.length));

        for (int[] combination : combinations) {

            Set<String> processCombinations = processCombination(combination);

            // If there is a valid phrase add it to the list
            if (processCombinations.size() > 0) {
                combined.addAll(processCombinations);
            }

        }

        // Select the shortest phrase or the first lexicographically listed
        if (combined.size() > 0) {
            OptionalInt min = combined.stream().mapToInt(val -> val.length()).min();
            String result = combined.stream().filter(line -> line.length() == min.getAsInt()).limit(1)
                    .collect(Collectors.toList()).get(0);
            System.out.println(whichCase + ": " + result);
        } else {
            System.out.println(whichCase + ": IMPOSSIBLE");
        }

    }

    private Set<String> processCombination(int[] combination) {

        byte[] byteComb = new byte[combination.length];
        for (int i = 0; i < combination.length; i++) {
            byteComb[i] = (byte) combination[i];
        }

        PartitionPermuteUtil util = new PartitionPermuteUtil(byteComb, 20000000);

        Set<String> result = new HashSet<>();
        while (util.hasNext()) {

            List<byte[]> permutations = util.next();

            Optional<String> first = permutations.parallelStream()

                    .map(this::validateCase)

                    .flatMap(Optional::stream)

                    .findFirst();

            first.ifPresent(val -> result.add(val));

        }

        return result;

    }

    private Optional<String> validateCase(byte[] permutation) {
//        if (caseFound) {
//            return Optional.empty();
//        }

        StringBuilder columnA = new StringBuilder();
        StringBuilder columnB = new StringBuilder();

        for (int i : permutation) {

            String[] values = lines.get(i);

            if (values[0].equals(values[1])) {
                continue;
            }

            columnA.append(values[0]);
            columnB.append(values[1]);

        }

        if (columnA.compareTo(columnB) == 0) {
            return Optional.ofNullable(columnA.toString());
        } else {
            return Optional.empty();
        }

    }

    // Generate the combinations for a list with the PowerSet technique
    private List<int[]> combine(int[] list) {
        List<int[]> all = new LinkedList<>();
        int max = 1 << list.length;
        for (int k = 0; k < max; k++) {
            int[] subList = convertValueToSet(k, list);
            if (subList.length > 1) {
                all.add(subList);
            }
        }
        return all;
    }

    // Convert a number to its binary representation and select the items from the
    // initial list based on each bit
    private int[] convertValueToSet(int x, int[] list) {
        List<Integer> subList = new LinkedList<>();
        int index = 0;
        for (int k = x; k > 0; k = k >> 1) {

            if ((k & 1) == 1) {
                subList.add(list[index]);
            }
            index++;

        }
        int[] result = new int[subList.size()];
        for (int i = 0; i < subList.size(); i++) {
            result[i] = subList.get(i);
        }
        return result;
    }

    class PartitionPermuteUtil {

        private byte[] combination;
        private int length;
        private int partitions;
        private int chunckSize;
        private int[] index;
        private int actualPartition = 1;

        public PartitionPermuteUtil(byte[] combination, int chunckSize) {
            this.combination = combination;
            this.chunckSize = chunckSize;
            this.length = IntStream.rangeClosed(1, combination.length).reduce(1, (x, y) -> x * y);
            if (length < chunckSize) {
                partitions = 1;
            } else {
                partitions = length / chunckSize;
                if (length % chunckSize > 0) {
                    partitions++;
                }
            }
            index = new int[this.combination.length];
//        System.out.println("Partitions: " + partitions);
//        System.out.println("Len: " + length);
        }

        public boolean hasNext() {
            return actualPartition <= partitions;
        }

        public int getPartitions() {
            return partitions;
        }

        // Generate permutations based on the Heap Algorithm
        public List<byte[]> next() {
            List<byte[]> result = new ArrayList<>();
            int count = 0;
            if (actualPartition == 1) {
                result.add(this.combination.clone());
                count++;
            }
            int i = 0;

            while (i < this.combination.length) {

                if (index[i] < i) {
                    int first;

                    if (i % 2 == 0) {
                        first = 0;
                    } else {
                        first = index[i];
                    }

                    int second = i;
                    swap(this.combination, first, second);
                    byte[] newCombination = this.combination.clone();
                    result.add(newCombination);

                    index[i]++;

                    if (count >= this.chunckSize - 1) {
                        actualPartition++;
                        break;
                    }

                    count++;
                    // System.out.println("IndexI: " + Arrays.toString(index) + ". i: " + i);
                    i = 0;
                } else {
                    // System.out.println("IndexElse: " + Arrays.toString(index) + ". i: " + i);
                    index[i] = 0;
                    i++;
                }

            }

            if ((actualPartition - 1) * chunckSize + count == length) {
                actualPartition++;
            }

            return result;

        }

        private void swap(byte[] list, int a, int b) {
            byte temp = list[a];
            list[a] = list[b];
            list[b] = temp;
        }

    }
}