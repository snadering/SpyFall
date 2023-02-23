import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;

public class MainMenu {

    public void infoMenu(ArrayList<Player> players){
        TextUI.clearConsole();
        TextUI.displayMessage("Take turns pressing your own number to see your role and location.");
        for (int i = 0; i < players.size(); i++){
            TextUI.displayMessage(i+1 + ") " + players.get(i).getName());
        }

        String input = TextUI.getStringInput("Pick the number corresponding to you and press 'ENTER'");
        TextUI.clearConsole();
        if (input.trim().equals("1")){
            TextUI.displayMessage("Name: " + players.get(0).getName());
            TextUI.displayMessage("Role: " + players.get(0).getRole());
            TextUI.displayMessage("Location: " + players.get(0).getLocation());
        } else if (input.trim().equals("2")){
            TextUI.displayMessage("Name: " + players.get(1).getName());
            TextUI.displayMessage("Role: " + players.get(1).getRole());
            TextUI.displayMessage("Location: " + players.get(1).getLocation());
        } else if (input.trim().equals("3")){
            TextUI.displayMessage("Name: " + players.get(2).getName());
            TextUI.displayMessage("Role: " + players.get(2).getRole());
            TextUI.displayMessage("Location: " + players.get(2).getLocation());
        } else if (input.trim().equals("4")){
            TextUI.displayMessage("Name: " + players.get(3).getName());
            TextUI.displayMessage("Role: " + players.get(3).getRole());
            TextUI.displayMessage("Location: " + players.get(3).getLocation());
        } else if (input.trim().equals("5")){
            TextUI.displayMessage("Name: " + players.get(4).getName());
            TextUI.displayMessage("Role: " + players.get(4).getRole());
            TextUI.displayMessage("Location: " + players.get(4).getLocation());
        }
        TextUI.displayMessage("");
        TextUI.getStringInput("Press 'B' to go back.");
        infoMenu(players);

    }

}
