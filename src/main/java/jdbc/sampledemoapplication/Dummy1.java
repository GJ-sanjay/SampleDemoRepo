/**
 * 
 */
package jdbc.sampledemoapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

/**
 * @author sjayakumar
 *
 */
public class Dummy1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		String dbURL="jdbc:oracle:thin:@localhost:1521:XE";
		String username="SYSTEM";

		String password="Sj_15032023";
		Connection con=null;
		Statement stat=null;
		//registering the oracle driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//connecting to the database

		con=DriverManager.getConnection(dbURL,username,password);

		if(con!=null)
			System.out.println("Connected to the database"+" "+con);

		else
			System.out.println("Not connected to the database");

		//creation of statement

		stat=con.createStatement();


		//execute the statement

		Scanner scan=new Scanner(System.in);

		int row=0;

		System.out.println("Enter choice : ");

		int x=scan.nextInt();

		switch(x) {

		case 1:

		for(int i=0;i<3;i++) {

		System.out.println("Enter the data : ");

		String sql1="insert into sanjay.pet1 values('"+scan.next()+"','"+scan.next()+"','"+scan.nextInt()+"')";

		row=stat.executeUpdate(sql1);

		}

		break;


		case 2:
			ResultSet rs=null;
			String sql="SELECT * FROM sanjay.pet1";
			rs=stat.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Name : "+rs.getString(1)+" Owner : "+rs.getString(2)+" Age :"+rs.getInt(3));
		}

		break;
		
		
		case 3:
			Connection connn = null;
	        PreparedStatement p = null;
	        String sql2= "update sanjay.pet1 set name='a' where Species=2";
	        p = connn.prepareStatement(sql2);
	        p.execute();
	        break;
	      
			

		}
		stat.close();

		con.close();
	}
}

