package net.marcoreis.algorithms;

import java.util.ArrayList;

public class Flags {
    public static void main(String[] args) {

        int A[] = new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6,
                2 };

        System.out.println(new Flags().solution(A));
    }

    // FIXME Essa é difícil
    // https://codility.com/media/train/solution-flags.pdf
    public int solution(int[] A) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                array.add(i);
            }
        }
        if (array.size() == 1 || array.size() == 0) {
            return array.size();
        }
        int sf = 1;
        int ef = array.size();
        int result = 1;
        while (sf <= ef) {
            int flag = (sf + ef) / 2;
            boolean suc = false;
            int used = 0;
            int mark = array.get(0);
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) >= mark) {
                    used++;
                    mark = array.get(i) + flag;
                    if (used == flag) {
                        suc = true;
                        break;
                    }
                }
            }
            if (suc) {
                result = flag;
                sf = flag + 1;
            } else {
                ef = flag - 1;
            }
        }
        return result;
    }
}
