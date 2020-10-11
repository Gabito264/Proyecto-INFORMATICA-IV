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
        xD.remove(3421);
        MGR.setCode(2459);
        xD.add(MGR);
        MGSV.setCode(1246);
        xD.add(MGSV);
        System.out.println(xD.getSize());
        xD.save();

    }
}
