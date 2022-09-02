package test;
import java.util.*;
import java.sql.*;
public class DBCon {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");   //step1
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclb","system","amol"); //step2
			Statement stm=con.createStatement();   
			Scanner s=new Scanner(System.in);
			System.out.println("=====Choice=====");
			System.out.println("1.AddBookDetails\n2.ViewBooks");
			System.out.println("Enter the Choice: ");
			int choice=Integer.parseInt(s.nextLine());
			switch(choice)
			{
			   case 1:PreparedStatement ps1=con.prepareStatement
					   ("insert into Book44 values(?,?,?,?,?)");
			   		System.out.println("Enter the Book Code: ");
			   		int bCode=Integer.parseInt(s.nextLine());
			   		System.out.println("Enter the Book Name: ");
			   		String bName=s.nextLine();
			   		System.out.println("Enter the Book Author: ");
			   		String bAuthor=s.nextLine();
			   		System.out.println("Enter the Book Price: ");
			   		int bPrice=s.nextInt();
			   		System.out.println("Enter the Book Qty: ");
			   		int bQty=s.nextInt();
			   		
			   		ps1.setInt(1, bCode);
			   		ps1.setString(2, bName);
			   		ps1.setString(3, bAuthor);
			   		ps1.setInt(4, bPrice);
			   		ps1.setInt(5, bQty);
			   		
			   		int k=ps1.executeUpdate(); //Execution
			   		if(k>0)
			   		{
			   			System.out.println("BookDetails inserted Successfully...");
			   			
			   		}
			   		break;
			   case 2:
				   PreparedStatement ps2=con.prepareStatement("Select * from Book44");
				   ResultSet rs = ps2.executeQuery();
				   while(rs.next()) {
					   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
				   }
				   break;
				   default: System.out.println("Invalid Choice...");
		
				  }
				con.close();
		
				s.close();
			
		}catch(Exception e) {e.printStackTrace();}
	}

}
