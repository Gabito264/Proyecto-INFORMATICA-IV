package Informatica;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Sale {
    private Product soldProduct;
    private Date dateSold;
    private int transactionCode;
    private SimpleDateFormat format;

    public Sale(){
        dateSold = new Date();
        format = new SimpleDateFormat("MM/dd/yyyy");
        transactionCode=0;
        soldProduct = null;
    }
    public void setSoldProduct(Product newProduct){
        soldProduct = newProduct;
    }
    public Product getProduct(){
        return soldProduct;
    }
    public String getDateSold(){
        return format.format(dateSold);
    }
    public void setDateSold(int year, int month, int day){
        dateSold.setYear(year-1900);
        dateSold.setDate(day);
        dateSold.setMonth(month-1);
    }
    public int getTransActionCode(){
        return transactionCode;
    }
    public void setTransActionCode(int newCode) {
        transactionCode = newCode;
    }

}
