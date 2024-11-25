package com.tka.controller;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Candidate;
import com.tka.service.Service;

public class ECCIController {
	
	Service service =new Service();
	
	public List<Candidate> getAllCandidates(){
	    
		//System.out.println("We are at controller class");
	    List<Candidate> allCandidates=service.getAllCandidates();
        return allCandidates;

}

	public void addCandidate() {
		service.addCandidate();
	}
	
	public void removeCandidate() {
		service.removeCandidate();
    }
	
	public List<Candidate> getAllCandidatesByParty() {
	      List<Candidate> allCandidatesbyparty = service.getAllCandidatesByParty();
		  return allCandidatesbyparty;
	
	}
	
	public List<Candidate> getAllCandidatesByAssemblyName() {
	      List<Candidate> allCandidatesbyAssemblyName = service.getAllCandidatesByAssemblyName();
		  return allCandidatesbyAssemblyName;
	
	}
	
	public List<Candidate> getCandidatesByGender() {
	      List<Candidate> CandidatesByGender = service.getCandidatesByGender();
		  return CandidatesByGender;
	
	}
	public List<Candidate> getAllCandidatesByName() {
		List<Candidate> candidatesbyname=service.getAllCandidatesByName();
		return candidatesbyname;
	}

	public void updateCandidate() {
		service.updateCandidate();
		
	}
}
