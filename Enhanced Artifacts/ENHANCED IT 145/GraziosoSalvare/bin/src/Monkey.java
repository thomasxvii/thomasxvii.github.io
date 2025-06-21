/* 
 * Michael Thomas
 * CS 499
 * 6/8/2025
 * Monkey.java
 * Represents a monkey in the rescue animal system with monkey-specific attributes
*/

import org.bson.Document;

public class Monkey extends RescueAnimal {

    // Monkey-specific attributes
    private String species;
    private String bodyLength;
    private String tailLength;
    private String height;

    /**
     * Default constructor required for BSON deserialization or manual instantiation.
     */
    public Monkey() {
        super(); // Calls RescueAnimal's default constructor
    }

    /**
     * Full constructor to initialize all monkey and base rescue animal attributes.
     */
    public Monkey(String name, String gender, String age,
                  String weight, String acquisitionDate, String acquisitionCountry,
                  String trainingStatus, boolean reserved, String inServiceCountry,
                  String species, String bodyLength, String tailLength, String height) {

        super();
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

        setSpecies(species);
        setBodyLength(bodyLength);
        setTailLength(tailLength);
        setHeight(height);
    }

    // Accessor and Mutator for species
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // Accessor and Mutator for body length
    public String getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    // Accessor and Mutator for tail length
    public String getTailLength() {
        return tailLength;
    }

    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    // Accessor and Mutator for height
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Override: Converts this Monkey object into a BSON document.
     */
    @Override
    public Document toBsonDocument() {
        Document doc = super.toBsonDocument(); // Base fields from RescueAnimal
        doc.append("species", species);
        doc.append("bodyLength", bodyLength);
        doc.append("tailLength", tailLength);
        doc.append("height", height);
        doc.append("type", "monkey"); // Helpful for type filtering in DB
        return doc;
    }

    /**
     * Static method to create a Monkey object from a BSON document.
     */
    public static Monkey fromBsonDocument(Document doc) {
        Monkey monkey = new Monkey();
        monkey.setName(doc.getString("name"));
        monkey.setGender(doc.getString("gender"));
        monkey.setAge(doc.getString("age"));
        monkey.setWeight(doc.getString("weight"));
        monkey.setAcquisitionDate(doc.getString("acquisitionDate"));
        monkey.setAcquisitionLocation(doc.getString("acquisitionLocation"));
        monkey.setTrainingStatus(doc.getString("trainingStatus"));
        monkey.setReserved(doc.getBoolean("reserved", false));
        monkey.setInServiceCountry(doc.getString("inServiceCountry"));

        monkey.setSpecies(doc.getString("species"));
        monkey.setBodyLength(doc.getString("bodyLength"));
        monkey.setTailLength(doc.getString("tailLength"));
        monkey.setHeight(doc.getString("height"));

        return monkey;
    }
}