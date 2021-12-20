package Threads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectiondb.dbhandler;

public class ReportThread implements Runnable {

	private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();

	public ReportThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("\n****************************Election Report****************************");
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

}
