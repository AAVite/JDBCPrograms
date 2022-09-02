package test;
import java.sql.*;
import java.util.*;
public class DBCon8 {
	public static void main(String[] args) {
		try 
		{
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the CustAccNo: ");
			long accNo=s.nextLong();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");   //step1
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclb","system","amol"); 
			
			CallableStatement cs=con.prepareCall("{call ?:=getBalance44(?)}");
			cs.registerOutParameter(1,Types.FLOAT);
			cs.setLong(2,accNo);
			cs.execute();
			
			System.out.println("AccNo: "+accNo);
			System.out.println("Balance: "+cs.getFloat(1));

			s.close();
			
		}catch(Exception e) {e.printStackTrace();}
	}

}
