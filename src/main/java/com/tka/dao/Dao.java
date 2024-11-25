package com.tka.dao;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Candidate;

public class Dao {
	
	 String url="jdbc:mysql://localhost:3306/batch_193";
	 String uname="root";
	 String pwd="root";
	 private static final Logger LOGGER = Logger.getLogger(Dao.class.getName());

	 
	 String sql="select * from batch_193.candidate";
	 
	public List<Candidate>  getAllCandidates(){
		//System.out.println("we are at dao layer");
		List<Candidate> allCandidates = new ArrayList<Candidate>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println(1);
			
			Connection connection=DriverManager.getConnection(url, uname, pwd);
			//System.out.println(2);
			
			Statement st=connection.createStatement();
			//System.out.println(3);
			
			ResultSet rs=st.executeQuery(sql);
			//System.out.println(4);
			
			while(rs.next()) {
				int c_id=rs.getInt(1);
				String c_name=rs.getString(2);
				String party=rs.getString(3);
				String state=rs.getString(4);
				String assembly=rs.getString(5);
				String gender=rs.getString(6);
                int age=rs.getInt(7);
                
                Candidate ca=new Candidate(c_id,c_name,party,state,assembly,gender,age);
                allCandidates.add(ca);
				//System.out.println("Candidate is "+c_name+" and "+"party name is "+party+" from assembly "+assembly+".");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allCandidates;
		
		}
	
	public void addCandidate(Candidate candidate) {
		String sql = "INSERT INTO candidate (c_id,c_name,party,state,assembly,gender,age) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(url, uname, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, candidate.getC_id());
			pstmt.setString(2, candidate.getC_name());
			pstmt.setString(3, candidate.getParty());
			pstmt.setString(4,candidate.getState());
			pstmt.setString(5, candidate.getAssembly());
			pstmt.setString(6, candidate.getGender());
			pstmt.setInt(7, candidate.getAge());


			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
      
	public boolean updateCandidate(Candidate candidate) {
	    String sql = "UPDATE candidate SET c_name = ?, party = ?, state = ?, assembly = ?, gender = ?, age = ? WHERE c_id = ?";
	    try (Connection con = DriverManager.getConnection(url, uname, pwd);
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setString(1, candidate.getC_name());
	        pstmt.setString(2, candidate.getParty());
	        pstmt.setString(3, candidate.getState());
	        pstmt.setString(4, candidate.getAssembly());
	        pstmt.setString(5, candidate.getGender());
	        pstmt.setInt(6, candidate.getAge());
	        pstmt.setInt(7, candidate.getC_id());

	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        LOGGER.log(Level.SEVERE, "Error updating candidate: ", e);
	        return false;
	    }
	}
    
	
	public boolean removeCandidate(int c_id) {
		String sql = "DELETE FROM candidate WHERE c_id = ?";
		try (Connection con = DriverManager.getConnection(url, uname, pwd);
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, c_id);
			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<Candidate> getCandidatesByPartyName(String partyName) {
	        List<Candidate> candidatesByPartyName = new ArrayList<>();

	        String query = "SELECT * FROM batch_193.candidate WHERE party = ?";

	        try (Connection conn = DriverManager.getConnection(url, uname,pwd);
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            // Set the party name parameter in the prepared statement
	            pstmt.setString(1, partyName);

	            try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                    // Assuming the Candidate class has a constructor that takes all fields
	                    Candidate candidate = new Candidate(
	                        rs.getInt("c_id"),
	                        rs.getString("c_name"),
	                        rs.getString("party"),
	                        rs.getString("state"),
	                        rs.getString("assembly"),
	                        rs.getString("gender"),
	                        rs.getInt("age")
	                    );
	                    candidatesByPartyName.add(candidate);
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("Error retrieving candidates by party: " + e.getMessage());
	        }

	        return candidatesByPartyName;
	    }
	
	public List<Candidate> getCandidatesByAssemblyName(String assemblyName) {
        List<Candidate> candidatesByAssemblyName = new ArrayList<>();

        String query = "SELECT * FROM batch_193.candidate WHERE assembly = ?";

        try (Connection conn = DriverManager.getConnection(url, uname,pwd);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the party name parameter in the prepared statement
            pstmt.setString(1, assemblyName);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Assuming the Candidate class has a constructor that takes all fields
                    Candidate candidate = new Candidate(
                        rs.getInt("c_id"),
                        rs.getString("c_name"),
                        rs.getString("party"),
                        rs.getString("state"),
                        rs.getString("assembly"),
                        rs.getString("gender"),
                        rs.getInt("age")
                    );
                    candidatesByAssemblyName.add(candidate);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving candidates by party: " + e.getMessage());
        }

        return candidatesByAssemblyName;
    }

	
	 public List<Candidate> getCandidatesByName(String Name) {
	        List<Candidate> candidatesbyname = new ArrayList<>();

	        String query = "SELECT * FROM batch_193.candidate WHERE c_name LIKE ?";

	        try (Connection conn = DriverManager.getConnection(url, uname, pwd);
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            // Set the name pattern parameter with wildcards for partial matching
	            pstmt.setString(1, "%" + Name + "%");

	            try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                    // Assuming the Candidate class has a constructor that takes all fields
	                    Candidate candidate = new Candidate(
	                        rs.getInt("c_id"),
	                        rs.getString("c_name"),
	                        rs.getString("party"),
	                        rs.getString("state"),
	                        rs.getString("assembly"),
	                        rs.getString("gender"),
	                        rs.getInt("age")
	                    );
	                    candidatesbyname.add(candidate);
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("Error retrieving candidates by name pattern: " + e.getMessage());
	        }

	        return candidatesbyname;
	    }
	 
	 public List<Candidate> getCandidatesByGender(String Gender) {
	        List<Candidate> candidatesByGender = new ArrayList<>();

	        String query = "SELECT * FROM batch_193.candidate WHERE gender = ?";

	        try (Connection conn = DriverManager.getConnection(url, uname,pwd);
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            // Set the party name parameter in the prepared statement
	            pstmt.setString(1, Gender);

	            try (ResultSet rs = pstmt.executeQuery()) {
	                while (rs.next()) {
	                    // Assuming the Candidate class has a constructor that takes all fields
	                    Candidate candidate = new Candidate(
	                        rs.getInt("c_id"),
	                        rs.getString("c_name"),
	                        rs.getString("party"),
	                        rs.getString("state"),
	                        rs.getString("assembly"),
	                        rs.getString("gender"),
	                        rs.getInt("age")
	                    );
	                    candidatesByGender.add(candidate);
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("Error retrieving candidates by party: " + e.getMessage());
	        }

	        return candidatesByGender;
	    }

		
	}
