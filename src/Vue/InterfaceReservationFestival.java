package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Fichier.Fichier;
import Modele.Date;
import Modele.Festival;
import Modele.Programme;
/**
 * Interface "pop-up" qui s'ouvre quand on presse le bouton r�server d'un festival, permet la r�servation du festival souhait�
 * @author Benjamin, Lo�c
 *
 */
public class InterfaceReservationFestival extends JPanel implements ActionListener {
	private Programme chProgramme;	
	JComboBox<Date> boxDates = new JComboBox<Date>();
	JLabel labelNomFestival;
	JLabel labelPrixFestival;
	JLabel labelNombreDePlaces;
	JButton boutonReservation;
	Festival chFestival ;
	File file = new File("Programme");

	/**
	 * Constructeur de l'interface qui extends JPanel
	 * @param festival Festival pris en param�tre
	 * @param parProgramme Programme pris en param�tre
	 */
	public InterfaceReservationFestival(Festival festival, Programme parProgramme){
		chProgramme = parProgramme;
		chFestival = festival;
		labelNomFestival = new JLabel("Festival " + festival.getChNom());
		labelPrixFestival = new JLabel("Prix : "+festival.getChPrix()+"�");
		labelNombreDePlaces = new JLabel("Places : "+ festival.nombreDePlace(festival.getchDate(0)));
		boutonReservation = new JButton("R�server");
		boutonReservation.addActionListener(this);
		for (Date date : festival.getChDate()) {
				if(festival.nombreDePlace(date)!=0){
					boxDates.addItem(date);
			}
		}
		setLayout(new GridBagLayout());
		GridBagConstraints cont = new GridBagConstraints();
		cont.insets = new Insets (10,10,10,10); 
		add(labelNomFestival,cont);
		cont.gridx=1;
		add(labelPrixFestival,cont);
		cont.gridx=0;
		cont.gridy=1;
		add(boxDates,cont);
		boxDates.addActionListener(this);
		cont.gridx=1;
		add(labelNombreDePlaces,cont);
		cont.gridx=0;
		cont.gridy=3;
		cont.gridwidth=2;
		add(boutonReservation,cont);
	}

	@Override
	public void actionPerformed(ActionEvent parEvt) {
		Date dateSelectionne = (Date)boxDates.getSelectedItem();
		if(parEvt.getSource()==boxDates){
			labelNombreDePlaces.setText("Places : "+chFestival.nombreDePlace(dateSelectionne));
		}
		if(parEvt.getSource()==boutonReservation){
			chFestival.reservationFestival((Date)boxDates.getSelectedItem());
			labelNombreDePlaces.setText("Places : "+chFestival.nombreDePlace(dateSelectionne));
			JOptionPane.showMessageDialog(this, "La r�servation � bien �t� effectu�e","Confirmation",JOptionPane.PLAIN_MESSAGE);
			Fichier.ecriture(file, chProgramme); 
		}
	}
}
