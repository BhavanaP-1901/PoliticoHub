package com.tka.service;
import java.util.List;
import com.tka.dao.Dao;
import com.tka.entity.Candidate;
import java.util.Scanner;
import java.util.Scanner;
public class Service {
	
	Scanner sc = new Scanner(System.in);
    Dao dao =new Dao();
	
	public List<Candidate> getAllCandidates() {
	// TODO Auto-generated method stub
	      //System.out.println("We are at service class");
          List<Candidate> allCandidates=dao.getAllCandidates();
          System.out.println("***********************************************************************************");
			System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", "C_id", "C_Name", "Party", "State", "Assembly","Gender","Age");
			System.out.println("***********************************************************************************");
			for (Candidate candidate : allCandidates) {
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", candidate.getC_id(), candidate.getC_name(),
						candidate.getParty(), candidate.getState(), candidate.getAssembly(), candidate.getGender(), candidate.getAge());
				// System.out.println(p);
				System.out.println("------------------------------------------------------------------------------------");
			}
          return allCandidates;
}

	public void addCandidate() {
		
		try {
		System.out.println("Enter Candidate Details:");
		System.out.println("Enter Candidate ID: ");
		int c_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Candidate Name: ");
		String c_name = sc.nextLine();
		System.out.println("Enter Party name: ");
		String party = sc.nextLine();
		System.out.println("Enter State: ");
		String state = sc.nextLine();
		System.out.println("Enter Assembly: ");
		String assembly = sc.nextLine();
		System.out.println("Enter Gender: ");
		String gender = sc.nextLine();
		System.out.println("Enter Age: ");
		int age= sc.nextInt();
		//sc.nextLine();

		Candidate newCandidate = new Candidate(c_id,c_name,party,state,assembly,gender,age);
		dao.addCandidate(newCandidate);
		System.out.println("Candidate added successfully!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeCandidate() {
		System.out.println("Enter the ID of candidate to remove: ");
		int cid_remove = sc.nextInt();
		sc.nextLine();
		boolean removed = dao.removeCandidate(cid_remove);
		if (removed) {
			System.out.println("Candidate removed successfully!");
		} else {
			System.out.println("Candidate not found.");
		}
		
    }
	public List<Candidate> getAllCandidatesByParty() {
		      System.out.println("Enter the Party name");
		      String partyName = sc.nextLine();
	          List<Candidate> allCandidatesByParty=dao.getCandidatesByPartyName(partyName);
	          System.out.println("***********************************************************************************");
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", "C_id", "C_Name", "Party", "State", "Assembly","Gender","Age");
				System.out.println("***********************************************************************************");
				for (Candidate candidate : allCandidatesByParty) {
					System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", candidate.getC_id(), candidate.getC_name(),
							candidate.getParty(), candidate.getState(), candidate.getAssembly(), candidate.getGender(), candidate.getAge());
					// System.out.println(p);
					System.out.println("------------------------------------------------------------------------------------");
				}
	        return allCandidatesByParty;
			
	}
	public List<Candidate> getAllCandidatesByAssemblyName() {
	      System.out.println("Enter the Assembly name");
	      String assemblyName = sc.nextLine();
        List<Candidate> allCandidatesByAssemblyName=dao.getCandidatesByAssemblyName(assemblyName);
        System.out.println("***********************************************************************************");
			System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", "C_id", "C_Name", "Party", "State", "Assembly","Gender","Age");
			System.out.println("***********************************************************************************");
			for (Candidate candidate : allCandidatesByAssemblyName) {
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", candidate.getC_id(), candidate.getC_name(),
						candidate.getParty(), candidate.getState(), candidate.getAssembly(), candidate.getGender(), candidate.getAge());
				// System.out.println(p);
				System.out.println("------------------------------------------------------------------------------------");
			}
      return allCandidatesByAssemblyName;
		
}
	
	public List<Candidate> getCandidatesByGender() {
	      System.out.println("Enter the Gender");
	      String assemblyName = sc.nextLine();
      List<Candidate> allCandidatesByGender=dao.getCandidatesByGender(assemblyName);
      System.out.println("***********************************************************************************");
			System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", "C_id", "C_Name", "Party", "State", "Assembly","Gender","Age");
			System.out.println("***********************************************************************************");
			for (Candidate candidate : allCandidatesByGender) {
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", candidate.getC_id(), candidate.getC_name(),
						candidate.getParty(), candidate.getState(), candidate.getAssembly(), candidate.getGender(), candidate.getAge());
				// System.out.println(p);
				System.out.println("------------------------------------------------------------------------------------");
			}
    return allCandidatesByGender;
		
}
	
	public List<Candidate> getAllCandidatesByName() {
	      System.out.println("Enter the name");
	      String Name = sc.nextLine();
      List<Candidate> candidatesbyname=dao.getCandidatesByName(Name);
      System.out.println("***********************************************************************************");
			System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", "C_id", "C_Name", "Party", "State", "Assembly","Gender","Age");
			System.out.println("***********************************************************************************");
			for (Candidate candidate : candidatesbyname) {
				System.out.printf("|%-4s|     %-20s| %-10s| %-7s| %-10s| %-7s| %-7s| \n", candidate.getC_id(), candidate.getC_name(),
						candidate.getParty(), candidate.getState(), candidate.getAssembly(), candidate.getGender(), candidate.getAge());
				// System.out.println(p);
				System.out.println("------------------------------------------------------------------------------------");
			}
    return candidatesbyname;
		
}

	public void updateCandidate() {
		
		 System.out.println("Enter Candidate ID you want to update:");
         int c_id = sc.nextInt();
         sc.nextLine(); // Consume newline

         System.out.println("Enter Candidate Name:");
         String c_name = sc.nextLine();

         System.out.println("Enter Party:");
         String party = sc.nextLine();

         System.out.println("Enter State:");
         String state = sc.nextLine();

         System.out.println("Enter Assembly:");
         String assembly = sc.nextLine();

         System.out.println("Enter Gender:");
         String gender = sc.nextLine();

         System.out.println("Enter Age:");
         int age = sc.nextInt();
         sc.nextLine(); // Consume newline

         // Create a Candidate object and populate it
         Candidate candidate = new Candidate(c_id, c_name, party, state, assembly, gender, age);

         // Update the candidate using the DAO method
         boolean success = dao.updateCandidate(candidate);
         if (success) {
             System.out.println("Candidate updated successfully!");
         } else {
             System.out.println("Failed to update candidate. Please try again.");
         }
	}
	
	
	
}