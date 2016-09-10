package domain;

/**
 * Created by Matyas on 9/2/2016.
 */
public class    Room {
    private int roomNumber;
    private Landlord landlord;
    private Tenant tenant;
    private int squaremeter;
    private double price;
    private String city;
    private boolean rentStatus; // true if rented false if is free

    public Room(int roomNumber, Landlord landlord, int squaremeter, double price, String city, boolean rentStatus) {
        this.roomNumber = roomNumber;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public int getSquaremeter() {
        return squaremeter;
    }

    public double getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public boolean isRentStatus() {
        return rentStatus;
    }
}

