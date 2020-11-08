package setandmap;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1,1);
        integerIntegerHashMap.put(2, 1);
        integerIntegerHashMap.put(1, 3);
        System.out.println("integerIntegerHashMap = " + integerIntegerHashMap);
    }
}
