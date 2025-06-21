// Author: Michael Thomas
// IT 145 Section J6878
// Assignment 5.4
// 13 August 2023

public class Monkey extends RescueAnimal {
	
	//Instance variables
	private String species;
	private String bodyLength;
	private String tailLength;
	private String height;
	
	//Constructor
	public Monkey(String name, String gender, String age,
	String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry,
	String species, String bodyLength, String tailLength, String height) {
		setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        //Monkey specific attributes
        setSpecies(species);
        setBodyLength(bodyLength);
        setTailLength(tailLength);
        setHeight(height);
	}
	
	//Accessor & Mutator for species
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	
	//Accessor & Mutator for body length
	public String getBodyLengh() {
		return bodyLength;
	}
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}
	
	//Accessor & Mutator for tail length
	public String getTailLength() {
		return tailLength;
	}
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}
	
	//Accessor & Mutator for height
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
}
