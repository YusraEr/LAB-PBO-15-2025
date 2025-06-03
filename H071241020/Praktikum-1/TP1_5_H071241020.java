package TP_1;

import java.util.Scanner;

public class TP1_5_H071241020 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        if (isPasswordValid(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        scanner.close();
    }public static boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            }else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            }else if (Character.isDigit(c)) {
                adaAngka = true;
            }if (adaHurufBesar && adaHurufKecil && adaAngka) {
                break;
            }
        }return adaHurufBesar && adaHurufKecil && adaAngka;
    } 
}
