# command to startup dynamodb in localhost
run-dynamodb:
	java -Djava.library.path=./db/DynamoDBLocal_lib -jar ./db/DynamoDBLocal.jar -sharedDb

# command to check if dynamodb is up and running
check-dynamodb:
	aws dynamodb list-tables --entrypoint http://localhost:8000

docker-dynamodb-up:
	docker-compose -f docker-compose-dynamodb-local.yaml up -d

docker-dynamodb-down:
	docker-compose -f docker-compose-dynamodb.yaml down