import java.util.Scanner;//package scanner
public class mod3_ganjil {//nama kelas
    public static void main (String[] args){//main method
        System.out.println("Program Mod3 Ganjil");// name prgoram
        Scanner input = new Scanner(System.in);// create obj from user input

        System.out.print("Masukkan jumlah n yang anda mau : ");//printout user req
        int n = input.nextInt();// n variable untuk batas angka yang akan di print nanti

        calculate_mod3_ganjil MyObj = new calculate_mod3_ganjil();// membuat obj dari kelas calculate_mod3_ganjil MyObj

        System.out.print("Bilangan habis dibagi 3 namun tidak habis dibagi 2: ");//printout hasil
        MyObj.print_calculate_mod3_ganjil(n);//Obj kelas memanggil method

        input.close();//user input close
    }
}

class calculate_mod3_ganjil{// name class
    public void print_calculate_mod3_ganjil(int n){// method untuk print hasil dan logic

        int printCount = 0;// variabel untuk menghitung banyaknya angka yang telah di print
        int i = 1;// variabel i untuk increment nilai

        while (printCount < n){//while loop, dimana akan berhenti jika telah mencetak lebih dari batas
            if (i%3 ==0 && i%2 != 0){// logic mod 3 ganjil, dimana kondisi jika i mod 3 sama dengan nol dan i mod 2 tidak sama dengan nol
                System.out.print(i + ", ");//print i
                printCount++;//increment print count
            }
            i++;//increment i
        }
    }
}
