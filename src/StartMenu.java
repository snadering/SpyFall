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
        players.get(spy).setRole(Color.ANSI_BLACK_BACKGROUND + Color.ANSI_RED + "The Spy " + Color.ANSI_RESET);
        players.get(spy).setLocation(Color.ANSI_BLACK_BACKGROUND + Color.ANSI_RED + "??? " + Color.ANSI_RESET);

        //Putting the location in a variable, to make sure all players get the same location.
        String location = DatabaseIO.getLocation(locationID);


        for (Player p : players){
            if (!p.isSpy()){
                p.setLocation(Color.ANSI_BLACK_BACKGROUND + Color.ANSI_BLUE + location + " " + Color.ANSI_RESET);
            }
        }
        ArrayList<String> roles = DatabaseIO.getRoles(locationID);
        int iterator = 0;
        for (Player p : players) {
            if (!p.isSpy()){
                p.setRole(Color.ANSI_YELLOW + roles.get(iterator++) + " " +  Color.ANSI_RESET);
            }
        }
    }

    private int amountOfPlayers(){
        //Initializing the string, but assigning a key to know if the user has changed the input.
        String amount = "1234567890987654>Z>Z32123456789098765432123456789098765432";
        TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + "Welcome to " + Color.ANSI_BLACK + Color.ANSI_WHITE_BACKGROUND + " SpyFall " + Color.ANSI_RESET);
        do {
            if (!amount.equals("1234567890987654>Z>Z32123456789098765432123456789098765432")){
                TextUI.clearConsole();
                TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + "Sorry '"+ Color.ANSI_RED + amount + Color.ANSI_RESET + Color.ANSI_BLACK_BACKGROUND + "' isn't a valid input" + Color.ANSI_RESET);
            }
        TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + "First select how many players will be playing (3-5 Players)." + Color.ANSI_RESET);
         amount = TextUI.getStringInput(Color.ANSI_BLACK_BACKGROUND + "Amount of players: " + Color.ANSI_RESET);
        } while (!amount.equals("3") && !amount.equals("4") && !amount.equals("5"));

        switch (amount) {
            case "3":
                TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + Color.ANSI_GREEN + "You have successfully chosen 3 players." + Color.ANSI_RESET);
                playerAmount = 3;
                return 3;
            case "4":
                TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + Color.ANSI_GREEN + "You have successfully chosen 4 players." + Color.ANSI_RESET);
                playerAmount = 4;
                return 4;
            case "5":
                TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + Color.ANSI_GREEN + "You have successfully chosen 5 players." + Color.ANSI_RESET);
                 playerAmount = 5;
                return 5;

        }
        return -1;
    }

    private ArrayList<Player> createPlayerNames(int amountOfPlayers){
        String currentName = TextUI.getStringInput(Color.ANSI_BLACK_BACKGROUND + "Please enter the name of Player 1: " + Color.ANSI_RESET);
        Player player1 = new Player(currentName, false, "", "");
        listOfPlayers.add(player1);
        if (amountOfPlayers > 1){
            currentName = TextUI.getStringInput(Color.ANSI_BLACK_BACKGROUND + "Please enter the name of Player 2: " + Color.ANSI_RESET);
            Player player2 = new Player(currentName, false, "", "");
            listOfPlayers.add(player2);
        }
        if (amountOfPlayers > 2) {
            currentName = TextUI.getStringInput(Color.ANSI_BLACK_BACKGROUND + "Please enter the name of Player 3: " + Color.ANSI_RESET);
            Player player3 = new Player(currentName, false, "", "");
            listOfPlayers.add(player3);
        }
        if (amountOfPlayers > 3) {
            currentName = TextUI.getStringInput(Color.ANSI_BLACK_BACKGROUND + "Please enter the name of Player 4: " + Color.ANSI_RESET);
            Player player4 = new Player(currentName, false, "", "");
            listOfPlayers.add(player4);
        }
        if (amountOfPlayers > 4) {
            currentName = TextUI.getStringInput(Color.ANSI_BLACK_BACKGROUND + "Please enter the name of Player 5: " + Color.ANSI_RESET);
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
