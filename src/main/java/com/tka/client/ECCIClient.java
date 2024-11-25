package com.tka.client;
import java.util.Scanner;
import com.tka.entity.Candidate;
import java.util.List;
import com.tka.controller.ECCIController;


public class ECCIClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ECCIController controller=new ECCIController();
		
		try {
			do {
				System.out.println("   Welcome to ECCI  ");
				System.out.println();
				System.out.println("1. View all Candidates");
				System.out.println("2. Add candidate");
				System.out.println("3. Update Candidate");		
			    System.out.println("4. Remove Candidate");
				System.out.println("5. View Candidates by Party name");
				System.out.println("6. View Candidates by Assembly");
				System.out.println("7. View Candidates by Name");
				System.out.println("8. View Candidates by Gender");
				System.out.println("9. Exit");
				System.out.println("Enter your choice: ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					List<Candidate> allCandidates = controller.getAllCandidates();
					break;
					
				case 2:
                    controller.addCandidate();
					break;
					
				case 3:
					controller.updateCandidate();
					break;
		        
				case 4:
					controller.removeCandidate();
					break;
					
				case 5:
					controller.getAllCandidatesByParty();
					break;
					
				case 6:
					controller.getAllCandidatesByAssemblyName();
					break;
				
				case 7:
					List<Candidate> candidatesbyname = controller.getAllCandidatesByName();
					break;
				
				
				case 8:
					List<Candidate> CandidatesByGender = controller.getCandidatesByGender();
					break;
				
				
				case 9:

					System.out.println("Thank You for Using Our Service");
					sc.close();
					System.exit(0);
					break;

               default:
	           System.out.println("Invalid Option, Try Again");
			   }

               } while (true);
           }catch (Exception e) {
                   e.printStackTrace();
                   }

		
}
}