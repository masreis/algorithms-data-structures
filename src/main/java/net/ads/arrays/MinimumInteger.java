package net.ads.arrays;

import java.util.Set;
import java.util.TreeSet;

//FIXME Detected time complexity: O(N**2)
public class MinimumInteger {
    public static void main(String[] args) {
        int[] A = { 1, 3, 6, 4, 1, 2 };
        A = new int[] { 1, 2, 3 };
        A = new int[] { -1, -2 };
        System.out.println(new Solution().solution(A));
    }

}

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new TreeSet<>();
        int result = 1;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val > 0) {
                set.add(val);
            }
        }
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                result = i;
                break;
            }
            i++;

        }
        return result;
    }
}
