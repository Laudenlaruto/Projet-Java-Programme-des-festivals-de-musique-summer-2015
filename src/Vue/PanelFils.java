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
 * Classe du conteneur secondaire, qui h�rite de JPanel, instancie un JTabbedPane
 * avec les interfaces de saisie, affichage et r�servation
 * @author Lo�c, Benjamin
 *
 */
/**
 * Classe du conteneur secondaire, qui h�rite de JPanel, instancie un JTabbedPane
 * avec les interfaces de saisie, affichage et r�servation
 * @author Lo�c, Benjamin
 *
 */

public class PanelFils extends JPanel implements ActionListener{
	private JMenuItem initMenu = new JMenuItem("Initialisation",'I');
	private JMenuItem progMenu = new JMenuItem("Programme",'P');
	private JMenuItem reserMenu = new JMenuItem("R�servation",'R');
	private JMenuBar menuBar = new JMenuBar();
	private JPanel panelTest = new JPanel();
	private JPanel panelMenu = new JPanel();
	
	
	public PanelFils(){

		//Pr�paration du Menu
		initMenu.addActionListener(this);
	    menuBar.add(initMenu);
	    initMenu.setAccelerator(KeyStroke.getKeyStroke('I',java.awt.Event.CTRL_MASK));
	    progMenu = new JMenuItem("Programme",'P');
	    progMenu.addActionListener(this);
	    menuBar.add(progMenu);
	    progMenu.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.Event.CTRL_MASK));
	    reserMenu = new JMenuItem("R�servation",'R');
	    reserMenu.addActionListener(this);
	    menuBar.add(reserMenu);
	    reserMenu.setAccelerator(KeyStroke.getKeyStroke('R',java.awt.Event.CTRL_MASK));

	    //BorderLayout
	    this.setLayout(new BorderLayout());
	    panelMenu.setLayout(new BorderLayout());
		panelMenu.add(menuBar,BorderLayout.WEST);
		add(panelMenu,BorderLayout.NORTH);
		add(panelTest,BorderLayout.CENTER);
		panelTest.setBackground(new Color(255,255,255));
		
	
		
		
		
	} //PanelFils()



	@Override
	public void actionPerformed(ActionEvent parEvt) {
		
		if(parEvt.getSource()==initMenu){
			panelTest.setBackground(new Color(255,0,255));
		}
		
		if(parEvt.getSource()==progMenu){
			panelTest.setBackground(new Color(0,255,255));
		}
		
		if(parEvt.getSource()==reserMenu){
			panelTest.setBackground(new Color(255,255,0));
		}
	}
	
} //PanelFils
