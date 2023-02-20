import java.util.ArrayList;

public class StartMenu {
    private ArrayList<String> usernames;


    public StartMenu() {

    }

    public ArrayList<String> StartGame() {
        //To start the game at the bottom of the console.
        TextUI.clearConsole();

        usernames = new ArrayList<>();
        createPlayerNames(amountOfPlayers());

        //Test printing all the player names.
        for (String s : usernames){
            System.out.println(s);
        }



     return usernames;
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
                return 3;
            case "4":
                TextUI.displayMessage("You have successfully chosen 4 players.");
                return 4;
            case "5":
                TextUI.displayMessage("You have successfully chosen 5 players.");
                return 5;

        }
        System.out.println("This is not supposed to happen. (amountOfPlayers)");
        return -1;
    }

    private ArrayList<String> createPlayerNames(int amountOfPlayers){
        String currentName = TextUI.getStringInput("Please enter the name of Player 1: ");
        usernames.add(currentName);
        if (amountOfPlayers > 1){
            currentName = TextUI.getStringInput("Please enter the name of Player 2: ");
            usernames.add(currentName);
        }
        if (amountOfPlayers > 2) {
            currentName = TextUI.getStringInput("Please enter the name of Player 3: ");
            usernames.add(currentName);
        }
        if (amountOfPlayers > 3) {
            currentName = TextUI.getStringInput("Please enter the name of Player 4: ");
            usernames.add(currentName);
        }
        if (amountOfPlayers > 4) {
            currentName = TextUI.getStringInput("Please enter the name of Player 5: ");
            usernames.add(currentName);
        }
        return usernames;
    }

}
