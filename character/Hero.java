package character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import item.Item;
import item.Weapon;
import map.Place;

public class Hero {

	private int hp = 100; //si on mange on regagne des hp
	private int attack = 10; //si on boit on fait plus de degat
	private int alcoholLevel = 15; //si on boit, le niveau d'alcool monte, si on atteint 100 = coma
	private List<Item> inventory;
	private Weapon weapon = null;
	private Place actualPlace;

	public Hero(Place p) {
		this.actualPlace = p;
		this.inventory = new ArrayList<>();
	}
	
	public Place getPlace(){
		return this.actualPlace;
	}
	
	public void go(String direction){
		if (actualPlace.testdirection(direction)){
			this.actualPlace.go(direction);
			this.actualPlace = this.actualPlace.getNextPlace(direction);
			System.out.println("\nVous pouvez aller ici :");
			this.actualPlace.displayExit();
		}else{
			System.out.println("Direction impossible");
		}
	}
	
	public void look(){
		System.out.println("Vous regardez autour de vous");
		this.actualPlace.describe();
	}
	
	public void look(String s){
		//Description Place
		Place p = null;
		p = this.actualPlace.getNextPlace(s);
		if (p != null){
			switch (s){
				case "forward": System.out.println("Vous regardez devant vous"); break;
				case "backward":System.out.println("Vous regardez derriere vous"); break;
				case "house1":System.out.println("Vous regardez la maison a gauche"); break;
				case "house2":System.out.println("Vous regardez la maison a droite"); break;
				default: System.out.println("Vous regardez " + p.getName()); break;
			}
			p.describe();
		}else{
			System.out.println("Argument incorrect");
		}
	}
	
	public void attack(NPC npc){
		// TODO
	}
	
	public int getAlcoholLevel(){
		return this.alcoholLevel;
	}
	
	public void setAlcoholLevel(int alcoholSup){
		this.alcoholLevel += alcoholSup;
	}

	public void setAttack(int attackSup){
		this.attack += attackSup;
	}
	
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	public void setWeapon(int attackWeapon){
		this.attack += attackWeapon;
	}
	
	public void setHp(int hpSup){
		this.hp += hpSup;
	}
	
	public void pickUpItem(Item item){ //on ramasse l'objet
		this.inventory.add(item);
	}
	
	public void printInventory(){
		Iterator<Item> it = this.inventory.iterator();
		int i=1;
		while(it.hasNext()){
			System.out.println("objet "+i +": " + it.next());
			i++;
		}
	}
	
	public void use(Item item){
		// Si le hero possede l'objet
		if (this.inventory.contains(item)){
			item.use();	// A tester
			inventory.remove(item); //apres avoir utiliser l'objet on le retire de notre inventaire
		}
		else{
			System.out.println("Vous ne possedez pas cet objet");
		}
	}

}