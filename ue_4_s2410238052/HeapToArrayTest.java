package ue_4_s2410238052;

import java.util.Arrays;

public class HeapToArrayTest {
    
    public static void main(String[] args) {
            
        Heap h = new Heap();
        
        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(1);
        h.insert(7);
        h.insert(2);

        Object[] arr = h.toArray();

        System.out.println(Arrays.toString(arr));
    }
}
