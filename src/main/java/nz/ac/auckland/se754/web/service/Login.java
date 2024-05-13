package nz.ac.auckland.se754.web.service;


public class Login {
    private final Database db;

    public Login(Database db) {
        this.db = db;
    }

    public boolean validateUser(String userID, String password) {
        return password.equals(db.getPassword(userID));
    }

}
