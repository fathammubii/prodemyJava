package Main;

import Interface.CRUD;//Import CRUD from package Interface
import Interface.MapCRUD;//Import MapCRUD from package Interface
import Product.Product;//Import Product from package Product

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);//Obj scanner for input user
        Map<Integer, Product> map = new HashMap<>();//obj dari Hash Map dengan Map sebagai riferensi dan <int(key), Product>
        CRUD crud = new MapCRUD();//Polimorfisme, membuat obj dari MapCRUD Class dengan riferensi(tipe) CRUD class

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
                        crud.create(map, scanner);//call method create from obj crud
                        break;
                    case 2:
                        crud.read(map);//call method read from obj crud
                        break;
                    case 3:
                        crud.update(map, scanner);//call method update from obj crud
                        break;
                    case 4:
                        crud.delete(map, scanner);//call method delete from obj crud
                        break;
                    case 5:
                        System.out.println("Program Selesai.");
                        scanner.close();
                        System.exit(0);//system exit
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {//Exception for missmatch input
                System.err.println("Error: Masukkan pilihan menu dalam bilangan bulat");
                scanner.nextLine();
            }
        }
    }
}

