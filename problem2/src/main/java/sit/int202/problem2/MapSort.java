package sit.int202.problem2;

import java.util.Comparator;
import java.util.Map;

public class MapSort implements Comparator<Object> {

    private Map<String, Integer> map;

    public MapSort(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (map.get(o1).equals(map.get(o2))) {
            return 1;
        } else {
            return map.get(o1).compareTo(map.get(o2));
        }
    }
}
