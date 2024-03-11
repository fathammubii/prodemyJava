public class sum_2d_array {
    public int[] array1d;

    //konsturktor array 1 dimensi
    public sum_2d_array(int rows, int columns, int [][] array2d){
        array1d = new int[rows];

        //menghitung jumlah tiap baris array 2 dimensi dan menyimpan ke dalam array
        for (int i = 0; i < rows; i++){
            int sum = 0;
            for (int j = 0; j < columns; j++){
                sum += array2d[i][j];
            }
            array1d[i] = sum;
        }
    }

    //method print array 1 dimensi
    public void displayArray(){
        System.out.print("Array 1D : ");
        for (int num : array1d) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int [][] array2d = { {1, 2, 3}, {4, 5, 6} };
        int rows = array2d.length;
        int columns = array2d[0].length;

        //create obj sum_2d_array
        sum_2d_array sum_array_2d = new sum_2d_array(rows, columns, array2d);

        //print array 1 dimensi yang berisi jumlah array 2 dimensi
        sum_array_2d.displayArray();
    }
}
