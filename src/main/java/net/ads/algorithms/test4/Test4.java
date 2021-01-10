package net.ads.algorithms.test4;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * https://stackoverflow.com/questions/8819550/efficiently-ordered-data-structure-that-supports-duplicate-keys
 * Try a priority queue
 * 
 * @author Marco Reis
 *
 */
public class Test4 {
    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (int q : queries) {
            int d = stockData.get(q - 1);
            int l = q - 2;
            int r = q;
            int[] arr = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
            boolean lok = false;
            boolean rok = false;
            while (l >= 0 || r < stockData.size()) {
                i++;
                if (l > 0) {
                    int vl = stockData.get(l);
                    if (vl < d) {
                        arr[0] = l + 1;
                        lok = true;
                    }
                    l--;
                }
                if (lok) {
                    break;
                }
                if (r < stockData.size()) {
                    int vr = stockData.get(r);
                    if (vr < d) {
                        arr[1] = r + 1;
                        rok = true;
                    }
                    r++;
                }
                if (l == 0 && r == stockData.size()) {
                    arr[0] = -1;
                    break;
                }
                if (lok || rok) {
                    break;
                }
            }

            result.add(Math.min(arr[0], arr[1]));

        }
        System.out.println(i);
        return result;
    }

    public static List<Integer> predictAnswerDynamic(List<Integer> stockData, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        int[][] arr = new int[stockData.size()][stockData.size()];

        for (int i = 0; i < stockData.size(); i++) {

        }

        return result;
    }

    public static List<Integer> predictAnswerTree(List<Integer> stockData, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        List<Integer> valQueries = new ArrayList<>();

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();

//        List<Integer> idx = IntStream.range(0, stockData.size()).boxed().collect(Collectors.toList());

//        for (int q : queries) {
//            int val = stockData.get(q - 1);
//            listQueries.add(val);
//        }

        for (int q : queries) {
            set.add(q);
        }

        TreeSet<Integer> treeData = new TreeSet<Integer>();
        for (int p : stockData) {
            treeData.add(p);
        }

        for (int p : stockData) {
            map.put(p, set);
        }

        Entry<Integer, TreeSet<Integer>> entry = map.lowerEntry(10);

        int val1 = treeData.lower(10);
        int val2 = treeData.lower(9);
        int val3 = treeData.lower(4);

//        for (int q : listQueries) {
//            int low = set.lower(q);
//            System.out.println(low);
//        }

//        Entry<Integer, TreeSet<Integer>> low = map.lowerEntry(10);
//        Entry<Integer, TreeSet<Integer>> high = map.higherEntry(10);
        return result;

    }

    public static void main(String[] args) {
        List<Integer> stockData = Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4);
        List<Integer> queries = Arrays.asList(6, 5, 4);
        // 5,4,8

        stockData = Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4);
        queries = Arrays.asList(3, 1, 8);
        // 2, 4, -1

        stockData = new ArrayList<>();
        int sizeData = 1000000;
        int sizeQuery = 1000000;
        for (int i = 0; i < sizeData; i++) {
            stockData.add(ThreadLocalRandom.current().nextInt(1000000000));
        }

        queries = new ArrayList<>();
        for (int i = 0; i < sizeQuery; i++) {
            queries.add(ThreadLocalRandom.current().nextInt(1, sizeData - 1));
        }

        Instant start = Instant.now();
        predictAnswer(stockData, queries);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(timeElapsed);
    }
}

//
//
//import heapq
//
//class Data:
//    def __init__(self, day, value):
//        self.day = day
//        self.value = value
//    def __lt__(self, other):
//        return self.value >= other.value
//    def __repr__(self):
//        return f'Data(day={self.day}, value={self.value})'
//
//def precalc(days):
//    result = []
//    heap = []
//    for day, value in days:
//        data = Data(day, value)
//        while heap and heap[0] < data:
//            heapq.heappop(heap)
//        result.append(heap[0].day if heap else -1)
//        heapq.heappush(heap, data)
//    return result
//
//def compare(f, b, q):
//    if f < 0: return b
//    if b < 0: return f
//    if q-f <= b-q:
//        return f
//    else:
//        return b
//
//def predictAnswer(stockData, queries):
//    forward = precalc(enumerate(stockData, 1))
//    backward = list(reversed(precalc(reversed(list(enumerate(stockData, 1))))))
//    return [compare(forward[q-1], backward[q-1], q) for q in queries]
//
//def test(stockData, queries):
//  def short(l):
//    return l if len(l) <= 10 else l[:9]+['...']
//
//  out = predictAnswer(stockData, queries)
//  print(f"""
//stockData = {short(stockData)}
//queries = {short(queries)}
//Output
//{short(out)}
//""")
//
//test(stockData=[5,6,8,4,9,10,8,3,6,4], queries=[6,5,4])
//test(stockData=[5,6,8,4,9,10,8,3,6,4], queries=[3,1,8])
//test(stockData=[1]+[2]*9999, queries=list(range(1,10001)))
//
