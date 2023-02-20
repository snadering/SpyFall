import java.util.Scanner;

public class TextUI {

    public static void displayMessage(String message){
        System.out.println(message);
    }

    public static String getStringInput(String message){
        Scanner scn = new Scanner(System.in);
        displayMessage(message);
        return scn.next();
    }

    public static void clearConsole(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }
}
