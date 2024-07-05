package com.example.fileprocessor;

//import com.example.fileprocessor.client.ChannelPartnerClient;
//import com.example.fileprocessor.client.ChannelPartnerClient2;
import com.example.fileprocessor.client.FSPParentMappingClient;
import com.example.fileprocessor.client.AgentNameUpdateClient;
import com.example.fileprocessor.client.AgentUpdateClient;
import com.example.fileprocessor.client.NIPTransactionRetry;
import com.example.fileprocessor.client.StaffUpgradeClient;
import com.example.fileprocessor.reader.FSPDealerInformationDto;
import com.example.fileprocessor.reader.IdReaderDto;
import com.example.fileprocessor.reader.MyFileReader2;
import com.example.fileprocessor.reader.ProcessedTransactionReader;
import com.example.fileprocessor.reader.ceva.NIPTransactionInformationDto;
import com.example.fileprocessor.reader.staff.StaffInputDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@Log4j2
public class FileProcessorApplication implements CommandLineRunner {

	@Autowired
	MyFileReader2 myFileReader2;

	public static void main(String[] args) {
		SpringApplication.run(FileProcessorApplication.class, args);
	}

	@Autowired
	FSPParentMappingClient fspParentMappingClient;

	@Autowired
	AgentNameUpdateClient agentNameUpdateClient;

	@Autowired
	AgentUpdateClient agentUpdateClient;

	@Autowired
	NIPTransactionRetry nipTransactionRetry;

	@Autowired
	StaffUpgradeClient staffUpgradeClient;

	@Override
	public void run(String... args) throws Exception {

//		List<AgentInformation> agentInformations = myFileReader2.readFile();
//		List<String> parentMsIsdn = List.of("9012221207","8029222020","8120706655","7015909654","8028266734","9071774414","8025623257","9014725416","9022044471","8088680000","8126270810","7018893559","8131218435");
//		for(AgentInformation ag: agentInformations) {
//			if(ag.getParentId().contains("not found")) {
//				log.info("Agent without parent Id - {}", ag);
//			}

//			if(parentMsIsdn.contains(ag.getParentMsisdn())) {
//				channelPartnerClient.callCP(ag);
//			}else {
//				log.info("No match with parentMsisdn for agent - {}", ag);
//			}

//		}

//		doFSPParentMapping();

//		List<FSPDealerInformationRetry> fspDealersRetry = myFileReader2.readProcessReport();
//		int i = 0;
//		for(FSPDealerInformationRetry fspDealerRetry: fspDealersRetry) {
//			if(fspDealerRetry.getMessage().contains("MQ Error")) {
//				log.info("retry - {}", fspDealerRetry);
//				i++;
//			}
//		}
//
//		log.info("total files - {}", i);

//		String processedFile = "classpath:processedFile.txt";
//		List<ProcessedTransactionReader> procs = myFileReader2.readProcessedTransaction(processedFile);
//		for(ProcessedTransactionReader id: procs) {
//			if(id.id.contains("Failure")) {
//				System.out.println(id);
//			}
//		}

//		String subset = "classpath:apc-completed.txt";
//		String allFiles = "classpath:apc-all.txt";
//		compareFiles(subset, allFiles);

//		doGradeCodeChange();

		doAPCReprocessTransactions();

//		doStaffUpgrade();

	}

	private void doFSPParentMapping() throws IOException {
		List<FSPDealerInformationDto> fspDealers = myFileReader2.readMsisdnGradeCode();
		for(FSPDealerInformationDto fspDealerInformation: fspDealers) {
			fspParentMappingClient.callCP(fspDealerInformation.getMsisdn());
		}
	}

	private void compareFiles(String subset, String allFiles) throws IOException {
		Set<String> idReaderSIT = myFileReader2.readIds(subset);
		Set<String> idReaderProd = myFileReader2.readIds(allFiles);

		myFileReader2.createFileWriter("src/main/resources/output/res1.txt");
		for(String id: idReaderProd) {
			if(!idReaderSIT.contains(id)) {
				myFileReader2.writeToFile(id);
			}
		}

		myFileReader2.closeFile();
		System.out.println("Complete");
	}

	private void doGradeCodeChange() throws IOException {
		List<IdReaderDto> datas = myFileReader2.readFile();
		for(IdReaderDto data: datas) {
			agentUpdateClient.callCP(data);
		}
	}

	private void doAPCReprocessTransactions() throws IOException {
		List<NIPTransactionInformationDto> nipTransaction = myFileReader2.readNIPTransaction();
		try{
			for(NIPTransactionInformationDto data: nipTransaction) {
				nipTransactionRetry.callBackendServer(data);
			}
		}catch (Exception ex) {
			System.out.println("Error occured processing data");
			ex.printStackTrace();
		}
		System.out.println("Processing completed @" + LocalDateTime.now());
	}

	private void doStaffUpgrade() throws IOException {
		List<StaffInputDto> staffData = myFileReader2.readStaffData();

		myFileReader2.createFileWriter("src/main/resources/output/staff-upgrade-res.txt");

		String result = "";
		int total = 0;
		for(StaffInputDto data: staffData) {
			result = result + staffUpgradeClient.callBackendStaffUpgrade(data) + "\n";
			total++;
		}

		myFileReader2.writeToFile(result);
		myFileReader2.closeFile();
		System.out.println("Complete");
	}
}
