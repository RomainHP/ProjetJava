package item;

import java.util.Random;

import character.Hero;

public class Drink implements Item {
	
	private TypeDrink tDrink;
	private String name;
	
	public Drink(TypeDrink drink){
		this.tDrink = drink;
		this.name=drink.toString().toLowerCase();
	}	
	
	public Drink(String name){
		TypeDrink[] tabDrink = TypeDrink.values();
		boolean correctDrink = false;
		for(int i=0; i<tabDrink.length; i++){
			if(name.equals(tabDrink[i].toString().toLowerCase())){
				correctDrink = true;
			}
		}
		if (correctDrink){
			this.name = name;
		}else{
			System.out.println("Cet objet n'existe pas");
		}
	}
	
	public static Drink createDrink(){
		TypeDrink[] tabDrink = TypeDrink.values();
		Random rand = new Random();
		TypeDrink randomDrink = tabDrink[rand.nextInt(tabDrink.length)];
		Drink res = new Drink(randomDrink);		
		return res;		
	}
	
	public int testItem(){ //pour tester si l'item est un drink
		TypeDrink[] tabDrink = TypeDrink.values();
		int res = 0;
		for(int i=0; i<tabDrink.length; i++){
			if (this.toString().equals(tabDrink[i].toString().toLowerCase())){
				res = 2;
			}
		}
		return res;
	}	
	
	public Drink convertToDrink(Item item){
		Drink d = null;
		TypeDrink[] tabDrink = TypeDrink.values();
		for(int i=0; i<tabDrink.length; i++){
			if(item.toString().equals(tabDrink[i].toString().toLowerCase())){
				d = new Drink(tabDrink[i]);
			}
		}
		return d;
	}
	
	public void use(Hero hero){
		if(this.testItem()==2){			
			hero.setAttack(hero.getAttack() + convertToDrink(this).tDrink.getAttack());
			hero.setAlcoholLevel(hero.getAlcoholLevel() + convertToDrink(this).tDrink.getAlcoholLevel());
			hero.getInventory().remove(this);
		}
	}
	
	public void use(Item item, Hero hero){
		if(this.testItem()==2 && item.testItem()==2){
			Drink drink1 = convertToDrink(this);
			Drink drink2 = convertToDrink(item);
			if(drink1.toString().equals("energydrink") && drink2.toString().equals("jagermeister")  || drink1.toString().equals("jagermeister") && drink2.toString().equals("energydrink")){
				Drink drink3 = new Drink("jagerbomb");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(drink3);
			}else if(drink1.toString().equals("energydrink") && drink2.toString().equals("vodka")  || drink1.toString().equals("vodka") && drink2.toString().equals("energydrink")){
				Drink drink3 = new Drink("vodkaenergy");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(drink3);
			}else if(!drink1.toString().equals("energydrink") && !drink2.toString().equals("energydrink")){
				Drink drink3 = new Drink("gnole");
				hero.getInventory().remove(this);
				hero.getInventory().remove(item);
				hero.getInventory().add(drink3);
			}else{
				System.out.println("energydrink ne peut etre combiner uniquement avec vodka et jagermeister");
			}					
		}
	}

	@Override
	public String toString() {
		return "" +name;
	}
	
	
}