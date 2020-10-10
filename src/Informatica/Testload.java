package Informatica;

import java.io.IOException;

public class Testload {
    public static void main(String[] args) throws IOException {
    ProductTable xD = new ProductTable();
    xD.load();
    System.out.println(xD);
    }
}
