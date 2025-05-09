package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");
        int selectMenu = sc.nextInt();
        sc.nextLine();

        switch (selectMenu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
                break;
            default:
                runApp();
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");

        int attempts = 3;
        while (attempts > 0) {
            System.out.println("Masukkan Username");
            System.out.print("> ");
            String username = sc.nextLine();

            int userIndex = -1;
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getUsername().equals(username)) {
                    userIndex = i;
                    break;
                }
            }

            if (userIndex != -1) {
                System.out.println("Password");
                System.out.print("> ");
                String password = sc.nextLine();
                boolean isPasswordMatch = listUser.get(userIndex).isPasswordCorrect(password);

                if (isPasswordMatch) {
                    System.out.println("Berhasil Login");
                    showDetailUser(listUserProfile.get(userIndex));
                    System.exit(0);
                } else {
                    System.out.println("Password Salah");
                }
            } else {
                System.out.println("Username tidak ditemukan.");
            }

            attempts--;
            System.out.println("Sisa percobaan: " + attempts);
        }

        System.out.println("Gagal Login! Silakan coba lagi nanti.");
        runApp();
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username = "";
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }

            boolean isDuplicate = false;
            for (User user : listUser) {
                if (user.getUsername().equals(username)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Username sudah digunakan!");
            } else {
                break;
            }
        }

        String password = "";
        while (true) {
            System.out.println("Password (minimal 8 karakter)");
            System.out.print("> ");
            password = sc.nextLine();

            if (password.length() < 8) {
                System.out.println("Password harus minimal 8 karakter!");
            } else {
                break;
            }
        }

        User user = new User(username, password);
        Profile profile = new Profile();

        String fullName = "";
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine().trim();
            if (!fullName.isEmpty())
                break;
            System.out.println("Nama lengkap tidak boleh kosong!");
        }

        int age = -1;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                sc.nextLine(); // consume newline
                if (age > 0)
                    break;
            } else {
                sc.nextLine(); // clear input
            }
            System.out.println("Masukkan umur yang valid!");
        }

        String hobby = "";
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine().trim();
            if (!hobby.isEmpty())
                break;
            System.out.println("Hobby tidak boleh kosong!");
        }

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setNickName(StringUtils.getNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);

        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("=======================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("=======================");
        profile.showProfile();
    }
}
