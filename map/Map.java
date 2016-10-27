package map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import character.Hero;

public class Map {

	private Hero hero;
	private int nbStreet;
	private Street streetHero;
	private Street[] street;
	
	public Map(Hero hero, int nbStreet) {
		this.hero = hero;
		this.nbStreet = nbStreet;
		this.street = new Street[nbStreet];
		
		for (Street s : this.street){
			Random rand = new Random();
			// Une rue a entre 3 et 8 maisons
			int taille = rand.nextInt(4)+3;
			
			// Lire dans les données pour donner un nom a la rue
			String nom = "";
			int i = rand.nextInt(10)+1; // 1 à 12
			String fichier ="donnees/Lieux.txt";
			
			try{
				InputStream ips=new FileInputStream(fichier); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while (i!=0 && (ligne=br.readLine())!=null){
					nom = ligne;
					i--;
				}
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			// Instanciation de la rue
			s = new Street(nom,taille);
		}
		
		// Le hero se trouve sur la premiere rue
		this.streetHero = this.street[0];
		this.street[0].moveHeroStreet();
	}
	
	public void moveHero(){
		// Test si hero au bord de la rue
		this.streetHero.moveHeroStreet();
		this.streetHero = this.street[1];
		this.streetHero.moveHeroStreet();
		// Sinon le hero avance dans la rue
		
		// ou il rentre dans une maison (ou sort de la maison)
		
	}
}