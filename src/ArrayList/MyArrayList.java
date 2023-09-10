package ArrayList;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.StringJoiner;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<Object> {
    private Object[] items;
    private int size;
    private static final int INIT_SIZE = 8;

    public MyArrayList() {
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

    public void remove(int index) {
        Objects.checkIndex(index, size);
        Object[] newItems = new Object[size - 1];
        for (int i = 0, y = 0; i < size; i++) {
            if (i != index) {
                newItems[y++] = items[i];
            }
        }
        items = newItems;
        size--;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) items[index];
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
