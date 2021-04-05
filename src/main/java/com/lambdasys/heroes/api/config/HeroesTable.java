package com.lambdasys.heroes.api.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.lambdasys.heroes.api.constants.HeroesConstants;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {

    public static void main( String... args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                HeroesConstants.DYNAMO_ENDPOINT,
                                HeroesConstants.DYNAMO_REGION))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        try{
            Table table = dynamoDB.createTable(
                    HeroesConstants.HEROES_TABLE_NAME,
                    List.of( new KeySchemaElement("id", KeyType.HASH)),
                    List.of( new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L,5L));
            table.waitForActive();
        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }

    }

}
