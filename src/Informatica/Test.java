package Informatica;

import java.io.IOException;
import java.util.Hashtable;
public class Test {
    public static void main(String[] args) throws IOException {

        
        ProductTable xD = new ProductTable();
        xD.load();
        Product test  = xD.getProduct(1447);
        System.out.println(test.getReleaseDate());
        

    }
}
