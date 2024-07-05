package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class FSPDealerInformationRetryDto {

    @CsvBindByPosition(position = 0)
    private String message;
}