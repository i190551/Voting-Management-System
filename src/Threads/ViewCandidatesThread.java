package Threads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectiondb.dbhandler;

public class ViewCandidatesThread implements Runnable{
	

	private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();

	public ViewCandidatesThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("\nAll the Candidates who are standing are: ");
		try {
       		connection=handler.getConnection();
           	String results="SELECT candidatename, symbol, candidateparty FROM candidates ";
           	pst = connection.prepareStatement(results);
           	
           	ResultSet rs=pst.executeQuery();
           	int i=1;
           	while (rs.next())
    		{
    			System.out.println("\n\n"+i++ +") " + rs.getString(1)+"\nSymbol: " +rs.getString(2) +"\nParty: "+rs.getString(3)  );
    			
    		}
    		

    		

       		//System.out.println("Is the Winner");
       		pst.close();	
       	}catch(Exception e)
       	{
       		System.out.println(e);
       	}
       	
		
	}

}
