package com.ecb.xmltutility.serviceimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecb.xmltutility.dao.UnsecuredTransactionRecordDao;
import com.ecb.xmltutility.dto.ActiveCurrencyAndAmount;
import com.ecb.xmltutility.dto.BrokeredDeal1Code;
import com.ecb.xmltutility.dto.BusinessApplicationHeaderV01;
import com.ecb.xmltutility.dto.CounterpartyIdentification3Choice;
import com.ecb.xmltutility.dto.DateAndDateTimeChoice;
import com.ecb.xmltutility.dto.Document;
import com.ecb.xmltutility.dto.FinancialInstrumentProductType1Code;
import com.ecb.xmltutility.dto.FloatingRateNote2;
import com.ecb.xmltutility.dto.InterestRateType1Code;
import com.ecb.xmltutility.dto.MmsrMessageType;
import com.ecb.xmltutility.dto.MoneyMarketReportHeader1;
import com.ecb.xmltutility.dto.MoneyMarketTransactionType1Code;
import com.ecb.xmltutility.dto.MoneyMarketUnsecuredMarketStatisticalReportV02;
import com.ecb.xmltutility.dto.NameAndLocation1;
import com.ecb.xmltutility.dto.NovationStatus1Code;
import com.ecb.xmltutility.dto.Option12;
import com.ecb.xmltutility.dto.OptionDateOrPeriod1Choice;
import com.ecb.xmltutility.dto.OptionType1Code;
import com.ecb.xmltutility.dto.SectorAndLocation1;
import com.ecb.xmltutility.dto.TransactionOperationType1Code;
import com.ecb.xmltutility.dto.UnsecuredMarketReport4Choice;
import com.ecb.xmltutility.dto.UnsecuredMarketTransaction4;
import com.ecb.xmltutility.model.RequestMapper;
import com.ecb.xmltutility.model.TransactionReport;
import com.ecb.xmltutility.service.CreateXMLHeaderService;
import com.ecb.xmltutility.service.CreateXMLReportingAgentService;
import com.ecb.xmltutility.service.XMLUtilityService;
import com.ecb.xmlutility.util.DateUtility;

@Service
public class XMLUtilityServiceImpl implements XMLUtilityService {
	private static final Logger log = LoggerFactory.getLogger(XMLUtilityServiceImpl.class);
	private static final String INTERNAL_FILE_PATH = "C:\\XMLFiles\\";
	private static final String FILE_NAME = "EBORXML";
	static int temp = 1;

	@Autowired
	private UnsecuredTransactionRecordDao transactionRecordDao;

	@Autowired
	private CreateXMLHeaderService headerService;

	@Autowired
	private CreateXMLReportingAgentService agentService;

	@Override
	public List<TransactionReport> retrieveTransactionRecords(RequestMapper mapper,
			int reportAgentId){
		List<TransactionReport> transactionReportList = transactionRecordDao.getUnsecuredTransactionRecords(mapper,
				reportAgentId);

		return transactionReportList;
	}

	@Override
	public BusinessApplicationHeaderV01 createHeader(TransactionReport transactionReport) {

		return headerService.createXMLHeader(transactionReport);
	}

	@Override
	public UnsecuredMarketReport4Choice process(List<TransactionReport> transactionReportList) throws Exception {

		UnsecuredMarketReport4Choice unsecuredTransaction = new UnsecuredMarketReport4Choice();

		log.info(":::::: Transaction report list size ::::::" + transactionReportList.size());

		for (TransactionReport data : transactionReportList) {
			try {
				UnsecuredMarketTransaction4 unsecuredTransactions = createUnsecuredTransactionElements(data);
				unsecuredTransaction.getTx().add(unsecuredTransactions);
			} catch (Exception e) {
				log.error("Exception in process" + e.getMessage());
				throw e;
			}

		}
		return unsecuredTransaction;
	}

