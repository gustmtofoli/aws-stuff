import boto3

class Sqs:
    def __init__(self):
        self.conn = boto3.client('sqs')
        
    def createQueue(self, queueName):
        response = self.conn.create_queue(
            QueueName = queueName,
            Attributes = {
                'MessageRetentionPeriod': '1209600'
            }
        )
        
        return response
    
    def sendMessage(self, queueUrl, user, messageBody):
        response = self.conn.send_message(
            QueueUrl = queueUrl,
            MessageAttributes={
                'User': {
                    'DataType': 'String',
                    'StringValue': user
                }
            },
            MessageBody = (messageBody)
        )
        
        return response

    def deleteQueue(self, queue):
        return self.conn.delete_queue(QueueUrl = queue['QueueUrl'])