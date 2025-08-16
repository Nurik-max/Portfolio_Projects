import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       int[][] arr = new int[][] {{45, 67}, {78, 8}};

        LinkedList<String> name = new LinkedList<>();
        name.add("N");
        name.add("u");
        name.add("r");
        name.add("i");
        name.add("k");
        name.add("H");
        name.add("i");

        //Вызов Функций
        FunkArray(arr);
        FunkArrList();
        FunkLinList(name);

        }
        //Функция Массива
    public static void FunkArray(int[][] arr1){

        for (int i = 0; i < arr1.length; i++){
            System.out.println("\n");
            System.out.println("Array num " + i);
            System.out.print("{ ");
            for(int j = 0; j < arr1.length; j++){

                System.out.print(arr1[i][j] + " ,");
            }
            System.out.print(" }");
        }
    }
                //Функция Колекций Джава
                //ArrayList<>()
    public static void FunkArrList(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of Array: ");
         int size = scanner.nextInt();
        ArrayList<Integer> nummbers = new ArrayList<>();

        // Ввод первого значения отдельно
        System.out.print("Enter value #1: ");
         int firstValue = scanner.nextInt();
        nummbers.add(firstValue);

        int max = firstValue;
        int min = firstValue;


        for(int i = 1; i < size; i++) {
            System.out.print("Enter your value: ");
             int value = scanner.nextInt();
            nummbers.add(value);
            if (value >  max)
                max = value;
            if (value < min)
                min = value;
        }

        System.out.println("Result: " + nummbers);
        System.out.println("Max value in array = " + max);
        System.out.println("Min value in array = " + min);

    }

                //LinkedList<>()
    public static void FunkLinList(LinkedList<String> name1){


        System.out.print(name1.get(5) + name1.get(6) + "\t");
        for(int i = 0; i < name1.size(); i++ )
            if (i != 5 && i != 6)
            System.out.print(name1.get(i) );

        System.out.println("\n" + "LinkedList: " + name1);

    }
    }
