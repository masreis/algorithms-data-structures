package net.ads.algorithms.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PrimeFactors {

    public static void main(String[] args) {

        new PrimeFactors().doProcess();
//        new PrimeFactors().doProcessRandom();

    }

    private void doProcess() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {

            long value = scan.nextLong();

            if (value == 4) {
                break;
            }

            processValue(value);
        }
        scan.close();

    }

    void doProcessRandom() {

        for (int i = 0; i < 20000; i++) {

            long value = Math.abs(ThreadLocalRandom.current().nextLong(2, 10000000000l));

            if (value == 4) {
                i--;
                continue;
            }

            processValue(value);
        }

    }

    private void processValue(long initialValue) {

        long value = initialValue;
        int passes = 0;
        boolean keepGoing = true;

        while (keepGoing) {
            passes++;
            System.out.println("Initial: " + value);
            List<Long> factors = factors(value);
            if (factors.size() == 1) {
                break;
            }
            value = factors.stream().reduce((a, b) -> a + b).get();

        }
        System.out.println(value + " " + passes);

    }

    // Extract the factors from a number
    private List<Long> factors(long value) {
        List<Long> result = new ArrayList<>();

        // Even numbers
        while (value % 2 == 0) {
            result.add(2l);
            value = value / 2;
            System.out.println("Even: " + value);
        }

        // Odd numbers
        double sqrt = Math.ceil(Math.sqrt(value));
        for (int i = 3; i <= sqrt; i += 2) {
            while (value % i == 0) {
                result.add(Long.valueOf(i));
                value = value / i;
                System.out.println("Odd: " + value);
            }
        }

        // Rest
        if (value > 2) {
            result.add(value);
            System.out.println("Rest: " + value);
        }
        return result;
    }

}
