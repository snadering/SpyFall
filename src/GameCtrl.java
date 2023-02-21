public class GameCtrl {
    StartMenu startMenu = new StartMenu();
    MainMenu mainMenu = new MainMenu();

    public void run(){
        mainMenu.assignLocationAndRoles(startMenu.StartGame(), startMenu.getPlayerAmount());
    }

}
