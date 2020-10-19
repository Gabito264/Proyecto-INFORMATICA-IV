package Informatica;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaleTable {
    private Hashtable<Integer, Sale> tableSale;
    private Set<Integer> keys;
    private File file;
    private FileWriter fw;
    private PrintWriter pw;
    private Scanner scan;
    public SaleTable() throws IOException {
        tableSale = new Hashtable<Integer, Sale>();
        keys = tableSale.keySet();
        file = new File("testsales.txt");
        fw = null;
        pw = null;
        scan = new Scanner(file);
    }
    public void add(Sale sale){
        tableSale.put(Integer.valueOf(sale.getTransActionCode()), sale);
    }
    
    public Sale getSale(int code){
        return tableSale.get(Integer.valueOf(code));
    }
    public int getSize(){
        return tableSale.size();
    }
    public void save() throws IOException{
        Sale sale;
        fw = new FileWriter(file);
        pw = new PrintWriter(fw);
        for(Integer key: keys){
            sale = tableSale.get(key);
            pw.print(sale.getDateSold()+"#");
            pw.print(sale.getTransActionCode()+"#");
            Product product = sale.getProduct();
            pw.println(product.getCode());
        }
    }
    public void load(ProductTable table){
        while(scan.hasNext()){
            String x = scan.nextLine();
            String[] data = x.split("#");
            Sale sale = new Sale();
            sale.setSoldProduct(table.getProduct(Integer.parseInt(data[2])));
            String[] day = data[0].split("/");
            int month = Integer.parseInt(day[0]);
            int days = Integer.parseInt(day[1]);
            int year = Integer.parseInt(day[2]);
            sale.setDateSold(year, month,days);
            sale.setTransActionCode(Integer.parseInt(data[1]));
            add(sale);
        }

    }
    public Set<Integer> getKeys(){
        return keys;
    }
    public Hashtable<Integer, Sale> getTable(){
        return tableSale;
    }
    //Investigar
    public void toExcel(){

    }
}
