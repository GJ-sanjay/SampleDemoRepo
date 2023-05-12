/**
 * 
 */
package jdbc.sampledemoapplication;



/**
 * @author sjayakumar
 *
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;public class dummy {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn = null;
		Statement stat = null;
		final String driver = "oracle.jdbc.driver.OracleDriver";
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username ="SYSTEM";
		String password ="Sj_15032023";
		Class.forName(driver);
		System.out.println(driver);
		try {
		// create the connection
		conn = DriverManager.getConnection(dbURL, username, password);
		if (conn != null)
			System.out.println("Connected to the database!" + conn);
		else
			System.out.println("Not connected to the database!");
		stat = conn.createStatement();
		System.out.println(stat);
		String sql = "insert into SANJAY.pet values('sarvesh','Sonam','human')";
		// Execute the statement
		int row=stat.executeUpdate(sql);
		for(int i=1;i<=3;i++) {
			String sql1="insert into SANJAY.pet values('sanjay','sanam','heman')";
			int row1=stat.executeUpdate(sql1);

		}
		Scanner sc=new Scanner(System.in);
		int row2=0;
		for(int i=1;i<=3;i++) {
			System.out.println("Enter the name , owner and species");
			String sql2="insert into SANJAY.pet values('"+sc.next()+"','"+sc.next()+"','"+sc.next()+"')";
			row2=stat.executeUpdate(sql2);
		}
		if(row>0)
			System.out.println("Row Inserted");
		else
			System.out.println("Not inserted");
		stat.executeUpdate(sql);
		System.out.println(stat.executeUpdate(sql));
		} 
		catch (Exception ex) {

		ex.getStackTrace();
		//

		}

		}

		}
