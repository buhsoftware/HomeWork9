package Stack;

public class MyStackTest {

    public static void main(String[] args) {

        MyStack<String> myStack = new MyStack<>();
        myStack.add("Text test 1");
        myStack.add("Text test 2");
        myStack.add("Text test 3");
        myStack.add("Text test 4");
        System.out.println("myStack (add): " + myStack);
        //peek
        System.out.println("myStack.peek() = " + myStack.peek());
        //remove
        myStack.remove(1);
        System.out.println("myStack.remove(1) = " + myStack);
        //size
        System.out.println("myStack.size() = " + myStack.size());
        //pop
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack: " + myStack);
        //clear
        myStack.clear();
        System.out.println("myStack.clear() = " + myStack);
    }
}
