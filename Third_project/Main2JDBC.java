import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main2JDBC {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:mydatabase.db"; // база создастся автоматически
     
      
        try (Connection conn = DriverManager.getConnection(url)) {
             
            if (conn != null) {
                System.out.println("✅ Connection to SQLite has been established.");
                
                String createStudentSQL = "CREATE TABLE IF NOT EXISTS students (" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "name TEXT NOT NULL," +
                                        "age INTEGER," +
                                        "grade REAL);";
            
               Statement stmt = conn.createStatement();
               stmt.execute("DELETE FROM students");
               System.out.println("🧹 Table cleared.");
              stmt.execute(createStudentSQL);
              System.out.println("📘 Table 'students' created or already exists.");
              //Подготавливаем запрос с параметрами
              String insertSQL = "INSERT INTO students(name, age, grade) VALUES(?, ?, ?)";
              
              
              Scanner scan = new Scanner(System.in);
              while (true) {
    System.out.println("\n=== Student Menu ===");
    System.out.println("[1] Add student");
    System.out.println("[2] Update age");
    System.out.println("[3] Delete student");
    System.out.println("[4] Show all students");
    System.out.println("[0] Exit");
    System.out.print("Choose option: ");
    
    int choice = scan.nextInt();
    scan.nextLine();
    String name;
    int age;
    double grade;
    int id;
   

    switch (choice) {
        case 1: // add
        
         
              //PreparedStatement pstmt = conn.prepareStatement(insertSQL);
              System.out.print("Enter student name: ");
              name = scan.nextLine();
              System.out.print("Enter student age: ");
              age = scan.nextInt();
              System.out.print("Enter student grade: ");
              grade = scan.nextDouble();
              
              insertSQL = "INSERT INTO students(name, age, grade) VALUES(?, ?, ?)";
              PreparedStatement pstmt = conn.prepareStatement(insertSQL);
              pstmt.setString(1, name);
              pstmt.setInt(2, age);
              pstmt.setDouble(3, grade);
              pstmt.executeUpdate();
              pstmt.close();
                System.out.println("➕ One student inserted. Name: " + name);
                
                String selectSQL = "SELECT id, name, age, grade FROM students";
                ResultSet rs = stmt.executeQuery(selectSQL);
                while (rs.next()) {
                    id = rs.getInt("id");
                     name = rs.getString("name");
                     age = rs.getInt("age");
                     grade = rs.getDouble("grade");

                    System.out.printf("Name:%s | age: %d | grade: %.2f%n",name, age, grade);
             

                }
                
            break;
        
        case 2: // update age
         insertSQL = "INSERT INTO students(name, age, grade) VALUES(?, ?, ?)";
          String updateSQL = "UPDATE students SET age = ? WHERE name = ? ";
           PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
              System.out.print("Enter student name which you want update age: ");
              name = scan.nextLine();
             System.out.print("Enter update student age: ");
              age = scan.nextInt();
             updateStmt.setInt(1, age); //Age
             updateStmt.setString(2, name); //name
             updateStmt.executeUpdate();
             //Read data
              selectSQL = "SELECT id, name, age, grade FROM students";
                rs = stmt.executeQuery(selectSQL);
               
                System.out.println("\n📋 Students list:");
                while (rs.next()) {
                    id = rs.getInt("id");
                     name = rs.getString("name");
                     age = rs.getInt("age");
                     grade = rs.getDouble("grade");

                    System.out.printf("Name:%s | age: %d | grade: %.2f%n",name, age, grade);
             

                }

                rs.close();
                
                break;
               
        case 3: // delete
         String deleteSQL = "DELETE FROM students WHERE name = ?";
              PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL);
              System.out.print("Enter student name which you want delete: ");
              name = scan.nextLine();
              deleteStmt.setString(1, name);
              deleteStmt.executeUpdate();
              
            selectSQL = "SELECT id, name, age, grade FROM students";
              rs = stmt.executeQuery(selectSQL);
              while (rs.next()) {
                    id = rs.getInt("id");
                     name = rs.getString("name");
                     age = rs.getInt("age");
                     grade = rs.getDouble("grade");

                    System.out.printf("Name:%s | age: %d | grade: %.2f%n",name, age, grade);
             

                }
              break;
        case 4: // show
         selectSQL = "SELECT id, name, age, grade FROM students";
              rs = stmt.executeQuery(selectSQL);
               
                System.out.println("\n📋 Students list:");
                while (rs.next()) {
                     id = rs.getInt("id");
                    name = rs.getString("name");
                    age = rs.getInt("age");
                    grade = rs.getDouble("grade");

                    System.out.printf("Name:%s | age: %d | grade: %.2f%n",name, age, grade);

                }

                rs.close();
                
                break;
                
        case 0: // exit
        System.out.printf("Programm closed!");
        return;
        
        default: // wrong input
        System.out.printf("Sorry, not have this option!");
        break;
        
       
    }
    

  }
  //stmt.close(); 
 //scan.close();
 
}

            
              } catch (SQLException e) {
            System.out.println("❌ Connection failed.");
            System.out.println(e.getMessage());
        }
    }
}
