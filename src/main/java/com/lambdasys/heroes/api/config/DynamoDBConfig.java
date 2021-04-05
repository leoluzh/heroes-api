package com.lambdasys.heroes.api.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.apache.commons.lang3.StringUtils;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="amazon.dynamo")
@EnableDynamoDBRepositories
public class DynamoDBConfig {

    @Value("${endpoint}")
    private String endpoint;

    @Value("${amazon_aws_accesskey}")
    private String accessKey;

    @Value("${amazon_aws_secretkey}")
    private String secretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        var amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials());
        if( StringUtils.isNotEmpty( endpoint ) ){
            amazonDynamoDB.setEndpoint(endpoint);
        }
        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials awsCredentials(){
        return new BasicAWSCredentials(
                this.accessKey ,
                this.secretKey
        );
    }

}
