package com.example.fileprocessor.reader.ceva;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class NIPTransactionInformationReader {

    @CsvBindByPosition(position = 0)
    private String nipSessionId;

    @CsvBindByPosition(position = 1)
    private String amount;

    @CsvBindByPosition(position = 2)
    private String txn_status;

    @CsvBindByPosition(position = 3)
    private String txn_type;

    @CsvBindByPosition(position = 4)
    private String incomingRequest;

}