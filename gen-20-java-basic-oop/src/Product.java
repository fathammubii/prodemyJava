import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
    protected String name;
    protected String exp;
    protected double price;

    public Product(){

    }

    public Product(String name, String exp, double price){
        this.name = name;
        this.exp = exp;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getExp(){
        return exp;
    }
    public double getPrice(){
        return price;
    }

    public static void displayProduct(Product product){
        System.out.println("Nama : "+product.getName());
        System.out.println("Expired : "+product.getExp());
        System.out.println("Harga : "+product.getPrice()+"\n");
    }

    public static Product inputProduct(Scanner scanner){

        System.out.println("\nMasukkan informasi product:");
        System.out.print("Nama Product : ");
        String productName = scanner.nextLine();

        System.out.print("Tanggal Expired : ");
        String productExp = scanner.nextLine();

        System.out.print("Harga (Bilangan Bulat) : ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine();

        return new Product(productName, productExp, productPrice);

    }
}
