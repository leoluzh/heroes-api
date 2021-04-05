package com.lambdasys.heroes.api.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.lambdasys.heroes.api.constants.HeroesConstants;

public class HeroesData {

    public static void main( String... args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                HeroesConstants.DYNAMO_ENDPOINT ,
                                HeroesConstants.DYNAMO_REGION
                        ))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(HeroesConstants.HEROES_TABLE_NAME);
        Item hero = new Item()
                .withPrimaryKey("id",1)
                .withString("name","Wonder Woman")
                .withString("universe","DC Comics")
                .withNumber("films",3);

        PutItemOutcome outcome = table.putItem(hero);

    }

}
