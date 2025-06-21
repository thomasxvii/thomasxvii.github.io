// Author: Michael Thomas
// IT 145 Section J6878
// Assignment 5.4
// 13 August 2023

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	//Scanner initialization
	private static Scanner scanner = new Scanner(System.in);
	
	//Array Lists for Monkey and Dog
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
    	
        initializeDogList();
        initializeMonkeyList();
        
        char option;
        
        //Loop accepts user input and displays the menu
        do {
        	displayMenu();
        	option = scanner.nextLine().charAt(0);
        	if(option == '1') {
        		intakeNewDog(scanner);
        	}
        	
        	else if (option == '2') {
        		intakeNewMonkey(scanner);
        	}
        	
        	else if (option == '3') {
        		reserveAnimal(scanner);
        	}
        	
        	else if (option == '4') {
        		printAnimals("dog");
        	}
        	
        	else if (option == '5') {
        		printAnimals("monkey");
        	}
        	
        	else if (option == '6') {
        		printAnimals("available");
        	}
        	else if (option == 'q') {
        		System.out.println("Goodbye.\nThank you for using the Grazioso Salvare system.");
        	}
        	else {
        		System.out.println("\nInvalid input, please try again. Enter 1-6 or 'q' for valid inputs.");
        	}  	
        }
        while (option !=  'q');
    }

    //This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    //Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    //Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Billy", "male", "1", "28", "09-14-2020", "United States", "in service", true, "United States", "Capuchin", "1.5 feet", "15 inches", "3 feet");
    	Monkey monkey2 = new Monkey("Grace", "female", "4", "16", "10-14-2022", "United States", "Phase I", false, "Great Britain", "Tamarin", "1 foot", "10 inches", "2 feet");
    	Monkey monkey3 = new Monkey("Drake", "male", "2", "19", "4-14-2021", "United States", "in service", false, "United States", "Squirrel Monkey", "2 feet", "12 inches", "4 feet");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }

    
    //Intake new dog method with question prompts
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the new dog's breed?\n");
        String breed = scanner.nextLine();
        
        System.out.println("What is the new dog's gender?\n");
        String gender = scanner.nextLine();
        
        System.out.println("What is the new dog's age?\n");
        String age = scanner.nextLine();
        
        System.out.println("What is the new dog's weight?\n");
        String weight = scanner.nextLine();
        
        System.out.println("What is the new dog's date of acquiry?\n");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("What is the new dog's country of origin?\n");
        String acquisitionCountry = scanner.nextLine();
        
        System.out.println("What is the new dog's training status?\n");
        String trainingStatus = scanner.nextLine();
        
        System.out.println("Is the dog currently reserved? True or False\n");
        boolean reserved = scanner.nextBoolean();     
        scanner.nextLine();
        
        System.out.println("What is the new dog's current service country?\n");
        String inServiceCountry = scanner.nextLine();

        //Instantiates the new dog with the above inputs
        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, 
        		trainingStatus, reserved, inServiceCountry);
        
        //Adds the new dog to the Dog array
        dogList.add(dog);
        System.out.println("Your new dog has been added to the Dog List.");
    }


    //Intakes new monkey method with question prompts
    public static void intakeNewMonkey(Scanner scanner) {
    	System.out.println("What is the new monkey's name?\n");
        String name = scanner.nextLine();
        	for(Monkey monkey: monkeyList) { 
            	if(monkey.getName().equalsIgnoreCase(name)) {
            		System.out.println("\n\nThis monkey is already in our system.\n\n");
            		return; //Returns to menu
            	}
        	}
        System.out.println("What is the new monkey's species?\n");
        String species = scanner.nextLine();
        if(!(species.equalsIgnoreCase("Capuchin")) && !(species.equalsIgnoreCase("Guenon")) && 
            	!(species.equalsIgnoreCase("Macaque")) && !(species.equalsIgnoreCase("Marmoset")) &&
            	!(species.equalsIgnoreCase("Squirrel Monkey")) && !(species.equalsIgnoreCase("Tamarin"))) {
            System.out.println("\n\nThis monkey's species is not allowed.\n\n");
            return; // Returns to menu
        }
        System.out.println("What is the new monkey's gender?\n");
        String gender = scanner.nextLine();
            
        System.out.println("What is the new monkey's age?\n");
        String age = scanner.nextLine();
            
        System.out.println("What is the new monkey's weight?\n");
        String weight = scanner.nextLine();
            
        System.out.println("What is the new monkey's date of acquiry?\n");
        String acquisitionDate = scanner.nextLine();
            
        System.out.println("What is the new monkey's country of origin?\n");
        String acquisitionCountry = scanner.nextLine();
            
        System.out.println("What is the new monkey's training status?\n");
        String trainingStatus = scanner.nextLine();
            
        System.out.println("Is the monkey currently reserved? True or False.\n");
        boolean reserved = scanner.nextBoolean();     
        scanner.nextLine();
        
        System.out.println("What is the new monkey's current service country?\n");
        String inServiceCountry = scanner.nextLine();
            
        
            
        System.out.println("What is the new monkey's body length?\n");
        String bodyLength = scanner.nextLine();
            
        System.out.print("What is the new monkey's tail length?\n");
        String tailLength = scanner.nextLine();
            
        System.out.println("What is the new monkey's height?\n");
        String height = scanner.nextLine();
            
        //Instantiates a new monkey using the above inputs
        Monkey monkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry, 
        		trainingStatus, reserved, inServiceCountry, species, bodyLength, tailLength, height);
            
            //Adds the new monkey to the Monkey array
            monkeyList.add(monkey);
            System.out.println("Your new monkey has been added to the Monkey List.");
        }

    
    //Initializes animal reservation
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter animal type:");
        String animalType = scanner.nextLine();
        
        //Checks for monkeys
        if (animalType.equalsIgnoreCase("Monkey")) {
        	for (Monkey monkey: monkeyList) {
        		System.out.println(monkey.getName() + ", " + monkey.getSpecies() + ", " + monkey.getAcquisitionLocation());
        	}
        	System.out.println("\nEnter the monkey's acquisition country: ");
        	String country = scanner.nextLine();
        	for (Monkey obj: monkeyList) {
        		
        		//Updates the reserved attribute and prints confirmation
        		if(obj.getAcquisitionLocation().equalsIgnoreCase(country)) {
        			obj.setReserved(true);
        			System.out.println("\nThank you for your reservation, your monkey will reach you shortly.");
        			return;
        		}
        	}
        	//Reject confirmation that prints feedback
        	System.out.println("The monkey specified is not in the list.");
        }
        //Checks for dogs
        else if (animalType.equalsIgnoreCase("Dog")) {
        	for (Dog dog: dogList) {
        		System.out.println(dog.getName() + ", " + dog.getBreed() + ", " + dog.getAcquisitionLocation());
        	}
        	System.out.println("\nEnter the dog's acquisition country: ");
        	String country = scanner.nextLine();
        	for (Dog obj: dogList) {
        		
        		
        		//Updates the reserved attribute and prints confirmation
        		if(obj.getAcquisitionLocation().equalsIgnoreCase(country)) {
        			obj.setReserved(true);
        			System.out.println("\nThank you for your reservation, your dog will reach you shortly.");
        			return;
        		}
        	}
        	//Reject confirmation that prints feedback
        	System.out.println("The dog specified is not in the list.");
        }
        //Displays error if animal type does not exist within program
        else {
        	System.out.println("Animal type not found.");
        }
    }
    
    //Print animals 
    public static void printAnimals(String choice) {
        
    	//Prints the dog list
    	if (choice.equalsIgnoreCase("dog")) {
        	for (Dog dog: dogList) {
    			System.out.println(dog.getName() + "," + dog.getBreed());
        	}
        }
    	
    	//Prints the monkey list
        else if (choice.equalsIgnoreCase("monkey")) {
        	for (Monkey monkey: monkeyList) {
    			System.out.println(monkey.getName() + "," + monkey.getSpecies());
        	}
        }
    	
    	//Prints the combined list of all available animals
        else if (choice.equalsIgnoreCase("available")) {
        	
        	for (Dog dog: dogList) {
        		if (dog.getTrainingStatus().equalsIgnoreCase("in service") && dog.getReserved() == false) {
        			//Only prints if there is available dogs
        			System.out.println("\nAvailable dogs:");
        			System.out.println(dog.getName() + "," + dog.getBreed());
        		}
        	}
        	for (Monkey monkey: monkeyList) {
        		if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && monkey.getReserved() == false) {
        			//Only prints if there is available monkeys
        			System.out.println("\nAvailable monkeys:");
        			System.out.println(monkey.getName() + "," + monkey.getSpecies());
        		}
        	}
        }
    }
}