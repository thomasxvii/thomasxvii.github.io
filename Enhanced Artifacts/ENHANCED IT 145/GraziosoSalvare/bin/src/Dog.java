/* 
 * Michael Thomas
 * CS 499
 * 6/8/2025
 * Dog.java
 * Represents a dog in the rescue animal system with additional 'breed' field
*/

import org.bson.Document;

public class Dog extends RescueAnimal {

    // Additional attribute specific to dogs
    private String breed;

    /**
     * Default constructor required for BSON deserialization or manual instantiation.
     */
    public Dog() {
        super(); // Calls RescueAnimal's default constructor
    }

    /**
     * Full constructor to create a Dog with all properties initialized.
     */
    public Dog(String name, String breed, String gender, String age,
               String weight, String acquisitionDate, String acquisitionCountry,
               String trainingStatus, boolean reserved, String inServiceCountry) {
        super(); // Ensures base class fields can be set
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    // Accessor and Mutator for breed
    public String getBreed() {
        return breed;
    }

    public void setBreed(String dogBreed) {
        this.breed = dogBreed;
    }

    /**
     * Override: Converts this Dog object into a BSON document.
     */
    @Override
    public Document toBsonDocument() {
        Document doc = super.toBsonDocument(); // Get base fields
        doc.append("breed", breed);            // Add dog-specific field
        doc.append("type", "dog");             // Tag for querying by type
        return doc;
    }

    /**
     * Static method to create a Dog object from a BSON document.
     */
    public static Dog fromBsonDocument(Document doc) {
        Dog dog = new Dog();
        dog.setName(doc.getString("name"));
        dog.setBreed(doc.getString("breed"));
        dog.setGender(doc.getString("gender"));
        dog.setAge(doc.getString("age"));
        dog.setWeight(doc.getString("weight"));
        dog.setAcquisitionDate(doc.getString("acquisitionDate"));
        dog.setAcquisitionLocation(doc.getString("acquisitionLocation"));
        dog.setTrainingStatus(doc.getString("trainingStatus"));
        dog.setReserved(doc.getBoolean("reserved", false));
        dog.setInServiceCountry(doc.getString("inServiceCountry"));
        return dog;
    }
}