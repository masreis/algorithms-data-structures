package net.ads.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

//https://leetcode.com/discuss/interview-question/788488/robinhood-oa
//https://www.codenong.com/cs108946574/
public class MinimalPeaks {

    static Queue<Integer> heap = new PriorityQueue<>();
    static List<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 8, 5, 1, 6, 3, 9, 4));
    static List<Integer> listToRemove = new ArrayList<>(list);
    static Map<Integer, Integer> positions = new HashMap<>();
    static Map<Integer, Node> nodeByPosition = new HashMap<>();
    static Map<Integer, Node> nodeByValue = new HashMap<>();
    static int[] prev = new int[list.size()];
    static int[] next = new int[list.size()];

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();

        IntStream.range(0, list.size()).forEach(i -> {
            MinimalPeaks.fillPeaks(i);
            Integer value = list.get(i);
            positions.put(value, i);
            prev[i] = i;
            next[i] = list.size() - i - 1;

            Integer leftPos = i == 0 ? null : i - 1;
            Integer rightPos = i == list.size() - 1 ? null : i + 1;

            Integer leftValue = i == 0 ? null : list.get(i - 1);
            Integer rightValue = i == list.size() - 1 ? null : list.get(i + 1);

//            nodeByPosition.put(i, new Peaks().new Node(value, leftPos, rightPos));
            Node node = new Node(value);
            node.prev = new Node(leftValue);
            node.next = new Node(rightValue);
//            nodeByValue.compute(value, node);

        });

        while (heap.size() > 0) {
            Integer poll = heap.poll();
            result.add(poll);
            System.out.println(poll);
//            listToRemove.remove(poll);
            Node node = nodeByValue.get(poll);
            Node prevNode = nodeByPosition.get(node.prev);

            node.prev = node.next;

            fillPeaks(positions.get(poll) - 1);
            fillPeaks(positions.get(poll) + 1);
        }
    }

    private static void fillPeaks(int i) {
        if (i < 0 || i >= listToRemove.size()) {
            return;
        }
        int newValue = listToRemove.get(i);
        if (i == 0) {
            if (newValue > listToRemove.get(i + 1)) {
                heap.add(newValue);
            }
            return;
        }
        if (i == listToRemove.size() - 1) {
            if (listToRemove.get(i - 1) < newValue) {
                heap.add(newValue);
            }
            return;
        }

        if (listToRemove.get(i - 1) < newValue && newValue > listToRemove.get(i + 1)) {
            heap.add(newValue);
            return;
        }
    }

}

class Node {

    Node prev;
    Node next;
    Integer value;

    public Node(Integer value) {
//            if (prev >= 0)
//                this.prev = list.get(prev);
//            if (next < list.size())
//                this.next = list.get(next);
//        this.prev = prev;
//        this.next = next;
        this.value = value;
    }
}
