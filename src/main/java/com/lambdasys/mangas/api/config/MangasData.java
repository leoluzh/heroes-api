package com.lambdasys.mangas.api.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.lambdasys.mangas.api.constants.MangasConstants;
import com.lambdasys.mangas.api.document.AgeGroup;
import com.lambdasys.mangas.api.document.Format;
import com.lambdasys.mangas.api.document.Genre;

public class MangasData {

    public static void main( String... args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                MangasConstants.DYNAMO_ENDPOINT ,
                                MangasConstants.DYNAMO_REGION
                        ))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(MangasConstants.MANGAS_TABLE_NAME);

        var manga1 = new Item()
                .withPrimaryKey("id",1)
                .withString("name","Vagabond")
                .withString("description","Manga Vagabond")
                .withString("publisher","Panini")
                .withInt("year",2000)
                .withInt("volumes",37)
                .withString("genre",Genre.GEKIGA.toString())
                .withString("age_group",AgeGroup.SEINEN.toString())
                .withString("format",Format.AIZOBAN.toString());

        PutItemOutcome outcome1 = table.putItem(manga1);

        var manga2 = new Item()
                .withPrimaryKey("id",2)
                .withString("name","Lobo Solitário")
                .withString("description","Manga Lobo Solitário")
                .withString("publisher","Panini")
                .withInt("year",2000)
                .withInt("volumes",29)
                .withString("genre",Genre.GEKIGA.toString())
                .withString("age_group",AgeGroup.SEINEN.toString())
                .withString("format",Format.AIZOBAN.toString());

        PutItemOutcome outcome2 = table.putItem(manga2);

        var manga3 = new Item()
                .withPrimaryKey("id",3)
                .withString("name","My Hero Academia")
                .withString("description","Manga My Hero Academia")
                .withString("publisher","JBC")
                .withInt("year",2000)
                .withInt("volumes",25)
                .withString("genre",Genre.NEKKETSU.toString())
                .withString("age_group",AgeGroup.SHONEN.toString())
                .withString("format",Format.AIZOBAN.toString());

        PutItemOutcome outcome3 = table.putItem(manga3);


        var manga4 = new Item()
                .withPrimaryKey("id",4)
                .withString("name","Jojos Bizarre Adventure")
                .withString("description","Manga Jojos Bizarre Adventure")
                .withString("publisher","JBC")
                .withInt("year",2000)
                .withInt("volumes",25)
                .withString("genre",Genre.NEKKETSU.toString())
                .withString("age_group",AgeGroup.SHONEN.toString())
                .withString("format",Format.AIZOBAN.toString());

        PutItemOutcome outcome4 = table.putItem(manga4);


    }

}
