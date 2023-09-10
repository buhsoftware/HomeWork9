package LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        //LinkedList
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Text test 1");
        myLinkedList.add("Text test 2");
        myLinkedList.add("Text test 3");
        myLinkedList.add("Text test 4");
        System.out.println("myLinkedList (add): " + myLinkedList);
        //get
        System.out.println("myLinkedList.get(3) = " + myLinkedList.get(3));
        //remove
        myLinkedList.remove(0);
        System.out.println("myLinkedList.remove(2) = " + myLinkedList);
        //size
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        //clear
        myLinkedList.clear();
        System.out.println("myLinkedList.clear() = " + myLinkedList);
    }
}
