import psycopg2 as db

class ConnectionPostgres:
    def __init__(self):
        self.user = ""
        self.password = ""
        self.host = ""
        self.port = ""
        self.database = ""

    def connect(self, user, password, host, port, database):
    	try:
    		connection = db.connect(user, password, host, port, database)
    		cursor = connection.cursor()
    		return cursor, connection
    	except (Exception, db.Error) as error :
    		print("Error while connecting to PostgreSQL", error)
    		return False