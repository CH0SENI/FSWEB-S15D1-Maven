package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== GROCERY APP ===");

        while (running) {
            System.out.println("Lütfen seçim yapınız:");
            System.out.println("0 - Uygulamayı durdur");
            System.out.println("1 - Ürün ekle");
            System.out.println("2 - Ürün çıkar");
            System.out.println("Seçiminiz: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    System.out.println("Uygulama durduruluyor");
                    running = false;
                    break;

                case "1":
                    System.out.println("Eklemek istediğiniz ürün(leri) giriniz (örnek: tomato, orange, peach): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;

                case "2":
                    System.out.print("Çıkarmak istediğiniz ürün(leri) giriniz (örnek: tomato, orange, peach): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;

                default:
                    System.out.println("Geçersiz seçim! Lütfen 0, 1 veya 2 giriniz.");
            }
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String rawItem : items) {
            String item = rawItem.trim().toLowerCase();
            if (!item.isEmpty()) {
                if (!checkItemIsInList(item)) {
                    groceryList.add(item);
                    System.out.println(item + " listeye eklendi.");
                } else {
                    System.out.println(item + " zaten listede mevcut!");
                }
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String rawItem : items) {
            String item = rawItem.trim().toLowerCase();
            if (!item.isEmpty()) {
                if (checkItemIsInList(item)) {
                    groceryList.remove(item);
                    System.out.println(item + " listeden çıkarıldı.");
                } else {
                    System.out.println(item + " listede bulunamadı!");
                }
            }
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.toLowerCase().trim());
    }

    public static void printSorted() {
        sortList();
        System.out.println(" Güncel Liste: " + groceryList);
    }

    private static void sortList() {
        Collections.sort(groceryList);
    }

    public static void main(String[] args) {
        startGrocery();
    }
}