package UserAdmin;

public class User {
    private int id;
    private String name;
    private String password;

    public User (int id ) {
       setId();
    }

    public User (int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password= password;
    }

    public void setId () {
        this.id = id;
    }

    public int getId () {
        return id;
    }
    void setName(String name) {
        this.name = name;   }

    String getName() { return name;   }

    void setPassword(String password) {
        this.password = password;   }
    String getPassword() {
        return password;   }

    public String toString()
    { return "ID: " + getId() + " | Name: " + getName() + " | Password: " + getPassword();   }
}




