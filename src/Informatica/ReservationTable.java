package Informatica;
import java.util.Hashtable;
import java.util.Set;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class ReservationTable {
    private Hashtable<Integer, Reservation> tableRes;
    private Set<Integer> keys;
    private File file;
    private FileWriter fw;
    private PrintWriter pw;
    private Scanner scan;

    public ReservationTable() throws IOException{
        tableRes = new Hashtable<>();
        keys = tableRes.keySet();
        file = new File("test.txt");
        fw = null;
        pw = null;
        scan = new Scanner(file);
    }
    public void add( Reservation reservation){
        tableRes.put(Integer.valueOf(reservation.getReservationCode()), reservation);
    }
    public void cancel(int code){
        Reservation res = tableRes.get(Integer.valueOf(code));
        res.cancel();
    }
    public Reservation getReservation(int code){
        return tableRes.get(Integer.valueOf(code));
    }
    public int getSize(){
        return tableRes.size();
    }
    public void save() throws IOException{
        Reservation save;
        fw = new FileWriter(file);
        pw = new PrintWriter(fw);
        for(Integer key: keys){
            save = tableRes.get(key);
            pw.print(save.getClientName()+"#");
            pw.print(save.getReservationCode()+"#");
            pw.print(save.getReservationDate()+"#");
            pw.print(save.getCondition()+"#");
            Product svd = save.getWantedProduct();
            pw.println(svd.getCode());
        }
    }
    public void load(ProductTable table){
        while(scan.hasNext()){
            String x = scan.nextLine();
            String[] data = x.split("#");
            Reservation res = new Reservation();
            String cName = data[0];
            int rCode = Integer.parseInt(data[1]);
            String[] day = data[2].split("/");
            int month = Integer.parseInt(day[0]);
            int days = Integer.parseInt(day[1]);
            int year = Integer.parseInt(day[2]);
            boolean condition = Boolean.parseBoolean(data[3]);
            Product product = table.getProduct(Integer.parseInt(data[4]));
            res.setClientName(cName);
            res.setReservationCode(rCode);
            res.setReservationDate(year, month, days);
            res.setWantedProduct(product);
            if(condition = false){
                res.cancel();
            }
            add(res);
        }
    }
}
