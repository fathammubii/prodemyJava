public class Medicine extends Product{
    public Medicine(String name, String exp, double price){
        super(name, exp, price);
    }

    public String getName(){
        return name;
    }

    public String getExp(){
        return exp;
    }

    @Override
    public double getPrice(){
        return price;
    }
}
