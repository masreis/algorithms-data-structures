package net.marcoreis.algorithms;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PackNumbers {

    // Complete the packNumbers function below.
    static List<String> packNumbers(List<Integer> arr) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int idx = 0;
        int prev = 0;
        for (Integer i : arr) {
            if (prev != i) {
                idx++;
            }
            if (map.get(i) == null) {
                map.put(String.valueOf(i) + "," + idx, 1);
            } else {
                map.put(String.valueOf(i) + "," + idx,
                        map.get(i) + 1);
            }
        }
        // System.out.println(map);
        for (String i : map.keySet()) {
            if (map.get(i) == 1) {
                result.add(String.valueOf(i));
            } else {
                result.add(
                        i + ":" + String.valueOf(map.get(i)));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        List<Integer> arr = null;
        List<String> res = packNumbers(arr);

    }
}
