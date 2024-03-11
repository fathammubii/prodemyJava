package Interface;

import Product.Product;//Import class product in package product

import java.util.Map;//Import map
import java.util.Scanner;

public class MapCRUD implements CRUD {//MapCRUD sebagai child class CRUD

    @Override
    public void create(Map<Integer, Product> map, Scanner scanner) {// create Method, Map obj dan scanner param

        try {//try exception
            System.out.print("Enter new product ID: ");
            int id = scanner.nextInt();//input user ID
            scanner.nextLine();

            if (map.containsKey(id)) {//jika dalam map terdapat key (id)
                System.out.println("Product with ID " + id + " already exists");
            } else {
                System.out.print("Enter the name for ID " + id + ": ");
                String name = scanner.nextLine();//Input nama
                map.put(id, new Product(id, name));//new obj Product (id, name)
                System.out.println("Data successfully added.");
            }
        } catch (RuntimeException e) {//catch exception, Runtime error e.g. missmatch input
            System.err.println("ID yang Anda Masukkan tidak sesuai Format");
            scanner.nextLine();//clean buffer
        }

    }

    @Override
    public void read(Map<Integer, Product> map) {//Read method, Map obj param
        System.out.println("Data dalam Map:");
        if (map.isEmpty()){//method is empty map
            System.err.println("Data masih kosong");
        }else {//jika ada data dalam map
            for (Map.Entry<Integer, Product> entry : map.entrySet()) {//for each, Map Entry (Key, Value) obj, use method entrySet()
                System.out.println("ID: " + entry.getValue().getId() + ", Name: " + entry.getValue().getName());//Get key(id), get name mathod from Product Class
            }
        }
    }

    @Override
    public void update(Map<Integer, Product> map, Scanner scanner) {//method update param map obj, dan scanner
        try {//try exception
            System.out.print("Enter the ID to update: ");
            int id = scanner.nextInt();// user input id
            scanner.nextLine();

            if (!map.containsKey(id)) {// id doesn't contain in map
                System.out.println("Product with ID " + id + " does not exist");
            } else {//id contain in map
                System.out.print("Enter the new name for ID " + id + ": ");//input new name on ID
                String name = scanner.nextLine();//user Input name
                map.get(id).setName(name);//method map.getId than product set name (name)
                System.out.println("Data successfully updated.");
            }
        } catch (RuntimeException e) {//catch exception, Runtime error e.g. missmatch input
            System.err.println("ID yang Anda Masukkan tidak sesuai Format");
            scanner.nextLine();
        }
    }

    @Override
    public void delete(Map<Integer, Product> map, Scanner scanner) {//Method delete

        try {//try exception
            System.out.print("Enter the ID to delete: ");
            int id = scanner.nextInt();//user input id
            scanner.nextLine();
            if (!map.containsKey(id)) {//if id doesn't contain in map
                System.out.println("Product with ID " + id + " does not exist");
            } else {//id contain in map
                map.remove(id);//map id remove
                System.out.println("Data successfully deleted.");
            }
        } catch (RuntimeException e) {//catch exception, Runtime error e.g. missmatch input
            System.err.println("ID yang Anda Masukkan tidak sesuai Format");
            scanner.nextLine();
        }
    }
}
