package sit.int202.problem4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{8, 2, 3, 7, 8, 8, 7, 4, 7, 4, 4, 2, 2, 3, 8, 2, 7, 3, 3, 8};
        Map<Integer, Integer> map = new TreeMap<>();
        int maxFrequent = 0;
        int value = 0;
        for (int number : numbers) {
            if (map.containsKey(number)) {
                map.replace(number, map.get(number) + 1);
                if (map.get(number) > maxFrequent) {
                    value = number;
                    maxFrequent = map.get(value);
                }
            } else {
                map.put(number, 1);
            }
        }
        System.out.println(value + "(" + maxFrequent + "): " + findAllIndex(numbers, value));
    }

    private static String findAllIndex(int[] arr, Integer value) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                list.add(i);
            }
        }
        return list.toString();
    }
}
