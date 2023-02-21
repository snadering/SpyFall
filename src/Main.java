import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GameCtrl game = new GameCtrl();
        DatabaseIO db = new DatabaseIO("jdbc:mysql://localhost:3306/SpyFallDatabase?serverTimezone=CET&useSSL=false", "root", "K!ro1171");

        for (String s : db.getLocations()) {
            System.out.println(s);
        }
        for (String s : db.getRoles(3)) {
            System.out.println(s);
        }
        //game.run();
    }
}