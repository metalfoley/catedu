package Window;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import Base.DBConn;

import javax.swing.*;

import Program.District;
import Base.Filo;
import Program.Person;
import Program.Place;
import Program.Program;

import java.util.ArrayList;


public class UserInterFace extends Frame  implements WindowListener, ActionListener {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private TextArea dataArea, summaryArea, currentArea;
	    private Button createPersonButton, updateButton, showButton, removeButton, addButton;
	    private TextField input, inputId;
	    private Label inputLabel, inputIdLabel;
	    private ArrayList<String> rolesSet = new ArrayList<String>();
	    private ArrayList<String> placesSet = new ArrayList<String>();
	    private ArrayList<String> roleAttributes = new ArrayList<String>();
	    private ArrayList<String> placeAttributes = new ArrayList<String>();
	    private JComboBox<String> comboBoxRole;
	    private JComboBox<String> comboBoxPlace;
	    private JComboBox<String> comboBoxAttributesRole;
	    private JComboBox<String> comboBoxAttributesPlace;
	    
	    private String personRole;
	    private String placeType;
	    private String placeAttribute;
	    private String personAttribute;
	    
	    District currentDistrict = null;
	    
	    
	public UserInterFace() throws SQLException
	{
		addTypesToComboBox(placesSet, "Type", "Place_Type");
		addTypesToComboBox(rolesSet,"Role","Roles");
		addTypesToComboBox(roleAttributes, null, "Person");
		addTypesToComboBox(placeAttributes,null,"Place");
		//Use the Make GUI method
		this.makeGui();
		
		//Add a welcome message
		//Set the size of the window
		//this.setSize(800, 800);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setBounds(0,0,screenSize.width, screenSize.height - 40);
	    this.setTitle("Learning Management System");
		//Make the UserInterface visible
		this.setVisible(true);
			
	}
	

	
	//Create the GUI itself
	public void makeGui() {

	        //Changed the Layout of the Panel to FlowLayout
	    	Panel left = new Panel();
	        left.setLayout(new GridLayout(0, 1));
	        
	        Panel top = new Panel();
	        top.setLayout(new FlowLayout());
	        
	        Panel leftTop = new Panel();
	        leftTop.setLayout(new GridLayout(0,2));
	        
	        Panel leftBottom = new Panel();
	        leftBottom.setLayout(new GridLayout(0,2));
	        
	        Panel bottom = new Panel();
	        bottom.setLayout(new GridLayout(0, 1));
	        
	        Panel centerCenter = new Panel();
	        centerCenter.setLayout(new GridLayout(0, 1));        
      
	        
	        //Create buttons
	        createPersonButton = new Button("Create");
	        updateButton = new Button("Update");
	        showButton = new Button("Show");
	        removeButton = new Button("Remove");
	        addButton = new Button("Add");

	        input = new TextField(20);
	        inputLabel = new Label("Input ");
	        inputId = new TextField(20);
	        inputIdLabel = new Label("ID # ");
	        
	        comboBoxRole = new JComboBox<String>(rolesSet.toArray(new String[rolesSet.size()]));
	        comboBoxPlace = new JComboBox<String>(placesSet.toArray(new String[placesSet.size()]));
	        comboBoxAttributesRole = new JComboBox<String>(roleAttributes.toArray(new String[placesSet.size()]));
	        comboBoxAttributesPlace = new JComboBox<String>(placeAttributes.toArray(new String[placesSet.size()]));

	        //Add action listeners to the buttons
	        createPersonButton.addActionListener(this);
	        updateButton.addActionListener(this);
	        showButton.addActionListener(this);
	        removeButton.addActionListener(this);
	        addButton.addActionListener(this);
	        comboBoxRole.addActionListener(this);
	        comboBoxPlace.addActionListener(this);
	        comboBoxAttributesRole.addActionListener(this);
	        comboBoxAttributesPlace.addActionListener(this);
	        
	        leftTop.add(createPersonButton);
	        leftTop.add(updateButton);
	        leftBottom.add(showButton);
	        leftBottom.add(removeButton);
	        left.add(leftTop);
	        left.add(leftBottom);
	        
	        
	        left.add(addButton);
	        
	        top.add(comboBoxRole);
	        top.add(comboBoxAttributesRole);
	        top.add(inputLabel);
	        top.add(input);
	        top.add(comboBoxPlace);
	        top.add(comboBoxAttributesPlace);
	        top.add(inputIdLabel);
	        top.add(inputId);
	        
	        dataArea = new TextArea(10, 50);
	        summaryArea = new TextArea(10, 50);
	        currentArea = new TextArea(1, 50);
	        bottom.add(currentArea);
	        centerCenter.add(summaryArea);
	        centerCenter.add(dataArea);
	        
	        add("Center", centerCenter);
	        
	        //Add the Top panel to the top of the Frame
	        add("North", top);
	        add("West", left);
	        add("South", bottom);
  
	        //Add a window listener to the frame
	        addWindowListener(this);
	}
	
