import java.util.Scanner;

public class TP1_1_H071241077 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan Judul Film : ");
        String input = scanner.nextLine();
        
        System.out.println(toTitleCase(input));
        
        scanner.close();
    }

    public static String toTitleCase(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        return result.toString().trim();
    }
}
