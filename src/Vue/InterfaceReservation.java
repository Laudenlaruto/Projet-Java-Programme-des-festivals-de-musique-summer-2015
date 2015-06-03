package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Modele.BoutonFestival;
import Modele.Festival;
import Modele.FestivalHelper;
import Modele.Programme;

public class InterfaceReservation extends JPanel implements ActionListener {

	
	public InterfaceReservation(Programme chProgramme){
		int nombreDeFestivals = chProgramme.getChProgramme().size();
		Float ligneFloat = new Float(nombreDeFestivals/4);
		int nombreDeLigne = ligneFloat.intValue();// A tester
		GridLayout gridLayout = new GridLayout(nombreDeLigne,4);
		BoutonFestival boutonFestival;
		int chNombreDeGenres = Festival.Genres.length-1;
		for (int i = 0; i <= chNombreDeGenres;i++ ){
			List<Festival>  list = FestivalHelper.extractListFestival(chProgramme.getChProgramme(),Festival.Genres[i]);	
			if(list !=null){
				for (Festival festival : list) {
					JPanel panelReservationFestival = new JPanel();
					panelReservationFestival.setLayout(gridLayout);
					panelReservationFestival.setLayout(new GridBagLayout());
					GridBagConstraints cont = new GridBagConstraints();
					JTextArea textFestival = new JTextArea(festival.toString()+"\nIl reste "+festival.nombreDePlaceTotal()+" places");
					textFestival.setEditable(false);
					boutonFestival = new BoutonFestival(festival);
					boutonFestival.addActionListener(this);
					JLabel image =  new JLabel(new ImageIcon(festival.getChImagePath()));
					cont.insets = new Insets (10,10,10,10);
					panelReservationFestival.add(image,cont);
					cont.gridx=1; 
					panelReservationFestival.add(textFestival,cont);
					cont.gridy=1;
					cont.gridx=0;
					cont.gridwidth=2;
					panelReservationFestival.add(boutonFestival,cont);
					panelReservationFestival.setBackground(new Color(208,237,180));
					panelReservationFestival.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
					setBackground(new Color(208,237,189));
					this.add(panelReservationFestival);
					
				}
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent parEvt) {
		BoutonFestival boutonFestival = (BoutonFestival)parEvt.getSource();
		Festival festival = boutonFestival.getFestival();
		JDialog dial = new JDialog();
		
	}

}
