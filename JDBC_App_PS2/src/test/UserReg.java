package test;
import java.util.*;
import java.sql.*;
public class UserReg {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //step1
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclb","system","amol"); //step2
			Statement stm=con.createStatement();   
			Scanner s=new Scanner(System.in);
			System.out.println("=====Choice=====");
			System.out.println("1.Register\n2.Login\n3.ViewProfile");
			System.out.println("Enter the Choice: ");
			int choice=Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:PreparedStatement ps1=con.prepareStatement("insert into UserReg44 values(?,?,?,?,?,?,?)");
				   System.out.println("Enter the UserName: ");
				   String uName=s.nextLine();
				   System.out.println("Enter the Password: ");
				   String pWord=s.nextLine();
				   System.out.println("Enter the FirstName: ");
				   String fName=s.nextLine();
				   System.out.println("Enter the LastName: ");
				   String lName=s.nextLine();
				   System.out.println("Enter the Address: ");
				   String addr=s.nextLine();
				   System.out.println("Enter the Mail_ID: ");
				   String mID=s.nextLine();
				   System.out.println("Enter the PhNo: ");
				   long phNo=Long.parseLong(s.nextLine());
				   
				   ps1.setString(1, uName);
				   ps1.setString(2, pWord);
				   ps1.setString(3, fName);
				   ps1.setString(4, lName);
				   ps1.setString(5, addr);
				   ps1.setString(6, mID);
				   ps1.setLong(7, phNo);
				
				   int k=ps1.executeUpdate();
				   if(k>0)
				   {
					   System.out.println("User registered Succesfully...");
				   }
				break;
				
			case 2:
					PreparedStatement ps2=con.prepareStatement
					("select * from UserReg44 where uname=? and pword=?");
					System.out.println("Enter the UserName: ");
					String uName1=s.nextLine();
					System.out.println("Enter the Password: ");
					String pWord1=s.nextLine();
					ps2.setString(1, uName1);
					ps2.setString(2, pWord1);
					ResultSet rs1=ps2.executeQuery();
					if(rs1.next())
					{
						System.out.println("Login Successfull...");
						System.out.println("Welcome user"+rs1.getString(3));
					}
					else
					{
						System.out.println("Invalid Login Process...");
					}
				break;
				
			case 3:
					PreparedStatement ps3=con.prepareStatement
					("select * from UserReg44 where uname=? and pword=?");
					System.out.println("Enter the UserName: ");
					String uName2=s.nextLine();
					System.out.println("Enter the Password: ");
					String pWord2=s.nextLine();
					ps3.setString(1, uName2);
					ps3.setString(2, pWord2);
					ResultSet rs2=ps3.executeQuery();
					if(rs2.next())
					{
						System.out.println("====UserDetails====");
						System.out.println("FirstName: "+rs2.getString(3)+"\nLastName: "+rs2.getString(4)+"\nAddress: "+rs2.getString(5)+"\nMailID: "+rs2.getString(6)+"\nPhone No: "+rs2.getString(7));
					}
					else
					{
						System.out.println("invalid Login Process ");
					}
				
				break;
			default: System.out.println("Invalid Choice...");
			}
			s.close();
		}catch(Exception e) {e.printStackTrace();}
	}

}
