package uebung_4.tests;

import java.lang.reflect.Field;
import java.util.Random;

import kapitel_3.tests.IntegerComparator;
import kapitel_3.tests.IntegerKey;
import kapitel_3.vl.AVLTree;


class CommonFormat implements ICommonFormat {
    private Class<?> nodeClass = null;
    private Field balance = null;
    
    public CommonFormat() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
        nodeClass = Class.forName("kapitel_3.vl.AVLTree$AVLNode");
        balance = nodeClass.getDeclaredField("balance");
        balance.setAccessible(true);
    }
    
    @Override
    public String nodeFormat(Object node) {
        String format = "";
        
        try {
            try {
                format = "normal node, label={[draw=none]below:\\tiny " + balance.getInt(node) + "}";
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        
        return format;
    }
}


public class TestPGFTreePrinter {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
        
        AVLTree avlTree = new AVLTree(new IntegerComparator());
        PGFTreePrinter ptp = new PGFTreePrinter(avlTree);
        ptp.setCommonFormat(new CommonFormat());
        
        IntegerKey integerKey = new IntegerKey(0);
        
        Random rand = new Random();
        
        int MAX = 15;
        
        for (int i = 0; i < MAX; i++) {
            int n = 0;
            
            do {
                n = rand.nextInt(100);
                integerKey.setKeyValue(n);
            } while (avlTree.search(integerKey) != null);
            
            Integer data = n;
            avlTree.insert(data);
            ptp.format(data);//.setNodeFormat("normal node");
        }
        
        System.out.println(ptp);
    }
}