	/**
	 * Checks if result set is empty. If not empty, the arrayList is cleared. Each item of the result set is added to the arrayList
	 * @param arr the arrayList that will hold the resultSet data
	 * @param str the string to be added to the arrayList
	 * @param table the table that holds the roles or place types
	 */
	private void addTypesToComboBox(ArrayList<String> arr, String str, String table) {
		try {
			ResultSet rs = DBConn.query("Select * from " + table);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String columnName;
			if(rs.getFetchSize() != 0)
			{
				arr.clear();
			}
			if(columnCount > 3){
				for(int i = 2; i < columnCount; i++) {
					columnName = rsmd.getColumnName(i);
					arr.add(columnName);
				}
			} else {
				while(rs.next())
				{
					arr.add(rs.getString(str));
				}
			}
			DBConn.closeConn();
		} catch (SQLException e) {
			System.out.println("UserInterFace.addTypesToComboBox " + e.getMessage());
			Filo.log("UserInterFace.addTypesToComboBox " + e.getMessage());
		}
	}
	
	
	
	public void actionPerformed(ActionEvent evt) {
	  	

		if(evt.getSource() == comboBoxRole) {
			personRole = comboBoxRole.getSelectedItem().toString();
			dataArea.setText("Please enter a the name of your new " + personRole +"\n\n");
			dataArea.append("Create  -  Create a new " + personRole + "\n");
			dataArea.append("Update -  Update your " + personRole + " given an ID\n");
			dataArea.append("Show    -  Show all " + personRole + "s\n");
			dataArea.append("Delete  -  Delete the " + personRole + " given an ID\n");
			setCurrentArea(personRole, personAttribute);
			placeType = null;
			placeAttribute = null;
		}
		if(evt.getSource() == comboBoxPlace) {
			placeType = comboBoxPlace.getSelectedItem().toString();
			dataArea.setText("Please enter a the name of your new " + placeType +"\n\n");
			dataArea.append("Create  -  Create a new " + placeType + "\n");
			dataArea.append("Update -  Update your " + placeType + " given an ID\n");
			dataArea.append("Show    -  Show all " + placeType + "s\n");
			dataArea.append("Delete  -  Delete the " + placeType + " given an ID\n");
			setCurrentArea(placeType, placeAttribute);
			personRole = null;
			personAttribute = null;
		}
		if(evt.getSource() == comboBoxAttributesPlace) {
			placeAttribute = comboBoxAttributesPlace.getSelectedItem().toString();
			setCurrentArea(placeType, placeAttribute);
			personRole = null;
			personAttribute = null;
		}
		if(evt.getSource() == comboBoxAttributesRole) {
			personAttribute = comboBoxAttributesRole.getSelectedItem().toString();
			setCurrentArea(personRole, personAttribute);
			placeType = null;
			placeAttribute = null;
		}
		
		if (evt.getSource() == createPersonButton)
		{
			if(personRole != null) {
				if(input.getText().isEmpty()) { 
					dataArea.setText("You must give your " + personRole + " a name.");
				} else {
					try {
						dataArea.setText("Creating new Student name " + input.getText() + "...");
						DBConn.update("INSERT INTO Person (FirstName, Role, Active) VALUES ('" + input.getText() + "', '" + getTypeId(personRole) +"', 'True')");
						summaryArea.append("Name: " + input.getText() + "   Role: " + comboBoxRole.getSelectedItem() + "\n");
					} catch (SQLException e) {
						Filo.log(e.getMessage());
					}
				}
			} 
			else if (placeType != null) {
				if(input.getText().isEmpty()) { 
					dataArea.setText("You must give your " + personRole + " a name.");
				} else {
					try {
						DBConn.update("INSERT INTO Place (Name, Place_Type, Active) VALUES ('" + input.getText() + "', '" + getTypeId(placeType) +"', 'True')");
						summaryArea.append("The " + input.getText() + " " + placeType + " was created.\n");
					} catch (SQLException e) {
						Filo.log(e.getMessage());
					}
				}
			}
	    }
	   		

		if (evt.getSource() == updateButton)
		{
			if(personAttribute != null) { updateRecord(personRole, "Person", personAttribute); }
			else if(placeType != null) { updateRecord(placeType, "Place", placeAttribute); }
			else if(personRole == null && placeType == null) { dataArea.setText("You must select either the person ro place you want to update"); }
			else { dataArea.setText("You must select the attribute you would like to update"); }
	    }
		
		if (evt.getSource() == showButton)
		{
			if(personRole != null) { showRecords(personRole, "Person", "Role"); }
			else if(placeType != null) { showRecords(placeType, "Place", "Place_Type"); }	
			else { dataArea.setText("You must select a person or place to show."); }
	    }
		
		if (evt.getSource() == removeButton)
		{
			if(personRole != null) { deleteRecord(personRole, "Person"); }
			else if(placeType != null) { deleteRecord(placeType, "Place"); }
			else { dataArea.setText("You must select the id of which record to delete."); }
		}
		
		if (evt.getSource() == addButton) {
			AddStudent add = new AddStudent();
		}
	}
	
