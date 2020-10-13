package Informatica;
import java.util.Hashtable;
import java.util.Set;
public class VariableSaleTable {
    private Hashtable<Integer, Product> table;
    private Set<Integer> keys;

    public VariableSaleTable(){
    table = new Hashtable<Integer, Product>();
        keys = table.keySet();
    }
    public void add(Product product){
        table.put(product.getCode(), product);
    }
    public void getProduct(int code){
        table.get(Integer.valueOf(code));
    }
    public void toSaleTable(Hashtable<Integer, Sale> tableSale){
        for(Integer key: keys){
            Sale newSale = new Sale();
            newSale.setSoldProduct(table.get(key));
            newSale.setTransActionCode(tableSale.size());
            tableSale.put(newSale.getTransActionCode(), newSale);
        }
    }
    public Set<Integer> getKeys(){
        return keys;
    }
    public Hashtable<Integer, Product> getTable(){
        return table;
    }
}
