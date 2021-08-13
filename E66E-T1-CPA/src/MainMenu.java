/*
 * Matthew Ng Wei Chen 20011105
 */

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper.line(30, "-");
		System.out.println("Welcome to Career Planning Application (CPA)!");
		Helper.line(30, "-");
		System.out.println("1. User account details");
		System.out.println("2. Academic cluster details");
		System.out.println("3. Career information details");
		System.out.println("4. Subject details");
		System.out.println("5. Prerequisites details");
		System.out.println("6. Quit");
		
		int option = Helper.readInt("Choose an option: ");
		while (option != 6) {
			if (option == 1) {
				//Patrick you key in your start method here (User account information)
			}
			else if (option == 2) {
				//Philip you key in your start method here (academic cluster information)
			}
			else if (option == 3) {
				//Hikma you key in your start method here (career information)
			}
			else if (option == 4) {
				SubjectManagement.start();
			}
			else if (option == 5) {
				PrerequisiteManagement.start();
			}
			else {
				System.out.println("Invalid option!");
			}
		}
		
		System.out.println("Thank you for using Career Planning Application (CPA), goodbye!");
		
	}

}
