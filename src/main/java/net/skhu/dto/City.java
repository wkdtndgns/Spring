package net.skhu.dto;

public class City {

	int id;
	int districtId;
	String name;
	int population;
	String districtName;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}



}
