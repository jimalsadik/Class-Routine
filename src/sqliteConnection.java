import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	Connection conn=null;
    public static Connection dbConnector() {
  	  try {
  		  Class.forName("org.sqlite.JDBC");
  		  Connection conn=DriverManager.getConnection("jdbc:sqlite:F:\\Projects\\Workspace\\Class_Routine_new_work\\sqlite_docoment\\class_routine_all_new.sqlite");
  		  JOptionPane.showMessageDialog(null, "Connection Successful");
  		  return conn;
  	  }catch(Exception e) {
  		  JOptionPane.showMessageDialog(null,e);
  		  return null;
  	  }
    }
}
