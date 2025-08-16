public class Car {

    private String model;
    private String brand;
    private int year;
    private float mileage;

    public Car(String model,String brand, int year, float mileage){
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }
    public double exMileage(){
        mileage = mileage + 100;
        return mileage;
    }

    public void displayInfo(){
        System.out.println("Car model: " + model + "\nBrand car: "
                + brand + "\nYear car: " + year + "\nCar mileage: " + mileage);
    }

}

