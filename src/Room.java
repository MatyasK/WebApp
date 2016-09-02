import users.Landlord;
import users.Tenant;

/**
 * Created by Matyas on 9/2/2016.
 */
public class Room {
    private int ID;
    private Landlord landlord;
    private Tenant tenant;
    private int squaremeter;
    private double price;
    private String city;
    private boolean rentStatus;

    public Room(int ID, Landlord landlord, int squaremeter, double price, String city, boolean rentStatus) {
        this.ID = ID;
        this.landlord = landlord;
        this.squaremeter = squaremeter;
        this.price = price;
        this.city = city;
        this.rentStatus = rentStatus;
    }

    public void addTenant(Tenant tenant){
        rentStatus = true;
        this.tenant = tenant;

    }
}

