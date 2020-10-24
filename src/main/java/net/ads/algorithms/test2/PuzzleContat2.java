package net.ads.algorithms.test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PuzzleContat2 {

    private List<String[]> lines;

    private boolean caseFound = false;

    public void doProcess() throws IOException {

        // Prod
//        Scanner scan = new Scanner(System.in);

        // Test
//         InputStream is = new FileInputStream("/home/marco/Downloads/sample-01.in");
        InputStream is = new FileInputStream("/home/marco/Downloads/sample-02.in");
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

        caseFound = false;

        for (int[] combination : combinations) {

            Integer[] combInteger = Arrays.stream(combination).boxed().toArray(Integer[]::new);

            Set<String> processCombinations = processCombination(combInteger);

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

    private Set<String> processCombination(Integer[] combination) {

//        Optional<String> result = Permutations.of(combination)
//
//                .map(perm -> perm.collect(Collectors.toList()))
//
//                .parallel()
//
//                .map(this::validateCase)
//
//                .flatMap(Optional::stream)
//                
//                .findFirst();
//
////                .collect(Collectors.toList());
//
////                .forEachOrdered(System.out::println);
//
////                .forEach(System.out::println);
//
////        result.forEach(System.out::println);
//        result.ifPresent(System.out::println);

        return new HashSet<>();
    }

    private Optional<String> validateCase(List<Integer> permutation) {

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
            System.out.println("---------" + permutation);
            caseFound = true;
            return Optional.ofNullable(columnA.toString());
        } else {
            return Optional.empty();
        }

    }

}
