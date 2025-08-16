public abstract class Animal {
    protected String name;
    protected float weight;
    protected int age;
    protected String nameProduct;
    protected int numberOfProduct;
    public Animal(String name, float weight,int age, String nameProduct, int numberOfProduct){
        this.name =name;
        this.weight = weight;
        this.age =age;
        this.nameProduct =nameProduct;
        this.numberOfProduct =numberOfProduct;
    }

    public float getWeight(){
        return weight;
    }
    public int getNumberOfProduct(){
        return numberOfProduct;
    }
    public void displayInfo(){
        System.out.println("Name of " + getClass().getSimpleName() + ": " + name + "\nweight " + weight + "\nAge: " + age
                + "\nName of product: " + nameProduct + "\nNumber of product: " + numberOfProduct + "\n");
    }



}



