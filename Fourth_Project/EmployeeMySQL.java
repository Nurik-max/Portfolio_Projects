import java.sql.*;
import java.util.Scanner;

public class EmployeeMySQL {

static final String URL = "jdbc:mysql://localhost:3306/CompanyDB";
static final String USER = "root"; 
static final String PASSWORD = "985568_Fedora";

public static void main(String[] args){

try{
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
 
System.out.println("Connected to MySQL!");

Scanner scanner = new Scanner(System.in);

while(true){
System.out.println("\n=== Employee Manager ===");
System.out.println("1. Show all employees");
  System.out.println("2. Add employee");
System.out.println("3. Update employee");
System.out.println("4. delete employee");
System.out.println("5. Payment");
System.out.println("6. Show employees with total payments");
System.out.println("7. Create table for Payments");
System.out.println("8. Select amount for employee");
System.out.println("9. Clean table with payment");
System.out.println("0. Exit");
System.out.print("Choose option: ");
int choice = scanner.nextInt();
scanner.nextLine(); //clean new line
int idUpd;

switch(choice){

	case 1: 
	showAllEmployees(conn);
	break;
	
	case 2: 
	addEmployee(conn, scanner);
	break;
	
	case 3:
	 System.out.print("Enter employee ID which you want update: ");
    idUpd = scanner.nextInt();
    scanner.nextLine();
	updateEmployee(conn, scanner, idUpd);
	break;
	
	case 4:
	 System.out.print("Enter employee ID which you want delete: ");
    idUpd = scanner.nextInt();
     scanner.nextLine();
	deleteEmployee(conn, idUpd);
	break;
	
	case 5:
	
	break;
	
	case 6:
    showEmployeesWithPayments(conn);
    break;

  case 7: 
      createPaymentsTableIfNotExists(conn);
    break;
  case 8:
    addPaymentsForAllEmployees(conn, scanner);
    break;
	
	case 9:
    clearPaymentsTable(conn);
    break;

	case 0:
	System.out.println("Programm closed!");
	return;


	default:
	System.out.println("Invalid choice!");
	break;
}
}
} catch(SQLException e){
System.out.println("Connection faieled: " + e.getMessage());
}
} catch(ClassNotFoundException e){
System.out.println("Connection failed: " + e.getMessage());
}
}
public static void showAllEmployees(Connection conn){
 	String sql = "SELECT id, name, age, department FROM Employees";
 	try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
 	System.out.println("Employees List: ");
 	while(rs.next()){
 	
 	System.out.printf("ID: %d | Name: %s | Age: %d | Department: %s%n", 
 	rs.getInt("id"),
 	rs.getString("name"),
 	rs.getInt("age"),
 	rs.getString("department"));
 	 }
 	}catch(SQLException e){
 	System.out.println("Error reading employees: " + e.getMessage());
 	}
}

