package com.example.fileprocessor.reader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class IdReaderDto {

    @CsvBindByPosition(position = 0)
    public String id;
}
