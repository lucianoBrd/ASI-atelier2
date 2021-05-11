package com.sp.model;

public class Card {
	private String name;
	private String description;
	private String family;
	private int energy;
	private int hp;
	private int price;
	public Card() {}
	public Card(String name,String description,String family,int energy,int hp,int price) {
		this.setName(name);
		this.setDescription(description);
		this.setFamily(family);
		this.setEnergy(energy);
		this.setHp(hp);
		this.setPrice(price);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
