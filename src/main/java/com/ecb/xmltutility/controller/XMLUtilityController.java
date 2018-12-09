package com.ecb.xmltutility.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecb.xmltutility.dto.BusinessApplicationHeaderV01;
import com.ecb.xmltutility.dto.MoneyMarketReportHeader1;
import com.ecb.xmltutility.dto.ReportPeriodActivity3Code;
import com.ecb.xmltutility.dto.UnsecuredMarketReport4Choice;
import com.ecb.xmltutility.model.RequestMapper;
import com.ecb.xmltutility.model.TransactionReport;
import com.ecb.xmltutility.service.XMLUtilityService;

@Controller
@RequestMapping("/xmlutility")
public class XMLUtilityController {
	private static final Logger log = LoggerFactory.getLogger(XMLUtilityController.class);
	@Autowired
	XMLUtilityService service;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String getRequestDetails(@ModelAttribute RequestMapper mapper) throws Exception {

		UnsecuredMarketReport4Choice unsecuredMarketReport4Choice = null;

		BusinessApplicationHeaderV01 headerApp = null;

		MoneyMarketReportHeader1 reportHeader = null;

		int lastAgentPicked = 0;

		List<Integer> reportingAgentList = service.getReportingAgent();

		log.info("agent list " + reportingAgentList.size() + " ::::: " + reportingAgentList);

		if (reportingAgentList.size() > mapper.getFileSize()) {
			lastAgentPicked = reportingAgentList.size() - 1;
		}

		for (int i = 0; i < mapper.getFileSize(); i++) {
			List<TransactionReport> listOfTransactions = null;
			if (i >= reportingAgentList.size()) {
				break;
				
			} else {
				log.info("::::: Constant flow :::::::::: " + reportingAgentList.get(i).intValue());
				listOfTransactions = service.retrieveTransactionRecords(mapper, reportingAgentList.get(i).intValue());
			}
			if (listOfTransactions != null && listOfTransactions.size() > 0) {
				log.info("::::::Transaction list is not null processing XML files start:::::");
				unsecuredMarketReport4Choice = service.process(listOfTransactions);
				log.info("::::::Creating app header starts:::::::");
				headerApp = service.createHeader(listOfTransactions.get(0));
				log.info("::::::Creating report agent starts:::::");
				reportHeader = service.createReportAgent(listOfTransactions.get(0));

			} else {
				unsecuredMarketReport4Choice = new UnsecuredMarketReport4Choice();
				unsecuredMarketReport4Choice.setDataSetActn(ReportPeriodActivity3Code.NORA);

			}
				service.createXML(unsecuredMarketReport4Choice, headerApp, reportHeader,
						reportingAgentList.get(i).intValue());
	

		}
		return "success";

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		log.info("::::: Home Controller Invoked :::::: ");
		return "welcome";
	}

}