	private UnsecuredMarketTransaction4 createUnsecuredTransactionElements(TransactionReport data)
			throws DatatypeConfigurationException {
		UnsecuredMarketTransaction4 transactions = new UnsecuredMarketTransaction4();
		CounterpartyIdentification3Choice counterpartyIdentification3Choice = new CounterpartyIdentification3Choice();

		NameAndLocation1 nameAndLocation = new NameAndLocation1();

		SectorAndLocation1 sectrAndLoc = new SectorAndLocation1();

		DateAndDateTimeChoice dateAndTimeChoice = new DateAndDateTimeChoice();

		ActiveCurrencyAndAmount crrncyAndAmt = new ActiveCurrencyAndAmount();

		FloatingRateNote2 rateNote = new FloatingRateNote2();

		Option12 option = new Option12();

		OptionDateOrPeriod1Choice opdc = new OptionDateOrPeriod1Choice();

		if (data.getRptdTrxStatus() != null) {
			transactions.setRptdTxSts(TransactionOperationType1Code.valueOf(data.getRptdTrxStatus()));
		}
		if (data.getNovationStatus() != null) {
			transactions.setNvtnSts(NovationStatus1Code.valueOf(data.getNovationStatus()));
		}
		if (data.getBranchId() != null) {
			transactions.setBrnchId(data.getBranchId());
		}
		if (data.getUniqueTrxIdentifier() != null) {
			transactions.setUnqTxIdr(data.getUniqueTrxIdentifier());
		}
		if (data.getProprietaryTrxId() != null) {
			transactions.setPrtryTxId(data.getProprietaryTrxId());
		}
		if (data.getRelatedPrtryTxId() != null) {
			transactions.setRltdPrtryTxId(data.getRelatedPrtryTxId());
		}

		if (data.getCounterPartyPrtryTxId() != null) {
			transactions.setCtrPtyPrtryTxId(data.getCounterPartyPrtryTxId());
		}

		if (data.getCounterPartyLEI() != null) {
			counterpartyIdentification3Choice.setLEI(data.getCounterPartyLEI());
			transactions.setCtrPtyId(counterpartyIdentification3Choice);
		} else if (data.getCounterPartyLocation() != null && data.getCounterPartyName() != null) {
			nameAndLocation.setLctn(data.getCounterPartyLocation());
			nameAndLocation.setNm(data.getCounterPartyName());
			counterpartyIdentification3Choice.setNmAndLctn(nameAndLocation);
			transactions.setCtrPtyId(counterpartyIdentification3Choice);
		} else if (data.getCounterPartySecondLoc() != null && data.getCounterPartyLocation() != null) {
			sectrAndLoc.setLctn(data.getCounterPartySecondLoc());
			sectrAndLoc.setSctr(data.getCounterPartyLocation());
			counterpartyIdentification3Choice.setSctrAndLctn(sectrAndLoc);
			transactions.setCtrPtyId(counterpartyIdentification3Choice);
		}


		if (data.getTradeDate() != null) {
			dateAndTimeChoice.setDt(DateUtility.getXMLGegorianDate(data.getTradeDate()));
		} else {
			dateAndTimeChoice.setDtTm(DateUtility.dateTimeToXMLGregorianCalendar(data.getTradeDateTime()));
		}

		if (dateAndTimeChoice != null) {
			transactions.setTradDt(dateAndTimeChoice);
		}

		if (data.getSettlementDate() != null) {
			transactions.setSttlmDt(DateUtility.getXMLGegorianDate(data.getSettlementDate()));
		}
		if (data.getMaturityDate() != null) {
			transactions.setMtrtyDt(DateUtility.getXMLGegorianDate(data.getMaturityDate()));
		}

		if (data.getTransactionType() != null && data.getTransactionType()
				.equals(MoneyMarketTransactionType1Code.valueOf(data.getTransactionType()).toString())) {
			transactions.setTxTp(MoneyMarketTransactionType1Code.valueOf(data.getTransactionType()));
		}

		if (data.getInstrumentType() != null && data.getInstrumentType()
				.equals(FinancialInstrumentProductType1Code.valueOf(data.getInstrumentType()).toString())) {
			transactions.setInstrmTp(FinancialInstrumentProductType1Code.valueOf(data.getInstrumentType()));

		}

		if (data.getTrxNominalAmountCurrency() != null) {
			crrncyAndAmt.setCcy(data.getTrxNominalAmountCurrency());
		}
		if (data.getTrxNominalAmountValue() != null) {
			crrncyAndAmt.setValue(BigDecimal.valueOf(data.getTrxNominalAmountValue()));

			transactions.setTxNmnlAmt(crrncyAndAmt);
		}


		if (data.getDealPrice() != null) {
			transactions.setDealPric(BigDecimal.valueOf(data.getDealPrice()));
		}

		if (data.getRateType() != null) {
			transactions.setRateTp(InterestRateType1Code.valueOf(data.getRateType()));
		}
		if (data.getDealRate() != null) {
			transactions.setDealRate(BigDecimal.valueOf(data.getDealRate()));
		}

		if (data.getBsisPtSprd() != null) {
			rateNote.setBsisPtSprd(BigDecimal.valueOf(data.getBsisPtSprd()));
		}

		if (data.getRefRateIndx() != null) {
			rateNote.setRefRateIndx(data.getRefRateIndx());
			transactions.setFltgRateNote(rateNote);
		}


		if (data.getBrokeredDeal() != null) {
			transactions.setBrkrdDeal(BrokeredDeal1Code.valueOf(data.getBrokeredDeal()));
		}

		if (data.getCallPutOptionType() != null) {
			option.setTp(OptionType1Code.valueOf(data.getCallPutOptionType()));
			if (data.getEarlstExrcDt() != null) {
				opdc.setEarlstExrcDt(DateUtility.getXMLGegorianDate(data.getEarlstExrcDt()));

			} else {
				opdc.setNtcePrd(BigDecimal.valueOf(data.getNoticePeriod()));
			}

			if (opdc != null) {
				option.setDtOrPrd(opdc);
				transactions.getCallPutOptn().add(option);
			}
		}
		log.info(":::::: value of transaction ::::::" + transactions);
		return transactions;
	}

