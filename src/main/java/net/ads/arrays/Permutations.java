package net.ads.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    private static List<int[]> permute(int[] arr) {
        List<int[]> list = new ArrayList<>();
        list.add(arr.clone());
        int[] idx = new int[arr.length];
        int i = 0;
        while (i < arr.length) {
            if (idx[i] < i) {
                int a;
                if (i % 2 == 0) {
                    a = 0;
                } else {
                    a = idx[i];
                }
                a = i % 2 == 0 ? 0 : idx[i];
                int b = i;
                swap(arr, a, b);
                list.add(arr.clone());
                idx[i]++;
                i = 0;
            } else {
                idx[i] = 0;
                i++;
            }
        }
        return list;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3, 4 };
        List<int[]> result = permute(arr);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }

    }
}
