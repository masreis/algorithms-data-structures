package net.marcoreis.algorithms;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        int N = 5;
        int[] A = new int[] { 3, 4, 4, 6, 1, 4, 4 };
        //
        // N = 1;
        // A = new int[] { 1 };
        int[] result = new MaxCounters().solution(N, A);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int N, int[] A) {
        int maxMatrix = 0;
        int maxUsed = 0;
        int[] result = new int[N];
        for (int i = 0; i < A.length; i++) {
            // Increase
            if (A[i] <= N) {
                if (result[A[i] - 1] < maxUsed) {
                    result[A[i] - 1] = maxUsed;
                }
                result[A[i] - 1] += 1;
                if (maxMatrix < result[A[i] - 1]) {
                    maxMatrix = result[A[i] - 1];
                }
                // MaxCounter
            } else {
                maxUsed = maxMatrix;
            }
            System.out.println(Arrays.toString(result)
                    + ". Max: " + maxMatrix);
        }
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < N; i++) {
            if (result[i] < maxUsed) {
                result[i] = maxUsed;
            }
        }
        System.out.println(Arrays.toString(result));
        return null;
    }
}
