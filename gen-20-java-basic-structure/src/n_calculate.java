import java.util.Scanner;// package scanner untuk user input

public class n_calculate {//class name
    public static void main(String[] args){//main method
        System.out.println("\nProgram menghitung hingga jumlah user input (n)");//Printout program name
        Scanner input = new Scanner(System.in);//new object scanner
        n_calculate main = new n_calculate();// create new obj :main from class n_calculate

        System.out.print("Masukkan jumlah n: ");//printout user input req
        int n = input.nextInt();//new variable n for temporary save user input

        int sum = main.calculate_sum_n(n);// new variable sum for temporary save return value of method calculate_sum_n

        System.out.print("Jumlah dari 1 sampai "+ n + " adalah : "+ sum);//printout result

        input.close();//user input close
    }

    public int calculate_sum_n(int n){//method for calculate of sum n
        int temp_sum = 0;//new variable for temporary save the sum of n
        for (int i =1; i <=n; i++){//for loop 1 until = n
            temp_sum += i;// temp_sum = temp_sum+i
        }
        return temp_sum;//return value temp_sum(temporary save of the sum of n)
    }
}
