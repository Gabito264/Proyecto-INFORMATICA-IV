package Informatica;
import java.util.Date;
public class Sale {
    private Product soldProduct;
    private Date dateSold;
    private int transactionCode;

    public Sale(){
        dateSold = new Date();
    }
    public void setSoldProduct(Product newProduct){
        soldProduct = newProduct;
    }
    public Product getProduct(){
        return soldProduct;
    }
    public Date getDateSold(){
        return dateSold;
    }
    public int getTransActionCode(){
        return transactionCode;
    }
    //igual que en Product
    public void setTransActionCode(int newCode) {
        transactionCode = newCode;
    }

}
