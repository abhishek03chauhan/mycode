package com.ecb.xmltutility.service;

import com.ecb.xmltutility.dto.MoneyMarketReportHeader1;
import com.ecb.xmltutility.model.TransactionReport;

public interface CreateXMLReportingAgentService {
	
	public MoneyMarketReportHeader1 createReportAgentTag(TransactionReport transactionReport);

}
