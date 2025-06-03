import java.util.Scanner;

public class Nomor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String input = scanner.nextLine();
        String output = capitalizeEachWord(input);
        System.out.println(output); }

    public static String capitalizeEachWord(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        String[] words = str.split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return result.toString().trim();
    }
    
}