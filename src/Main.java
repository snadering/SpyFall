import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GameCtrl game = new GameCtrl();
        MainMenu mainMenu = new MainMenu();
        mainMenu.assignLocationAndRoles(5);


      /*
        for (String s : db.getLocations()) {
            System.out.println(s);
        }
        for (String s : db.getRoles(3)) {
            System.out.println(s);
        }

       */
        //game.run();
    }
}