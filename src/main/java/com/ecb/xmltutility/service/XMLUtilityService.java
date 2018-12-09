package com.ecb.xmltutility.service;

import java.util.List;

import com.ecb.xmltutility.dto.BusinessApplicationHeaderV01;
import com.ecb.xmltutility.dto.MoneyMarketReportHeader1;
import com.ecb.xmltutility.dto.UnsecuredMarketReport4Choice;
import com.ecb.xmltutility.model.RequestMapper;
import com.ecb.xmltutility.model.TransactionReport;

public interface XMLUtilityService {

	// public void retrieveTransactionRecords();

	public List<TransactionReport> retrieveTransactionRecords(RequestMapper mapper, int reportAgentId);

	public UnsecuredMarketReport4Choice process(List<TransactionReport> transactionReportList) throws Exception;

	public BusinessApplicationHeaderV01 createHeader(TransactionReport transactionReport);

	public MoneyMarketReportHeader1 createReportAgent(TransactionReport transactionReport);

	public void createXML(UnsecuredMarketReport4Choice unsecuredMarketReport4Choice,
			BusinessApplicationHeaderV01 headerApp, MoneyMarketReportHeader1 reportHeader, int reportAgentId) throws Exception;
/*
	public void insertDataIntable();

	public boolean checkAgentId(int agentId);*/
	
	public List<Integer> getReportingAgent();
}
