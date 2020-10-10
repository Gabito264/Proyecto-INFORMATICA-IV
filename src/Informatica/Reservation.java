package Informatica;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Reservation {
    private String clientName;
    private Date reservationDate;
    private Product wantedProduct;
    private int reservationCode;
    private SimpleDateFormat format;

    public Reservation(){
        clientName= "";
        format = new SimpleDateFormat("MM/dd/YYYY");
        reservationDate = new Date();
    }
    //igual que en Product
    public void setReservationCode(int newCode){
        reservationCode = newCode;
    }
    public int getReservationCode(){
        return reservationCode;
    }
    public String getReservationDate(){

        return format.format(reservationDate);
    }
    public Product getWantedProduct(){
        return wantedProduct;
    }
    public void setWantedProduct(Product newProduct){
        wantedProduct = newProduct;
    }
    public String getClientName(){
        return clientName;
    }
    public void setClientName(String newClientName){
        clientName = newClientName;
    }
}
