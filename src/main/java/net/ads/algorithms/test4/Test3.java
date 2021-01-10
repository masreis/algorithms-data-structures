package net.ads.algorithms.test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    /*
     * Complete the 'kthPerson' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * following parameters: 1. INTEGER k 2. INTEGER_ARRAY p 3. INTEGER_ARRAY q
     */

    public static List<Integer> kthPerson(int k, List<Integer> listPatiente, List<Integer> listQueue) {
        List<Integer> result = new ArrayList<>();

        int matched = 0;
        boolean added = false;

        for (int q : listQueue) {
            added = false;
            for (int i = 0; i < Math.min(i + k, listPatiente.size()); i++) {
                int p = listPatiente.get(i);
                if (p >= q) {
                    matched++;
                }
                if (matched == k) {
                    result.add(i + 1);
                    matched = 0;
                    added = true;
                    break;
                }
            }

            if (added) {
                continue;
            }

            result.add(0);
            matched = 0;
        }
        return result;
    }

    public static List<Integer> kthPerson2(int k, List<Integer> listPatiente, List<Integer> listQueue) {
        List<Integer> result = new ArrayList<>();

        int matched = 0;
        boolean added = false;

        ArrayList<Integer> sorted = new ArrayList<>(listQueue);
        Collections.sort(sorted);
        int j = 0;

        outer: for (int i = 0; i < listPatiente.size();) {
            int p = listPatiente.get(i);

            int q = sorted.get(j);

            while (p >= q) {
                j++;
                matched++;
                q = sorted.get(j);

//                if (matched == k) {
                matched = 0;
                result.add(i + 1);
//                }

                continue outer;

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int k = 2;
        List<Integer> p = Arrays.asList(1, 2, 3, 4);
        List<Integer> q = Arrays.asList(1, 3, 4);
        // 2,4,0

//        k = 3;
//        p = Arrays.asList(2, 5, 3);
//        q = Arrays.asList(1, 5);
        // 3, 0

        k = 2;
        p = Arrays.asList(1, 4, 4, 3, 1, 2, 6);
        q = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // 2, 3, 3, 3, 0, 0, 0;
        List<Integer> result = kthPerson(k, p, q);

        System.out.println(result);
    }
}
