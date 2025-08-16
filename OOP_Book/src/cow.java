public class cow extends Animal{
    public cow(String name, float weight, int age, String nameProduct, int numberOfProduct) {
        super(name, weight, age, nameProduct, numberOfProduct);
    }
// Полиморфизм: переопределение метода
    @Override
    public float getWeight() {

        System.out.println("Cow weight: " + super.getWeight());
        return super.getWeight();

    }
}

