package Informatica;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Product {
    private String name;
    private Date releaseDate;
    private int ammount;
    private int code;
    private double price;
    private int reservations;
    private SimpleDateFormat format;
    public Product(){
        name= "";
        format = new SimpleDateFormat("MM/dd/YYYY");
        releaseDate = new Date();
        ammount = 0;
        price = 0;
        reservations =0;
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
    public int getAmmount(){
        return ammount;
    }
    public void setAmmount(int newAmmount){
        ammount = newAmmount;
    }
    public void upAmmount(){
        ammount++;
    }
    public void downAmmount(){
        ammount--;
    }
    public String getReleaseDate(){
        return format.format(releaseDate);
    }
    public void setReleaseDate(int year, int month, int day){
        releaseDate.setYear(year-1900);
        releaseDate.setDate(day);
        releaseDate.setMonth(month-1);
    }
    //el código va a ser el size del hash table, ya que cambia
    public int getCode(){
        return code;
    }
    public void setCode(int newCode){
        code = newCode;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double newPrice){
        price = newPrice;
    }
    public int getReservations(){
        return reservations;
    }
    public void addReservations(){
        reservations++;
    }
    public void minusReservations(){
        reservations--;
    }

}
