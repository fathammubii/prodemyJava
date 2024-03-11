import java.util.*;

public class Main_collection {
    private List<String> dataList;
    private Map<Integer, String> dataMap;
    private Scanner scanner;

    //Konstruktor
    public Main_collection() {
        this.dataList = new ArrayList<>();//ArrayList untuk nama
        this.dataMap = new HashMap<>();//HashMap untuk nama dan ID
        this.scanner = new Scanner(System.in);
    }

    //Method menambah nama
    public void addDataToList(String data) {
        dataList.add(data);//manambahkan string nama
    }

    //Method menambahkan ID ke Nama
    public void convertListToMap() {
        for (int i = 0; i < dataList.size(); i++) {
            try {
                System.out.print("Masukkan id untuk nama \"" + dataList.get(i) + "\": ");
                int key = scanner.nextInt();//user input dimasukkan kedalam variabel
                scanner.nextLine();//bersihkan buffer input
                dataMap.put(key, dataList.get(i));//Menambahkan id(key) kedalam dataList menggunakan hashmap
            } catch (InputMismatchException e){//Exception jika user input non integer
                System.err.println("\nInput id harus berupa bilangan bulat");
                scanner.nextLine();
            }
        }
    }


    public void displayDataList() {
        System.out.println("Data Nama :");
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println(dataList.get(i));//Menampilkan nama-nama dalam data list
        }
    }

    //Method display Map (ID, Nama)
    public void displayDataMap() {
        System.out.println("Data Nama & ID :");
        for (Map.Entry<Integer, String> entry : dataMap.entrySet()) {// for each tiap entriSet dalam dataMap, dengan menggunakan obj entry
            System.out.println("ID: " + entry.getKey() + ", Nama: " + entry.getValue());//Menampilkan id(key) dan nama secara urut dari id(key) terkecil
        }
    }

    //Method display name by id(key)
    public void displayDataByKey() {
        try {
            System.out.print("Masukkan nomor key untuk menampilkan data: ");
            int key = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (dataMap.containsKey(key)) {//Jika dalam DataMap terdapat id (key)
                System.out.println("Data dengan ID " + key + ": " + dataMap.get(key));// Menampilkan nama dengan ID
            } else {//Jika data tidak ditemukan
                System.out.println("Data dengan ID " + key + " tidak ditemukan.");
            }
        } catch (InputMismatchException e){//Exception jika user input non integer
            System.err.println("\nInput id harus berupa bilangan bulat");
            scanner.nextLine();
        }
    }

    public void displayMenu() {// method display menu
        System.out.println("\nMenu:");
        System.out.println("1. Tambahkan Nama");
        System.out.println("2. Tambahkan ID");
        System.out.println("3. Tampilkan Data Nama");
        System.out.println("4. Tampilkan Data Nama dan ID");
        System.out.println("5. Tampilkan Data berdasarkan ID");
        System.out.println("6. Keluar");
    }

    public void handleUserInput(int choice) {
        switch (choice) {
            case 1:
                addDataToListWithQ();//memanggil method add data (nama)
                break;
            case 2:
                convertListToMap();//Memanggil method covert list to map (menambahkan id ke data nama)
                break;
            case 3:
                displayDataList();//memanggil method menampilkan data dalam list
                break;
            case 4:
                displayDataMap();//memanggil method menampilan data dalam map (id, nama)
                break;
            case 5:
                displayDataByKey();//memanggil method untuk menampilkan data nama berdasarkan id (key) pada map
                break;
            case 6:
                System.out.println("Program selesai");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Pilihan tidak tersedia");
        }
    }

    //Method menambahkan data Nama
    public void addDataToListWithQ() {
        System.out.println("Masukkan Nama, ketik 'q' untuk berhenti:");
        while (true) {
            System.out.print("Nama : ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {//Jika user memasukan case 'q' maka break
                break;
            }
            addDataToList(input);//Memanggil method add data nama berdasarkan inout string user
        }
    }

    //Main method
    public static void main(String[] args) {
        Main_collection data1 = new Main_collection();//new obj

        while (true) {
            try {
                data1.displayMenu();//memanggil method display menu
                System.out.print("Masukkan pilihan: ");
                int choice = data1.scanner.nextInt();// user input menu
                data1.scanner.nextLine();//membersihkan buffer input
                data1.handleUserInput(choice);//memanggil method handle user dan menjalankan program berdasarkan pilihan user

            } catch (InputMismatchException e) {//Exception jika user input non integer
                System.err.println("Masukkan pilihan menu dalam bilangan Bulat");
                data1.scanner.next();//membersihkan buffer input
            }
        }
    }
}
