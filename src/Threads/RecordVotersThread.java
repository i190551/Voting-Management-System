package Threads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectiondb.dbhandler;

public class RecordVotersThread implements Runnable {


	private Connection connection;
	 private PreparedStatement pst;
	 private dbhandler handler=new dbhandler();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			connection=handler.getConnection();
	    	String record="Select * from votes";
	    
	    
	    	pst = connection.prepareStatement(record);
	    	
	    	ResultSet rs=pst.executeQuery();
	    	
		System.out.println("Records of Voters:");
		while (rs.next())
		{
			System.out.println("\n" + rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		}
		
		pst.close();	
	}catch(Exception e)
	{
		System.out.println(e);
	}
    
		
	}

}
