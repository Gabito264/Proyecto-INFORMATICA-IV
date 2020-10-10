package Informatica;
import java.util.Hashtable;
import java.util.Set;
public class SaleTable {
    private Hashtable<Integer, Sale> tableSale;
    private Set<Integer> keys;
    public SaleTable(){
        tableSale = new Hashtable<Integer, Sale>();
        keys = tableSale.keySet();

    }
    public void add(Sale sale){
        tableSale.put(Integer.valueOf(sale.getTransActionCode()), sale);
    }
    public void remove(Sale sale){
        tableSale.remove(sale.getTransActionCode());
    }
    public Sale getSale(int code){
        return tableSale.get(Integer.valueOf(code));
    }
    public int getSize(){
        return tableSale.size();
    }
    public void save(){

    }
    public void load(){

    }
}
