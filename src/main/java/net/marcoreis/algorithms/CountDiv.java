package net.marcoreis.algorithms;

public class CountDiv {

    public static void main(String[] args) {
        int A = 6;
        int B = 11;
        int K = 2;
        //
        // A = 0;
         B = 2000000000;
        // B = 0;
        //
        // K = 3;
        // K = 11;
        System.out.println(new CountDiv().solution(A, B, K));
    }

    public int solution(int A, int B, int K) {
        while (B % K > 0) {
            System.out.println(B % K);
            B--;
        }
        while (A % K > 0) {
            A++;
        }

        return (B - A) / K + 1;
    }

    public int solutiona(int A, int B, int K) {
        // int arraySize = B - A;
        // int[] result = new int[arraySize];
        // List<Integer> result = new ArrayList<>();
        // int index = 0;
        int total = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                // result.add(i);
                total++;
            }
        }
        // System.out.println(Arrays.toString(result.toArray()));
        // return result.size();
        return total;
    }

    public int solutionb(int A, int B, int K) {
        int divisors = 0;

        // nothing to do when K > B
        if (K > B) {
            if (A == 0 || B == 0) {
                return 1; // K mod 0 == 0 so count a single divisor
            }
            return 0; // no divisors when A, B both != 0
        }

        if (A == 0) {
            divisors++; // K mod 0 == 0
        }

        int updatedA = A;
        if (K > A) {
            updatedA = K; // skip checking all values < K
        }

        int firstNonZeroDivisor = 0;
        int lastNonZeroDivisor = 0;

        for (int i = updatedA; i <= B; i++) {
            if (i % K == 0) {
                firstNonZeroDivisor = i;
                break;
            }
        }
        for (int i = B; i >= updatedA; i--) {
            if (i % K == 0) {
                lastNonZeroDivisor = i;
                break;
            }
        }
        if (firstNonZeroDivisor == 0
                && lastNonZeroDivisor == 0) {
            divisors = 0;
        } else {
            divisors +=
                    ((lastNonZeroDivisor - firstNonZeroDivisor)
                            / K) + 1;
        }

        return divisors;
    }

}
