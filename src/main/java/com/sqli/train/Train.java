package com.sqli.train;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Train {
	public static final String PASSENGER = "|OOOO|";
	public static final String CARGO_EMPTY = "|____|";
	public static final String CARGO_FULL = "|^^^^|";
	public static final String RESTAURANT = "|hThT|";
	public static final String LAST_HEADER = "<HHHH";
	public static final String FIRST_HEADER = "HHHH>";

	public static final  HashMap<Character, String> data = new HashMap<>();

	static{
		data.put('H',LAST_HEADER);
		data.put('P', PASSENGER);
		data.put('C', CARGO_EMPTY);
		data.put('R', RESTAURANT);
		data.put('F', FIRST_HEADER);
	}

	private final List<String> wagons;
	public Train(String structure) {

		  this.wagons = new LinkedList<>();
		  prepareTrain(structure);
		//throw new UnsupportedOperationException("Still to be implemented");
 	}

	public String print(){
		return String.join("::", wagons);
	}

	public void detachEnd(){
		wagons.remove(wagons.size()-1);
	}

	public void detachHead(){
	   wagons.remove(0);
	}

	public boolean fill(){
		for(int i = 0;i < wagons.size();i++){
			if(wagons.get(i).equals(CARGO_EMPTY)){
				wagons.set(i, CARGO_FULL);
				return true;
			}
		}
		return false;
	}

	private void prepareTrain(String structure){
		if(structure.endsWith("H")){
			structure = structure.substring(0, structure.length() - 1) + "F";
		}

		for(int i = 0;i < structure.length();i++){
			wagons.add(data.get(structure.charAt(i)));
		}
	}

}
