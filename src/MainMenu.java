import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;

public class MainMenu {

    public void infoMenu(ArrayList<Player> players){
        TextUI.clearConsole();
        TextUI.displayMessage("Take turns pressing your own number to see your role and location.");
        for (int i = 0; i < players.size(); i++){
            TextUI.displayMessage(i+1 + ") " + players.get(i).getName());
        }

        String input;
        do {
                input = TextUI.getStringInput("Pick the number corresponding to you and press 'ENTER'");
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"));
        TextUI.clearConsole();
        if (input.trim().equals("1")){
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Name: " + players.get(0).getName() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Role: " + players.get(0).getRole() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Location: " + Color.ANSI_RESET + players.get(0).getLocation());
        } else if (input.trim().equals("2")){
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Name: " + players.get(1).getName() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Role: " + players.get(1).getRole() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Location: " + Color.ANSI_RESET + players.get(1).getLocation());
        } else if (input.trim().equals("3")){
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Name: " + players.get(2).getName() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Role: " + players.get(2).getRole() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Location: " + Color.ANSI_RESET + players.get(2).getLocation());
        } else if (input.trim().equals("4")){
            if (players.size() < 4) infoMenu(players);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Name: " + players.get(3).getName() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Role: " + players.get(3).getRole() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Location: " + Color.ANSI_RESET + players.get(3).getLocation());
        } else if (input.trim().equals("5")){
            if (players.size() < 5) infoMenu(players);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Name: " + players.get(4).getName() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Role: " + players.get(4).getRole() + " " + Color.ANSI_RESET);
            TextUI.displayMessage(Color.ANSI_BLACK_BACKGROUND + " Location: " + Color.ANSI_RESET + players.get(4).getLocation());
        }
        TextUI.displayMessage("");
        TextUI.getStringInput(Color.ANSI_BLACK_BACKGROUND + "Press 'B' to go back." + Color.ANSI_RESET);
        infoMenu(players);

    }

}
