package net.ads.dynamicprogramming;

public class TraverseTreeBreadthFisrt {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[] { 1, 2 };
        int i = 0;
        traverseBfs(n, arr, i);
    }

    public static void traverseBfs(int n, int[] arr, int i) {
        if (n == 0) {
            System.out.println("Found leaf");
            return;
        }
        if (n < 0) {
            System.out.println("Did not find leaf");
            return;
        }

        while (n > 0) {
            int next = n - 1;
            System.out.println(next);
            traverseBfs(next, arr, i);
            n = next;
        }
    }
}
