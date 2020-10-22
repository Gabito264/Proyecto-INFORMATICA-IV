package Informatica;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Reservation {
    private String clientName;
    private Date reservationDate;
    private Product wantedProduct;
    private int reservationCode;
    private SimpleDateFormat format;
    boolean condition;

    public Reservation(){
        clientName= "";
        format = new SimpleDateFormat("MM/dd/YYYY");
        reservationDate = new Date();
        condition = true;
        wantedProduct = null;
    }
    public void setReservationCode(int newCode){
        reservationCode = newCode;
    }
    public int getReservationCode(){
        return reservationCode;
    }
    public String getReservationDate(){

        return format.format(reservationDate);
    }
    public void setReservationDate(int year, int month, int day){
        reservationDate.setYear(year-1900);
        reservationDate.setDate(day);
        reservationDate.setMonth(month-1);
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
    public boolean getCondition(){
        return condition;
    }
    public void setCode(int code) {
    	reservationCode = code;
    }
    public void cancel(){
        condition = false;
    }
}
