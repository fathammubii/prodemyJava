import java.util.Scanner;//package scanner

public class Basic_aritmatic {//nama kelas
    public static void main (String[] args){//main method
        System.out.println("We will Adding your integer two numbers");//printout name program
        Scanner input = new Scanner(System.in);//make new obj for input
        System.out.print("Enter First Number: ");//printout first number for input user
        Double number1 = input.nextDouble();//double number 1 for temp input user
        System.out.print("Enter Second Number: ");//printout second number for input user
        Double number2 = input.nextDouble();//double number 2 fir tem input user 2
        System.out.println("The result of Adding two numbers is "+(number1+number2));//print out the result of adding
    }
}