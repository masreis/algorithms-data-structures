package net.ads.dynamicprogramming;

public class Fibonacci {

    public static void main(String[] args) {

        int n = 7;
        long start = System.currentTimeMillis();
        System.out.println(fib(n));
        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) / 1000);

    }

    public static long fib(int n) {
        System.out.println("N: " + n);
        if (n <= 2) {
            System.out.println("Return N: " + n);
            return 1;
        }

        System.out.println("FibMinus1 -> N: " + n);
        long fibMinus1 = fib(n - 1);
        System.out.println("FibMinus1: " + fibMinus1);

        System.out.println("==================");

        System.out.println("FibMinus2 - N: " + n);
        long fibMinus2 = fib(n - 2);
        System.out.println("FibMinus2: " + fibMinus2);

        System.out.println("==================");

        long result = fibMinus1 + fibMinus2;
        System.out.println(" >>>>>>>>>>>>> Result: " + result + " N: " + n);

        return result;

    }

}
