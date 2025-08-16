public class Triangle {
    private double sideA, sideB, sideC;

    //Constriction for Calculation Triangle
    public Triangle(double sideA, double sideB, double sideC){
        //input date
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        // Calculation Area
        double perimeter = (sideA + sideB + sideC);
        double area = Math.sqrt(perimeter/2 * (perimeter/2 - sideA) * (perimeter/2 - sideB) * (perimeter/2 - sideC));
        //Out info about Triangle
        System.out.printf("Side triangle: " + " " + sideA + ", " + sideB + ", " + sideC + "\nArea Triangle according to Heron's formula:  " + area + "\nPerimeter of triangle: " + perimeter);
    }
    }
