import java.util.InputMismatchException;
import java.util.Scanner;

public class MainOOP {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Food foodProduct = null;
        Drink drinkProduct = null;
        Medicine medicineProduct = null;

        menu(scanner, foodProduct, drinkProduct, medicineProduct);

        System.out.println("Program telah berakhir");

        scanner.close();

    }

    public static void menu(Scanner scanner, Product foodProduct, Product drinkProduct, Product medicineProduct){

        boolean inputValid = false;

        while (!inputValid){
            try {
                System.out.print("Pilih Kategori Product : \n1. Makanan\n2. Minuman\n3. Obat\n4. Exit\nKategori : ");
                int category = scanner.nextInt();
                scanner.nextLine();

                switch (category){
                    case 1 :
                        foodProduct = Food.inputProduct(scanner);
                        Food.displayProduct(foodProduct);
                        break;
                    case 2 :
                        drinkProduct = Drink.inputProduct(scanner);
                        Drink.displayProduct(drinkProduct);
                        break;
                    case 3 :
                        medicineProduct = Medicine.inputProduct(scanner);
                        Medicine.displayProduct(medicineProduct);
                        break;
                    case 4 :
                        inputValid = true;
                    default:
                        System.out.println("Pilihan tidak ada");
                        break;
                }
            }catch (InputMismatchException e){
                System.err.println("Input yang anda masukkan tidak sesuai format");
                scanner.nextLine();
            }
        }

    }

}
