package com.ecb.xmltutility.dao;

import java.util.List;

import com.ecb.xmltutility.model.RequestMapper;
import com.ecb.xmltutility.model.TransactionReport;

public interface UnsecuredTransactionRecordDao {

	public List<TransactionReport> getUnsecuredTransactionRecords(RequestMapper mapper, int reportAgentId);

	List<Integer> getReportAgentId();

}
