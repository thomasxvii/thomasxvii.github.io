import sqlite3

# Function to connect to the SQLite database and initialize the animals table if it doesn't exist
def connect_db():
    # Connect to (or create) a SQLite database file
    conn = sqlite3.connect("rescue_animals.db")
    cursor = conn.cursor()

    # Create the 'animals' table with required fields and constraints
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS animals (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            species TEXT CHECK(species IN ('Dog', 'Monkey')) NOT NULL,
            breed TEXT,
            gender TEXT,
            age INTEGER,
            weight REAL,
            acquisition_date TEXT,
            training_status TEXT,
            reserved INTEGER DEFAULT 0
        )
    ''')
    # Commit changes to the database
    conn.commit()
    # Return the database connection
    return conn