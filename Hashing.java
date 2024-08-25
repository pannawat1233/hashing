package com.mycompany.hashing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hashing {

    public static void display(int[] hashTable) {
        System.out.println("   Index   Key   ");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.printf("   %d       %d\n", i, hashTable[i]);
        }
    }

    public static int hash(int key, int size) {
        return key % size;
    }

    public static void main(String[] args) {
        int[] hashTable = new int[11];
        boolean runnable = true;
        Scanner scanner = new Scanner(System.in);

        while (runnable) {
            try {
                System.out.println("Menu");
                System.out.printf(" 1. Insert\n 2. Delete\n 3. Display\n 4. Search\n 5. Delete all\n 6. Exit\n");
                System.out.println("Enter number");
                int choice = scanner.nextInt();
                int key;

                switch (choice) {
                    case 1:
                        System.out.println("Enter the data");
                        key = scanner.nextInt();
                        insert(key, hashTable);
                        break;
                    case 2:
                        System.out.println("Enter the data");
                        key = scanner.nextInt();
                        delete(key, hashTable);
                        break;
                    case 3:
                        display(hashTable);
                        break;
                    case 4:
                        System.out.println("Enter the data");
                        key = scanner.nextInt();
                        search(key, hashTable);
                        break;
                    case 5:
                        deleteAll(hashTable);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        runnable = false;
                        break;
                    default:
                        System.out.println("Wrong choice, please input a number between 1 - 6 only!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }
        scanner.close();
    }

    public static void insert(int key, int[] hashTable) {
        int index = hash(key, hashTable.length);
        if (hashTable[index] == 0) {
            hashTable[index] = key;
            System.out.println("Inserted data: " + key + " at index " + index);
        } else {
            System.out.println("Index " + index + " is already occupied.");
        }
    }

    public static void delete(int key, int[] hashTable) {
        int index = hash(key, hashTable.length);
        if (hashTable[index] == key) {
            hashTable[index] = 0;
            System.out.println("Deleted data: " + key + " from index " + index);
        } else {
            System.out.println("Data not found at index " + index);
        }
    }

    public static void search(int key, int[] hashTable) {
        int index = hash(key, hashTable.length);
        if (hashTable[index] == key) {
            System.out.println("Data " + key + " found at index " + index);
        } else {
            System.out.println("Data " + key + " not found");
        }
    }

    public static void deleteAll(int[] hashTable) {
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = 0;
        }
        System.out.println("All data deleted.");
    }
}
