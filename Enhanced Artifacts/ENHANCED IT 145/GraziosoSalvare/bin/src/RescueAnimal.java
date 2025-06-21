/* 
 * Michael Thomas
 * CS 499
 * 6/8/2025
 * RescueAnimal.java
 * Represents a generic rescue animal object with key attributes
*/

import org.bson.Document;

public class RescueAnimal {

    // Common attributes for all rescue animals
    private String name;
    private String gender;
    private String age;
    private String weight;
    private String acquisitionDate;
    private String acquisitionLocation;
    private String trainingStatus;
    private boolean reserved;
    private String inServiceCountry;

    // Default constructor to resolve subclass constructor issue
    public RescueAnimal() {
        // No initialization; fields can be set via setters
    }

    // Accessor and Mutator methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getAcquisitionLocation() {
        return acquisitionLocation;
    }

    public void setAcquisitionLocation(String acquisitionLocation) {
        this.acquisitionLocation = acquisitionLocation;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getInServiceCountry() {
        return inServiceCountry;
    }

    public void setInServiceCountry(String inServiceCountry) {
        this.inServiceCountry = inServiceCountry;
    }

    /**
     * Converts this animal's data into a BSON Document for MongoDB storage.
     */
    public Document toBsonDocument() {
        return new Document("name", name)
            .append("gender", gender)
            .append("age", age)
            .append("weight", weight)
            .append("acquisitionDate", acquisitionDate)
            .append("acquisitionLocation", acquisitionLocation)
            .append("trainingStatus", trainingStatus)
            .append("reserved", reserved)
            .append("inServiceCountry", inServiceCountry);
    }

    /**
     * Static method to populate a RescueAnimal from a BSON Document.
     */
    public static RescueAnimal fromBsonDocument(Document doc) {
        RescueAnimal animal = new RescueAnimal();
        animal.setName(doc.getString("name"));
        animal.setGender(doc.getString("gender"));
        animal.setAge(doc.getString("age"));
        animal.setWeight(doc.getString("weight"));
        animal.setAcquisitionDate(doc.getString("acquisitionDate"));
        animal.setAcquisitionLocation(doc.getString("acquisitionLocation"));
        animal.setTrainingStatus(doc.getString("trainingStatus"));
        animal.setReserved(doc.getBoolean("reserved", false));
        animal.setInServiceCountry(doc.getString("inServiceCountry"));
        return animal;
    }
}