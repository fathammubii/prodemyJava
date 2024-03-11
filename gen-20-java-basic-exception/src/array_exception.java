import java.util.Scanner;
public class array_exception {

    private int[] array;

    public array_exception(int[] array){
        this.array = array;
    }

    public void handle_array(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nilai array ke: ");
        int index = input.nextInt();

        //Exception Handling
        try{
            System.out.printf("index ke-%d, adalah %d\n", index, array[index]);
        } catch(ArrayIndexOutOfBoundsException e){//exception spesific out of bound index
            System.err.printf("Indeks ke- %d di luar batas untuk panjang array : 4\n", index);
        } finally {
            System.out.println("Finally dijalankan");
        }
    }

    public static void main(String[] args) {

        int[] array = {0,1,2,3};
        array_exception handler = new array_exception(array);
        handler.handle_array();

        System.out.println("\nProgram berakhir");
    }
}
