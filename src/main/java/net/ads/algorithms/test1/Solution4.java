package net.ads.algorithms.test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result4 {

    // TODO Use only the first position of the array
    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        boolean[][] gate = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (h.contains(i + 1)) {
                for (int j = 0; j < m; j++) {
                    gate[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (v.contains(i + 1)) {
                for (int j = 0; j < n; j++) {
                    gate[j][i] = true;
                }
            }
        }

        List<int[]> matches = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gate[i][j] && h.contains(i + 1) && v.contains(j + 1)) {
                    matches.add(new int[] { i + 1, j + 1 });
                }
            }

        }

        long countI = matches.stream().mapToInt(val -> val[0]).distinct().count();
        long countJ = matches.stream().mapToInt(val -> val[1]).distinct().count();

        long i = Math.max(countI, countJ);
        long j = Math.min(countI, countJ);

        long size = (i * 2) + 2 + ((j - 1) * (i + 1));

        return size;

    }

}

public class Solution4 {
    public static void main(String[] args) throws IOException {

        int n = 6;

        int m = 6;

        List<Integer> h = Arrays.asList(4);
        h = Arrays.asList(3, 4, 5);

        List<Integer> v = Arrays.asList(2);
        v = Arrays.asList(1, 2);

        long result = Result4.prison(n, m, h, v);

    }

}
