package com.ecb.xmltutility.service;

import com.ecb.xmltutility.dto.BusinessApplicationHeaderV01;
import com.ecb.xmltutility.model.TransactionReport;

public interface CreateXMLHeaderService {

	public BusinessApplicationHeaderV01 createXMLHeader(TransactionReport transactionReport);
}
