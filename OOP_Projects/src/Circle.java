public class Circle {

    private float radius;

    //Constriction for Calculation Circle
    public Circle(float radius){
        //input date
        this.radius = radius;
        //Calculation Area
        double area = Math.PI*(radius*radius);
        double lineCircle = 2 * Math.PI * radius;

        //Out info about Circle
        System.out.print("Radius of circle: " + radius + "\nArea of circle: " + area + "\nLine of Circle: " + lineCircle);
    }
}
