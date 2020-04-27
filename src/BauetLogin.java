import javax.swing.*;
import java.awt.event.*;
public class BauetLogin extends JFrame{
	public static void main(String[] args) {
        BauetLogin frameTabel = new BauetLogin();
    }
    
    JButton teacher = new JButton("Teacher");
     JButton student = new JButton("Student");
     JLabel whoAreYou = new JLabel("Who are you ?");
     JPanel panel = new JPanel();
   
   
     BauetLogin() {
        super("Who are you ?");
        setSize(300, 200);
        setLocation(500, 280);
        panel.setLayout(null);
        
        whoAreYou.setBounds(108,30,150,40);
        teacher.setBounds(70, 65, 150, 25);
        student.setBounds(70, 100, 150, 25);
        
        panel.add(whoAreYou);
        panel.add(teacher);
        panel.add(student);
          Login l=new Login();
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        teacherLogin();
        studentLogin();
}
     public void teacherLogin() {
         teacher.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                 
                     TeacherLogIn regFace = new TeacherLogIn();
                     regFace.setVisible(true);
                     dispose();
                 
             }
         });
     }
     

     
     public void studentLogin() {
         student.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                 
                     //Newframe regFace = new Newframe();
                     StudentLog regFace = new StudentLog();
                     regFace.setVisible(true);
                     dispose();
                 
             }
         });
     }
     
     
     // Student log in System
     public class StudentLog extends JFrame {

     JLabel userName = new JLabel("UserName [student]");
     JLabel passwordText = new JLabel("password [123456]");
     JButton blogin = new JButton("Login");
     JPanel panel = new JPanel();
     JTextField txuser = new JTextField(15);
     JPasswordField pass = new JPasswordField(15);

     StudentLog() {
         super("Login Autentification");
         setSize(300, 200);
         setLocation(500, 280);
         panel.setLayout(null);

         userName.setBounds(70,10,150,20);
         txuser.setBounds(70, 30, 150, 20);
         passwordText.setBounds(70, 50, 150, 20);
         pass.setBounds(70, 70, 150, 20);
         blogin.setBounds(110, 100, 80, 20);

         panel.add(userName);
         panel.add(txuser);
         panel.add(passwordText);
         panel.add(pass);
         panel.add(blogin);

         getContentPane().add(panel);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         actionlogin();
     }

     public void actionlogin() {
         blogin.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                 String puname = txuser.getText();
                 String ppaswd = pass.getText();
                 if (puname.equals("student") && ppaswd.equals("123456")) {
                     StudentDatabase regFace = new StudentDatabase();
                     regFace.setVisible(true);
                     dispose();
                 } else {

                     JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                     txuser.setText("");
                     pass.setText("");
                     txuser.requestFocus();
                 }

             }
         });
     }

     // student database link
     public class StudentDatabase extends JFrame {

         JLabel welcome = new JLabel("Welcome to Student Database");
         JPanel panel = new JPanel();

          StudentDatabase() {
             super("Welcome");
             setSize(300, 200);
             setLocation(500, 280);
             panel.setLayout(null);

             welcome.setBounds(50, 50, 250, 60);

             panel.add(welcome);

             getContentPane().add(panel);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setVisible(true);
         }

     }
 }
     
     // Teacher log in System
     public class TeacherLogIn extends JFrame {

     JLabel userName = new JLabel("UserName   [teacher]");
     JLabel passwordText = new JLabel("password   [121212]");
     JButton blogin = new JButton("Login");
     JPanel panel = new JPanel();
     JTextField txuser = new JTextField(15);
     JPasswordField pass = new JPasswordField(15);

     TeacherLogIn() {
         super("Login Autentification");
         setSize(300, 200);
         setLocation(500, 280);
         panel.setLayout(null);

         userName.setBounds(70,10,150,20);
         txuser.setBounds(70, 30, 150, 20);
         passwordText.setBounds(70, 50, 150, 20);
         pass.setBounds(70, 70, 150, 20);
         blogin.setBounds(110, 100, 80, 20);

         panel.add(userName);
         panel.add(txuser);
         panel.add(passwordText);
         panel.add(pass);
         panel.add(blogin);

         getContentPane().add(panel);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         actionlogin();
     }

     public void actionlogin() {
         blogin.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                 String puname = txuser.getText();
                 String ppaswd = pass.getText();
                 if (puname.equals("teacher") && ppaswd.equals("121212")) {
                     teacherDatabase regFace = new teacherDatabase();
                     regFace.setVisible(true);
                     dispose();
                 } else {

                     JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                     txuser.setText("");
                     pass.setText("");
                     txuser.requestFocus();
                 }

             }
         });
     }

     //teacher database link
     public class teacherDatabase extends JFrame {

         JLabel showText = new JLabel("Welcome to teacher's Database");
         JPanel panel = new JPanel();

          teacherDatabase() {
             super("Welcome");
             setSize(300, 200);
             setLocation(500, 280);
             panel.setLayout(null);

             showText.setBounds(50, 50, 250, 60);

             panel.add(showText);

             getContentPane().add(panel);
             setVisible(true);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
         }

     }
 }
     
 } // end of RuetLogin class

