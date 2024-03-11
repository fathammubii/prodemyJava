package mainPackage;

import crudPackage.CRUD;//Import abstract CRUD form crudPackage
import crudPackage.FileCRUD;//import FileCRUD (child class CRUD) from crudPackage

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File file = new File("Siswa.txt");//Make file with pathname Siswa
        CRUD crud = new FileCRUD();//Polimorfisme, membuat obj dari FileCRUD Class dengan riferensi(tipe) CRUD class

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Choose operation: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        crud.create(file, scanner);//call method create from obj crud
                        break;
                    case 2:
                        crud.read(file);//call method read from obj crud
                        break;
                    case 3:
                        crud.update(file, scanner);//call method update from obj crud
                        break;
                    case 4:
                        crud.delete(file, scanner);//call method delete from obj crud
                        break;
                    case 5:
                        System.out.println("Program Selesai.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {//Exception for missmatch input
                System.err.println("Error: Masukkan pilihan menu dalam bilangan bulat");
                scanner.nextLine();
            } catch (IOException e) {//exception for IO, for example file does not exist when use method read, update, or delete
                System.err.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}

