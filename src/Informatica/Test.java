package Informatica;

import java.io.IOException;
import java.util.Hashtable;
public class Test {
    public static void main(String[] args) throws IOException {

        
        ProductTable xD = new ProductTable();
        xD.load();
        ReservationTable w = new ReservationTable();
        w.load(xD);
        Reservation test = new Reservation();
        test.setCode(w.getSize());
        test.setClientName("Armando Roque");
        System.out.println(test.getClientName());
        System.out.println(test.getReservationCode());
        test.setWantedProduct(xD.getProduct(1349));
        w.add(test);
        Hashtable<Integer, Reservation> x = w.getTable();
        w.save();
        

    }
}
