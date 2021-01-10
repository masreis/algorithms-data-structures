package net.ads.arrays;

public class SolutionPlusMinus {
    public static void main(String[] args) {
        int[] arr = new int[] { -4, 3, -9, 0, 4, 1 };
        plusMinus(arr);
    }

    static void plusMinus(int[] arr) {
        float negatives = 0;
        float positives = 0;
        float zeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negatives++;
            } else if (arr[i] == 0) {
                zeros++;
            } else if (arr[i] > 0) {
                positives++;
            }
        }
//        int[] arrNegatives = new int[negatives];
//        int[] arrPositives = new int[positives];
//        int[] arrZeros = new int[zeros];

        float fPositives = positives / arr.length;
        System.out.printf("%.6f\n", fPositives);

        float fNegatives = negatives / arr.length;
        System.out.printf("%.6f\n", fNegatives);

        float fZeros = zeros / arr.length;
        System.out.printf("%.6f\n", fZeros);
    }
}
