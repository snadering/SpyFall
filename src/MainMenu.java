import java.util.Random;

public class MainMenu {

    public void assignLocationAndRoles(int amountOfPlayers) {
        Random rnd = new Random();
        //Picking a random locationID from amount of locations available in the DB
        int locationID = rnd.nextInt(10);
        locationID++;

        int spy = rnd.nextInt(amountOfPlayers);
        //System.out.println(spy+1);
        System.out.println(DatabaseIO.getLocation(locationID));

    }

}
