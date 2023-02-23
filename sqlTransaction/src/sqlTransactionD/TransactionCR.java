package sqlTransactionD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;





public class TransactionCR {
	Scanner sc = new Scanner(System.in);
	 
	public static void main(String[] args) throws SQLException {
		Connection getconnection = ConectionC.Getconnection();
		
		try {
			ConectionC.con.setAutoCommit(false);
		
			 PreparedStatement  st1=ConectionC.con.prepareStatement("INSERT INTO Stud values('kajal','daman','female',25)");
			 st1.executeUpdate();
			 PreparedStatement  st2=ConectionC.con.prepareStatement("INSERT INTO Stud values('pratik','valsad','male',25)");
			 st2.executeUpdate();
			 PreparedStatement  st3=ConectionC.con.prepareStatement("INSERT INTO Stud values(12356468,'daman','female',30)");
			 st3.executeUpdate();
			 System.out.println("data inserted");
			 ConectionC.con.commit();
			 ConectionC.con.close();
			 
			 
		} catch (Exception e) {
			System.out.println("data not inserted");
			ConectionC.con.rollback();
			
			
			
		}
		

	}

}
