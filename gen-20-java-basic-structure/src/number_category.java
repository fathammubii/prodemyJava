import java.util.Scanner;//pacakege sccaner for input user

public class number_category {//name class
    public static void main (String[] args){//method main
        System.out.println("We will categorical your two number + 1");//printout name program
        Scanner input = new Scanner(System.in);//new obj for input user
        System.out.print("Input your number 1: ");//printout user number input
        Double number1 = input.nextDouble();//variabel double number 1 for temp input user 1
        System.out.print("Input your number 2: ");//printout user number input 2
        Double number2 = input.nextDouble();////variabel double number 2 for temp input user 2

        if ((number1 + number2 + 1)%2 ==0) {//logic operation, jika number 1+ number 2+ 1 dibagi 2 sama dengan 0 maka
            System.out.print("Your number : "+(number1 + number2)+" + 1 = "+(number1 + number2+1)+" is odd");//jika logic benar maka print odd
        }else{//kecuali
            System.out.print("Your number : "+(number1 + number2)+" + 1 = "+(number1 + number2+1)+" is even");//jika logic salah maka print even
        }
    }
}
