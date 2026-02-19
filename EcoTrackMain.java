package eco;

	
	import java.util.Scanner;

	public class EcoTrackMain {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n===== EcoTrack Waste Monitoring System =====");
	            System.out.println("1. Staff Menu");
	            System.out.println("2. Admin Menu");
	            System.out.println("3. Exit");
	            System.out.print("Enter choice: ");

	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    StaffMenu.staffOperations();
	                    break;
	                case 2:
	                    AdminMenu.adminOperations();
	                    break;
	                case 3:
	                    System.out.println("Thank you for using EcoTrack");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }
	}



