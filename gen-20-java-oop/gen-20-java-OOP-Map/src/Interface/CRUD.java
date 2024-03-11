package Interface;

import Product.Product;

import java.util.Map;
import java.util.Scanner;

public interface CRUD {//Interface CRUD
    void create(Map<Integer, Product> map, Scanner scanner);//create method dalam interface

    void read(Map<Integer, Product> map);//read method dalam interface

    void update(Map<Integer, Product> map, Scanner scanner);//Update method dalam interface

    void delete(Map<Integer, Product> map, Scanner scanner);
}
