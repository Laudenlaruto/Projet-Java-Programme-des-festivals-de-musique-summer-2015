package Vue;

import javax.swing.JFrame ;
/**
 * Classe du conteneur principale qui permet l'intenciation de PanelFils,
 * le conteneur secondaire.
 * @author Loïc, Benjamin
 *
 */

public class FenetreMere extends JFrame{
	
	public FenetreMere (){
		super ("Festivals de musique été 2015"); 
		setContentPane (new PanelFils ());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100,600); setVisible(true);  setLocation(100,50);
		//this.pack();
	} // FenetreMere ()
	 	
	
	public static void main (String [] args){
		new FenetreMere ();	
	}  // main ()
	
} // FenetreMere
