import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class Siswa {
    private int id;
    private String name;

    public Siswa (int id){
        this.id = id;
    }

    public Siswa (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "," + name;
    }
}

interface CRUD {
    void create(File file, Scanner scanner) throws IOException;
    void read(File file) throws IOException;
    void update(File file, Scanner scanner) throws IOException;
    void delete(File file, Scanner scanner) throws IOException;
}

class FileCRUD implements CRUD {

    @Override
    public void create(File file, Scanner scanner) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(writer);
        try {
            System.out.print("Enter new product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Siswa newProduct = new Siswa(id);
            System.out.print("Enter the name for ID " + id + ": ");
            String name = scanner.nextLine();
            newProduct.setName(name);
            printWriter.println(newProduct);
            System.out.println("Data successfully added.");
        } finally {
            printWriter.close();
            writer.close();
        }
    }

    @Override
    public void read(File file) throws IOException {
        System.out.println("Data in the File:");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            System.out.println("ID: " + parts[0] + ", Name: " + parts[1]);
        }
        reader.close();
    }

    @Override
    public void update(File file, Scanner scanner) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String tempFile = "temp.txt";
        FileWriter writer = new FileWriter(tempFile, true);
        PrintWriter printWriter = new PrintWriter(writer);
        try {
            System.out.print("Enter the ID to update: ");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine();

            String line;
            boolean updated = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                if (id == idToUpdate) {
                    System.out.print("Enter the new name for ID " + id + ": ");
                    String newName = scanner.nextLine();
                    printWriter.println(id + "," + newName);
                    updated = true;
                    System.out.println("Data successfully updated.");
                } else {
                    printWriter.println(line);
                }
            }

            if (!updated) {
                System.out.println("Product with ID " + idToUpdate + " does not exist");
            }
        } finally {
            printWriter.close();
            writer.close();
            bufferedReader.close();
            reader.close();
            // Delete the old file
            if (file.delete()) {
                // Rename the temp file to the original file name
                File newFile = new File(file.getAbsolutePath());
                File temp = new File(tempFile);
                if (temp.renameTo(newFile)) {
                    System.out.println("File updated successfully.");
                } else {
                    System.err.println("Failed to update file.");
                }
            } else {
                System.err.println("Failed to delete file.");
            }
        }
    }

    @Override
    public void delete(File file, Scanner scanner) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String tempFile = "temp.txt";
        FileWriter writer = new FileWriter(tempFile, true);
        PrintWriter printWriter = new PrintWriter(writer);
        try {
            System.out.print("Enter the ID to delete: ");
            int idToDelete = scanner.nextInt();
            scanner.nextLine();

            String line;
            boolean deleted = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                if (id != idToDelete) {
                    printWriter.println(line);
                } else {
                    deleted = true;
                    System.out.println("Data with ID " + id + " successfully deleted.");
                }
            }

            if (!deleted) {
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
                File newFile = new File(file.getAbsolutePath());
                File temp = new File(tempFile);
                if (temp.renameTo(newFile)) {
                    System.out.println("File updated successfully.");
                } else {
                    System.err.println("Failed to update file.");
                }
            } else {
                System.err.println("Failed to delete file.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File file = new File("Siswa.txt");
        CRUD crud = new FileCRUD();

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Choose operation: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        crud.create(file, scanner);
                        break;
                    case 2:
                        crud.read(file);
                        break;
                    case 3:
                        crud.update(file, scanner);
                        break;
                    case 4:
                        crud.delete(file, scanner);
                        break;
                    case 5:
                        System.out.println("Program Selesai.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Masukkan pilihan menu dalam bilangan bulat");
                scanner.nextLine();
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}

