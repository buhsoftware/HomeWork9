package HashMap;

public class MyHashMapTest {
    public static void main(String[] args) {

        MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();

        myHashMap.put("key1", "Text test 1");
        myHashMap.put("key1", "Text test 11");
        myHashMap.put("key1", "Text test 12");
        myHashMap.put("key1", "Text test 13");
        myHashMap.put("key2", "Text test 2");
        myHashMap.put("key3", "Text test 3");
        myHashMap.put("key4", "Text test 4");

        System.out.println("myHashMap (put): " + myHashMap);
        //size
        System.out.println("myHashMap.size() = " + myHashMap.size());
        //get
        System.out.println("myHashMap.get(\"key1\") = " + myHashMap.get("key1"));
        //remove
        myHashMap.remove("key4");
        System.out.println("myHashMap.remove(\"key4\") : " + myHashMap);
        //clear
        myHashMap.clear();
        System.out.println("myHashMap.clear() = " + myHashMap);
    }
}
