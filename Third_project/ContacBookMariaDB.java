import java.sql.*;

public class ContacBookMariaDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/contactdb";
        String user = "nurbol";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connected to MariaDB!");

            String sql = "SELECT * FROM contacts";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                System.out.printf("Name: %s | Phone: %s%n", name, phone);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error connecting to DB:");
            e.printStackTrace();
        }
    }
}

