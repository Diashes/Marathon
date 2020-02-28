import javax.swing.*;


public class NyDeltagare {

		JTextField namn = new JTextField();
		JTextField land = new JTextField();
		JTextField alder = new JTextField();
		
		final JComponent[] inputs = new JComponent[]{
				new JLabel("Namn"),
				namn,
				new JLabel("Land"),
				land,
				new JLabel("Ålder"),
				alder
		};
	
		public void getDialog(){
		JOptionPane.showMessageDialog(null, inputs, "Ny Tävlande", JOptionPane.PLAIN_MESSAGE);
		
		System.out.println("You entered " + 
				namn.getText() + ", " + 
				land.getText() + ", " +
				alder.getText());
		}
}
