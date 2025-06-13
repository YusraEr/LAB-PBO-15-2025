package login_app.utils;

public class StringUtils {
    public static String getNickName(String fullName) {
        fullName = fullName.trim();
        
        int spaceIndex = fullName.indexOf(" ");

        if (spaceIndex == -1) {
            return fullName; 
        } else {
            return fullName.substring(0, spaceIndex);
        }
    }
}
