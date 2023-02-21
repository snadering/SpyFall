import java.sql.*;
import java.util.ArrayList;

public class DatabaseIO {

    private Connection connection;
    private String url;
    private String name;
    private String password;

    public DatabaseIO(String url, String name, String password) {
        this.url = url;
        this.name = name;
        this.password = password;
    }

    public ArrayList<String> getLocations() {
        establishConnection();
        String query = "SELECT SpyFallDatabase.Locations.Name FROM SpyFallDatabase.Locations;";
        ArrayList<String> listOfLocations = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOfLocations.add(resultSet.getString("Name"));
            }
        } catch (SQLException SQLE) {
            System.out.println(SQLE);
        }
        return listOfLocations;
    }

    public ArrayList<String> getRoles(int locationID) {
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

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