	@Override
	public MoneyMarketReportHeader1 createReportAgent(TransactionReport transactionReport) {
		return agentService.createReportAgentTag(transactionReport);
	}

	@Override
	public void createXML(UnsecuredMarketReport4Choice unsecuredMarketReport4Choice,
			BusinessApplicationHeaderV01 headerApp, MoneyMarketReportHeader1 reportHeader, int agentId) throws Exception {

		MoneyMarketUnsecuredMarketStatisticalReportV02 statisticalV2 = new MoneyMarketUnsecuredMarketStatisticalReportV02();
		Document document = new Document();
		MmsrMessageType objMmsrMessageType = new MmsrMessageType();

		statisticalV2.setRptHdr(reportHeader);
		statisticalV2.setUscrdMktRpt(unsecuredMarketReport4Choice);

		document.setMnyMktUscrdMktSttstclRpt(statisticalV2);

		objMmsrMessageType.setAppHdr(headerApp);
		objMmsrMessageType.getDocument().add(document);

		try {
			createFinalXML(objMmsrMessageType, agentId);
		} catch (Exception e) {
			log.error(":::::::::::Exception in create XML function ::::: " + e.getMessage());
			throw e;
		}
	}

	private void createFinalXML(MmsrMessageType messageType, int agentId) throws JAXBException, FileNotFoundException {

		JAXBContext jaxbContext = JAXBContext.newInstance(MmsrMessageType.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		QName qName = new QName("", "MMSRMessage");
		JAXBElement<MmsrMessageType> root = new JAXBElement<>(qName, MmsrMessageType.class, messageType);
		String fileName = INTERNAL_FILE_PATH + FILE_NAME + "_" + agentId + ".xml";
		
		marshaller.marshal(root, new File(fileName));
		temp=temp+1;
	}



	@Override
	public List<Integer> getReportingAgent() {
		return transactionRecordDao.getReportAgentId();
	}
}
