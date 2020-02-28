import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame {
	
	ArrayList<Person> personLista = new ArrayList<Person>();
	JPanel east = new JPanel();
	JPanel south = new JPanel();
	JButton nyBtn = new JButton("Ny");
	JButton visaBtn = new JButton("Visa");
	JButton tidBtn = new JButton("Tid");
	JTextArea display = new JTextArea();
	JRadioButton rStartNr = new JRadioButton("StartNr");
	JRadioButton rNamn = new JRadioButton("Namn");
	JRadioButton rAlder = new JRadioButton("Ålder");
	JRadioButton rTid = new JRadioButton("Tid");
	ButtonGroup radioGroup = new ButtonGroup();
	JTextField namnTxt = new JTextField(8);
	JTextField landTxt = new JTextField(8);
	JTextField alderTxt = new JTextField(8);
	RadioLyss rLyss = new RadioLyss();
	JScrollPane scrollPane = new JScrollPane(display);
	
	Main(){
		//------------ GUI -----------------//
		
		super("DSV Kista Maraton");
		
		add(new JLabel("DSV Kista Maraton"), BorderLayout.NORTH);
		
		display.setEditable(false);
		scrollPane.add(display);
		add(display);
		
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.add(new JLabel("Sortering"));
		east.add(rStartNr);
		rStartNr.addActionListener(rLyss);
		east.add(rNamn);
		rNamn.addActionListener(rLyss);
		east.add(rAlder);
		rAlder.addActionListener(rLyss);
		east.add(rTid);
		rTid.addActionListener(rLyss);
		radioGroup.add(rStartNr);
		radioGroup.add(rNamn);
		radioGroup.add(rAlder);
		radioGroup.add(rTid);
		add(east, BorderLayout.EAST);
		
		south.add(nyBtn);
		nyBtn.addActionListener(new NyLyss());
		south.add(visaBtn);
		visaBtn.addActionListener(new VisaLyss());
		south.add(tidBtn);
		tidBtn.addActionListener(new TidLyss());
		add(south, BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		
		//------------ Befolka -----------------//
		
		personLista.add(new Person(1, "Amanda", "Sverige", 21));
		personLista.add(new Person(2, "Lisa", "Sverige", 15));
		personLista.add(new Person(3, "Kobol", "Ukraina", 20));
		personLista.add(new Person(4, "Felix", "England", 18));
		personLista.add(new Person(5, "Hanna", "Frankrike", 25));
		personLista.add(new Person(6, "Gudrun", "Norge", 87));
		personLista.add(new Person(7, "Rosa", "Finland", 31));
		personLista.add(new Person(8, "Lasse", "Sverige", 54));
		Person.antalDeltagare += 8;
	}
	
	//------------ Comparatorer -----------------//
	
	class NamnComparator implements Comparator<Person>{
		public int compare(Person arg0, Person arg1) {
				return arg0.getNamn().compareTo(arg1.getNamn());
		}
	}
	
	class TidComparator implements Comparator<Person>{
		public int compare(Person arg0, Person arg1) {
			if (arg0.getTid() > arg1.getTid())
				return 1;
			else if (arg0.getTid() < arg1.getTid())
				return -1;
			else
				return 0;
		}
	}
	
	class AlderComparator implements Comparator<Person>{
		public int compare(Person arg0, Person arg1) {
			return arg0.getAlder() - arg1.getAlder();
		}
	}
	
	class StartNrComparator implements Comparator<Person>{
		public int compare(Person arg0, Person arg1) {
			return arg0.getStartNr() - arg1.getStartNr();
		}
	}
	
	
	//------------ Ny Tävlande formulär -----------------//
	class Form extends JPanel {

		Form(){
			
			JPanel rad1 = new JPanel();
			JPanel rad2 = new JPanel();
			JPanel rad3 = new JPanel();
			JPanel rad4 = new JPanel();
			
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			rad1.add(new JLabel("Startnr: " + Person.antalDeltagare));
			add(rad1);
			
			rad2.add(new JLabel("Namn: "));
			rad2.add(namnTxt);
			add(rad2);
			
			rad3.add(new JLabel("Land: "));
			rad3.add(landTxt);
			add(rad3);
			
			rad4.add(new JLabel("Ålder: "));
			rad4.add(alderTxt);
			add(rad4);
		}
	}
	
	//------------ Ny Tävlande Lyssnare -----------------//
	class NyLyss implements ActionListener {
		public void actionPerformed(ActionEvent e){
			Form f = new Form();
			boolean trycatch = false;
			
			namnTxt.setText("");
			landTxt.setText("");
			alderTxt.setText("");
			
			while (trycatch == false) {
				int okcancel = JOptionPane.showConfirmDialog(null, f, "Ny Tävlande", JOptionPane.OK_CANCEL_OPTION);
				
				if (okcancel == JOptionPane.CANCEL_OPTION)
					break;
				
				try {
					if (namnTxt.getText().length() == 0 || landTxt.getText().length() == 0 || alderTxt.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Land, ålder eller namn måste vara minst ett tecken.");
						trycatch = false;
					} else {
						personLista.add(new Person(Person.antalDeltagare, namnTxt.getText(), landTxt.getText(), Integer.parseInt(alderTxt.getText())));
						Person.antalDeltagare++;
						trycatch = true;
					}
				} catch (NumberFormatException error){
					JOptionPane.showMessageDialog(null, "Ålder måste vara i siffror.");
					trycatch = false;
				}
			}
		}
	}
	
	Comparator<Person> compare;
	
	//------------ Visa Lyssnare -----------------//
	class VisaLyss implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			display.setText("");

			Collections.sort(personLista, compare);
			
			for (int i = 0; i < personLista.size(); i++){
			display.append(personLista.get(i).toString() + "\n");
			}
			
		}
	}
	
	//------------ JRadioButton Lyssnare -----------------//
	class RadioLyss implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == rNamn)
				compare = new NamnComparator();
			else if (e.getSource() == rTid)
				compare = new TidComparator();
			else if (e.getSource() == rStartNr)
				compare = new StartNrComparator();
			else if (e.getSource() == rAlder)
				compare = new AlderComparator();
		}
	}
	
	//------------ Tid Lyssnare -----------------//
	class TidLyss implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			// GUI
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			JPanel p1 = new JPanel();
			p1.add(new JLabel("StartNr: "));
			JTextField in1 = new JTextField(8);
			p1.add(in1);
			panel.add(p1);
			
			JPanel p2 = new JPanel();
			p2.add(new JLabel("Tid: "));
			JTextField in2 = new JTextField(8);
			p2.add(in2);
			panel.add(p2);
			int valtStartNr = 0;
			double nyTid = 0.0;
			boolean finnsStartNr = false;
			
			// Frågeformulär
			while (finnsStartNr == false) {

				int okcancel1 = JOptionPane.showConfirmDialog(null, panel, "Registrera tid", JOptionPane.OK_CANCEL_OPTION);
				
				if (okcancel1 == JOptionPane.CANCEL_OPTION)
					break;
				
				try {
					valtStartNr = Integer.parseInt(in1.getText());
					nyTid = Double.parseDouble(in2.getText());
					
					for (int i = 0; i < personLista.size(); i++){
						if (personLista.get(i).getStartNr() == valtStartNr) {
							personLista.get(i).setTid(nyTid);	
							finnsStartNr = true;
						}
					}
					
					if (finnsStartNr == false) {
						JOptionPane.showMessageDialog(null, "Tävlande finns inte.");
					} 
					
				} catch (NumberFormatException err) {
					if (in1.getText().length() == 0 || in2.getText().length() == 0)
						JOptionPane.showMessageDialog(null, "Du kan inte ha tomma rutor.");
					else
						JOptionPane.showMessageDialog(null, "Ange bara siffror.");
				}	
			}
		}
	}
	
	public static void main(String []args){
		new Main();
	}
}
