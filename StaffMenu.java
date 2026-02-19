package eco;


	import java.sql.*;
	import java.util.Scanner;

	public class StaffMenu {

	    public static void staffOperations() {
	        Scanner sc = new Scanner(System.in);
	        Connection con = DBConnection.getConnection();

	        while (true) {
	            System.out.println("\n--- Staff Menu ---");
	            System.out.println("1. Add Waste Collection Record");
	            System.out.println("2. Update Collection Status");
	            System.out.println("3. Back");
	            System.out.print("Enter choice: ");
	            int ch = sc.nextInt();

	            try {
	                if (ch == 1) {
	                    System.out.print("Area Name: ");
	                    sc.nextLine();
	                    String area = sc.nextLine();

	                    System.out.print("Waste Type: ");
	                    String type = sc.nextLine();

	                    System.out.print("Collection Date (YYYY-MM-DD): ");
	                    String date = sc.next();

	                    System.out.print("Collected By: ");
	                    sc.nextLine();
	                    String staff = sc.nextLine();

	                    PreparedStatement ps = con.prepareStatement(
	                        "INSERT INTO waste_collection(area_name,waste_type,collection_date,collected_by,status) VALUES(?,?,?,?,?)"
	                    );
	                    ps.setString(1, area);
	                    ps.setString(2, type);
	                    ps.setDate(3, Date.valueOf(date));
	                    ps.setString(4, staff);
	                    ps.setString(5, "Pending");
	                    ps.executeUpdate();

	                    System.out.println("Record Added Successfully");

	                } else if (ch == 2) {
	                    System.out.print("Enter Record ID: ");
	                    int id = sc.nextInt();

	                    System.out.print("Enter New Status (Collected/Pending): ");
	                    String status = sc.next();

	                    PreparedStatement ps = con.prepareStatement(
	                        "UPDATE waste_collection SET status=? WHERE record_id=?"
	                    );
	                    ps.setString(1, status);
	                    ps.setInt(2, id);
	                    ps.executeUpdate();

	                    System.out.println("Status Updated");

	                } else if (ch == 3) {
	                    break;
	                } else {
	                    System.out.println("Invalid choice");
	                }
	            } catch (Exception e) {
	                System.out.println("Operation Failed");
	            }
	        }
	    }
	}


