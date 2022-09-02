package test;
import java.sql.*;
import java.util.*;
public class DBCon7 {
	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the AccNo: ");
			long accNo=s.nextLong();
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclb","system","amol");
			
			CallableStatement cs=con.prepareCall("{call RetrieveDetails44(?,?,?,?,?,?,?)}");
			cs.setLong(1,accNo);
			
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.FLOAT);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7,Types.BIGINT);
			
			cs.execute();
			
			System.out.println("Procedure Executed Successfully...");
			System.out.println("AccNo: "+accNo);
			System.out.println("CustName: "+cs.getString(2));
			System.out.println("Balance: "+cs.getFloat(3));
			System.out.println("AccType: "+cs.getString(4));
			System.out.println("Address: "+cs.getString(5));
			System.out.println("MailId: "+cs.getString(6));
			System.out.println("PhNo: "+cs.getLong(7));
			con.close();
			s.close();
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
