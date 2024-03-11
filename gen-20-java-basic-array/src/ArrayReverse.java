import java.util.Scanner;
import java.util.Arrays;

public class ArrayReverse {
    private int[] array1D;
    private int[][] array2D;

    // Konstruktor untuk array 1 dimensi
    public ArrayReverse(int[] array1D) {
        this.array1D = array1D;
    }

    // Konstruktor untuk array 2 dimensi
    public ArrayReverse(int[][] array2D) {
        this.array2D = array2D;
    }

    // Method untuk membalikkan array 1 dimensi
    public void reverseArray1D() {
        int length = array1D.length;// mengukur panjang array
        for (int i = 0; i < length / 2; i++) {// looping berlangsung untuk setengah array, menukar elemen dari ujung yang berlawanan
            int temp = array1D[i];// menyimpan array pada indeks i dalam variabel sementara temp
            array1D[i] = array1D[length - 1 - i];// menukar elemen pada indeks i dengan elemen pada indeks yang akhir
            array1D[length - 1 - i] = temp;// menaruh nilai yang sebelumnya di temp ke elemen pada indeks akhir
        }
    }

    // Method untuk membalikkan array 2 dimensi
    public void reverseArray2D() {
        for (int[] row : array2D) {
            reverseArray1D(row);
        }
    }

    // Method untuk membalikkan array 1 dimensi (digunakan dalam array 2 dimensi)
    private void reverseArray1D(int[] array) {//method menggunakan parameter array per 1 dimensi
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }

    // Method untuk menampilkan array 1 dimensi
    public void displayArray1D(String text) {
        System.out.println(text + Arrays.toString(array1D));
    }

    // Method untuk menampilkan array 2 dimensi
    public void displayArray2D() {
        for (int[] row : array2D) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih tipe array:");
        System.out.println("1. Array 1 Dimensi");
        System.out.println("2. Array 2 Dimensi");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Masukkan jumlah elemen array 1 dimensi: ");
            int length = scanner.nextInt();
            int[] array1D = new int[length];
            for (int i = 0; i < length; i++) {
                System.out.print("Masukkan elemen-elemen array 1 dimensi ke-"+i+": ");
                array1D[i] = scanner.nextInt();
            }
            ArrayReverse reversal = new ArrayReverse(array1D);
            reversal.displayArray1D("Array sebelum reverse: ");
            reversal.reverseArray1D();
            reversal.displayArray1D("Array setelah reverse: ");
        }

        else if (choice == 2) {
            System.out.print("Masukkan jumlah baris array 2 dimensi: ");
            int rows = scanner.nextInt();
            System.out.print("Masukkan jumlah kolom array 2 dimensi: ");
            int columns = scanner.nextInt();
            int[][] array2D = new int[rows][columns];
            //System.out.println("Masukkan elemen-elemen array 2 dimensi:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("Masukkan elemen-elemen array 2 dimensi baris ke-"+i+" kolom ke-"+j+": ");
                    array2D[i][j] = scanner.nextInt();
                }
            }
            ArrayReverse reversal = new ArrayReverse(array2D);
            System.out.println("Array sebelum dibalik : ");
            reversal.displayArray2D();
            System.out.println("Array sesudah dibalik : ");
            reversal.reverseArray2D();
            reversal.displayArray2D();
        }

        else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
