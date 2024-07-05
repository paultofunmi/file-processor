package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class NINUpdate {

    @CsvBindByPosition(position = 0)
    private String gender;

    @CsvBindByPosition(position = 1)
    private String dob;

    @CsvBindByPosition(position = 2)
    private String nin;

    @CsvBindByPosition(position = 3)
    private String msisdn;

    @CsvBindByPosition(position = 4)
    private String surname;

    @CsvBindByPosition(position = 5)
    private String created;

    @CsvBindByPosition(position = 6)
    private String firstName;
    @CsvBindByPosition(position = 7)
    private String motherMaidenName;

}


//GENDER,DOB,NIN,MSISDN,SURNAME,CREATED_ON,FIRSTNAME,MOTHERMAIDENNAME,