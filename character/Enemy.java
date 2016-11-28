package character;

import util.Choice;
import util.ConsoleInput;

public class Enemy extends NPC {
	
	/**
	 * Enemy has an attack from 10 to 25
	 * @param name name of the enemy
	 */
	public Enemy(String name) {
		this.chooseName(name);
		//attack between 10 and 25
		this.attack = Choice.randomChoice(8, 15);
	}
	
	/**
	 * display a simple string when hero comes in house
	 */
	public void describe(){
		if (this.status){
			System.out.print("[" + this.name + "]" + " : ");
			ConsoleInput.displayString("Pourquoi rentrez-vous chez moi ? Sortez tout de suite !");
		}else{
			ConsoleInput.displayString("Il n'y a personne...");
		}
	}
	
	/**
	 * talk to the hero, this type of character attack the hero
	 */
	public void talk(Hero hero){
		if (this.status){
			ConsoleInput.displayString("Le pnj refuse de vous parler.");
			this.attack(hero);
		}
	}
	
	/**
	 * hero loses hp (-attack of the enemy)
	 * @param hero your hero
	 */
	public void attack(Hero hero){
		if (this.status){
			System.out.println(this.name + " attaque, vous perdez " + this.getAttack() + "HP");
			hero.setHp(hero.getHp()-this.attack);
		}
	}

}