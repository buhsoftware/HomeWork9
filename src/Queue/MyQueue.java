package Queue;

import java.util.*;
import java.util.function.Consumer;

public class MyQueue<T> implements Iterable<Object> {

    private Object[] items;
    private int size;
    private static final int INIT_SIZE = 8;

    public MyQueue() {
        this.items = new Object[INIT_SIZE];
    }

    public void add(T value) {
        checkSizeAndResize();
        items[size] = value;
        size++;
    }

    public void clear() {
        size = 0;
        items = new Object[INIT_SIZE];
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        size--;
        Object[] newItems = new Object[size];
        T deletedItem = (T) items[0];
        System.arraycopy(items, 1, newItems, 0, size);
        items = newItems;
        return deletedItem;
    }

    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return (T) items[0];
        }
    }

    public int size() {
        return size;
    }

    private void checkSizeAndResize() {
        if (size == items.length - 1) {
            int newSize = items.length * 2;
            Object[] newItems = new Object[newSize];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            result.add(items[i].toString());
        }
        return "[" + result + "]";
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Object next() {
                return items[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Object> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Object> spliterator() {
        return Iterable.super.spliterator();
    }

}
