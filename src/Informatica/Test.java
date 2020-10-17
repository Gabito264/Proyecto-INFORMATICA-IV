package Informatica;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        Product MGR = new Product();
        MGR.setName("MGR");
        Product MGSV = new Product();
        MGSV.setName("MGSV");
        ProductTable xD = new ProductTable();
        xD.load();
        MGR.setCode(1234);
        xD.add(MGR);
        MGSV.setCode(1236);
        xD.add(MGSV);
        System.out.println(xD.getSize());
        xD.save();

    }
}
