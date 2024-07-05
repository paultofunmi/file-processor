package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ProcessedTransactionReader {

    @CsvBindByPosition(position = 0)
    public String id;

    @CsvBindByPosition(position = 1)
    public String msgId;

    @CsvBindByPosition(position = 2)
    public String message;
}
