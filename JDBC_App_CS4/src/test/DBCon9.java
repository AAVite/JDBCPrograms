package test;
import java.sql.*;
import java.util.*;
public class DBCon9 {
	public static void main(String[] args) {
		try {
			Scanner s =new Scanner(System.in);
			System.out.println("Enter the EmpId: ");
			String eId=s.nextLine();
			System.out.println("Enter the EmpName: ");
			String eName=s.nextLine();
			System.out.println("Enter the EmpDesg: ");
			String eDesg=s.nextLine();
			System.out.println("Enter the hNo: ");
			String hNo=s.nextLine();
			System.out.println("Enter the sName: ");
			String sName=s.nextLine();
			System.out.println("Enter the City: ");
			String city=s.nextLine();
			System.out.println("Enter the pinCode: ");
			int pinCode = Integer.parseInt(s.nextLine());
			System.out.println("Enter the MailId: ");
			String mId=s.nextLine();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");   //step1
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclb","system","amol");
			
			
			
			
		}catch(Exception e) {e.printStackTrace();}
	}

}
