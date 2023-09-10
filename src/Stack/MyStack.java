package Stack;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.StringJoiner;

public class MyStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
        }
        head = node;
        size++;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return head.value;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T deletedItem = head.value;
        remove(0);
        return deletedItem;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (size == 0) {
            return;
        }

        Node<T> currentPosNode = getNodeByIndex(index);
        if (currentPosNode.previous == null && currentPosNode.next == null) //1 element
        {
            head = null;
            tail = null;
        } else if (currentPosNode.previous == null) {
            currentPosNode.next.previous = null;
            head = currentPosNode.next;
        } else if (currentPosNode.next == null) {
            currentPosNode.previous.next = null;
            tail = currentPosNode.previous;
        } else {
            currentPosNode.previous.next = currentPosNode.next;
            currentPosNode.next.previous = currentPosNode.previous;
        }
        currentPosNode = null;
        size--;
    }

    public Node getNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        Node<T> currentPosNode = head;
        for (int i = 0; i < index; i++) {
            currentPosNode = currentPosNode.next;
        }
        return currentPosNode;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) getNodeByIndex(index).value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;

        Node<T> currentPosNode = head;
        Node<T> nextPos;

        for (int i = 0; i < size; i++) {
            nextPos = currentPosNode.next;
            currentPosNode.value = null;
            currentPosNode.previous = null;
            currentPosNode.next = null;
            currentPosNode = nextPos;
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");

        Node<T> currentPosNode = head;

        for (int i = 0; i < size; i++) {
            result.add(currentPosNode.value.toString());
            currentPosNode = currentPosNode.next;
        }
        return "[" + result + "]";
    }
}
