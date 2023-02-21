import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.Random;

public class MainMenu {

    public void assignLocationAndRoles(ArrayList<Player> players, int amountOfPlayers) {
        System.out.println("ASSIGN LOCATION AND ROLES");
        Random rnd = new Random();
        //Picking a random locationID from amount of locations available in the DB
        int locationID = rnd.nextInt(DatabaseIO.getNumberOfLocations());
        locationID++;

        int spy = rnd.nextInt(amountOfPlayers);
        spy++;
        players.get(spy).setSpy(true);


        //TODO Set a random person to be spy.

        //Putting the location in a variable, to make sure all players get the same location.
        String location = DatabaseIO.getLocation(locationID);

        for (Player p : players){
            if (!p.isSpy()){
                p.setLocation(location);
            }
        }

        for (Player p : players){
            System.out.println(p);
        }
    }

}
