import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main3{

public static void main(String [] args) throws Exception {

ArrayList<String> orders = new ArrayList<>();
Scanner scan = new Scanner(System.in);
boolean val = true;
boolean status = true;
System.out.println("\t\t=== Welcome to our restoran! ===");
System.out.println("\t\t== If you want oerdering, just writing - order or if you don't want - off ==");

while(status){ //outside cicle
  String action = scan.nextLine(); //Geting your action for programm 
    if(action.equalsIgnoreCase("order")){ // Check in similar value
      
      System.out.println("== Please add your food: ==");
        val = true;
while(val){ //inside cicle
  String order = scan.nextLine();
    if(!order.equalsIgnoreCase("Stop"))
    orders.add(order);
      else val = false;
}
  System.out.println("Orders: " + orders);
  System.out.println("== If you want chang your order, just writing: remove, sort, reverse, find, clear, add ==");

while(true){
  System.out.print("Your command: "); 
  String command = scan.nextLine(); //Geting your command
    //Command for sort List
    if(command.equalsIgnoreCase("sort")){ // Check in similar value
      Collections.sort(orders);
        System.out.println("Orders: " + orders);
}
    //Command for reverse List
    else if(command.equalsIgnoreCase("reverse")){
      Collections.reverse(orders);
        System.out.println("Orders: " + orders);
}
    //Command for remove object from List
    else if(command.equalsIgnoreCase("remove")){
        System.out.print("Enter order what that you want remove: ");
          boolean object = false;
            String toRemove = null;
            String order1 = scan.nextLine();
                for(String item1: orders){
                  if(item1.equalsIgnoreCase(order1)){
                    object = true;
                      toRemove = item1;
                      break;
                    }
                  }
    if(object){
      orders.remove(toRemove);  //method for remove order
        System.out.println("Removed: " + toRemove);
        System.out.println("Orders: " + orders);
          }
    else 
      System.out.println("Sorry, not found! Try again!");
        }
      //Command for found object from List
      else if(command.equalsIgnoreCase("find")){
        System.out.print("Enter order what that you want find: ");
          boolean found = false;
          String order2 = scan.nextLine();
          for(String item: orders){
          if(item.equalsIgnoreCase(order2)){
          found = true;
          break;
              }
          }
        if(found)
          System.out.println("Your order: " + order2);

        else 
          System.out.println("Sorry, not found! Try again!");
          }
        //Command for clear(or delete all object) in List
          else if(command.equalsIgnoreCase("clear")){
            orders.clear();  //method for remove all order
              System.out.println("Orders: " + orders);
            }             
          //Command for add new object in List
          else if(command.equalsIgnoreCase("add")){
            System.out.println("Add your order: ");
              String difOrder = scan.nextLine();
                orders.add(difOrder); //method for add new order
                System.out.println("You add:" + difOrder);
                  System.out.println("Orders:" + orders);
                  }
         //Command for stop cicle
         else if (command.equalsIgnoreCase("stop")) {
              System.out.println("Exiting menu.");
                break;
                  }
              }


}
 //Exit from outside cicle 
else if (action.equalsIgnoreCase("off")) {
status = false;
break;
}

}
 scan.close();
}
}
