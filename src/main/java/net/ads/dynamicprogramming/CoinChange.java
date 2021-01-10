package net.ads.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange {

  public static long getWays(int n, List<Long> c) {
    Map<Long, List<Long>> map = new HashMap<>();

    int result = getWays(n, c, 0, map);

    return result;
  }

  private static int getWays(int n, List<Long> coins, int idx, Map<Long, List<Long>> map) {
    System.out.println("N: " + n);
    if (n == 0) {
      return 1;
    }

    if (idx >= coins.size()) {
      return 0;
    }

    int ways = 0;
    int amountWithCoin = 0;

    while (amountWithCoin <= n) {
      int rest = n - amountWithCoin;
      System.out.println("Rest: " + rest + " Idx: " + idx + " N: " + n);
      ways += getWays(rest, coins, idx + 1, map);
      System.out.println("=====================");
      amountWithCoin += coins.get(idx);
      System.out.println(
          "Coin: "
              + coins.get(idx)
              + " Amount: "
              + amountWithCoin
              + " Idx: "
              + idx
              + " N: "
              + n
              + "->"
              + ways);
    }
    System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");

    return ways;
  }

  private static int myGetWays(long n, List<Long> coins, int idx, Map<Long, List<Long>> map) {
    System.out.println("N: " + n);
    if (n == 0) {
      System.out.println("Return 1");
      return 1;
    }

    if (n < 0) {
      System.out.println("Return 0");
      return 0;
    }

    int ways = 0;

    long amount = n;

    long node = n;

    for (int i = 0; i < coins.size(); i++) {
      ways += myGetWays(n - coins.get(i), coins, i, map);
      node = node - coins.get(i);
    }

    return ways;
  }

  public static void main(String[] args) {
    int n = 10;
    List<Long> c = Arrays.asList(2l, 3l, 5l, 6l);
    System.out.println(getWays(n, c));
  }
}
