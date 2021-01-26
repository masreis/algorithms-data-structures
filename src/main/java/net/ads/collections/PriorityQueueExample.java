package net.ads.collections;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 10; i++) {
            queue.add(ThreadLocalRandom.current().nextInt(0, 100));
        }

        System.out.println(queue);
    }
}
