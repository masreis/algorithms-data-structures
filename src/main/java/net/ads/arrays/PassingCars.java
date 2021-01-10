package net.ads.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PassingCars {
    public static void main(String[] args) {
        int[] A = { 0, 1, 0, 1, 1, 0 };
        System.out.println(new PassingCars().solution(A));
    }

    public int solution(int[] A) {
        Map<Integer, Boolean> listE = new HashMap<>();
        Map<Integer, Boolean> listW = new HashMap<>();
        int tot = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                listE.put(i, false);
            } else {
                listW.put(i, true);
            }
        }
        //
        for (Iterator<Integer> iteE = listE.keySet().iterator(); iteE.hasNext();) {
            Integer nextE = iteE.next();
            for (Iterator<Integer> iteW = listW.keySet().iterator(); iteW.hasNext();) {
                if (nextE < iteW.next()) {
                    if (tot > 1000000000) {
                        return -1;
                    }
                    tot++;
                }
            }
        }
        return tot;
    }

    public int solutionb(int[] A) {
        int east = 0;
        int west = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                east++;
            } else {
                west += east;
            }
            if (west > 1000000000) {
                return -1;
            }

        }
        return west;
    }

}
