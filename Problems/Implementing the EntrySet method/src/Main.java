import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private final int size;
        private final TableEntry<List<T>>[] table;
        private int numberOfEntries = 0;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }
            if (table[idx] == null) {
                List<T> values = new ArrayList<>();
                values.add(value);
                table[idx] = new TableEntry(key, values);
                numberOfEntries++;
            } else {
                table[idx].getValue().add(value);
            }
            return true;
        }

        public List<T> get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return table[idx].getValue();
        }

        public TableEntry<List<T>>[] entrySet() {
            TableEntry<List<T>>[] entries = new TableEntry[numberOfEntries];
            int k = 0;
            for (TableEntry<List<T>> entry : table) {
                if (entry != null) {
                    entries[k] = entry;
                    k++;
                }
            }
            return entries;
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        public String printEntries(TableEntry<List<T>>[] tableEntries) {
            StringBuilder stringBuilder = new StringBuilder();
            for (TableEntry<List<T>> entry : tableEntries) {
                stringBuilder.append(entry.getKey()).append(":");
                for (T t : entry.getValue()) {
                    stringBuilder.append(" ").append(t);
                }
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        HashTable<String> table = new HashTable<>(size);
        for (int i = 0; i < size; i++) {
            int key = scanner.nextInt();
            String value = scanner.next();
            table.put(key, value);
        }
        System.out.println(table.printEntries(table.entrySet()));
    }
}
