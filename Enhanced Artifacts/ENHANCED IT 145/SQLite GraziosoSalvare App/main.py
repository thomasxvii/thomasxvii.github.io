from models import add_animal, update_training_status, delete_animal, list_animals, search_animals_by_species

# Helper function to print a list of animal records
def print_animals(animals):
    for animal in animals:
        print(animal)

# Displays a text-based menu and processes user input
def menu():
    while True:
        # Print main menu options
        print("\nRescue Animal Management System")
        print("1. Add Animal")
        print("2. List All Animals")
        print("3. Update Training Status")
        print("4. Delete Animal")
        print("5. Search by Species")
        print("6. Exit")
        choice = input("Enter choice: ")

        # Handle each menu option with corresponding logic
        if choice == '1':
            # Collect data for a new animal
            name = input("Name: ")
            species = input("Species (Dog/Monkey): ")
            breed = input("Breed: ")
            gender = input("Gender: ")
            age = int(input("Age: "))
            weight = float(input("Weight: "))
            acquisition_date = input("Acquisition Date (YYYY-MM-DD): ")
            training_status = input("Training Status: ")
            add_animal(name, species, breed, gender, age, weight, acquisition_date, training_status)
            print("Animal added.")

        elif choice == '2':
            # List and print all animals
            print_animals(list_animals())

        elif choice == '3':
            # Update training status for an animal
            animal_id = int(input("Animal ID to update: "))
            status = input("New Training Status: ")
            update_training_status(animal_id, status)
            print("Training status updated.")

        elif choice == '4':
            # Delete an animal by ID
            animal_id = int(input("Animal ID to delete: "))
            delete_animal(animal_id)
            print("Animal deleted.")

        elif choice == '5':
            # Search animals by species
            species = input("Enter species to search: ")
            print_animals(search_animals_by_species(species))

        elif choice == '6':
            # Exit the program
            print("Goodbye!")
            break

        else:
            # Handle invalid input
            print("Invalid choice. Try again.")

# Start the application
if __name__ == "__main__":
    menu()