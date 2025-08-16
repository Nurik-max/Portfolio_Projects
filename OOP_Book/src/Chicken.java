public class Chicken extends Animal{
    public Chicken(String name, float weight, int age, String nameProduct, int numberOfProduct) {
        super(name, weight, age, nameProduct, numberOfProduct);
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(numberOfProduct + ": " + nameProduct);
    }
}





