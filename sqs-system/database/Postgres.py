import psycopg2 as db

class Postgres:
    def __init__(self):
        self.user = ""
        self.password = ""
        self.database = ""
    
    def connectToPostgres(self, user, password, host, port, database):
        try:
            connection = db.connect(user, password, host, port, database)
            cursor = connection.cursor()
            return cursor, connection
        except (Exception, db.Error) as error :
            print("Error while connecting to PostgreSQL", error)
            return False