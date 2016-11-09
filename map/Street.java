package map;

import java.util.HashMap;

public class Street extends Place{

	private int nbStreetPart;
	private Place[] parts;

	public Street(String name, int nb) {
		this.exits = new HashMap<>();
		this.nbStreetPart = nb;
		this.name = name;
		this.parts = new StreetPart[nb];
		for (int i=0; i<nb; i++){
			this.parts[i] = new StreetPart(this);
		}
	}
	
	public void describe(){
		System.out.println("Vous arrivez sur la rue " + this.name);
	}
	
	public boolean testdirection(String direction){
		boolean test = false;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				test = true;
			}
		}
		return test;
	}
	
	public void go(String direction){
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				e.getValue().use();
			}
		}
	}
	
	public Place getNextPlace(String direction){
		Place p = null;
		for (HashMap.Entry<String, Exit> e : this.exits.entrySet()){
			if (e.getKey() == direction){
				p = e.getValue().getPlace();
			}
		}
		return p;
	}
}