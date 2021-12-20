package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Threads.ReportThread;
import Threads.ViewCandidatesThread;
import connectiondb.dbhandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Voter extends User
{

	private Connection connection;
  	 private PreparedStatement pst;
  	 private dbhandler handler=new dbhandler();
  	 

	private String username;

     private String cnic;

     private String place;

     private String password;
      
     private String age;
     
     
     private void showAlert1(AlertType error, Window owner, String string, String string2) {
 		// TODO Auto-generated method stub
 		 Alert alert = new Alert(error);
 	        alert.setTitle(string);
 	        alert.setHeaderText(null);
 	        alert.setContentText(string2);
 	        alert.initOwner(owner);
 	        alert.show();
 		
 	}
  	 public Voter(String username, String cnic, String place, String password, String age) 
  	 {
		this.username = username;
		this.cnic = cnic;
		this.place = place;
		this.password = password;
		this.age=age;
  	 }
  	 
  	 
	@Override
	public void viewreport() throws IOException {
		
		
		Thread t=new Thread(new ReportThread());
		t.run();
	   	

	}

	@Override
	public void viewcandidates() {
		// TODO Auto-generated method stub
		
		Thread tt=new Thread(new ViewCandidatesThread());
				tt.run();
		
		
	}
	@Override
	public void searchcandidates(String cname) {
		
		
		System.out.println("\nCandidate Information:");
		try {
       		connection=handler.getConnection();
           	String results="SELECT candidatename, symbol, candidateparty,numofvotes FROM candidates where candidatename=? ";
           	
           	pst = connection.prepareStatement(results);
           	
    			
           	pst.setString(1,cname);
    			   
    			
           	ResultSet rs=pst.executeQuery();
         
           	
           	while (rs.next())
    		{
    			System.out.println("\nName:" + rs.getString(1)+"\nSymbol: " +rs.getString(2) +"\nParty: "+rs.getString(3)+"\nVotes:"+rs.getString(4)   );
    			
    		}
    		

    		

       		pst.close();	
       	}catch(Exception e)
       	{
       		System.out.println(e);
       	}
       	
		
	}
	
	public void HELP() throws IOException
	{
		

    	Main m=new Main();
        m.changeScene("Help.fxml","HELP");

		
	}
	public void castvote(String candname) throws IOException
	{

    	
    	System.out.println("Voted="+candname);
    	String update="UPDATE candidates SET numofvotes=numofvotes+1 WHERE candidatename=?";
    	  
    	connection = handler.getConnection(); 
    	
    	try {
			pst=connection.prepareStatement(update);
			pst.setString(1,candname);
			   
			pst.executeUpdate();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
    	showAlert1(Alert.AlertType.CONFIRMATION,null, "Voted",
                "Voted!");

    	
    
  		
  	}
	
	public void logoutvoter() throws IOException
	{
		

    	Main m=new Main();
        m.changeScene("Choice.fxml","Electronic Voting");
//    	Stage votingproc=new Stage();
//    	Parent root=FXMLLoader.load(getClass().getResource("Choice.fxml"));
//
//    	Scene scene=new Scene(root);
//    	votingproc.setScene(scene);
//    	votingproc.show();
//    	votingproc.setResizable(false);
//
//    	votingproc.setTitle("Electronic Voting");
    	
	}


	@Override
	public void signup() throws IOException {
		// TODO Auto-generated method stub
		

		
    	int vage=Integer.parseInt(age); 
		if(vage<18)
		{
			showAlert1(Alert.AlertType.ERROR,null, "Error","Your Age must be greater than 18" );
			try {
			throw new AgeException();
			}catch(AgeException e)
			{
				e.printStackTrace();
			}
			
		}
		
		else if(cnic.length()<13||cnic.length()>13)
		{
			showAlert1(Alert.AlertType.ERROR,null, "CNIC ERROR!","Invalid CNIC" );
			try {
			throw new InvalidcnicException();
			}catch(InvalidcnicException e)
			{
				e.printStackTrace();
			}
		}
		else {
		
			
			FileWriter myfile = null; 
			BufferedWriter b = null; 
			PrintWriter p = null;
			try { 
				myfile = new FileWriter("voters.txt", true); 
				b = new BufferedWriter(myfile); 
				p = new PrintWriter(b);
				  p.write("\n************************************************");
				 p.write("\nVoter Name:"+username);
				  
				  p.write("\nCNIC:"+cnic);
				  
				  p.write("\nAge:"+age);
				  
				  p.write("\nPlace:"+place);
				  
				  p.write("\nPassword:"+password);
				
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
			

			
		String insert="INSERT INTO votes(cnic,name,place,pass,Approve)"+"VALUES(?,?,?,?,?)";
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(insert);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			
			pst.setString(1, cnic);
			pst.setString(2,username);

			pst.setString(3,place);
			pst.setString(4,password);
			pst.setInt(5,0);
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
    	String auth="Select * from votes where cnic=? and pass=? and Approve=1";
    	
    
    	try {
    	pst = connection.prepareStatement(auth);
    	pst.setString(1,cnic);
    	pst.setString(2, password);
    	
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
            m.changeScene("votingProcedure.fxml","Options");

//	    	Stage votingproc=new Stage();
//			Parent root=FXMLLoader.load(getClass().getResource("votingProcedure.fxml"));
//
//			Scene scene=new Scene(root);
//			votingproc.setScene(scene);
//			votingproc.show();
//			votingproc.setResizable(false);
//
//			votingproc.setTitle("Voting Option");
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



	

}
