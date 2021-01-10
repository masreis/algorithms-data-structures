package net.ads.arrays;

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
        K = 4513121;
        A = B = 0; // in {0,1}, K = 11
        K = 11;
        System.out.println(new CountDiv().solution(A, B, K));
    }

    public int solution(int A, int B, int K) {
        int first = A;
        int last = B;
        int total = 0;

        if (K > B) {
            return 0;
        }

        for (int i = A; i % K > 0; i++) {
            first++;
        }

        for (int i = A; i % K > 0; i--) {
            last++;
        }

        total = (last - first) / K + 1;

        return total;
    }

    public int solutiona(int A, int B, int K) {
        while (B % K > 0) {
            B--;
        }
        while (A % K > 0) {
            A++;
        }

        return (B - A) / K + 1;
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
        if (firstNonZeroDivisor == 0 && lastNonZeroDivisor == 0) {
            divisors = 0;
        } else {
            divisors += ((lastNonZeroDivisor - firstNonZeroDivisor) / K) + 1;
        }

        return divisors;
    }

}
