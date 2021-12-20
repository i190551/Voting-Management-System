package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Threads.CheckStatus;
import connectiondb.dbhandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Candidate extends User
{
	 private Connection connection;
	    private PreparedStatement pst;
	    private dbhandler handler=new dbhandler();

  

	private String candname;

    private String candsymbol;

    private String candparty;
    
    private String candcnic;

    private String passwordcand;
    
    private void showAlert1(AlertType error, Window owner, String string, String string2) {
		// TODO Auto-generated method stub
		 Alert alert = new Alert(error);
	        alert.setTitle(string);
	        alert.setHeaderText(null);
	        alert.setContentText(string2);
	        alert.initOwner(owner);
	        alert.show();
		
	}
    
    public Candidate(String candname, String candsymbol, String candparty, String candcnic, String passwordcand) {
  		this.candname = candname;
  		this.candsymbol = candsymbol;
  		this.candparty = candparty;
  		this.candcnic = candcnic;
  		this.passwordcand = passwordcand;
  	}
    

	@Override
	public void viewreport() {
		// TODO Auto-generated method stub
		try {
	   		connection=handler.getConnection();
	       	String results="SELECT candidatename,numofvotes FROM candidates";
	       	pst = connection.prepareStatement(results);
	       	
	       	ResultSet rs=pst.executeQuery();
	       	
	       	while (rs.next())
			{
				System.out.println("\n"  + rs.getString(1) + " : " + rs.getString(2));
			}
			

			

	   		//System.out.println("Is the Winner");
	   		pst.close();	
	   	}catch(Exception e)
	   	{
	   		System.out.println(e);
	   	}
	   	
	   	try {
	   		connection=handler.getConnection();
	      	String winner="SELECT candidatename FROM candidates WHERE numofvotes=(SELECT MAX(numofvotes) FROM candidates)";	         
	      	pst = connection.prepareStatement(winner);
	       	
	       	ResultSet rs=pst.executeQuery();
	       	
	       	while (rs.next())
			{
				System.out.println("\n"  + rs.getString(1)+" is the winner");
			}
			

			

	   		//System.out.println("Is the Winner");
	   		pst.close();	
	   	}catch(Exception e)
	   	{
	   		System.out.println(e);
	   	}

	}



	@Override
	public void searchcandidates(String ccnic) {
	
		int id=Integer.parseInt(ccnic);
		
		System.out.println("\nCandidate Information:");
		try {
       		connection=handler.getConnection();
           	String results="SELECT candidatename, symbol, candidateparty,numofvotes FROM candidates where cnic= "+id;
           	pst = connection.prepareStatement(results);
           	
           	ResultSet rs=pst.executeQuery();
         
           	while (rs.next())
    		{
    			System.out.println("\nName:" + rs.getString(1)+"\nSymbol: " +rs.getString(2) +"\nParty: "+rs.getString(3)+"\nVotes:"+rs.getString(4)   );
    			
    		}
    		

    		

       		//System.out.println("Is the Winner");
       		pst.close();	
       	}catch(Exception e)
       	{
       		System.out.println(e);
       	}
       	
		
	}
	
	public void updateprofile() throws IOException
	{
		
		String update="UPDATE candidates SET candidatename=?,password=? WHERE cnic="+candcnic;
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
			pst.setString(1,candname);
			pst.setString(2,passwordcand);
			   
			pst.executeUpdate();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		

		System.out.println("Candidate Profile Updated");
		

    	Main m=new Main();
        m.changeScene("CandidateProcedure.fxml","Options");
        
		showAlert1(Alert.AlertType.CONFIRMATION,null, "Updated!","Profile Updated" );
	}
	
	public void checkstatus()
	{
		Thread cs=new Thread(new CheckStatus());
		cs.run();
	}

	@Override
	public void signup() throws IOException {
		
		 if(candcnic.length()<13||candcnic.length()>13)
		{
			showAlert1(Alert.AlertType.ERROR,null, "CNIC ERROR!","Invalid CNIC" );
			try {
			throw new InvalidcnicException();
			}catch(InvalidcnicException e)
			{
				e.printStackTrace();
			}
		}
		 else
		 {
		// TODO Auto-generated method stub
			 
			 FileWriter myfile = null; 
				BufferedWriter b = null; 
				PrintWriter p = null;
				try { 
					myfile = new FileWriter("candidates.txt", true); 
					b = new BufferedWriter(myfile); 
					p = new PrintWriter(b);
					  p.write("\n************************************************");
					 p.write("\nCandidate Name:"+candname);
					  
					  p.write("\nCNIC:"+candcnic);
					  
					  p.write("\nParty:"+candparty);
					  
					  p.write("\nSymbol:"+candsymbol);
					
					  p.write("\nPassword:"+passwordcand);
						
					p.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally { 
						try { 
							p.close(); 
							b.close(); 
							myfile.close(); 
							} catch (IOException io) { }
					}
				
		String insert="INSERT INTO candidates(cnic,candidatename,candidateparty,symbol,numofvotes,password,approval)"+"VALUES(?,?,?,?,?,?,?)";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(insert);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			pst.setString(1,candcnic);
			pst.setString(2,candname);

			pst.setString(3,candparty);
			pst.setString(4,candsymbol);
			pst.setInt(5,0);
			pst.setString(6,passwordcand);
			pst.setInt(7,0);
			
			pst.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		Main m=new Main();
        m.changeScene("Choice.fxml","Choice");
        

    	showAlert1(Alert.AlertType.INFORMATION,null, "Success","Your Request is Submitted, you will be approved by the Admin Soon" );
    	
		 }

	}

	@Override
	public void login() throws IOException {
		// TODO Auto-generated method stub
		
		
		connection=handler.getConnection();
    	String auth="Select * from candidates where cnic=? and password=?and approval=1";
    
    	try {
    	pst = connection.prepareStatement(auth);
    	pst.setString(1,candcnic);
    	pst.setString(2, passwordcand);
    	
    	ResultSet rs=pst.executeQuery();
    	
    	int count=0;
    	while(rs.next())
    	{
    		count=count+1;
    	}
    	
    	if(count==1)
    	{
    		System.out.print("Login Successful");
    		
    		

	    	Main m=new Main();
            m.changeScene("CandidateProcedure.fxml","Options");

//	    	Stage votingproc=new Stage();
//			Parent root=FXMLLoader.load(getClass().getResource("CandidateProcedure.fxml"));
//
//			Scene scene=new Scene(root);
//			votingproc.setScene(scene);
//			votingproc.show();
//			votingproc.setResizable(false);
//
//			votingproc.setTitle("Options");
    	}
    	else
    	{
    		showAlert1(Alert.AlertType.ERROR,null, "Error!",
	                 "Invalid CNIC or Password,or may be you are not approved by the Administrator");
    		
    		
    		try {

        		throw new InvalidCredentialsException();
        		}catch(InvalidCredentialsException e)
        		{
        			e.printStackTrace();
        		}

    	}
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    		
    	finally
    	{
    		try
    		{
    			connection.close();
    		}catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    	}

		
	}


	@Override
	public void viewcandidates() {
		// TODO Auto-generated method stub
		
	}

	


}
