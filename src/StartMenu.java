import java.util.ArrayList;
import java.util.Random;

public class StartMenu {
    private ArrayList<Player> listOfPlayers;
    private int playerAmount;


    public StartMenu() {

    }

    public ArrayList<Player> StartGame() {
        //To start the game at the bottom of the console.
        TextUI.clearConsole();

        listOfPlayers = new ArrayList<>();
        createPlayerNames(amountOfPlayers());

        //Test printing all the player names.
        for (Player p : listOfPlayers){
            System.out.println(p);
        }
     return listOfPlayers;
    }

    public void assignLocationAndRoles(ArrayList<Player> players, int amountOfPlayers) {
        Random rnd = new Random();
        //Picking a random locationID from amount of locations available in the DB
        int locationID = rnd.nextInt(DatabaseIO.getNumberOfLocations());
        locationID++;
        //Assigning spy to a random player.
        int spy = rnd.nextInt(amountOfPlayers);
        //spy++;
        players.get(spy).setSpy(true);
        players.get(spy).setRole("The Spy");
        players.get(spy).setLocation("???");

        //Putting the location in a variable, to make sure all players get the same location.
        String location = DatabaseIO.getLocation(locationID);


        for (Player p : players){
            if (!p.isSpy()){
                p.setLocation(location);
            }
        }
        ArrayList<String> roles = DatabaseIO.getRoles(locationID);
        int iterator = 0;
        for (Player p : players) {
            if (!p.isSpy()){
                p.setRole(roles.get(iterator++));
            }
        }
        //TEST - Start -
        for (Player p : players){
            System.out.println(p);
        }
        //TEST - End -
    }

    private int amountOfPlayers(){
        //Initializing the string, but assigning a key to know if the user has changed the input.
        String amount = "1234567890987654>Z>Z32123456789098765432123456789098765432";
        TextUI.displayMessage("Welcome to SpyFall");
        do {
            if (!amount.equals("1234567890987654>Z>Z32123456789098765432123456789098765432")){
                TextUI.clearConsole();
                TextUI.displayMessage("Sorry '" + amount + "' isn't a valid input");
            }
        TextUI.displayMessage("First select how many players will be playing (3-5 Players).");
         amount = TextUI.getStringInput("Amount of players: ");
        } while (!amount.equals("3") && !amount.equals("4") && !amount.equals("5"));

        switch (amount) {
            case "3":
                TextUI.displayMessage("You have successfully chosen 3 players.");
                playerAmount = 3;
                return 3;
            case "4":
                TextUI.displayMessage("You have successfully chosen 4 players.");
                playerAmount = 4;
                return 4;
            case "5":
                TextUI.displayMessage("You have successfully chosen 5 players.");
                 playerAmount = 5;
                return 5;

        }
        System.out.println("This is not supposed to happen. (amountOfPlayers)");
        return -1;
    }

    private ArrayList<Player> createPlayerNames(int amountOfPlayers){
        String currentName = TextUI.getStringInput("Please enter the name of Player 1: ");
        Player player1 = new Player(currentName, false, "", "");
        listOfPlayers.add(player1);
        if (amountOfPlayers > 1){
            currentName = TextUI.getStringInput("Please enter the name of Player 2: ");
            Player player2 = new Player(currentName, false, "", "");
            listOfPlayers.add(player2);
        }
        if (amountOfPlayers > 2) {
            currentName = TextUI.getStringInput("Please enter the name of Player 3: ");
            Player player3 = new Player(currentName, false, "", "");
            listOfPlayers.add(player3);
        }
        if (amountOfPlayers > 3) {
            currentName = TextUI.getStringInput("Please enter the name of Player 4: ");
            Player player4 = new Player(currentName, false, "", "");
            listOfPlayers.add(player4);
        }
        if (amountOfPlayers > 4) {
            currentName = TextUI.getStringInput("Please enter the name of Player 5: ");
            Player player5 = new Player(currentName, false, "", "");
            listOfPlayers.add(player5);
        }
        return listOfPlayers;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }
}
