package ArrayList;

public class MyArrayListTest {

    public static void main(String[] args) {

        MyArrayList<String> myList = new MyArrayList<>();
        //add
        myList.add("Text test 1");
        myList.add("Text test 2");
        myList.add("Text test 3");
        myList.add("Text test 4");
        //foreach
        System.out.println("Foreach test:");
        for (Object listElem : myList) {
            System.out.println("listElem = " + listElem);
        }
        //toString
        System.out.println("ToString: " + myList);
        //remove
        myList.remove(2);
        System.out.println("myList.remove(2): " + myList);
        //size
        System.out.println("mylist.size(): " + myList.size());
        //get
        System.out.println("mylist.get(1): " + myList.get(1));
        //clear
        myList.clear();
        System.out.println("myList.clear(): " + myList);

    }
}
