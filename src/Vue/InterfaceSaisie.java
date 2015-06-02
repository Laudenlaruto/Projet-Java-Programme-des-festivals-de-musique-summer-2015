package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.Festival;

public class InterfaceSaisie extends JPanel implements ActionListener{
	
	//JLabel
	private JLabel labelIni = new JLabel("Initialisez votre festival :");
	private JLabel labelGenre = new JLabel("Genre :");
	private JLabel labelNom = new JLabel("Nom :");
	private JLabel labelLieu = new JLabel("Lieu :");
	private JLabel labelDateD = new JLabel("Date de début :");
	private JLabel labelDateF = new JLabel("Date de fin :");
	private JLabel labelPlace = new JLabel("Place disponible :");
	//JTextField
	private JTextField fieldNom = new JTextField(8);
	private JTextField fieldLieu = new JTextField(8);
	private JTextField fieldPlace = new JTextField (4);
	//Tableau
	String[] tabMois = {"Juillet","Aout"};
	String[] tabJour = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	//ComboBox
	private JComboBox comboGenre = new JComboBox(Festival.Genres);
	private JComboBox comboDateDJour = new JComboBox(tabJour);
	private JComboBox comboDateDMois = new JComboBox(tabMois);
	private JComboBox comboDateFJour = new JComboBox(tabJour);
	private JComboBox comboDateFMois = new JComboBox(tabMois);
	//JButton
	private JButton boutonCree = new JButton("Créer le festival !");
	
	
	public InterfaceSaisie(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints cont = new GridBagConstraints();
		cont.insets = new Insets (10,10,10,10); //bordure (haut,gauche,bas droite)
		cont.fill = GridBagConstraints.BOTH;
		cont.gridx=0;cont.gridy=0;cont.gridwidth=3;
		add(labelIni,cont);
		cont.gridy=1;cont.gridwidth=1;
		add(labelNom,cont);
		cont.gridx=1;cont.gridwidth=4;cont.insets = new Insets (20,10,20,10);
		add(fieldNom,cont);
		fieldNom.addActionListener(this);
		cont.gridx=0;cont.gridwidth=1;cont.gridy=2;
		add(labelLieu,cont);
		cont.gridx=1;cont.gridwidth=4;
		add(fieldLieu,cont);
		fieldLieu.addActionListener(this);
		cont.gridx=0;cont.gridy=3;cont.gridwidth=1;
		add(labelGenre,cont);
		cont.gridx=1;cont.gridy=3;
		add(comboGenre,cont);
		comboGenre.addActionListener(this);
		cont.gridx=0;cont.gridy=4;cont.gridwidth=2;
		add(labelDateD,cont);
		cont.gridx=2;cont.gridy=4;cont.gridwidth=1;cont.fill = GridBagConstraints.VERTICAL;
		add(comboDateDJour,cont);cont.fill = GridBagConstraints.BOTH;
		comboDateDJour.addActionListener(this);
		cont.gridx=3;cont.gridwidth=1;cont.gridwidth=2;
		add(comboDateDMois,cont);
		comboDateDMois.addActionListener(this);
		cont.gridx=0;cont.gridy=5;cont.gridwidth=2;
		add(labelDateF,cont);
		cont.gridx=2;cont.gridwidth=1;cont.fill = GridBagConstraints.VERTICAL;
		add(comboDateFJour,cont);cont.fill = GridBagConstraints.BOTH;
		comboDateFJour.addActionListener(this);
		cont.gridx=3;cont.gridwidth=2;
		add(comboDateFMois,cont);
		comboDateFMois.addActionListener(this);
		cont.gridy=6;cont.gridx=0;cont.gridwidth=2;
		add(labelPlace,cont);
		cont.gridx=2;cont.gridwidth=3;
		add(fieldPlace,cont);
		fieldPlace.addActionListener(this);
		cont.gridx=10;cont.gridwidth=0;
		add(boutonCree,cont);
		boutonCree.addActionListener(this);
		
		
		
		
		
		
	
	
	}


	@Override
	public void actionPerformed(ActionEvent parEvt){
		
		
		String mois = "Aout";
		String s = (String) comboDateDMois.getSelectedItem();
		if (s == mois){
				comboDateFMois.setSelectedItem("Aout");
				comboDateFMois.setEnabled(false);
		} //if
		else{
				comboDateFMois.setEnabled(true);
		}
		
		
		
	} // actionPerformed()
	
}
