package domain;

import domain.Landlord;
import domain.Room;
import domain.Tenant;
import domain.User;

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

    /**
     *
     * @param username
     * @return true if the username exist, false if is available
     */
    public Boolean userNameExist(String username){
        boolean exist = false;
        for (User user : users) {
            if (user.getUserName().equals(username)){
                exist = true;
            }
        }
        return exist;
    }



}
