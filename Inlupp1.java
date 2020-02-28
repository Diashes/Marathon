import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Inlupp1 extends JFrame{
	
	ArrayList<Deltagare> list = new ArrayList<Deltagare>();
	
	int nastaStartNr = 1;
	JPanel totalGUI, buttonPanel, infoPanel, headerPanel;
	JButton showButton, newButton, timeButton;
	JRadioButton startNrBox, nameBox, ageBox, timeBox;
	ButtonGroup group;
	JTextArea infoTextArea;
	JLabel header, sortering;
	
	public JPanel createContentPane(){
		
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);
		
		header = new JLabel("DSV Kista Marathon");
		header.setSize(120,30);
		header.setLocation(70,0);
		totalGUI.add(header);
		
		// Information Text Field
		infoTextArea = new JTextArea();
		infoTextArea.setSize(250,200);
		infoTextArea.setLocation(5,30);
		totalGUI.add(infoTextArea);
		
		group = new ButtonGroup();
		
		// JRadioButtons
		sortering = new JLabel("Sortering");
		sortering.setSize(120,30);
		sortering.setLocation(275,20);
		totalGUI.add(sortering);
		
		startNrBox = new JRadioButton("StartNr", true);
		startNrBox.setLocation(270,55);
		startNrBox.setSize(300,20);
		startNrBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				
			}
		});
		group.add(startNrBox);
		totalGUI.add(startNrBox);
		
		nameBox = new JRadioButton("Namn");
		nameBox.setLocation(270,75);
		nameBox.setSize(120,30);
		group.add(nameBox);
		totalGUI.add(nameBox);
		
		ageBox = new JRadioButton("Ålder");
		ageBox.setLocation(270,100);
		ageBox.setSize(120,30);
		group.add(ageBox);
		totalGUI.add(ageBox);
		
		timeBox = new JRadioButton("Tid");
		timeBox.setLocation(270,125);
		timeBox.setSize(120,30);
		group.add(timeBox);
		totalGUI.add(timeBox);
		
		// JButton Visa
		buttonPanel = new JPanel();
		buttonPanel.setLocation(-10,230);
		buttonPanel.setSize(200,50);
		totalGUI.add(buttonPanel);
		
		showButton = new JButton("Visa");
		showButton.setLocation(0,0);
		showButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for (int i = 0; i < list.size(); i++ ){
					Deltagare d = list.get(i);
					infoTextArea.append(d.toString() + "\n");
				}	
			}
		});
		buttonPanel.add(showButton);
				
		// JButton Ny
		newButton = new JButton("Ny");
		newButton.setSize(120,30);
		newButton.setLocation(0,0);
		newButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JTextField namn = new JTextField();
				JTextField land = new JTextField();
				JTextField alder = new JTextField();
				
				final JComponent[] inputs = new JComponent[]{
						new JLabel("Deltagarnummer: " + (nastaStartNr)),
						new JLabel("Namn"),
						namn,
						new JLabel("Land"),
						land,
						new JLabel("Ålder"),
						alder
				};
				
				boolean invalid = true;
				while (invalid) {
					JOptionPane.showMessageDialog(null, inputs, "Ny Tävlande", JOptionPane.PLAIN_MESSAGE);
					
					if (namn.getText().equals("") || alder.getText().equals("") || land.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Du måste fylla i alla fält!");
					}else{
						invalid = false;
					}
				}
				
				list.add(new Deltagare(namn.getText(), land.getText(), alder.getText(), nastaStartNr));
				
				namn.setText("");
				land.setText("");
				alder.setText("");
				nastaStartNr++;
			}
		});
		buttonPanel.add(newButton);
				
		// JButton Tid
		timeButton = new JButton("Tid");
		timeButton.setSize(120,30);
		showButton.setLocation(0,0);
		timeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JTextField tid = new JTextField();
				JTextField startNr = new JTextField();
				
				final JComponent[] inputs1 = new JComponent[]{
						new JLabel("Startnummer"),
						startNr,
						new JLabel("Registrera tid"),
						tid
				};
				
				JOptionPane.showMessageDialog(null, inputs1, "Registrera tid", JOptionPane.PLAIN_MESSAGE);
				System.out.println("You entered " + tid.getText());
			}
		});
		buttonPanel.add(timeButton);

		return totalGUI;
		
	}
	
	public static void createAndShowGUI(){
		
		JFrame frame = new JFrame("DSV Kista Marathon");
		Inlupp1 run = new Inlupp1();
		
		frame.setContentPane(run.createContentPane());
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(370,310);
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

