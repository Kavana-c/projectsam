package eco;


	
	import java.sql.*;
	import java.util.Scanner;

	public class AdminMenu {

	    public static void adminOperations() {
	        Scanner sc = new Scanner(System.in);
	        Connection con = DBConnection.getConnection();

	        while (true) {
	            System.out.println("\n--- Admin Menu ---");
	            System.out.println("1. View All Records");
	            System.out.println("2. View Pending Collections");
	            System.out.println("3. Delete Completed Records");
	            System.out.println("4. Back");
	            System.out.print("Enter choice: ");

	            int ch = sc.nextInt();

	            try {
	                if (ch == 1) {
	                    Statement st = con.createStatement();
	                    ResultSet rs = st.executeQuery("SELECT * FROM waste_collection");

	                    while (rs.next()) {
	                        System.out.println(
	                            rs.getInt(1) + " | " +
	                            rs.getString(2) + " | " +
	                            rs.getString(3) + " | " +
	                            rs.getDate(4) + " | " +
	                            rs.getString(5) + " | " +
	                            rs.getString(6)
	                        );
	                    }

	                } else if (ch == 2) {
	                    PreparedStatement ps = con.prepareStatement(
	                        "SELECT * FROM waste_collection WHERE status='Pending'"
	                    );
	                    ResultSet rs = ps.executeQuery();

	                    while (rs.next()) {
	                        System.out.println(
	                            rs.getInt(1) + " | " +
	                            rs.getString(2) + " | " +
	                            rs.getString(3)
	                        );
	                    }

	                } else if (ch == 3) {
	                    PreparedStatement ps = con.prepareStatement(
	                        "DELETE FROM waste_collection WHERE status='Collected'"
	                    );
	                    ps.executeUpdate();
	                    System.out.println("Completed Records Deleted");

	                } else if (ch == 4) {
	                    break;
	                } else {
	                    System.out.println("Invalid choice");
	                }
	            } catch (Exception e) {
	                System.out.println("Admin Operation Failed");
	            }
	        }
	    }
	}



