package net.ads.algorithms.test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PuzzleConcat {

    private List<String[]> lines;
    private Validator validator;

    public static void main(String[] args) throws IOException {

        PuzzleConcat clazz = new PuzzleConcat();
        Validator validator = clazz.new StrategyStringBuilder();
        clazz.doProcess(validator);

    }

    public void doProcess(Validator validator) throws IOException {
        this.validator = validator;
        // Prod
        // Scanner scan = new Scanner(System.in);

        // Test
        InputStream is = new FileInputStream("/home/marco/Dropbox/cv/sweden/sample-01.in");
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
            processCaseGroupingBy(linesOfCase, "Case " + (i + 1));
        }

    }

    private void processCaseGroupingBy(List<String> lines, String whichCase) {
        loadLines(lines);
        Set<String> combined = new TreeSet<>();
        List<byte[]> combinations = combine(convertLinesToByteArray(lines));
        Map<Object, List<byte[]>> mapCombinations = combinations.stream()
                .collect(Collectors.groupingBy(val -> val.length));

        for (Entry<Object, List<byte[]>> entry : mapCombinations.entrySet()) {

            for (byte[] combination : entry.getValue()) {
                processCombination(combination).forEach(listComb -> combined.add(listComb));
            }

            if (combined.size() > 0) {
                System.out.println(whichCase + ": " + combined.toArray()[0]);
                return;
            }
        }

        System.out.println(whichCase + ": IMPOSSIBLE");

    }

    private byte[] convertLinesToByteArray(List<String> lines) {
        byte[] list = new byte[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            list[i] = (byte) i;
        }
        return list;
    }

    private void loadLines(List<String> lines) {
        this.lines = lines.stream()

                .map(line -> line.split(" "))

                .map(arr -> arr[0].equals(arr[1]) ? new String[] { "", "" } : arr)

//                .filter(val -> !val[0].equals(val[1]))

                .collect(Collectors.toList());
    }

    private Set<String> processCombination(byte[] combination) {

        PartitionPermuteUtil util = new PartitionPermuteUtil(combination, 15 * 1000 * 1000);
        Set<String> result = new HashSet<>();
        while (util.hasNext()) {

            List<byte[]> permutations = util.next();

            permutations.stream()

                    .map(validator::validate)

                    .filter(val -> val != null)

                    .forEach(phrase -> result.add(phrase));

        }

        return result;

    }

    // Generate the combinations for a list with the PowerSet technique
    private List<byte[]> combine(byte[] list) {
        List<byte[]> all = new LinkedList<>();
        int max = 1 << list.length;
        for (int k = 0; k < max; k++) {
            byte[] subList = convertValueToSet(k, list);
            if (subList.length >= 1) {
                all.add(subList);
            }
        }
        return all;
    }

    // Convert a number to its binary representation and select the items from the
    // initial list based on each bit
    private byte[] convertValueToSet(int x, byte[] list) {
        List<Byte> subList = new LinkedList<>();
        int index = 0;
        for (int k = x; k > 0; k = k >> 1) {

            if ((k & 1) == 1) {
                subList.add(list[index]);
            }
            index++;

        }
        byte[] result = new byte[subList.size()];
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

    interface Validator {
        String validate(byte[] permutation);

        default String validate(List<Integer> permutation) {
            return null;
        }
    }

    class StrategyStringBuilder implements Validator {

        public String validate(byte[] permutation) {

            StringBuilder columnA = new StringBuilder();
            StringBuilder columnB = new StringBuilder();

            for (int i : permutation) {

                String[] values = lines.get(i);
                if (values[0].length() == 0) {
                    continue;
                }

                columnA.append(values[0]);
                columnB.append(values[1]);

            }

            if (columnA.length() > 0 && columnA.compareTo(columnB) == 0) {
                return columnA.toString();
            } else {
                return null;
            }
        }

    }

}
