package com.example.fileprocessor.reader;


import com.example.fileprocessor.reader.ceva.NIPTransactionInformationDto;
import com.example.fileprocessor.reader.staff.StaffInputDto;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyFileReader2 {

    @Autowired
    private ResourceLoader resourceLoader;

    private FileWriter fileWriter;

    public List<IdReaderDto> readFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:gradecodeChange20_03.txt");
        File file = resource.getFile();

        return getDataWithBeanBuilder(file);
    }

    private List<IdReaderDto> getDataWithBeanBuilder(File file) throws FileNotFoundException {
        List<IdReaderDto> beans = new CsvToBeanBuilder(new FileReader(file)).withSeparator(',')
                .withType(IdReaderDto.class)
                .build()
                .parse();

        return beans;
    }

    public List<NIPTransactionInformationDto> readNIPTransaction() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:ceva/APCNG_PENDING_29_06_24_10000_13126.txt");
        File file = resource.getFile();

        return getNipData(file);
    }

    private List<NIPTransactionInformationDto> getNipData(File file) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(file)).withSeparator(',')
                .withType(NIPTransactionInformationDto.class)
                .build()
                .parse();
    }

    public List<StaffInputDto> readStaffData() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:staffupgrade/staffdata.txt");
        File file = resource.getFile();

        return new CsvToBeanBuilder(new FileReader(file)).withSeparator(',')
                .withType(StaffInputDto.class)
                .build()
                .parse();
    }

    public List<FSPDealerInformationDto> readMsisdnGradeCode() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:WhsParentMsisdn.txt");
        File file = resource.getFile();

        return getMsisdnGradeCode(file);
    }

    private List<FSPDealerInformationDto> getMsisdnGradeCode(File file) throws FileNotFoundException {
        List<FSPDealerInformationDto> beans = new CsvToBeanBuilder(new FileReader(file)).withSeparator(',')
                .withType(FSPDealerInformationDto.class)
                .build()
                .parse();

        return beans;
    }

    public List<FSPDealerInformationRetryDto> readProcessReport() throws IOException {
            Resource resource = resourceLoader.getResource("classpath:WhsParentMsisdn-retry2.txt");
        File file = resource.getFile();

        return getProcessFile(file);
    }

    private List<FSPDealerInformationRetryDto> getProcessFile(File file) throws FileNotFoundException {
        List<FSPDealerInformationRetryDto> beans = new CsvToBeanBuilder(new FileReader(file))
                .withType(FSPDealerInformationRetryDto.class)
                .build()
                .parse();

        return beans;
    }

    public Set<String> readIds(String path) throws IOException {
        Resource resource = resourceLoader.getResource(path);
        File file = resource.getFile();

        List<IdReaderDto> lines = readId(file);
        return lines.stream().map(it -> it.id).collect(Collectors.toSet());
    }

    public List<ProcessedTransactionReader> readProcessedTransaction(String path) throws IOException {
        Resource resource = resourceLoader.getResource(path);
        File file = resource.getFile();

        return readProcessedTransaction(file);
    }

    public void createFileWriter(String filePath) throws IOException {
        fileWriter = new FileWriter(filePath, true);
    }
    public void writeToFile(String content) throws IOException {
        fileWriter.write(content + "\n");
    }

    public void closeFile() throws IOException {
        fileWriter.close();
    }

    private List<IdReaderDto> readId(File file) throws FileNotFoundException {
        List<IdReaderDto> beans = new CsvToBeanBuilder(new FileReader(file))
                .withType(IdReaderDto.class)
                .build()
                .parse();

        return beans;
    }

    private List<ProcessedTransactionReader> readProcessedTransaction(File file) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(file))
                .withType(ProcessedTransactionReader.class)
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
