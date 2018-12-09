package com.ecb.xmltutility.daoimpl;

import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecb.xmltutility.dto.NovationStatus1Code;
import com.ecb.xmltutility.dto.ReportPeriodActivity3Code;
import com.ecb.xmltutility.dto.TransactionOperationType1Code;
import com.ecb.xmltutility.model.TransactionReport;

@Component
@Transactional
public class DataInsertUtility {

	private static final Logger log = LoggerFactory.getLogger(DataInsertUtility.class);

	@Autowired
	SessionFactory sessionFactory;

	public void insertData() {

		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();

		log.info("Inside insert data");

		for(int a = 1 ; a<=5; a++) {
			for (Integer i = 1; i <= 50000; i++) {
				TransactionReport tr = new TransactionReport();

				tr.setDataSetAction(ReportPeriodActivity3Code.NOTX.toString());
				tr.setRptdTrxStatus(TransactionOperationType1Code.AMND.toString());
				tr.setNovationStatus(NovationStatus1Code.NOVA.toString());
				tr.setBranchId("52990002O5KK6XOGJ020");
				tr.setUniqueTrxIdentifier("TRX1232");
				tr.setProprietaryTrxId("6139127_20180214");
				tr.setRelatedPrtryTxId(i.toString());
				tr.setCounterPartyPrtryTxId("FF1");
				tr.setCounterPartyLEI("52990002O5KK6XOGJ020");
				tr.setCounterPartySector("SEC32235");
				tr.setCounterPartyLocation("Germany");
				tr.setCounterPartyName("Party1");
				tr.setCounterPartySecondLoc("SecondLocation1");
				// tr.setTradeDate(new Date());
				// tr.setTradeDateTime(new Date());
				// tr.setSettlementDate(new Date());
				tr.setMaturityDate(new Date());
				tr.setTransactionType("LEND");
				tr.setInstrumentType("CEOD");
				tr.setTrxNominalAmountValue(54466.60);
				tr.setTrxNominalAmountCurrency("CCY");
				tr.setDealPrice(i*1.001);
				tr.setRateType("FIXE");
				tr.setDealRate(15.03);
				tr.setRefRateIndx("EU0009659943");
				tr.setBsisPtSprd(10);
				tr.setBrokeredDeal("BROK");
				tr.setCallPutOptionType("CALL");
				// tr.setEarlstExrcDt(new Date());
				tr.setNoticePeriod(60);
				tr.setValidRecord("Y");
				// tr.setTradeDateTime(new Date());
				tr.setBusinessMessageIdentifier("BZMSGIDENTIFIER1");
				tr.setBusinessService("BusinessService");
				// tr.setHeaderCreationDate(new Date());
				tr.setFromOrgID("FrmOrg1");
				tr.setFrmSchemaName("fSc1");
				tr.setMessageDefinitionIdentifier("MSSGDEFId1");
				tr.setToOrgID("ToOrgId");
				tr.setToSchemaName("toS1");
				// tr.setRefPrdFromDateTime(new Date());
				// tr.setRefPrdToDateTime(new Date());
				tr.setReportingAgent("52990002O5KK6XOGJ020");
				tr.setReportAgentId(a);
				tr.setLabelInfo("L1");
				// tr.setCreatedDate(new Date());

				session.save(tr);
			}

		}
		
	}
	
	public void insertinvalidData() {


		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();

		log.info("Inside insert data");
		for(int a = 1 ; a<=5; a++) {
			for (Integer i = 1; i <= 50_000; i++) {
				TransactionReport tr = new TransactionReport();

				tr.setDataSetAction(ReportPeriodActivity3Code.NOTX.toString());
				tr.setRptdTrxStatus(TransactionOperationType1Code.AMND.toString());
				tr.setNovationStatus(NovationStatus1Code.NOVA.toString());
				tr.setBranchId("52990002O5KK6XOGJ020");
				tr.setUniqueTrxIdentifier("INVALID");
				tr.setProprietaryTrxId("6139127_20180214");
				tr.setRelatedPrtryTxId(i.toString());
				tr.setCounterPartyPrtryTxId("FF1");
				tr.setCounterPartyLEI("52990002O5KK6XOGJ020");
				tr.setCounterPartySector("SEC32235");
				tr.setCounterPartyLocation("Germany");
				tr.setCounterPartyName("Party1");
				tr.setCounterPartySecondLoc("SecondLocation1");
				// tr.setTradeDate(new Date());
				// tr.setTradeDateTime(new Date());
				// tr.setSettlementDate(new Date());
				tr.setMaturityDate(new Date());
				tr.setTransactionType("LEND");
				tr.setInstrumentType("CEOD");
				tr.setTrxNominalAmountValue(54466.60);
				tr.setTrxNominalAmountCurrency("CCY");
				tr.setDealPrice(i*2.001);
				tr.setRateType("FIXE");
				tr.setDealRate(15.03);
				tr.setRefRateIndx("EU0009659943");
				tr.setBsisPtSprd(10);
				tr.setBrokeredDeal("BROK");
				tr.setCallPutOptionType("CALL");
				// tr.setEarlstExrcDt(new Date());
				tr.setNoticePeriod(60);
				tr.setValidRecord("N");
				// tr.setTradeDateTime(new Date());
				tr.setBusinessMessageIdentifier("BZMSGIDENTIFIER1");
				tr.setBusinessService("BusinessService");
				// tr.setHeaderCreationDate(new Date());
				tr.setFromOrgID("FrmOrg1");
				tr.setFrmSchemaName("fSc1");
				tr.setMessageDefinitionIdentifier("MSSGDEFId1");
				tr.setToOrgID("ToOrgId");
				tr.setToSchemaName("toS1");
				// tr.setRefPrdFromDateTime(new Date());
				// tr.setRefPrdToDateTime(new Date());
				tr.setReportingAgent("52990002O5KK6XOGJ020");
				tr.setReportAgentId(a);
				// tr.setCreatedDate(new Date());
				tr.setLabelInfo("L1");
				session.save(tr);
			}
		}	
	}

	public boolean checkAgenid(int agentId) {
		Session session = sessionFactory.getCurrentSession();
		Boolean idFlag = false;
		Query queryReport = session.createQuery("from TransactionReport tp where tp.reportAgentId = :agentId")
				.setParameter("agentId", agentId);
		log.info(":::::::Get agent id present or not::::::" + queryReport.list().size());
		if (queryReport.list() != null && queryReport.list().size() > 0) {
			idFlag = true;
		}
		return idFlag;
	}

	public Date getPreviousDate() {
		Date currentDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_YEAR, -1);

		Date previousDate = calendar.getTime();
		System.out.println("previous :::: " + previousDate);

		return previousDate;
	}

}
