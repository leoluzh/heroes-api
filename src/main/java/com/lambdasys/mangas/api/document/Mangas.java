package com.lambdasys.mangas.api.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.lambdasys.mangas.api.constants.MangasConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("serial")
@DynamoDBTable(tableName= MangasConstants.MANGAS_TABLE_NAME)
public class Mangas implements Serializable {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "description")
    private String description;

    @DynamoDBAttribute(attributeName = "publisher")
    private String publisher;

    @DynamoDBAttribute(attributeName = "year")
    private Integer year;

    @DynamoDBAttribute(attributeName = "volumes")
    private Integer volumes;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "genre")
    private Genre genre;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "age_group")
    private AgeGroup ageGroup;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "format")
    private Format format;

}
