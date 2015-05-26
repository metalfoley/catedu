package Window;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Alert extends Frame implements WindowListener, ActionListener {
	
	private String message;
	private JButton closeButton;
	private JLabel text;
	
	public Alert(String pMessage) {
		this.message = pMessage;
		this.makeGui();
		this.setBounds(0,0,450,150);
		this.setLocationRelativeTo(null);
		this.setTitle("Learning Management System - Alert");
		this.setVisible(true);
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String pMessage) {
		this.message = pMessage;
	}
	
	public void makeGui() {
		
		Panel bottom = new Panel();
        bottom.setLayout(new FlowLayout());
        
		Panel centerCenter = new Panel();
        centerCenter.setLayout(new FlowLayout());
        
		closeButton = new JButton("OK");
		text = new JLabel(message);
		
		centerCenter.add(text);
		bottom.add(closeButton);
		
		add("Center", centerCenter);
		
		addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource() == closeButton) {		
			this.setVisible(false);
		}
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	@Override
	public void windowClosing(WindowEvent e) {
		this.setVisible(false);
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowOpened(WindowEvent e) {
	}
	
}
