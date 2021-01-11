package phonebook;

import java.util.ArrayList;

public class HashTable<K, V> {
    private final int size;
    private final ArrayList<TableEntry<K, V>>[] table;

    public HashTable(int size) {
        this.size = size;
        //noinspection unchecked
        table = new ArrayList[size];
    }

    public void put(K key, V value) {
        int index = findIndex(key);
        if (table[index] == null) {
            ArrayList<TableEntry<K, V>> values = new ArrayList<>();
            values.add(new TableEntry<>(key, value));
            table[index] = values;
        } else {
            table[index].add(new TableEntry<>(key, value));
        }
    }

    public V getValue(K key) {
        int index = findIndex(key);
        if (table[index] == null) {
            return null;
        }
        ArrayList<TableEntry<K, V>> values = table[index];
        for (TableEntry<K, V> value : values) {
            if (value.getKey().equals(key)) {
                return value.getValue();
            }
        }
        return null;
    }

    private int findIndex(K key) {
        final int absHash = Math.abs(key.hashCode());
        return absHash % size;
    }

    private static class TableEntry<K, V> {
        private final K key;
        private final V value;

        public TableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

