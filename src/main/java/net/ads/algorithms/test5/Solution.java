package net.ads.algorithms.test5;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

interface Operation {
    boolean check(int number);
}

class Number {
    public boolean checker(Operation operation, int number) {
        return operation.check(number);
    }

    public Operation isOdd() {
        return new Operation() {
            public boolean check(int number) {
                return number % 2 != 0;
            }
        };
    }

    public Operation isPalindrome() {
        return new Operation() {
            public boolean check(int number) {
                String asString = String.valueOf(number);
                int count = asString.length();
                AtomicInteger y = new AtomicInteger(count - 1);
                AtomicBoolean result = new AtomicBoolean(true);
                char[] arr = asString.toCharArray();
                IntStream.range(0, count / 2).forEach(x -> {
                    if (arr[x] != arr[y.getAndDecrement()]) {
                        result.set(false);
                    }
                });
                return result.get();
            }
        };
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Number number = new Number();
        String answer = null;
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        int T = Integer.parseInt(bufferedReader.readLine());
//        while (T-- > 0) {
//        String line = bufferedReader.readLine().trim();
//        StringTokenizer st = new StringTokenizer(line);
        int conditionToCheck = 2;// Integer.parseInt(st.nextToken());
        int numberToCheck = 1259521;// Integer.parseInt(st.nextToken());
        if (conditionToCheck == 1) {
            Operation operation = number.isOdd();
            boolean result = number.checker(operation, numberToCheck);
            answer = result ? "ODD" : "EVEN";
        } else if (conditionToCheck == 2) {
            Operation operation = number.isPalindrome();
            boolean result = number.checker(operation, numberToCheck);
            answer = result ? "PALINDROME" : "NOT PALINDROME";
        }
        System.out.println(answer);
//        }
    }
}