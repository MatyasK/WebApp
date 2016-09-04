
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
        Landlord landlord = new Landlord("matyas","matyas");
        Tenant tenant = new Tenant("eric","eric");
        users.add(landlord);
        users.add(tenant);

        rooms.add(new Room(100,landlord,150,50,"Enschede",true));
        rooms.add(new Room(101,new Landlord("this","this"),150,50,"Enschede",true));
        rooms.add(new Room(102,landlord,150,50,"Enschede",true));
        rooms.add(new Room(103,new Landlord("this","this"),170,70,"Enschede",true));
        rooms.add(new Room(104,landlord,170,70,"Enschede",true));
        rooms.add(new Room(105,new Landlord("this","this"),170,70,"Enschede",true));
        rooms.add(new Room(106,landlord,170,70,"Enschede",true));
    }



    public void addTenant(Tenant tenant){
        users.add(tenant);
    }

    public void addLandlord(Landlord landlord){
        users.add(landlord);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }



}
