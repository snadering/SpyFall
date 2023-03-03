public class GameCtrl {
    StartMenu startMenu = new StartMenu();
    MainMenu mainMenu = new MainMenu();

    public void run(){

            startMenu.assignLocationAndRoles(startMenu.StartGame(), startMenu.getPlayerAmount());
            mainMenu.infoMenu(startMenu.getListOfPlayers());

    }

}
