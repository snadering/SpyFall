import java.sql.*;
import java.util.ArrayList;

public class DatabaseIO {

    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/SpyFallDatabase?serverTimezone=CET&useSSL=false";
    private static String name = "root";
    private static String password = "K!ro1171";


    public static int getNumberOfLocations(){
        establishConnection();
        String query = "SELECT COUNT(*) FROM SpyFallDatabase.Locations;";
        int result = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        }catch (SQLException SQLE){
            System.out.println(SQLE);
        }
        return result;
    }

    public static String getLocation(int locationID) {
        establishConnection();
        String query = "SELECT SpyFallDatabase.Locations.Name FROM SpyFallDatabase.Locations WHERE LocationID = " + locationID + ";";
        String location = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                location = resultSet.getString("Name");
            }
        } catch (SQLException SQLE) {
            System.out.println(SQLE);
        }
        return location;
    }

    public static ArrayList<String> getRoles(int locationID) {
        establishConnection();
        String query = "SELECT SpyFallDatabase.Roles.Role FROM SpyFallDatabase.Roles WHERE LocationID = " + locationID + ";";
        ArrayList<String> listOfRoles = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                listOfRoles.add(resultSet.getString("Role"));
            }
        } catch (SQLException SQLE) {
            System.out.println(SQLE);
        }
        return listOfRoles;
    }

    private static void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
