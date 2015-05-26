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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Base.DBConn;
import Base.Filo;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Register extends Frame  implements WindowListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField inputUserName, inputPassword, inputFname, inputLname, inputAddress, inputCity,
						inputState, inputZip, inputPhone, inputEmail;
    private JLabel lUserName, lPassword, lTitle, lFname, lLname, lAddress, lCity, lState, lZip, lPhone, lEmail, lRole;
    private JButton cancelButton, registerButton;
    private JComboBox<String> comboBoxRole;
    private ArrayList<String> rolesSet = new ArrayList<String>();
    private boolean comboIsSet;
	
	public Register() {
		addRolesToComboBox();
		comboIsSet = false;
		this.makeGui();
		this.setBounds(0,0,450,650);
		this.setLocationRelativeTo(null);
		this.setTitle("Learning Management System - Login");
		this.setVisible(true);
	}
	
	private void makeGui() {
		Panel top = new Panel();
        top.setLayout(new FlowLayout());
        
        Panel centerCenter = new Panel();
        centerCenter.setLayout(new GridLayout(0,1));
        
        Panel bottom = new Panel();
        bottom.setLayout(new FlowLayout()); 
        
        cancelButton = new JButton("Cancel");
        registerButton = new JButton("Register");
        
        comboBoxRole = new JComboBox<String>(rolesSet.toArray(new String[rolesSet.size()]));
        
        inputUserName = new JTextField(10);
        inputPassword = new JTextField(10);
        inputFname = new JTextField(10);
        inputLname = new JTextField(10);
        inputAddress = new JTextField(10);
        inputCity = new JTextField(10);
        inputState = new JTextField(10);
        inputZip = new JTextField(10);
        inputPhone = new JTextField(10);
        inputEmail = new JTextField(10);
       
        lTitle = new JLabel("Please enter you information");
        lUserName = new JLabel("User Name: ");
        lPassword = new JLabel("Password: ");
        lFname = new JLabel("First Name: ");
        lLname = new JLabel("Last Name: ");
        lAddress = new JLabel("Address: ");
        lCity = new JLabel("City: ");
        lState = new JLabel("State: ");
        lZip = new JLabel("Zip Code: ");
        lPhone = new JLabel("Phone: ");
        lEmail = new JLabel("Email");
        lRole = new JLabel("Current Role: ");
        
        cancelButton.addActionListener(this);
        registerButton.addActionListener(this);
        comboBoxRole.addActionListener(this);
        
        top.add(lTitle);
        centerCenter.add(lUserName);
        centerCenter.add(inputUserName);
        centerCenter.add(lPassword);
        centerCenter.add(inputPassword);
        centerCenter.add(lFname);
        centerCenter.add(inputFname);
        centerCenter.add(lLname);
        centerCenter.add(inputLname);
        centerCenter.add(lAddress);
        centerCenter.add(inputAddress);
        centerCenter.add(lCity);
        centerCenter.add(inputCity);
        centerCenter.add(lState);
        centerCenter.add(inputState);
        centerCenter.add(lZip);
        centerCenter.add(inputZip);
        centerCenter.add(lPhone);
        centerCenter.add(inputPhone);
        centerCenter.add(lEmail);
        centerCenter.add(inputEmail);
        centerCenter.add(lRole);
        centerCenter.add(comboBoxRole);
        
        bottom.add(cancelButton);
        bottom.add(registerButton);    
        
        add("North", top);
        add("Center", centerCenter);
        add("South", bottom);
        
        //Add a window listener to the frame
        addWindowListener(this);
        
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Login login = new Login();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource() == cancelButton) {
			Login login = new Login();
			this.setVisible(false);
		}
		
		if(evt.getSource() == comboBoxRole) {
			System.out.println("a");
			comboIsSet = true;
		}
		
		// Adds User info to Person table and Account table with appropriate id for the foreign key
		if(evt.getSource() == registerButton) {
			Alert alert;
			if(!comboIsSet) {	
				alert = new Alert("You must choose your current role.");
			}
			else {
				try {				
					DBConn.update("INSERT INTO Person(FirstName, LastName, Address, City, State, Zipcode, Phone1, Email) VALUES('"+inputFname.getText()+"','"+inputLname.getText()+"','"+inputAddress.getText()+"','"+inputCity.getText()+"','"+inputState.getText()+"','"+inputZip.getText()+"','"+inputPhone.getText()+"','"+inputEmail.getText()+"')");
					ResultSet rs = DBConn.query("SELECT ID FROM Person WHERE FirstName='"+inputFname.getText()+"' AND LastName='"+inputLname.getText()+"' AND Address='"+inputAddress.getText()+"' AND City='"+inputCity.getText()+"' AND State='"+inputState.getText()+"' AND Zipcode='"+inputZip.getText()+"' AND Phone1='"+inputPhone.getText()+"' AND Email='"+inputEmail.getText()+"'");
					int id = 0;
					while(rs.next()) {
						id = rs.getInt(1);
					}
					DBConn.update("INSERT INTO Account(UserName,Password,Active,Person_ID) VALUES ('"+inputUserName.getText()+"','"+inputPassword.getText()+"','True','"+id+"')");
				} catch (SQLException e) {
					Filo.log("Register Button: " + e.getMessage());
				}
				finally {
					Login login = new Login();
					this.setVisible(false);
				}
			}
		}
	}
	
	private void addRolesToComboBox() {
		try {
			ResultSet rs = DBConn.query("Select * from Roles");
			if(rs.getFetchSize() != 0)
				rolesSet.clear();
			rolesSet.add(" ");
			while(rs.next())
				rolesSet.add(rs.getString("Role"));
			DBConn.closeConn();
		} catch (SQLException e) {
			Filo.log("UserInterFace.addTypesToComboBox " + e.getMessage());
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
