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
        fw = new FileWriter(file, true);
        pw = new PrintWriter(fw);
        scan = new Scanner(file);
    }
    public void add( Product product){
        tableProduct.put(Integer.valueOf(product.getCode()), product);

    }
    public void remove(Product product){
        tableProduct.remove(Integer.valueOf(product.getCode()));
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
            System.out.println("pato");
        }
    }
}
