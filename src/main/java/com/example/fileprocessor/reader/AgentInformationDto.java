package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class AgentInformationDto {

    @CsvBindByPosition(position = 0)
    private String userGrade;

    @CsvBindByPosition(position = 1)
    private String msisdn;

    @CsvBindByPosition(position = 2)
    private String userId;

    @CsvBindByPosition(position = 3)
    private String parentId;

    @CsvBindByPosition(position = 4)
    private String ownerId;

    @CsvBindByPosition(position = 5)
    private String username;

    @CsvBindByPosition(position = 6)
    private String lastname;

    @CsvBindByPosition(position = 7)
    private String parentMsisdn;
}