package utils;

public class StringUtils {
    public static String getNickName(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length == 1) {
            return parts[0]; // satu kata
        } else {
            return parts[1]; // lebih dari satu kata, ambil kata kedua
        }
    }
}
