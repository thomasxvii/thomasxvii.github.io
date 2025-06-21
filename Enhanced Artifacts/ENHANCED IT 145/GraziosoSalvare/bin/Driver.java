/* 
 * Michael Thomas
 * CS 499
 * 6/8/2025
 * Driver.java
 * Main driver to interact with RescueAnimal database using MongoDB
*/

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.Scanner;

public class Driver {

    private static final Scanner scanner = new Scanner(System.in);
    private static MongoCollection<Document> animalCollection;

    public static void main(String[] args) {

        // MongoDB connection setup
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("rescueAnimalDB");
            animalCollection = database.getCollection("animals");

            boolean running = true;
            while (running) {
                displayMenu();
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1": addAnimal(); break;
                    case "2": viewAllAnimals(); break;
                    case "3": updateAnimal(); break;
                    case "4": deleteAnimal(); break;
                    case "5": running = false; break;
                    default: System.out.println("Invalid option."); break;
                }
            }
        }
    }

    // Display menu options
    private static void displayMenu() {
        System.out.println("\n--- Rescue Animal Database ---");
        System.out.println("1. Add Animal");
        System.out.println("2. View All Animals");
        System.out.println("3. Update Training Status");
        System.out.println("4. Delete Animal");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // Create and insert a new animal document
    private static void addAnimal() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Age: ");
        String age = scanner.nextLine();
        System.out.print("Weight: ");
        String weight = scanner.nextLine();
        System.out.print("Acquisition Date: ");
        String date = scanner.nextLine();
        System.out.print("Acquisition Location: ");
        String location = scanner.nextLine();
        System.out.print("Training Status: ");
        String status = scanner.nextLine();
        System.out.print("Reserved (true/false): ");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("In Service Location: ");
        String serviceLoc = scanner.nextLine();

        Document doc = new Document("name", name)
                .append("animalType", type)
                .append("gender", gender)
                .append("age", age)
                .append("weight", weight)
                .append("acquisitionDate", date)
                .append("acquisitionLocation", location)
                .append("trainingStatus", status)
                .append("reserved", reserved)
                .append("inServiceLocation", serviceLoc);

        animalCollection.insertOne(doc);
        System.out.println("Animal added successfully.");
    }

    // Retrieve and display all animals
    private static void viewAllAnimals() {
        FindIterable<Document> animals = animalCollection.find();
        for (Document animal : animals) {
            System.out.println(animal.toJson());
        }
    }

    // Update training status for a specific animal
    private static void updateAnimal() {
        System.out.print("Enter animal name to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter new training status: ");
        String status = scanner.nextLine();

        animalCollection.updateOne(Filters.eq("name", name),
                new Document("$set", new Document("trainingStatus", status)));

        System.out.println("Training status updated.");
    }

    // Delete an animal by name
    private static void deleteAnimal() {
        System.out.print("Enter animal name to delete: ");
        String name = scanner.nextLine();

        animalCollection.deleteOne(Filters.eq("name", name));
        System.out.println("Animal deleted (if it existed).");
    }
}