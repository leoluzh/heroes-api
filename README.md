# mangas-api
API para gerenciamento de super heróis utilizando spring webflux (estudo de mono/flux reactive streams)

# API para gerenciamento de mangas utilizando spring webflux/dynamodb (estudo de mono/flux reactive streams)

## Stack utilizada

* Java8
* spring webflux
* Spring data
* dynamodb
* junit
* sl4j
* reactor

### Executar dynamo:

Na pasta em que o jar está baixado: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

Para listar as tabelas criadas:  aws dynamodb list-tables --endpoint-url http://localhost:8000


Documentação gerada pela aplicação: swagger: http://localhost:8080/swagger-ui-heroes-reactive-api.html