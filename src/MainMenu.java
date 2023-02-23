import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.Random;

public class MainMenu {

    public void infoMenu(ArrayList<Player> players){
        TextUI.clearConsole();
        TextUI.displayMessage("Take turns pressing your own number to see your role and location.");
        for (int i = 0; i < players.size(); i++){
            TextUI.displayMessage(i+1 + ") " + players.get(i).getName());
        }


    }

}
