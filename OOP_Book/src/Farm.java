import java.util.ArrayList;

public class Farm {

    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void sellAnimal(int number){
        animals.remove(number);
    }

    public void showAnimal(){
        for(Animal a: animals)
            a.displayInfo();
    }
    public float getTotalWeight(){
        float total = 0;
        for (Animal a: animals)
            total += a.getWeight();

        return total;

    }

    public float getTotalProduct(){
        float total1 =0;
        for (Animal a: animals){
            total1 += a.getNumberOfProduct();
        }
        return total1;
    }
}