package sit.int202.problem4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{8, 2, 3, 7, 8, 8, 7, 4, 7, 4, 4, 2, 2, 3, 8, 2, 7, 3, 3, 8};
        Map<Integer, Integer> map = new TreeMap<>();
        int maxFrequent = 0;
        int value = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                map.replace(numbers[i], map.get(numbers[i]) + 1);
                if (map.get(numbers[i]) > maxFrequent) {
                    value = numbers[i];
                    maxFrequent = map.get(value);
                }
            } else {
                map.put(numbers[i], 1);
            }
            if (i == (numbers.length - 1)) {
                System.out.println(value + "(" + maxFrequent + "): " + findAllIndex(numbers, value));
            }
        }
    }

    private static List<Integer> findAllIndex(int[] arr, Integer value) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
