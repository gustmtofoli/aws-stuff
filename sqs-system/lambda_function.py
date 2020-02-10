import json
import boto3 as aws
from database.Rds import Rds
from database.Postgres import Postgres
from sqs.Sqs import Sqs

def lambda_handler(event, context):
    
    rds = Rds()
    endpoint = rds.getInstance("dbIdentifier")
    
    postgres = Postgres()
    cursor, connection = postgres.connectToPostgres("user", "password", endpoint.host, endpoint.port, "database")
    
    sqs = Sqs()
    
    queue = sqs.createQueue(event.queueName)
    
    sqs.sendMessage(queue.queueUrl, event.user, event.messageBody)
    
    sqs.deleteQueue(queue)
    
    return {
        'statusCode': 200,
        'body': json.dumps('Hello from Lambda!')
    }
