package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableCellRenderer;

import Modele.Date;
import Modele.Festival;
import Modele.Programme;
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
	private JPanel panelMenu = new JPanel();
	private JTable chTableInterfaceAffichage = new JTable();
	private InterfaceSaisie interfaceSaisie = new InterfaceSaisie();
	private Programme chProgramme;
	
	public PanelFils(){
		//Valeurs
		chProgramme = new Programme();
		Date[] dates = {new Date()};
		int[] places = {500};
		chProgramme.ajout(new Festival("Unicorn", "Pop", dates, "Ex", places));
		//Préparation du Menu
		initMenu.addActionListener(this);
	    menuBar.add(initMenu);
	    initMenu.setAccelerator(KeyStroke.getKeyStroke('I',java.awt.Event.CTRL_MASK));
	    progMenu.addActionListener(this);
	    menuBar.add(progMenu);
	    progMenu.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.Event.CTRL_MASK));
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
		
		
		chTableInterfaceAffichage.setRowHeight(50);
		chTableInterfaceAffichage.setModel(new InterfaceAffichage(chProgramme));
		chTableInterfaceAffichage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0; i<Festival.Genres.length-1;i++){
			chTableInterfaceAffichage.getColumnModel().getColumn(i).setPreferredWidth(400);
			}
		JScrollPane scroll = new JScrollPane(chTableInterfaceAffichage);
		//add(scroll,BorderLayout.CENTER);
		panelMenu.setBackground(new Color(208,237,189));
		add(interfaceSaisie);
		
		
		
	} //PanelFils()

	@Override
	public void actionPerformed(ActionEvent parEvt) {
		
		if(parEvt.getSource()==initMenu){
		}
		
		if(parEvt.getSource()==progMenu){
		}
		
		if(parEvt.getSource()==reservMenu){
		}
	}
	
} //PanelFils
