package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
/**
 * Classe du conteneur secondaire, qui hérite de JPanel, instancie un JTabbedPane
 * avec les interfaces de saisie, affichage et réservation
 * @author Loïc, Benjamin
 *
 */
/**
 * Classe du conteneur secondaire, qui hérite de JPanel, instancie un JTabbedPane
 * avec les interfaces de saisie, affichage et réservation
 * @author Loïc, Benjamin
 *
 */

public class PanelFils extends JPanel implements ActionListener{
	private JMenuItem initMenu = new JMenuItem("Initialisation",'I');
	private JMenuItem progMenu = new JMenuItem("Programme",'P');
	private JMenuItem reservMenu = new JMenuItem("Réservation",'R');
	private JMenuBar menuBar = new JMenuBar();
	private JPanel panelTest = new JPanel();
	private JPanel panelMenu = new JPanel();
	
	
	public PanelFils(){

		//Préparation du Menu
		initMenu.addActionListener(this);
	    menuBar.add(initMenu);
	    initMenu.setAccelerator(KeyStroke.getKeyStroke('I',java.awt.Event.CTRL_MASK));
	    progMenu = new JMenuItem("Programme",'P');
	    progMenu.addActionListener(this);
	    menuBar.add(progMenu);
	    progMenu.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.Event.CTRL_MASK));
	    reservMenu = new JMenuItem("Réservation",'R');
	    reservMenu.addActionListener(this);
	    menuBar.add(reservMenu);
	    reservMenu.setAccelerator(KeyStroke.getKeyStroke('R',java.awt.Event.CTRL_MASK));
	    initMenu.setBackground(new Color(208,237,189));
	    progMenu.setBackground(new Color(208,237,189));
	    reservMenu.setBackground(new Color(208,237,189));
	    //BorderLayout
	    this.setLayout(new BorderLayout());
	    panelMenu.setLayout(new BorderLayout());
		panelMenu.add(menuBar,BorderLayout.WEST);
		add(panelMenu,BorderLayout.NORTH);
		add(panelTest,BorderLayout.CENTER);
		panelTest.setBackground(new Color(208,237,189));
		panelMenu.setBackground(new Color(208,237,189));
	
		
		
		
	} //PanelFils()



	@Override
	public void actionPerformed(ActionEvent parEvt) {
		
		if(parEvt.getSource()==initMenu){
			panelTest.setBackground(new Color(255,0,255));
		}
		
		if(parEvt.getSource()==progMenu){
			panelTest.setBackground(new Color(0,255,255));
		}
		
		if(parEvt.getSource()==reservMenu){
			panelTest.setBackground(new Color(255,255,0));
		}
	}
	
} //PanelFils
