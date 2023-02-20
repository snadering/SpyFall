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

    public String getLocation() {
        return location;
    }

    public String getRole() {
        return role;
    }
}
