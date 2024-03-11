import java.util.Scanner;//package scanner

public class tampilan_segitiga {//name of class
    public static void main(String[] args){//main method
        System.out.println("Program segitiga");//printout name program
        Scanner input = new Scanner(System.in);//new obj scanner for read input user
        System.out.print("Masukkan jumlah baris segitiga : ");//printout command for input user
        int baris = input.nextInt();//variabel int baris for temp input user

        for (int i =0; i<baris; i++){//outer loop to handle rows, perulanagan akan dilakukan sebanyak input user baris

            for (int j=baris-i; j>1;j--){//inner loop to handle number of spaces, perulangan untuk print space, dimana akan mencetak space sebanyak j:baris-i, misal pada perulangan i:0 maka akan mencetak sebanyak 3 space kosong
                System.out.print(" ");//print out space in loop
            }

            for (int k = 0; k<=i; k++){//inner loop to handle printout "*", dimana loop ini dijalankan setelah loop diatas berakhir, misal pointer terkahir yang berada di colom tiga maka akan mencetak (*) pada kolom 3
                System.out.print("* ");//print out (* and space)
            }
            System.out.println();//print out line, for ending per each row
        }
    }
}
