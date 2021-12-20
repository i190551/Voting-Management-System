package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectiondb.dbhandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Threads.RecordCandidatesThread;
import Threads.RecordVotersThread;

public class Administrator {

	private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();
	 
	private String cnic;
	
	public Administrator(String id1)
	{
		
		cnic=id1;
		
	}
	
	public void loginadmin() throws IOException
	{
		

    	Main m=new Main();
        m.changeScene("ManageSystem.fxml","Manage");
	}

	
	public void ManageVoter() throws IOException
	{
		

    	Main m=new Main();
        m.changeScene("Approval.fxml","ApprovalStatus");
	

	}
	
	public void ManageCandidate() throws IOException
	{
		

    	Main m=new Main();
        m.changeScene("ApproveCandidate.fxml","ApprovalStatus");
        
	

	}
	
	
	public void approveVoter() throws IOException
	{
		
		String update="UPDATE votes SET Approve=1 WHERE cnic="+cnic;
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
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
		System.out.println("Status:Approved");
		
		

    	Main m=new Main();
        m.changeScene("ManageSystem.fxml","Manage");
		
	
	}
	
	public void disapprovevoter() throws IOException
	{
		String update="UPDATE votes SET Approve=0 WHERE cnic="+cnic;
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
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
		
		
		System.out.println("Status:Disapproved");
		
		

    	Main m=new Main();
        m.changeScene("ManageSystem.fxml","Manage");
		

	}
	
	
	public void approvecandidate() throws IOException
	{
		String update="UPDATE candidates SET approval=1 WHERE cnic="+cnic;
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
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
		

		System.out.println("Status:Approved");

    	Main m=new Main();
        m.changeScene("ManageSystem.fxml","Manage");
		

	}
	
	
	public void disapprovecandidate() throws IOException
	{
		String update="UPDATE candidates SET approval=0 WHERE cnic="+cnic;
		
		connection = handler.getConnection(); 
		try {
			pst=connection.prepareStatement(update);
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
		

		System.out.println("Status:Disapproved");
		
		

    	Main m=new Main();
        m.changeScene("ManageSystem.fxml","Manage");
	
	}
	
	public void recordsofcandidates() throws IOException
	{

	
		Thread t0=new Thread(new RecordCandidatesThread());
		t0.run();


	}

	
	public void recordofvoters() throws IOException
	{
		
		Thread t1=new Thread(new RecordVotersThread());
		t1.run();
		
		

	}
}
