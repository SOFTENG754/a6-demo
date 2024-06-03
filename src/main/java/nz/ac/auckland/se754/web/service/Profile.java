package nz.ac.auckland.se754.web.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profile {
    private final Database db;
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

    public Profile(Database db) {
        this.db = db;
    }

    public Boolean validateUsername(String username) {
        boolean isUsernameTaken = db.checkUsernameExists(username);

        Matcher matcher = pattern.matcher(username);
        boolean isValidUsername = matcher.matches();

        return !isUsernameTaken && isValidUsername;

    }
}
