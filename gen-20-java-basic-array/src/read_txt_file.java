import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class read_txt_file {
    private String filePath;

    public read_txt_file(String filePath){
        this.filePath = filePath;
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Contens of the file : ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println("An error occurred while reading the file: "+ e.getMessage());
        }
    }

    public static void main(String[] args){
        String filePath = "baca.txt";//Name file to read
        read_txt_file reader_txt = new read_txt_file(filePath);
        reader_txt.readFile();
    }
}
