package map;

import java.util.HashMap;
import java.util.Random;

public class LockedExit extends Exit {

	private int keyType;
	private boolean status=true; //Locked or Unlocked
	private static HashMap<Integer, Boolean> keys = new HashMap<>();

	public LockedExit(int type, Street st, StreetPart sp, House h) {
		while (this.keys.containsKey(type)){
			Random rand = new Random();
			// Une chance sur 10 = 10 types de clés
			type = rand.nextInt(10)+1;
		}
		this.keyType = type;
		this.keys.put(type, true);
		this.street = st;
		this.streetPart = sp;
		this.house = h;
	}
	
	public void unlock(int key){
		if (key==this.keyType){
			this.status = false;
		}
	}
	
	public void use() {
		if (!status){
			//move
		}
		else{
			//unlock?
		}
	}

}