package net.marcoreis.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CutTheSticks {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 4, 2, 2, 8 };
        System.out.println(cutTheSticks(arr));
    }

    static int[] cutTheSticks(int[] arr) {
        // https://www.hackerrank.com/challenges/cut-the-sticks/problem
        Arrays.sort(arr);
        List<Integer> initialArray = new ArrayList<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            initialArray.add(arr[i]);
        }
        Set<Integer> result = new HashSet<Integer>();
        while (initialArray.size() > 0) {

            int min = initialArray.get(0);
            result.add(initialArray.size());

//            initialArray.remove(initialArray.size() - 1);

            for (int j = initialArray.size() - 1; j >= 0; j--) {
                if (initialArray.get(j) == min) {
                    initialArray.remove(j);
                }
            }

            ArrayList<Integer> tempArray = new ArrayList<Integer>();
            for (Integer val : initialArray) {
                tempArray.add(val - min);
            }

            initialArray = new ArrayList<Integer>(tempArray);

        }
        int[] arrResult = new int[result.size()];
        int i = result.size() - 1;
        for (int val : result) {
            arrResult[i--] = val;
            System.out.print(val);
            System.out.print(" ");
        }
        return arrResult;
    }

}
