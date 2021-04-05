# command to startup dynamodb in localhost
run-dynamodb:
	java -Djava.library.path=./db/DynamoDBLocal_lib -jar ./db/DynamoDBLocal.jar -sharedDb

# command to check if dynamodb is up and running
check-dynamodb:
	aws dynamodb list-tables --entrypoint http://localhost:8000
