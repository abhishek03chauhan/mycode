package com.ecb.xmltutility.serviceimpl;

import org.springframework.stereotype.Service;

import com.ecb.xmltutility.dto.DateTimePeriod1;
import com.ecb.xmltutility.dto.MoneyMarketReportHeader1;
import com.ecb.xmltutility.model.TransactionReport;
import com.ecb.xmltutility.service.CreateXMLReportingAgentService;
import com.ecb.xmlutility.util.DateUtility;

@Service
public class CreateXMLReportingAgentServiceImpl implements CreateXMLReportingAgentService {

	@Override
	public MoneyMarketReportHeader1 createReportAgentTag(TransactionReport transactionReport) {
		MoneyMarketReportHeader1 reportHeader = new MoneyMarketReportHeader1();
		DateTimePeriod1 agentDateAndTime = new DateTimePeriod1();

		reportHeader.setRptgAgt(transactionReport.getReportingAgent());

		agentDateAndTime.setFrDtTm(DateUtility.dateTimeToXMLGregorianCalendar(transactionReport.getRefPrdFromDateTime()));
		agentDateAndTime.setToDtTm(DateUtility.dateTimeToXMLGregorianCalendar(transactionReport.getRefPrdFromDateTime()));

		reportHeader.setRefPrd(agentDateAndTime);
		
		return reportHeader;

	}

}
