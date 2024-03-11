import java.util.Scanner;

public class throw_e_input {
    private int[] data;

    //konstruktor kelas
    public throw_e_input (int[] data) {
        this.data = data;
    }

    public void processData() {
        System.out.println("Data berhasil diproses: " + data.length);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int length;
        do {
            System.out.print("Masukkan banyak data (Positif): ");
            length = scan.nextInt();
        } while (length <=0);

        int[] input = new int[length];
        System.out.println("\nMasukkan data (Positif) : ");
        for (int i=0; i<length; i++){
            System.out.printf("Data ke-%d : ",i);
            input[i] = scan.nextInt();
        }

        scan.close();

        try {
            DataValidator.validateInput(input);//call method
            throw_e_input data = new throw_e_input(input);//make new obj
            data.processData();//call method
        } catch (IllegalArgumentException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public static class DataValidator {
        public static void validateInput(int[] data) throws IllegalArgumentException {//exception saat argumen yang dimasukkan kedalam method tidak sesuai dengan yang diharapkan/kesalahan argumen pada method
            if (data == null || data.length == 0) {// jika data null atau data = 0
                throw new IllegalArgumentException("Data tidak boleh kosong");
            }
            for (int num : data) {//for each loop, num menyimpan nilai sementara dlm array data
                if (num < 0) {//jika terdapat data negatif dalam element array
                    throw new IllegalArgumentException("Data tidak boleh negatif");
                }
            }
        }
    }
}

