package Informatica;
import java.util.Hashtable;
import java.util.Set;
public class ReservationTable {
    private Hashtable<Integer, Reservation> tableRes;
    private Set<Integer> keys;
    public ReservationTable(){
        tableRes = new Hashtable<>();
        keys = tableRes.keySet();
    }
    public void add( Reservation reservation){
        tableRes.put(Integer.valueOf(reservation.getReservationCode()), reservation);
    }
    public void remove(Reservation reservation){
        tableRes.remove(reservation.getReservationCode());
    }
    public Reservation getReservation(int code){
        return tableRes.get(Integer.valueOf(code));
    }
    public int getSize(){
        return tableRes.size();
    }
    public void save(){

    }
    public void load(){

    }
}
