package Entities;

import Abstract.Entity;

public class Game implements Entity {
	private int id;
	private String gameName;
	private double unitPrice;
	private int unitsInStock;
	
	public Game() {
		
	}
	
	public Game(int id, String gameName, double unitPrice, int unitsInStock) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

}