	/**
	 * Updates the record of the id number given
	 * @param type either a personRole or placeType
	 * @param table The table to show
	 * @param attribute the attribute comboBox to update
	 */
	private void updateRecord(String type, String table, String attribute) {
		if(inputId.getText().isEmpty()) {
			dataArea.setText("Enter the ID of the " + type + " you want to update.");
		} 
		else if(input.getText().isEmpty()) {
			dataArea.setText("Enter the " + attribute + " of the " + type + " you want to update.");
		}
		else {
			try {
				dataArea.setText("Updating " + attribute + " for " + type + "...");
				DBConn.update("UPDATE " + table + " SET " + attribute +" = '" + input.getText() +"' WHERE ID = '" + Integer.parseInt(inputId.getText()) + "'");
				summaryArea.append(attribute + " for " + type + " ID# " + inputId.getText() + " set to " + input.getText() + "\n");
				inputId.setText("");
				input.setText("");
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
		}
	}
	
	/**
	 * Shows all the records of a given type
	 * @param type either a personRole or placeType
	 * @param table The table to show
	 * @param column the column that holds either the personRole or placeType foreign key
	 */
	private void showRecords(String type, String table, String column) {
		ResultSet rs;
		if(type != null) {
			try {
				dataArea.setText("Hold on! We are finding all of the " + type + "s");
				rs = DBConn.query("SELECT * FROM " + table + " WHERE " + column + " = '" + getTypeId(type) +"'");
				if(rs.getFetchSize() != 0)
				{
					Program.People.clear();
					Program.Places.clear();
				}
				while(rs.next())
				{
					if(type.equals(personRole)) {
						Program.People.add(new Person(rs.getInt("ID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Address"), 
								   rs.getString("City"), rs.getString("State"), rs.getString("ZipCode"),
								   rs.getString("Phone1"), rs.getString("Phone2"), rs.getString("Email"), rs.getString("Role"), rs.getBoolean("Active")));
					}
					else {
						Program.Places.add(new Place(rs.getInt("ID"), rs.getString("Name"), rs.getString("Address"), 
														   rs.getString("City"), rs.getString("State"), rs.getString("ZipCode"),
														   rs.getString("Phone"), rs.getString("Email"), rs.getString("Fax"), rs.getBoolean("Active")));
					}
				}
				if((type.equals(personRole) && Program.People.size() == 0) || (type.equals(placeType) && Program.Places.size() == 0)) { 
					dataArea.setText("You don't have any " + type + "s"); 
				} else {
					dataArea.setText("");
					if (type.equals(personRole)) {
						for(Person p : Program.People) {
			         			dataArea.append(p.getId() + "\t\t" + p.getFirstName() + "\t" + p.getLastName() + "\t" + p.getAddress() + "\t" + p.getCity() + 
			         							"\t" + p.getState() + "\t" + p.getZipCode() + "\t" + p.getPhoneOne() + "\t" + p.getPhoneTwo() + 
			         							"\t" + p.getEmail() + "\t" + p.getRole() + "\t" + p.isActive() + "\n");
			         	}
					}
					else {
						for(Place p : Program.Places) {
		         			dataArea.append(p.getId() + " - " + p.getName() + " - " + p.getAddress() + " - " + p.getCity() + 
         							" - " + p.getState() + " - " + p.getZipCode() + " - " + p.getPhone() + 
         							" - " + p.getEmail() + " - " + p.getFax() + " - " + p.isActive() + "\n");
		         	}
					}
				}
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}	
		}
	}
	
	/**
	 * Deletes a record on a given table based on the id number of that record
	 * @param type personRole or placeType
	 * @param table the table to delete from
	 */
	private void deleteRecord(String type, String table) {
		if(inputId.getText().isEmpty()) {
			dataArea.setText("You must enter an id of the " + type + " you would like to remove.");
			return;
		}
		dataArea.setText("Deleting " + type + "...");
		try {
			DBConn.update("DELETE FROM " + table + " WHERE ID = '" + inputId.getText() +"'");
			summaryArea.append(type + " ID# " + inputId.getText() + " succesfully deleted.");
			inputId.setText("");
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		}	
	}
	
	private void setCurrentArea(String type, String attribute) {
		if(type != null && attribute != null) {
			currentArea.setText("Current Selections:    Type: " + type + "    Attribute: " + attribute);
		}
		else if (type != null && attribute == null) {
			currentArea.setText("Current Selections:    Type: " + type + "    Attribute: not selected");
		}
		else if (type == null && attribute != null) {
			currentArea.setText("Current Selections:    Type: not selected    Attribute: " + attribute);
		}
		else {
			currentArea.setText("Current Selections:    Type: not selected    Attribute: not selected");
		}
	}
	
	/**
	 * Returns an integer based on the person role
	 * @param personRole
	 * @return roleId
	 */
	private int getTypeId(String type) {
		int id = 0;
		switch(type) {
		case "Principle":
			id = 1;
			break;
		case "Teacher":
			id = 2;
			break;
		case "Councelor":
			id = 3;
			break;
		case "Student":
			id = 4;
			break;
		case "District":
			id = 1;
			break;
		case "School":
			id = 2;
			break;
		}
		return id;
	}
	
		//exit the application if the window closes
	public void windowClosing(WindowEvent e) {
	        System.exit(0);
	}
	    
	    //empty WindowListener Methods
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
}