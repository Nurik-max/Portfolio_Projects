public class Rectangle {

    private float width;
    private   float  height;

    //Constriction for Calculation Rectangle
    public Rectangle(float width, float height){

        //input date
        this.width = width;
        this.height = height;

        // Calculation Area
        float area = width * height;
        float perimeter = 2 * (width + height);

        //Out info about Rectangle
        System.out.print("Width of Rectangle: " + width + "\nHeight of Rectangle: " + height + "\nArea of Rectangle: " + area + "\nPerimeter of Rectangle: " + perimeter );


    }
}
