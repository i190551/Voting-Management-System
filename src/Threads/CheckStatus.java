package Threads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectiondb.dbhandler;

public class CheckStatus implements Runnable {


	private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("\nStatus of All Candidates:");
		try {
       		connection=handler.getConnection();
           	String results="SELECT candidatename,numofvotes FROM candidates ";
           	pst = connection.prepareStatement(results);
           	
           	ResultSet rs=pst.executeQuery();
           	int i=1;
           	while (rs.next())
    		{
    			System.out.println("\n"+i++ +"."+"Name:"  + rs.getString(1)+"\nVotes:"+rs.getString(2) );
    		}
    		

    		

       		//System.out.println("Is the Winner");
       		pst.close();	
       	}catch(Exception e)
       	{
       		System.out.println(e);
       	}

		
	}

}
