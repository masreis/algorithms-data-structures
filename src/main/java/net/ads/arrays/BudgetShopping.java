package net.ads.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

	/*
	 * Complete the 'budgetShopping' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. INTEGER_ARRAY bundleQuantities 3. INTEGER_ARRAY
	 * bundleCosts
	 */

	public static int budgetShopping1(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {

		int total = 0;
		int result = 0;
		int val = n;
		int totalOutter;
		List<Integer> resultList = new ArrayList<>();
		while (val >= 0) {
			for (int i = 0; i < bundleCosts.size(); i++) {
				int totalInner;
				int cost = bundleCosts.get(i);
				if (val - cost < 0) {
					if (result < total) {
						result = total;
					}
					val = n;
					total = 0;
					break;
				}
				val -= cost;
				total += bundleQuantities.get(i);
			}
		}

		return result;

	}

	public static int budgetShopping(int budget, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
		int[] temp = new int[budget + 1];

		int qtdVendors = bundleCosts.size();
		for (int i = 0; i <= budget; i++) {
			for (int j = 0; j < qtdVendors; j++) {
				int cost = bundleCosts.get(j);
				if (cost <= i) {
					int quantity = bundleQuantities.get(j);
					int tempCost = temp[i - cost];
					int tempI = temp[i];
					temp[i] = Math.max(tempI, tempCost + quantity);
					System.out.println("i: " + i + ", temp: " + temp[i]);
				}
			}
		}
		return temp[budget];
	}
}

public class BudgetShopping {
	public static void main(String[] args) throws IOException {

		int n = 50;
		List<Integer> bundleQuantities = Arrays.asList(20, 19);
		List<Integer> bundleCosts = Arrays.asList(24, 20);
		// result: 40

//		n = 4;
//		bundleQuantities = Arrays.asList(10);
//		bundleCosts = Arrays.asList(2);
		// 20

//		n = 1;
//		bundleQuantities = Arrays.asList(10);
//		bundleCosts = Arrays.asList(2);
//		//
//
//		n = 50;
//		bundleQuantities = Arrays.asList(20, 1);
//		bundleCosts = Arrays.asList(24, 2);
//		// 41
//
//		n = 50;
//		bundleQuantities = Arrays.asList(60, 100, 120);
//		bundleCosts = Arrays.asList(10, 20, 30);
//		// 220?
//
//		bundleCosts = Arrays.asList(1, 2, 3);
//		bundleQuantities = Arrays.asList(10, 15, 40);
//		n = 6;
//
		int result = Result.budgetShopping(n, bundleQuantities, bundleCosts);
		System.out.println(result);
	}
}

//
//def budgetShopping(n, bundleQuantities, bundleCosts):
//    
//    if not bundleQuantities or not n:
//        return 0
//    index = [bundleCosts.index(x) for x in sorted(bundleCosts)]
//    bundleCosts = [bundleCosts[i] for i in index]
//    bundleQuantities = [bundleQuantities[i] for i in index]
//    
//    if n < bundleCosts[0]:
//      return 0
//    countQuant = [0] * (n + 1)
//    
//    for i in range(bundleCosts[0], n + 1):
//      j = 0
//      while (j < len(bundleCosts)):
//          if i < bundleCosts[j]:
//              break
//          temp = countQuant[i - bundleCosts[j]] + bundleQuantities[j]
//          countQuant[i] = max(temp, countQuant[i])
//          j = j + 1
//    return countQuant[n]
//    
//print (budgetShopping(50, [20, 19], [24, 20]))
