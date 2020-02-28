/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MyClass implements ActionListener{
	
	
	
	int antalDeltagare = 0;
	
	JTextField namn = new JTextField();
	JTextField land = new JTextField();
	JTextField alder = new JTextField();
	JTextField tid = new JTextField();
	JTextField startNr = new JTextField();
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == showButton){
			
			for (int i = 0; i < list.size(); i++ ){
				Deltagare d = list.get(i);
				infoTextArea.append(d.toString() + "\n");
			}		
		}
		
		else if (e.getSource() == newButton){
			final JComponent[] inputs = new JComponent[]{
					new JLabel("Deltagarnummer: " + antalDeltagare),
					new JLabel("Namn"),
					namn,
					new JLabel("Land"),
					land,
					new JLabel("Ålder"),
					alder
			};
		
			JOptionPane.showMessageDialog(null, inputs, "Ny Tävlande", JOptionPane.PLAIN_MESSAGE);
			
			System.out.println("You entered " + 
					namn.getText() + ", " + 
					land.getText() + ", " +
					alder.getText());
			
			list.add(new Deltagare(namn.getText(), land.getText(), alder.getText()));
			namn.setText("");
			land.setText("");
			alder.setText("");
			
		}
		else if (e.getSource() == timeButton){
			final JComponent[] inputs1 = new JComponent[]{
					new JLabel("Startnummer"),
					startNr,
					new JLabel("Registrera tid"),
					tid
			};
			
			JOptionPane.showMessageDialog(null, inputs1, "Registrera tid", JOptionPane.PLAIN_MESSAGE);
			
			System.out.println("You entered " + tid.getText());
		}
	}
}*/