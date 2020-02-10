import psycopg2 as db

class Postgres:
    def __init__(self):
        self.user = ""
        self.password = ""
        self.database = ""
        self.cursor = None
        self.connection = None
    
    def connectToPostgres(self, user, password, host, port, database):
        try:
            connection = db.connect(user, password, host, port, database)
            cursor = connection.cursor()
            self.cursor = cursor
            self.connection = connection
            return cursor, connection
        except (Exception, db.Error) as error :
            print("Error while connecting to PostgreSQL", error)
            return False
    
    def __executeAndCommit(self, query):
        self.cursor.execute(query)
        self.connection.commit()
    
    def insert(self):
        query = "insert into table values (...);"
        self.__executeAndCommit(query)
    
    def delete(self):
        query = "delete from table where ...;"
        self.__executeAndCommit(query)
    
    def select(self):
        query = "select * from table where ...;"
        self.__executeAndCommit(query)
        
        return self.cursor.fetchall()
    