package Queue;

public class MyQueueTest {
    public static void main(String[] args) {

        MyQueue<String> myQueue = new MyQueue<String>();
        //add
        myQueue.add("Text test 1");
        myQueue.add("Text test 2");
        myQueue.add("Text test 3");
        myQueue.add("Text test 4");
        //foreach
        System.out.println("Foreach test:");
        for (Object listElem : myQueue) {
            System.out.println("QueueElem = " + listElem);
        }
        //toString
        System.out.println("ToString: " + myQueue);
        //poll
        System.out.println("Queue.poll(): " + myQueue.poll());
        //size
        System.out.println("Queue.size(): " + myQueue.size());
        //peek
        System.out.println("Queue.peek(): " + myQueue.peek());
        //clear
        myQueue.clear();
        System.out.println("Queue.clear(): " + myQueue);
    }
}
