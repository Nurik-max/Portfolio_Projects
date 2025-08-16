//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       // System.out.printf("Hello and welcome!");

      //  for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
           // System.out.println("i = " + i);
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        int value2 = 0;
        int max_ev = 0;
        int max_nev = 0;
        int i = 0;

        for (; i < arr.length; i++ ) {
            System.out.print("Enter your value: ");

            int value = scanner.nextInt();
            arr[i] = value;
            value2 = arr[i];

        }
        //System.out.print("Array { " + arr[0] + ","+ arr[1] + ","+ arr[2] + ","+ arr[3] + ","+ arr[4] + "}");
         i = 0;
        while (i < arr.length) {


                if (i == 0) {
                    System.out.print("Array {" + arr[0] + ",");
                } else if (i == 4) {
                    System.out.print(arr[4] + "}" + "\n");
                } else
                    System.out.print(arr[i] + ",");

            i++;
        }
        i = 0;
        System.out.print("Array with even value:{ " );
        while(i < arr.length){
            if(arr[i] % 2 == 0){
                System.out.print(arr[i] + ",");
                if(arr[i] > max_ev)
                    max_ev = arr[i];
            }
            i++;
        }
        System.out.print("}" + "\n");
        System.out.print("Max even value in array: " + max_ev + "\n");

        i = 0;
        System.out.print("Array with not even value:{ " );
        while(i < arr.length){
            if(arr[i] % 2 != 0){
                System.out.print(arr[i] + ",");
                if(arr[i] > max_nev)
                    max_nev = arr[i];
            }
            i++;
        }
        System.out.print("}" + "\n");
        System.out.print("Max not even value in array: " + max_nev);

        i = 0;
        char[] word = new char[] {'H', 'e', 'l', 'l', 'o', 'N','u', 'r', 'i', 'k'};
        while (i < word.length){
            if( i == 5){
                System.out.print("\t");
            }
            if(i > 3){
                System.out.print(word[i]);

            }

            else
                System.out.print(word[i]);


            i++;
        }

    }
        }


