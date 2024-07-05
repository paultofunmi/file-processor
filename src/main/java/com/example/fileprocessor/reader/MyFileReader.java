package com.example.fileprocessor.reader;


import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class MyFileReader {

    @Autowired
    private ResourceLoader resourceLoader;

    public List<AgentNameChangeRequestDto> readFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:nameChange.txt");
        File file = resource.getFile();

        return getAgentInformationWithBeanBuilder(file);
    }

    private List<ShopInformation> getShopsWithBeanBuilder(File file) throws FileNotFoundException {
        List<ShopInformation> beans = new CsvToBeanBuilder(new FileReader(file)).withSeparator(';')
                .withType(ShopInformation.class)
                .build()
                .parse();

        return beans;
    }

    private List<AgentNameChangeRequestDto> getAgentInformationWithBeanBuilder(File file) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(file)).withSeparator(',')
                .withType(AgentNameChangeRequestDto.class)
                .build()
                .parse();
    }

//    private List<ShopInformation> getShopsWithCSVReader(File file) throws IOException, CsvException {
//        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
//        CSVReader reader = new CSVReaderBuilder(new FileReader(file))
//                .withCSVParser(csvParser)
//                .withSkipLines(1).build();
//
//        List<String[]> r = reader.readAll();
//        r.forEach(row -> buildShopInformation(row));
//        r.forEach(x -> System.out.println(Arrays.toString(x)));
//
//    }
}
