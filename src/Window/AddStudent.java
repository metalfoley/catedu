package Window;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import Base.Filo;
import Program.Person;
import Program.Program;
import Base.DBConn;

public class AddStudent extends Frame  implements WindowListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField inputTeacher, inputStudent;
	private TextArea list;
    private Label inputTLabel, inputSLabel;
    private Button addButton, showTeachersButton, showStudentsButton;
	
	public AddStudent() {
		this.makeGui();
		this.setBounds(0,0,500,500);
		this.setLocationRelativeTo(null);
		this.setTitle("Learning Management System - Add Student to Teacher");
		this.setVisible(true);
	}
	
	private void makeGui() {
		Panel top = new Panel();
        top.setLayout(new FlowLayout());
        
        Panel centerCenter = new Panel();
        centerCenter.setLayout(new GridLayout(0, 1));
        
        Panel bottom = new Panel();
        bottom.setLayout(new FlowLayout()); 
        
        addButton = new Button("Add Student to Teacher");
        showTeachersButton = new Button("Show Teachers");
        showStudentsButton = new Button("Show Students");
        list = new TextArea();
        inputTeacher = new TextField(5);
        inputTLabel = new Label("Teacher ID# ");
        inputStudent = new TextField(5);
        inputSLabel = new Label("Student ID# ");
        
        addButton.addActionListener(this);
        showTeachersButton.addActionListener(this);
        showStudentsButton.addActionListener(this);
        
        top.add(inputTLabel);
        top.add(inputTeacher);
        top.add(inputSLabel);
        top.add(inputStudent);
        centerCenter.add(list);
        bottom.add(addButton);
        bottom.add(showTeachersButton);
        bottom.add(showStudentsButton);
        
        add("North", top);
        add("Center", centerCenter);
        add("South", bottom);
        
        //Add a window listener to the frame
        addWindowListener(this);
        
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == addButton) {
			if(inputTeacher.getText().isEmpty() || inputStudent.getText().isEmpty()) { 
				list.setText("You must enter an ID for both Teacher and Student.");
			} else {
				try {
					list.setText("Adding Teacher #" + inputTeacher.getText() + " to Student #" + inputStudent.getText() + "...");
					DBConn.update("INSERT INTO TeacherStudent (Teacher, Student) VALUES ('" + Integer.parseInt(inputTeacher.getText()) + "', '" + Integer.parseInt(inputStudent.getText()) +"'");
					list.setText("Student ID# " + inputStudent.getText() + " added to Teacher ID# " + inputTeacher.getText());
					inputTeacher.setText("");
					inputStudent.setText("");
				} catch (SQLException e) {
					Filo.log(e.getMessage());
				}
			}
		}
		if(evt.getSource() == showTeachersButton) {
			ResultSet rs;
			try {
				list.setText("Hold on! We are finding all of the teachers...");
				rs = DBConn.query("SELECT * FROM Person WHERE ROLE = 2");
				if(rs.getFetchSize() != 0)
				{
					Program.People.clear();
				}
				while(rs.next())
				{
					Program.People.add(new Person(rs.getInt("ID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Address"), 
							   rs.getString("City"), rs.getString("State"), rs.getString("ZipCode"),
							   rs.getString("Phone1"), rs.getString("Phone2"), rs.getString("Email"), rs.getString("Role"), rs.getBoolean("Active")));
				}
				if(Program.People.size() == 0) { 
					list.setText("You don't have any Teachers"); 
				} 
				else {
					list.setText("");
					for(Person p : Program.People) {
	         			list.append(p.getId() + " - " + p.getFirstName() + " - " + p.getLastName() + " - " + p.getAddress() + " - " + p.getCity() + 
	         							" - " + p.getState() + " - " + p.getZipCode() + " - " + p.getPhoneOne() + " - " + p.getPhoneTwo() + 
	         							" - " + p.getEmail() + " - " + p.getRole() + " - " + p.isActive() + "\n");
	         	}
				}
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
		}
		
		if(evt.getSource() == showStudentsButton) {
			ResultSet rs;
			try {
				list.setText("Hold on! We are finding all of the Students...");
				rs = DBConn.query("SELECT * FROM Person WHERE ROLE = 4");
				if(rs.getFetchSize() != 0)
				{
					Program.People.clear();
				}
				while(rs.next())
				{
					Program.People.add(new Person(rs.getInt("ID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Address"), 
							   rs.getString("City"), rs.getString("State"), rs.getString("ZipCode"),
							   rs.getString("Phone1"), rs.getString("Phone2"), rs.getString("Email"), rs.getString("Role"), rs.getBoolean("Active")));
				}
				if(Program.People.size() == 0) { 
					list.setText("You don't have any Teachers"); 
				} 
				else {
					list.setText("");
					for(Person p : Program.People) {
	         			list.append(p.getId() + " - " + p.getFirstName() + " - " + p.getLastName() + " - " + p.getAddress() + " - " + p.getCity() + 
	         							" - " + p.getState() + " - " + p.getZipCode() + " - " + p.getPhoneOne() + " - " + p.getPhoneTwo() + 
	         							" - " + p.getEmail() + " - " + p.getRole() + " - " + p.isActive() + "\n");
	         	}
				}
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
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
