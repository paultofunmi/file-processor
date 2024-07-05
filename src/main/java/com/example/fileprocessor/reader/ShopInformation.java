package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class ShopInformation {

    @CsvBindByPosition(position = 0)
    private String msisdn;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String region;

    @CsvBindByPosition(position = 3)
    private String zone;

    @CsvBindByPosition(position = 4)
    private String address;

}
