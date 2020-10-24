package net.ads.algorithms.test1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Result3 {

    public static String featuredProduct(List<String> products) {
        // Write your code here

        Map<String, Integer> mapAll = new TreeMap<>();

        products.stream().forEach(product -> {
            Integer value = mapAll.getOrDefault(product, 0);
            mapAll.put(product, ++value);
        });

        Optional<Integer> max = mapAll.values().stream().max((a, b) -> a.compareTo(b));

//        List<String> result = new ArrayList<>();

//        for (Entry<String, Integer> entry : mapAll.entrySet()) {
//            if (entry.getValue() == max.get()) {
//                result.add(entry.getKey());
//            }
//        }

        List<Map.Entry<String, Integer>> result = mapAll.entrySet().stream()
                .filter(entry -> entry.getValue() == max.get()).collect(Collectors.toList());

        return result.get(result.size() - 1).getKey();

    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {

        List<String> products = Arrays.asList("", "", "");

        String result = Result3.featuredProduct(products);

    }
}