public static void addEmployee(Connection conn, Scanner scanner){
	String sql = "INSERT INTO Employees (name, age, department) VALUES (?, ?, ?)";
	try(PreparedStatement pstmt = conn.prepareStatement(sql)){
	
	System.out.print("Enter name: ");
	String name = scanner.nextLine();
	
	System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // clean newline

            System.out.print("Enter department: ");
            String dept = scanner.nextLine();
          
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, dept);
            pstmt.executeUpdate();

            System.out.println("➕ Employee added!");
	}catch (SQLException e) {
            System.out.println("❌ Error adding employee: " + e.getMessage());
        }
        
}
public static void updateEmployee(Connection conn, Scanner scanner, int id){
    
    System.out.println("You can update: name, age, department. Just write!");
    String choice = scanner.nextLine();
    
    if(choice.equalsIgnoreCase("name")){
   String updateSQL = "UPDATE Employees SET name = ? WHERE id = ?";
   try(PreparedStatement update = conn.prepareStatement(updateSQL)){
        
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    
    update.setString(1, newName);
    update.setInt(2, id);
    update.executeUpdate(); // ВАЖНО!

    
    System.out.printf("Name: %s", newName);
    showAllEmployees(conn);
        }  catch(SQLException e){
    
    System.out.println("Error updating employee: " + e.getMessage());
      }
    }
     else if (choice.equalsIgnoreCase("age")){
      String updateSQL = "UPDATE Employees SET age = ? WHERE id = ?";
 try(PreparedStatement update = conn.prepareStatement(updateSQL)){
    
    //System.out.print("Enter the name: ");
    System.out.print("Enter new  age: ");
    int newAge = scanner.nextInt();
    scanner.nextLine();
    
    update.setInt(1, newAge);
    update.setInt(2, id);
    update.executeUpdate(); // ВАЖНО!

    
    System.out.printf("Age: %d\n", newAge);
    
    showAllEmployees(conn);
        }  catch(SQLException e){
    
    System.out.println("Error updating employee: " + e.getMessage());
      }
      
     }
     else if(choice.equalsIgnoreCase("department")){
     String updateSQL = "UPDATE Employees SET department = ? WHERE id = ?";
      try(PreparedStatement update = conn.prepareStatement(updateSQL)){
    
    //System.out.print("Enter the name: ");
   
   System.out.print("Enter new department: ");
    String newDepartment = scanner.nextLine();
    
    update.setString(1, newDepartment);
    update.setInt(2, id);
    update.executeUpdate(); // ВАЖНО!
    System.out.printf("department: %s", newDepartment);
    showAllEmployees(conn);
        }  catch(SQLException e){
    
    System.out.println("Error updating employee: " + e.getMessage());
      }
     }
     else{
          
          System.out.println("You enter not right command!");
          }


}
 public static void deleteEmployee(Connection conn, int id){
     try {
    String deleteSQL = "DELETE FROM Employees WHERE id = ?";
      try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
    
    
    deleteStmt.setInt(1, id);
    deleteStmt.executeUpdate();
     }
  
  } catch (SQLException e) {
            System.out.println("❌ Error adding contact: " + e.getMessage());
        }
    
    }
    
  public static void addPaymentsForAllEmployees(Connection conn, Scanner scanner) {
  
    String sql = "INSERT INTO Payments (employee_id, amount) VALUES (?, ?)";
    
    try (
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name FROM Employees");
        PreparedStatement pstmt = conn.prepareStatement(sql);
    ) {
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            
            System.out.printf("Enter the sum of amount for %s (ID: %d)", name, id);
            double amount = scanner.nextDouble();
            scanner.nextLine();
            
            pstmt.setInt(1, id);
            pstmt.setDouble(2, amount);
            pstmt.executeUpdate();
            System.out.printf("Added payment of %.2f for employee ID %d%n", amount, id);
            }
        
    } catch (SQLException e) {
        System.out.println("Error adding payments: " + e.getMessage());
    }
}

public static void showEmployeesWithPayments(Connection conn) {
    String sql = "SELECT e.id, e.name, e.age, e.department, " +
                 "IFNULL(SUM(p.amount), 0) AS total_payments " +
                 "FROM Employees e " +
                 "LEFT JOIN Payments p ON e.id = p.employee_id " +
                 "GROUP BY e.id, e.name, e.age, e.department " +
                 "ORDER BY e.id";

    try (
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
    ) {
        System.out.println("Employees and their total payments:");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String department = rs.getString("department");
            double totalPayments = rs.getDouble("total_payments");

            System.out.printf("ID: %d | Name: %s | Age: %d | Dept: %s | Total Payments: %.2f%n",
                              id, name, age, department, totalPayments);
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving employees with payments: " + e.getMessage());
    }
}
public static void createPaymentsTableIfNotExists(Connection conn) {
    String sql = """
        CREATE TABLE IF NOT EXISTS Payments (
            id INT AUTO_INCREMENT PRIMARY KEY,
            employee_id INT,
            amount DECIMAL(10,2),
            FOREIGN KEY (employee_id) REFERENCES Employees(id)
        )
        """;

    try (Statement stmt = conn.createStatement()) {
        stmt.executeUpdate(sql);
        System.out.println("Payments table checked/created.");
    } catch (SQLException e) {
        System.out.println("Error creating Payments table: " + e.getMessage());
    }
}
public static void clearPaymentsTable(Connection conn) {
    String sql = "TRUNCATE TABLE Payments"; // или "DELETE FROM Payments"

    try (Statement stmt = conn.createStatement()) {
        stmt.executeUpdate(sql);
        System.out.println("🗑️ Payments table cleared successfully.");
    } catch (SQLException e) {
        System.out.println("❌ Error clearing Payments table: " + e.getMessage());
    }
}


  
  }

