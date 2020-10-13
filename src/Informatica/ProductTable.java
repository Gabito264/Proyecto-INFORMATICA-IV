package Informatica;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProductTable {
    private Hashtable<Integer, Product> tableProduct;
    private Set<Integer> keys;
    private File file;
    private FileWriter fw;
    private PrintWriter pw;
    private Scanner scan;

    public ProductTable() throws IOException{
        tableProduct = new Hashtable<Integer, Product>();
        keys = tableProduct.keySet();
        file = new File("test.txt");
        fw = null;
        pw = null;
        scan = new Scanner(file);
    }
    public void add(Product product){
        tableProduct.put(Integer.valueOf(product.getCode()), product);

    }
    public void remove(int code){

        tableProduct.remove(Integer.valueOf(code));
    }
    public int getSize(){
       return tableProduct.size();
    }
    public Product getProduct(int code) {
        return tableProduct.get(Integer.valueOf(code));
    }
    //guardar del objeto al archivo de texto.
    public void save() throws IOException {
        Product save;
        fw = new FileWriter(file);
        pw = new PrintWriter(fw);
        for(Integer key : keys){
            save = tableProduct.get(key);
            pw.print(save.getName()+"#");
            pw.print(save.getPrice()+"#");
            pw.print(save.getAmmount()+"#");
            pw.print(save.getReservations()+"#");
            pw.print(save.getReleaseDate()+"#");
            pw.println(save.getCode());
        }
        pw.close();
    }
    //cargar de los archivos de texto a objetos y luego al hashtable
    public void load(){
        while(scan.hasNext()){
            String x = scan.nextLine();
            String[] data = x.split("#");
            Product product = new Product();
            String name = data[0];
            double price = Double.valueOf(data[1]);
            int ammount = Integer.parseInt(data[2]);
            int reservations = Integer.parseInt(data[3]);
            String[] day = data[4].split("/");
            int month = Integer.parseInt(day[0]);
            int days = Integer.parseInt(day[1]);
            int year = Integer.parseInt(day[2]);
            int code = Integer.parseInt(data[5]);
            product.setName(name);
            product.setPrice(price);
            product.setAmmount(ammount);
            product.setReservations(reservations);
            product.setReleaseDate(year, month, days);
            product.setCode(code);
            add(product);
            
        }
    }
    public Set<Integer> getKeys(){
        return keys;
    }
    public Hashtable<Integer, Product> getTable(){
        return tableProduct;
    }
}
