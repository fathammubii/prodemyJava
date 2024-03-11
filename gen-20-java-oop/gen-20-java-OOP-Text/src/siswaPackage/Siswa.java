package siswaPackage;

public class Siswa {//class siswa

    private int id;//Atribut class id
    private String name;//Atribut class name

    public Siswa(int id) {
        this.id = id;
    }//Konstruktor 1 param

    public Siswa(int id, String name) {//Konstruktor 2 param
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }//Enkapsulasi Get ID

    public String getName() {
        return name;
    }//Enkapsulasi Set ID

    public void setId(int id){
        this.id = id;
    }//Enkapsulasi set ID

    public void setName(String name) {
        this.name = name;
    }//Enkapsulasi Set name

    @Override
    public String toString() {
        return id + "," + name;
    }//Enkapsulasi get id and name
}
