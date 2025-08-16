import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Обьекты, Классы, Конструкторы


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nGeometry figure data base: Circle(enter number '1') - Rectangle(enter number '2') - Triangle(enter number '3')" + "\n Select geometry figure: ");
        int figure = scanner.nextInt();

        switch (figure) {
            case 1:
                System.out.println("Good! You select Circle - :)");
                System.out.print("Enter radius of circle: ");
                float radius = scanner.nextFloat();
                if (radius != 0) {
                    Circle Element = new Circle(radius);
                } else {
                    System.out.println("ERROR! - :( The radius cannot be zero!");
                }
                break;

            case 2:
                System.out.println("Good! You select Rectangle - :)");
                System.out.print("Enter width Rectangle: ");
                float width = scanner.nextFloat();
                if (width != 0) {
                    System.out.print("Enter height Rectangle: ");
                    float height = scanner.nextFloat();
                    if (height != 0) {
                        if(width != height) {
                            Rectangle Element1 = new Rectangle(width, height);
                        }
                        else {
                            System.out.println("\nWOW :() This SQUARE");
                            Rectangle Element1 = new Rectangle(width, height);

                        }
                    }
                }
                else {
                        System.out.println("ERROR! - :( The width or height cannot be zero!");
                    }
                    break;

                    case 3:

                        System.out.println("Good! You select Triangle - :)");
                        System.out.print("Enter side-A Triangle: ");
                        double sideA = scanner.nextDouble();
                        if (sideA != 0 ) {
                            System.out.print("Enter side-B Triangle: ");
                            double sideB = scanner.nextDouble();
                            if (sideB != 0) {
                                System.out.print("Enter side-C Triangle: ");
                                double sideC = scanner.nextDouble();
                                if (sideC != 0) {
                                    if (sideA != sideB && sideB != sideC && sideC != sideA) {
                                        Triangle Element3 = new Triangle(sideA, sideB, sideC);
                                    } else {
                                        System.out.println("\nWOW! - :() This isosceles triangle");
                                        Triangle Element3 = new Triangle(sideA, sideB, sideC);
                                    }
                                }
                            }
                        }else {
                            System.out.println("ERROR! - :( The sides cannot be zero!");
                        }
                        break;

                    default:
                        System.out.println("ERROR! - :( You entered not right value! Please try again :)");


                }
        }
    }