import java.util.Scanner;

public class sum_number_inArray {
    public int[] numbers;

    //konstruktor inisialisasi array
    public sum_number_inArray (int[] numbers){
        this.numbers = numbers;
    }

    //method menjumlah bilangan dalam array
    public int calculateSum(){
        int sum = 0;
        for (int number : numbers){
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Input user untuk memasukkan banyak bilangan dalam array
        System.out.print("Masukkan banyak bilangan dalam array: ");
        int length = input.nextInt();

        int[] numbers = new int[length];

        //Input user bilangan" di dalam array
        for (int i = 0; i<length; i++){
            System.out.print("Masukkan bilangan ke-" + (i+1)+ ": ");
            numbers[i] = input.nextInt();
        }

        System.out.print("Array yang anda masukkan adalah : ");
        for (int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        //Create obj Arraysum dari array input user
        sum_number_inArray arraySum = new sum_number_inArray(numbers);

        //Memanggil method menghitung jumlah bilangan dalam array
        int total = arraySum.calculateSum();

        System.out.println("\nJumlah bilangan dalam array: "+ total);

        input.close();
    }
}
