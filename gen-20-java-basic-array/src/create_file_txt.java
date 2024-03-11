import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class create_file_txt {
    private String filePath;
    private String content;

    public create_file_txt(String filePath, String content){
        this.filePath = filePath;
        this.content = content;
    }

    public void writeToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(content);
            System.out.println("File berhasil ditulis: "+filePath);
        }
        catch (IOException e){
            System.out.println("Terjadi kesalahan saat menulis ke file: "+ e.getMessage());
        }
    }

    public static void main(String[] args){
        String filePath = "menulis.txt";
        String content = "Tulis disini : coba test in code";

        create_file_txt newText = new create_file_txt(filePath, content);
        newText.writeToFile();
    }
}
