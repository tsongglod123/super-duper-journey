package sit.int202.classicmodelweb.models;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart<K, V extends CartItem> {
    private Map<K, V> map;

    public Cart() {
        this.map = new HashMap<>();
    }

    public int countItem() {
        return map.size();
    }

    public ClassicModelCartItem getProduct(K key) {
        return (ClassicModelCartItem) map.get(key);
    }

    public int countQuantity() {
        return map.values().stream().mapToInt(CartItem::getQuantity).sum();
    }

    public Collection<V> getAllItems() {
        return Collections.unmodifiableCollection(map.values());
    }

    public double getTotalPrice() {
        return map.values().stream().mapToDouble(CartItem::getTotal).sum();
    }

    public void addItem(K key, V value) {
        V item = map.get(key);
        if (item == null) {
            map.put(key, value);
        } else {
            item.setQuantity(item.getQuantity() + value.getQuantity());
        }
    }

    public void decreaseItem(K key) {
        V item = map.get(key);
        if (item.getQuantity() > 1) {
            item.setQuantity(item.getQuantity() - 1);
        }
    }

    public void removeItem(K key) {
        map.remove(key);
    }

    public void clear() {
        map.clear();
    }
}
