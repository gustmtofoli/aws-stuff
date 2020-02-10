import boto3

class Rds:
    def __init__(self):
        self.rds = boto3.client('rds')
        self.host = ""
        self.port = ""
        
    def getInstance(self, dbIdentifier):
        response = self.rds.describe_db_instances(DBInstanceIdentifier=dbIdentifier)
        db_instances = response['DBInstances']
        endpoint = db_instances['Endpoint']
        self.host = endpoint['Address']
        self.port = endpoint['Port']
        
        return endpoint
   