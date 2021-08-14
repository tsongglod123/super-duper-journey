package sit.int202.problem2;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        FileReader file = new FileReader("text.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String text = scanner.next();
            list.add(text);
            if (map.containsKey(text)) {
                map.replace(text, map.get(text) + 1);
            } else {
                map.put(text, 1);
            }
        }
        MapSort sort = new MapSort(map);
        Map<String, Integer> mapSorted = new TreeMap<>(sort);
        mapSorted.putAll(map);

        System.out.println(list);
        mapSorted.forEach((k, v) -> System.out.println(k + findAllIndex(list, k) + " -> " + v));
    }

    private static String findAllIndex(List<String> list, String key) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(key)) {
                index.add(i + 1);
            }
        }
        return index.toString();
    }
}
