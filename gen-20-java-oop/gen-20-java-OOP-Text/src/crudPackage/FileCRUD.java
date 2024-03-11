package crudPackage;

import siswaPackage.Siswa;//Import class Siswa pada siswaPackage

import java.io.*;
import java.util.Scanner;

public class FileCRUD extends CRUD {//FileCrud sebagai child class CRUD

    @Override
    public void create(File file, Scanner scanner) throws IOException {//Create menggunakan Class dari File (Package Java IO) dan Input user (Scan)
        FileWriter writer = new FileWriter(file, true);//Membuka file write mode, append True (Menambahkan konten baru) tanpa overwrite
        PrintWriter printWriter = new PrintWriter(writer);//menuliskan data(input user) ke dalam writer (obj file writer)
        try {
            System.out.print("Enter new product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();//Input ID
            Siswa newSiswa = new Siswa(id);//Make new obj from class Siswa, set ID
            System.out.print("Enter the name for ID " + id + ": ");
            String name = scanner.nextLine();//Input Nama
            newSiswa.setName(name);//Set Name
            printWriter.println(newSiswa);//menuliskan data newSiswa ke dalam fileWriter
            System.out.println("Data successfully added.");
        } finally {
            printWriter.close();//Menutup printWriter
            writer.close();//Menutup writer
        }
    }

    @Override
    public void read(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));//BufferReader untuk membaca isi file baris demi baris
        String line = reader.readLine();//Membaca baris
        if (line == null){
            System.out.println("Data kosong.");
        }else{
            System.out.println("Data dalam file :");
            do{
                String[] parts = line.split(",");//Array String[] Memisahkan ID dan Nama menggunakan separator koma
                System.out.println("ID: " + parts[0] + ", Name: " + parts[1]);//Print parts[0] sebagai ID dan parts[1] nama
            }while ((line = reader.readLine()) != null);//do while loop dilakukan hingga reader != null
        }
        reader.close();
    }

    @Override
    public void update(File file, Scanner scanner) throws IOException {
        FileReader reader = new FileReader(file);// FileReader package untuk membuka file yang akan dibaca
        BufferedReader bufferedReader = new BufferedReader(reader);//BufferReader untuk membaca isi file baris demi baris
        String tempFile = "temp.txt";//Temp file untuk tempat data sementara dituliskan
        FileWriter writer = new FileWriter(tempFile, true);//Membuka tempFile write mode, append True (Menambahkan konten baru) tanpa overwrite
        PrintWriter printWriter = new PrintWriter(writer);//menuliskan data(input user) ke dalam writer (obj file writer)
        try {
            System.out.print("Enter the ID to update: ");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine();

            String line;
            boolean updated = false;
            while ((line = bufferedReader.readLine()) != null) {//buffer membaca baris demi baris saat data ada
                String[] parts = line.split(",");//Array String[] Memisahkan ID dan Nama menggunakan separator koma
                int id = Integer.parseInt(parts[0]);//Cek part[0] yaitu ID
                if (id == idToUpdate) {//Jika ID yang akan di update ada
                    System.out.print("Enter the new name for ID " + id + ": ");
                    String newName = scanner.nextLine();
                    printWriter.println(id + "," + newName);//Update Nama
                    updated = true;//Update = True
                    System.out.println("Data successfully updated.");
                } else {
                    printWriter.println(line);//menulis kembali tiap baris kedalam temp file
                }
            }

            if (!updated) {//Jika ID tidak ada
                System.out.println("Product with ID " + idToUpdate + " does not exist");
            }
        } finally {//Exception Finally dijalankan
            printWriter.close();//Menutup writer untuk menulis file
            writer.close();//Menutup write mode
            bufferedReader.close();//Menutup bufferreader
            reader.close();//menutup reader obj
            // Logic Delete File
            if (file.delete()) {//Delete old file
                // Rename the temp file to the original file name
                File newFile = new File(file.getAbsolutePath());//Return pathname in main class
                File temp = new File(tempFile);//Menyimpan String tempFile kedalam File temp
                if (temp.renameTo(newFile)) {//File temp rename to newFile (pathname in main class)
                    System.out.println("File updated successfully.");
                } else {//File failed to rename / pathname does not exist
                    System.err.println("Failed to update file.");
                }
            } else {//File failed to rename / pathname does not exist
                System.err.println("Failed to delete file.");
            }
        }
    }

    @Override
    public void delete(File file, Scanner scanner) throws IOException {
        FileReader reader = new FileReader(file);// FileReader package untuk membuka file yang akan dibaca
        BufferedReader bufferedReader = new BufferedReader(reader);//BufferReader untuk membaca isi file baris demi baris
        String tempFile = "temp.txt";//Temp file untuk tempat data sementara dituliskan
        FileWriter writer = new FileWriter(tempFile, true);//Membuka tempFile write mode, append True (Menambahkan konten baru) tanpa overwrite
        PrintWriter printWriter = new PrintWriter(writer);//menuliskan data(input user) ke dalam writer (obj file writer)
        try {
            System.out.print("Enter the ID to delete: ");
            int idToDelete = scanner.nextInt();//temp id to Delete
            scanner.nextLine();

            String line;//obj line
            boolean deleted = false;
            while ((line = bufferedReader.readLine()) != null) {//while loop ketika readLine != null
                String[] parts = line.split(",");//split line with separator koma
                int id = Integer.parseInt(parts[0]);// id = convert String parts[0] to int
                if (id != idToDelete) {// jika ID tidak sama
                    printWriter.println(line);//Menulis kembali ID yang tidak di delete menggunakan method print pada printWriter dengan param line (input user)
                } else {
                    deleted = true;// ID Delete bol = True
                    System.out.println("Data with ID " + id + " successfully deleted.");
                }
            }

            if (!deleted) {//jika tidak ada ID
                System.out.println("Product with ID " + idToDelete + " does not exist");
            }
        } finally {
            printWriter.close();
            writer.close();
            bufferedReader.close();
            reader.close();
            // Delete the old file
            if (file.delete()) {
                // Rename the temp file to the original file name
                File newFile = new File(file.getAbsolutePath());//Return pathname in main class
                File temp = new File(tempFile);//Menyimpan String tempFile kedalam File temp
                if (temp.renameTo(newFile)) {//File temp rename to newFile (pathname in main class)
                    System.out.println("File updated successfully.");
                } else {//File failed to rename / pathname does not exist
                    System.err.println("Failed to update file.");
                }
            } else {//File failed to rename / pathname does not exist
                System.err.println("Failed to delete file.");
            }
        }
    }
}
