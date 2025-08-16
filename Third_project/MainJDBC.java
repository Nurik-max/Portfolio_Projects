import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainJDBC {
             static String url = "jdbc:sqlite:addressbook.db";  
    //Main
    public static void main(String[] args) {
        
        try (Connection conn = DriverManager.getConnection(url)) {
          if (conn != null) {
                System.out.println("✅ Connection to SQLite has been established.");
                   Statement stmt = conn.createStatement();
                   
              
                Scanner scan = new Scanner(System.in);

// Создание таблицы
String createTable = "CREATE TABLE IF NOT EXISTS contacts (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "name TEXT NOT NULL," +
                                        "number TEXT NOT NULL)";
              stmt.execute(createTable);
              stmt.execute("DELETE FROM contacts");
               System.out.println("🧹 Table cleared.");
              String insertSQL = "INSERT INTO contacts(id, name, number) VALUES(?, ?, ?)";
             
              
    
     while (true) {
    System.out.println("\n=== Student Menu ===");
    System.out.println("[1] Add contact");
    System.out.println("[2] Update number");
    System.out.println("[3] Delete contact");
    System.out.println("[4] Show all contacts");
    System.out.println("[5] Search contact in name");
    System.out.println("[0] Exit");
    System.out.print("Choose option: ");
    
    int choice = scan.nextInt();
    scan.nextLine();
   // Дальше — switch/case: insert, update, delete, select
   switch(choice){
    
          case 1: //Add contact
          System.out.print("Enter contact name: ");
             String nameAdd = scan.nextLine();
              System.out.print("Enter contact number: ");
              String numAdd = scan.nextLine();
              addContact(conn, nameAdd, numAdd);
            
          break;
          
         case 2: //Update contact 
    System.out.print("Enter contact name which you want update: ");
    String nameUpd = scan.nextLine();
    String query = "SELECT number FROM contacts WHERE name = ?";

    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, nameUpd);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                String oldNumber = rs.getString("number");
                System.out.println("Current number is: " + oldNumber);
                updateContact(conn, scan, nameUpd, oldNumber);
            } else {
                System.out.println("Contact with name '" + nameUpd + "' not found.");
            }
        }
    } catch (SQLException e) {
        System.out.println("❌ Error during lookup: " + e.getMessage());
    }
    break;

               
          case 3: //Delete contact
          System.out.print("Enter contact name which you want delete: ");
              String nameDel = scan.nextLine();
              deleteContact(conn, nameDel);
              break;
              
         case 4: //Show all contact
         showAll(conn);
         break;
         
         case 5:
         System.out.print("Enter the contact name or part full name which you want find: ");
         String search = scan.nextLine();
         searchContact(conn, search);
         break;
         
         case 0: //Exit
         System.out.println("Programm closed");
         return;
         
         default: // wrong input
        System.out.printf("Sorry, not have this option!");
        break;
              
          
   }   



         }
         
 
 
       }
      
  } catch (SQLException e) {
            System.out.println("❌ Connection failed.");
            System.out.println(e.getMessage());
        }
    }
        //Methods:
    public static void addContact(Connection conn, String name1, String num1){
     try {
            String insertSQL = "INSERT INTO contacts(name, number) VALUES(?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
              pstmt.setString(1, name1);
              pstmt.setString(2, num1);
              pstmt.executeUpdate();
              pstmt.close();
                System.out.println("➕ One contact inserted. Name: " + name1);
                
                }
              }catch (SQLException e) {
            System.out.println("❌ Error adding contact: " + e.getMessage());
        }
              
              
    }
    
    public static void updateContact(Connection conn, Scanner scan, String name2, String num2){
     
    // Scanner scan = new Scanner(System.in);
           System.out.println("If you want update'name' - writing 'name'. If number - 'number'. Chooce what you want update: ");
           String choice = scan.nextLine();
   try {
  if(choice.equalsIgnoreCase("number")){
                String updateSQL = "UPDATE contacts SET number = ? WHERE name = ? ";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
                System.out.print("Enter new number: ");
                String newNum = scan.nextLine();
              updateStmt.setString(1, newNum); //number
             updateStmt.setString(2, name2); //name
             updateStmt.executeUpdate();
              System.out.printf("Name: %s | number: %s%n",name2, newNum);
             }
             }
   else if(choice.equalsIgnoreCase("name")) { 
             String updateSQL = "UPDATE contacts SET name = ? WHERE name = ? ";
              try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
            System.out.print("Enter new name: ");
            String newName = scan.nextLine();
            updateStmt.setString(1, newName);//new name
            updateStmt.setString(2, name2); //old name
             updateStmt.executeUpdate();
              System.out.printf("Name: %s | number: %s%n",newName, num2);
             }
        
          }
          else{
          
          System.out.println("You enter not right command!");
          }
            } catch (SQLException e) {
            System.out.println("❌ Error adding contact: " + e.getMessage());
        }
              
                
    }
    
    public static void deleteContact(Connection conn, String name3){
     try {
    String deleteSQL = "DELETE FROM contacts WHERE name = ?";
      try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
    
    
    deleteStmt.setString(1, name3);
    deleteStmt.executeUpdate();
     }
  
  } catch (SQLException e) {
            System.out.println("❌ Error adding contact: " + e.getMessage());
        }
    
    }
    
    public static void showAll(Connection conn){
     try (Statement stmt = conn.createStatement()) {
    String selectSQL = "SELECT id, name, number FROM contacts";
       ResultSet rs = stmt.executeQuery(selectSQL);
                 while (rs.next()) {
                     int id = rs.getInt("id");
                     String name = rs.getString("name");
                      String num= rs.getString("number");
    
                    System.out.printf("id: %d | Name: %s | number: %s%n",id ,name, num);
                }
          }catch (SQLException e) {
            System.out.println("❌ Error adding contact: " + e.getMessage());
        }
    
    
    }
    
    public static void searchContact(Connection conn, String Sname){
    try {
    String searchSQL = "SELECT name, number FROM contacts WHERE name LIKE ?";
    try(PreparedStatement ps = conn.prepareStatement(searchSQL)){
    ps.setString(1, "%" + Sname + "%");
    
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    
    String name = rs.getString("name");
    String phone = rs.getString("number");
    System.out.println("- " + name + ": " + phone);
          }
        }
      }catch (SQLException e) {
            System.out.println("❌ Error adding contact: " + e.getMessage());
        }
    }
}

