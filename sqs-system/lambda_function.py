import json
import boto3 as aws
from database.Database import ConnectionPostgres
from sqs.Sqs import Sqs

def lambda_handler(event, context):
    # db = ConnectionPostgres().connect("user", "password", "host", "port", "database")
    
    sqs = Sqs()
    
    queue = sqs.createQueue(event.queueName)
    
    sqs.sendMessage(queue.queueUrl, event.user, event.messageBody)
    
    sqs.deleteQueue(queue)
    
    return {
        'statusCode': 200,
        'body': json.dumps('Hello from Lambda!')
    }
