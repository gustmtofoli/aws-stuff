import json
import boto3 as aws
from database.Rds import Rds
from database.Postgres import Postgres
from sqs.Sqs import Sqs
import os

def lambda_handler(event, context):
    
    rds = Rds()
    
    endpoint = rds.getInstance(os.environ['dbIdentifier'])
    
    postgres = Postgres()
    
    cursor, connection = postgres.connectToPostgres(
        os.environ['user'], 
        os.environ['password'], 
        endpoint.host, 
        endpoint.port, 
        os.environ['database']
    )
    
    
    sqs = Sqs()
    
    queue = sqs.createQueue(event.queueName)
    
    sqs.sendMessage(queue.queueUrl, event.user, event.messageBody)
    
    sqs.deleteQueue(queue)
    
    return {
        'statusCode': 200,
        'body': json.dumps('Hello from Lambda!')
    }
