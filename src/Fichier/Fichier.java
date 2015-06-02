package Fichier;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Modele.Programme;



/**
 * Classe qui permet la lecture et l'ecriture dans un fichier
 * @author Benjamin
 *
 */
public class Fichier  {
	/**
	 * Lit un fichier et renvoi l'objet lu
	 * @param parFichier
	 * @return l'objet lu
	 */
	public static Object lecture(File parFichier){
		ObjectInputStream flux;
		Object objetLu = null;
		
		try{
			flux = new ObjectInputStream(new FileInputStream(parFichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		catch(ClassNotFoundException parExc) {
			System.err.println(parExc.toString());
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Erreur lecture fichier "+ e.toString());
			System.exit(1);
		} 
		return objetLu;
	}
		/**
		 * Ecrit dans un fichier donn� un objet donn�
		 * @param parFichier
		 * @param parObject
		 */
		public static void ecriture(File parFichier, Object parObject){
			ObjectOutputStream flux = null;
			try{
				flux = new ObjectOutputStream(new FileOutputStream(parFichier));
				flux.writeObject(parObject);
				flux.flush();
				flux.close();
			}
			catch(IOException parExc){
				System.err.println("Probleme a l'ecriture"+parExc.toString());
				System.exit(1);
				
			}
		}
		/**
		 * Reset un fichier pour pas qu'il y est d'erreur o� le fichier serais vide.
		 * @param parFichier
		 */
		public static void reset(File parFichier){
			ObjectOutputStream flux = null;
			try{
				flux = new ObjectOutputStream(new FileOutputStream(parFichier));
				flux.reset();
				ecriture(parFichier,new Programme());
			}
			catch(IOException parExc){
				
			}
		}
}
