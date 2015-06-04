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
 * @author Benjamin, Loïc
 *
 */
public class Fichier  {
	/**
	 * Méthode qui lit un fichier et renvoi l'objet lu
	 * @param parFichier le fichier qui va être lu
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
		 * Méthode qui ecrit dans un fichier donné un objet donné
		 * 
		 * @param parFichier fichier dans lequel l'objet va être écrit
		 * @param parObject objet qui va être écrit dans fichier
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
		 *Méthode qui reset un fichier pour éviter l'erreure ou le fichier serait vide.
		 * @param parFichier fichier qui va être reset
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
