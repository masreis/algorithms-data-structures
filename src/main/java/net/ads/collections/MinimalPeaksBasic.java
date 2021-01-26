package net.ads.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MinimalPeaksBasic {

    public List<Integer> solution(List<Integer> array) {
        // List<Integer> list = new ArrayList();
        // List<Integer> res = new ArrayList();
        // int[] var4 = array;
        int val = array.size();

//        int i;
        // for(i = 0; i < val; ++i) {
        // int num = var4[i];
        // list.add(num);
        // }

        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i : array) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            if (list.size() == 1) {
                res.add(list.get(0));
                break;
            }

            int index = 0;
            val = Integer.MAX_VALUE;

            for (int i = 0; i < list.size(); ++i) {
                if (i == 0) {
                    if (list.get(i) >= list.get(i + 1) && list.get(i) <= val) {
                        index = i;
                        val = list.get(i);
                    }
                } else if (i == list.size() - 1) {
                    if (list.get(i) >= list.get(i - 1) && list.get(i) <= val) {
                        index = i;
                        val = list.get(i);
                    }
                } else if (list.get(i) >= list.get(i - 1) && list.get(i) >= list.get(i + 1) && list.get(i) <= val) {
                    index = i;
                    val = list.get(i);
                }
            }

            list.remove(index);
            res.add(val);
        }

        return res;
    }

    public static void main(String[] args) {
        MinimalPeaksBasic dm = new MinimalPeaksBasic();
        int[] array = new int[] { 1, 2 };
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 8, 5, 1, 6, 3, 9, 4));
        array = new int[] { 2, 7, 8, 5, 1, 6, 3, 9, 4 };
        int size = 100000;
        array = new int[size];
        IntStream.range(1, size).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(1, size)));
        System.out.print(dm.solution(list));
    }
}