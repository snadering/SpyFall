public class Player {
    private String name;
    private boolean isSpy;
    private String location;
    private String role;

    public Player(String name, boolean isSpy, String location, String role) {
        this.name = name;
        this.isSpy = isSpy;
        this.location = location;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public boolean isSpy() {
        return isSpy;
    }

    public void setSpy(boolean spy) {
        isSpy = spy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", isSpy=" + isSpy +
                ", location='" + location + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
