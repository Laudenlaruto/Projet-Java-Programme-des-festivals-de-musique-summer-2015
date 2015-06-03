package Modele;

import java.awt.Color;

import javax.swing.JButton;

public class BoutonFestival extends JButton{
	private Festival chFestival;
	
	public BoutonFestival(Festival parFestival){
		super("Réserver");
		chFestival = parFestival;
		
		JButton bouton = new JButton(parFestival.toString());
		if (chFestival.nombreDePlaceTotal()==0)
			setBackground(Color.BLACK);
		else
			setBackground(Color.CYAN);
	}
	public Festival getFestival(){
		return chFestival;
	}
}
