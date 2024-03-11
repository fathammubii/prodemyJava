package Product;

public class Product {//class Product
    private int id;//Atribut id
    private String name;//Atribut Name

    public Product(int id, String name) {//Konstruktor 2 param
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }//Method Get ID Enkapsulasi

    public String getName() {
        return name;
    }//Method Get Name Enkapsulasi

    public void setName(String name) {
        this.name = name;
    }////Method Set ID and Name Enkapsulasi
}
