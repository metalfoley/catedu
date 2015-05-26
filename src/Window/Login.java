package Window;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Base.DBConn;
import Base.Filo;

public class Login extends Frame  implements WindowListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField inputName, inputPassword;
    private JLabel lName, lPassword, lTitle, lBlank;
    private JButton loginButton, registerButton;
	
	public Login() {
		this.makeGui();
		this.setBounds(0,0,450,150);
		this.setLocationRelativeTo(null);
		this.setTitle("Learning Management System - Login");
		this.setVisible(true);
	}
	
	private void makeGui() {
		Panel top = new Panel();
        top.setLayout(new FlowLayout());
        
        Panel centerCenter = new Panel();
        centerCenter.setLayout(new GridLayout(0,2));
        
        Panel bottom = new Panel();
        bottom.setLayout(new FlowLayout()); 
        
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        inputName = new JTextField(5);
        lName = new JLabel("Name: ");
        inputPassword = new JTextField(5);
        lPassword = new JLabel("Password: ");
        lTitle = new JLabel("Enter you name and password");
        
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        
        top.add(lTitle);
        centerCenter.add(lName);
        centerCenter.add(inputName);
        centerCenter.add(lPassword);
        centerCenter.add(inputPassword);
        bottom.add(loginButton);
        bottom.add(registerButton);
        
        add("North", top);
        add("Center", centerCenter);
        add("South", bottom);
        
        //Add a window listener to the frame
        addWindowListener(this);
        
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource() == loginButton) {
			UserInterFace inter;
			Alert alert;
			ResultSet rs = DBConn.query("SELECT * FROM Account WHERE UserName='"+inputName.getText()+"' AND Password='"+inputPassword.getText()+"'");
			try {
				if(rs.next())
					inter = new UserInterFace();
				else
					alert = new Alert("You were not found in the system. Please try again or register.");
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
			finally {
				DBConn.closeConn();
				this.setVisible(false);
			}
		}
		
		if(evt.getSource() == registerButton) {
			Register register = new Register();
			this.setVisible(false);
		}

	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}

}
