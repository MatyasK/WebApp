
import users.Landlord;
import users.Tenant;
import users.User;

import java.util.ArrayList;

/**
 * Created by Matyas on 9/2/2016.
 */
public class DataModel {


    private ArrayList<User> users;
    private ArrayList<Room> rooms;


    public DataModel(){
        users = new ArrayList<>();
        rooms = new ArrayList<>();
    }



    public void addTenant(Tenant tenant){
        users.add(tenant);
    }

    public void addLandlord(Landlord landlord){
        users.add(landlord);
    }
    public void addRoom(int id,  Landlord landlord, int squaremater, double price, String city ){
        rooms.add(new Room(id,landlord,squaremater,price,city,false));
    }


}
