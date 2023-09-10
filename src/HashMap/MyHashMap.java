package HashMap;

import java.util.Currency;
import java.util.HashMap;
import java.util.StringJoiner;

public class MyHashMap<K, V> {

    private static final int DEFAULT_SIZE = 8;
    private Entry<K, V>[] entries = new Entry[DEFAULT_SIZE];

    private int size;

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> entry = new Entry<>(key, value, null);

        if (entries[index] == null) {
            entries[index] = entry;
        } else {
            Entry<K, V> lastEntry = entries[index];
            for (Entry<K, V> currentEntry = entries[index]; currentEntry != null; currentEntry = currentEntry.next) {
                if (currentEntry.key == entry.key && currentEntry.key.equals(entry.key)) {
                    currentEntry.value = entry.value;
                    return;
                }
                lastEntry = currentEntry;
            }
            lastEntry.next = entry;
        }
        size++;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < entries.length; i++) {
            entries[i] = null;
        }
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (entries[index] == null) return;
        for (Entry<K, V> entry : entries) {
            Entry<K, V> currentEntry = entry;
            if (currentEntry == null) {
                continue;
            }

            boolean itFirstEntry = true;
            Entry<K, V> previousEntry = entry;

            while (currentEntry.next != null) {
                itFirstEntry = false;
                previousEntry = currentEntry;
                if (currentEntry.key == key && currentEntry.key.equals(key)) {
                    previousEntry.next = currentEntry.next;
                    break;
                }
                currentEntry = currentEntry.next;
            }

            if (currentEntry.key == key && currentEntry.key.equals(key)) {
                if (itFirstEntry) {
                    entries[index] = null;
                } else if (currentEntry.next == null) {
                    previousEntry.next = null;
                }
            }
        }
        size--;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (entries[index] == null) return null;
        if (entries[index].key.equals(key)) {
            return entries[index].value;
        } else {
            for (Entry<K, V> currentEntry = entries[index]; currentEntry != null; currentEntry = currentEntry.next) {
                if (currentEntry.key == key && currentEntry.key.equals(key)) {
                    return currentEntry.value;
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % entries.length;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {

        StringJoiner result = new StringJoiner(", ");
        for (Entry<K, V> entry : entries) {
            for (Entry<K, V> currentEntry = entry; currentEntry != null; currentEntry = currentEntry.next) {
                result.add("<" + currentEntry.key + "," + currentEntry.value + ">");
            }
        }
        return "[" + result + "]";
    }
}
