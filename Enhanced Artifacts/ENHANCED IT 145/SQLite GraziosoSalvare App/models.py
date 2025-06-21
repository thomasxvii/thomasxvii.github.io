from database import connect_db

# Adds a new animal to the database
def add_animal(name, species, breed, gender, age, weight, acquisition_date, training_status):
    conn = connect_db()
    cursor = conn.cursor()

    # SQL INSERT query using parameterized inputs to prevent SQL injection
    cursor.execute('''
        INSERT INTO animals (name, species, breed, gender, age, weight, acquisition_date, training_status)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    ''', (name, species, breed, gender, age, weight, acquisition_date, training_status))

    conn.commit()
    conn.close()

# Updates the training status of an existing animal by ID
def update_training_status(animal_id, status):
    conn = connect_db()
    cursor = conn.cursor()

    # SQL UPDATE query
    cursor.execute('UPDATE animals SET training_status = ? WHERE id = ?', (status, animal_id))

    conn.commit()
    conn.close()

# Deletes an animal from the database by ID
def delete_animal(animal_id):
    conn = connect_db()
    cursor = conn.cursor()

    # SQL DELETE query
    cursor.execute('DELETE FROM animals WHERE id = ?', (animal_id,))

    conn.commit()
    conn.close()

# Returns a list of all animals in the database
def list_animals():
    conn = connect_db()
    cursor = conn.cursor()

    # SQL SELECT query to get all animals
    cursor.execute('SELECT * FROM animals')
    results = cursor.fetchall()

    conn.close()
    return results

# Searches for animals by species (e.g., "Dog" or "Monkey")
def search_animals_by_species(species):
    conn = connect_db()
    cursor = conn.cursor()

    # SQL SELECT query with a WHERE clause
    cursor.execute('SELECT * FROM animals WHERE species = ?', (species,))
    results = cursor.fetchall()

    conn.close()
    return results