package character;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import item.Weapon;

public class Hero {

	private int hp = 100; //si on mange on regagne des hp
	private int attack = 10; //si on boit on fait plus de degat
	private int alcoholLevel = 15; //si on boit, le niveau d'alcool monte, si on atteint 100 = coma
	private List<Item> items;
	private Weapon weapon = null;

	public Hero() {
		this.items = new ArrayList<>();
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
	
	public void use(Item item){
		// Si le hero possede l'objet
		if (this.items.contains(item)){
			item.use();	// A tester
		}
		else{
			System.out.println("Vous ne possedez pas cet objet");
		}
	}

}