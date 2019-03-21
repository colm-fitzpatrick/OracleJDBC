package OracelJDBC;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet; 
import javax.swing.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
public class OracleJDBC extends JPanel {
	static JLabel label1, label2, label3;
		public OracleJDBC(){
			System.out.println("-------- Oracle JDBC Connection Testing ------");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
				return;
			}
			System.out.println("Oracle JDBC Driver Registered!");
			Connection connection = null;
			try {
					connection = DriverManager.getConnection(
					"", "",
							""); // fill in connection details
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
			try {
				//Execute the query to populate the ResultSet
				ResultSet resultset2 = null;
				Statement statement2 = null;
				String data2;
				statement2 = connection.createStatement();
				resultset2 = statement2.executeQuery("update Area set Language = 'French' where Address = 'Delgany'");
			} catch (SQLException e) {
				System.out.println("SQL Error: "+e.getMessage());
			}
			try {
				//Execute the query to populate the ResultSet
				ResultSet resultset = null;
				Statement statement = null;
				String data;
				StringBuffer sb=new StringBuffer();
				statement = connection.createStatement();
				resultset = statement.executeQuery("select * from Persons");
				while (resultset.next()) {
					for (int i=1; i <= 5; i++) {
						//Output each column by its index
						System.out.print(resultset.getString(i)+" | ");
						sb.append(resultset.getString(i));
						sb.append(" | ");
					}
					//Output a line feed at the end of the row
					System.out.println("");
					sb.append(System.getProperty("line.separator"));
					data = sb.toString();
					label1 = new JLabel(data);
					add(label1);
					data = "";
					sb.setLength(0);
				}
			} catch (SQLException e) {
				System.out.println("SQL Error: "+e.getMessage());
			}
			try {
				//Execute the query to populate the ResultSet
				ResultSet resultset1 = null;
				Statement statement1 = null;
				String data1;
				StringBuffer sb1=new StringBuffer();
				statement1 = connection.createStatement();
				resultset1 = statement1.executeQuery("select * from Area");
				while (resultset1.next()) {
					for (int i=1; i <= 3; i++) {
						//Output each column by its index
						System.out.print(resultset1.getString(i)+" | ");
						sb1.append(resultset1.getString(i));
						sb1.append(" | ");
					}
					//Output a line feed at the end of the row
					System.out.println("");
					sb1.append(System.getProperty("line.separator"));
					data1 = sb1.toString();
					label2 = new JLabel(data1);
					add(label2);
					data1 = "";
					sb1.setLength(0);
				}
			} catch (SQLException e) {
				System.out.println("SQL Error: "+e.getMessage());
			}
			
			try {
				//Execute the query to populate the ResultSet
				ResultSet resultset3 = null;
				Statement statement3 = null;
				String data3;
				StringBuffer sb3=new StringBuffer();
				statement3 = connection.createStatement();
				resultset3 = statement3.executeQuery("select Language, LastName, FirstName from Area join Persons on Area.ADDRESS = Persons.ADDRESS");
				while (resultset3.next()) {
					for (int i=1; i <= 5; i++) {
						//Output each column by its index
						System.out.print(resultset3.getString(i)+" | ");
						sb3.append(resultset3.getString(i));
						sb3.append(" | ");
					}
					//Output a line feed at the end of the row
					System.out.println("");
					sb3.append(System.getProperty("line.separator"));
					data3 = sb3.toString();
					label3 = new JLabel("join result = " + data3);
					add(label3);
					data3 = "";
					sb3.setLength(0);
				}
			} catch (SQLException e) {
				System.out.println("SQL Error: "+e.getMessage());
			}
		}
		public static void main(String[] argv) {
			JFrame frame = new JFrame("jLabel Usage Demo");
			frame.addWindowListener(new WindowAdapter() {
				// Shows code to Add Window Listener
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			frame.setContentPane(new OracleJDBC());
			frame.pack();
			frame.setVisible(true);

}
}