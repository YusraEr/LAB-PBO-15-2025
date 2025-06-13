package loginapp.utils;

public class StringUtils {
    public static String Nickname(String fullName) {
        String[] nickname = fullName.trim().split("\\s+");
        if (nickname.length == 1) {
            return nickname[0];
        } else {
            return nickname[1];
        }
    }
}