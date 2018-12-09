package com.ecb.xmltutility.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecb.xmltutility.dao.UnsecuredTransactionRecordDao;
import com.ecb.xmltutility.model.RequestMapper;
import com.ecb.xmltutility.model.TransactionReport;
import com.ecb.xmlutility.util.DateUtility;

@Repository
@Transactional
public class UnsecuredTransactionRecordsDaoImpl implements UnsecuredTransactionRecordDao {

	private static final Logger log = LoggerFactory.getLogger(UnsecuredTransactionRecordsDaoImpl.class);

	private static final String QUERYFOR_VALID_RECORDS = "from TransactionReport model where model.reportAgentId =:agentId and model.validRecord=:validRecord";
	private static final String QUERYFOR_VALID_RECORDS_WITHLABELINFO = QUERYFOR_VALID_RECORDS
			+ " and model.labelInfo =:labelInfo";

	private static final String QUERYFOR_VALID_RECORDS_WITHLABELINFOANDCREATEDBY = QUERYFOR_VALID_RECORDS_WITHLABELINFO
			+ " and model.createdBy = :createdBy";

	private static final String DEFAULT_USER_NAME = "user";
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<TransactionReport> getUnsecuredTransactionRecords(RequestMapper mapper, int reportAgentId) {

		Session session = sessionFactory.getCurrentSession();
		List<TransactionReport> transactionList = new ArrayList<>();
		int invalidRecordSize = (int) ((mapper.getInValidRecords() * mapper.getTransactions()) / 100);

		log.info(":::::: Invalid Transaction size ::::: " + invalidRecordSize);
		int lastDayTransactionSize = (int) ((mapper.getTransactions() * mapper.getLastDayTransactions()) / 100);
		log.info(":::::: Last Day Transaction size ::::: " + lastDayTransactionSize);

		int validRecords = 0;
		Query queryValidRecord = null;
		List<TransactionReport> resultOfValidRecords = null;
		try {
			if (invalidRecordSize > 0) {
				validRecords = mapper.getTransactions() - invalidRecordSize;
			} else {
				validRecords = mapper.getTransactions();
			}
			if (validRecords > 0) {
				System.out.println("Value of valid transactions :: " + validRecords);

				if (!(DEFAULT_USER_NAME.equalsIgnoreCase(mapper.getCreatedBy()))) {
					queryValidRecord = session.createQuery(QUERYFOR_VALID_RECORDS_WITHLABELINFOANDCREATEDBY);

					queryValidRecord.setFirstResult(0);
					queryValidRecord.setMaxResults(validRecords);
					queryValidRecord.setParameter("agentId", reportAgentId).setParameter("validRecord", "Y");

					resultOfValidRecords = queryValidRecord.list();
				} else if (mapper.getLabelInfo() != null) {
					log.info("::: Inside label info query::::");
					queryValidRecord = session.createQuery(QUERYFOR_VALID_RECORDS_WITHLABELINFO);

					queryValidRecord.setFirstResult(0);
					queryValidRecord.setMaxResults(validRecords);
					queryValidRecord.setParameter("agentId", reportAgentId).setParameter("validRecord", "Y")
							.setParameter("labelInfo", mapper.getLabelInfo());

					resultOfValidRecords = queryValidRecord.list();
				}

				log.info("Size of valid records ::::: " + resultOfValidRecords.size());
				if (resultOfValidRecords != null && resultOfValidRecords.size() > 0) {
					log.info("Size of valid records ::::: " + lastDayTransactionSize);
					if (resultOfValidRecords.size() > lastDayTransactionSize) {
						log.info(":::::: Inside greater :::::");
						List<TransactionReport> lastDayValidRecords = resultOfValidRecords.subList(0,
								lastDayTransactionSize);
						List<TransactionReport> remainingValidRecords = resultOfValidRecords
								.subList(lastDayTransactionSize, resultOfValidRecords.size());

						log.info("last day valid records :::: " + lastDayValidRecords.size());
						log.info(" Size of remaining list ::::: " + remainingValidRecords.size());

						List<TransactionReport> listOfLastDayValidRecords = lastDayValidRecords.stream().map((data) -> {
							data.setTradeDate(DateUtility.setPreviousDate(1));
							data.setTradeDateTime(DateUtility.setPreviousDate(1));
							data.setSettlementDate(DateUtility.setPreviousDate(1));
							data.setMaturityDate(DateUtility.setCurrentDateByOne(1));
							data.setEarlstExrcDt(DateUtility.setPreviousDate(1));
							data.setHeaderCreationDate(DateUtility.setPreviousDate(1));
							data.setRefPrdFromDateTime(DateUtility.setPreviousDate(1));
							data.setRefPrdToDateTime(DateUtility.setPreviousDate(1));
							return data;
						}).collect(Collectors.toList());
							int num = DateUtility.getRandomNumber();
						List<TransactionReport> listOfRemainingValidRecords = remainingValidRecords.stream()
								.map((data) -> {
									
									data.setTradeDate(DateUtility.setPreviousDate(num));
									data.setTradeDateTime(DateUtility.setPreviousDate(num));
									data.setSettlementDate(DateUtility.setPreviousDate(num));
									data.setMaturityDate(DateUtility.setCurrentDateByOne(num+1));
									data.setEarlstExrcDt(DateUtility.setPreviousDate(num));
									data.setHeaderCreationDate(
											DateUtility.setPreviousDate(num));
									data.setRefPrdFromDateTime(
											DateUtility.setPreviousDate(num));
									data.setRefPrdToDateTime(
											DateUtility.setPreviousDate(num));
									return data;
								}).collect(Collectors.toList());

						transactionList.addAll(listOfLastDayValidRecords);
						transactionList.addAll(listOfRemainingValidRecords);

					} else {
						log.info("Size of valid records is equal or less than last day transactions input ::::: "
								+ resultOfValidRecords.size());
						List<TransactionReport> listOfLastDayValidRecords = resultOfValidRecords.stream()
								.map((data) -> {
									data.setTradeDate(DateUtility.setPreviousDate(1));
									data.setTradeDateTime(DateUtility.setPreviousDate(1));
									data.setSettlementDate(DateUtility.setPreviousDate(1));
									data.setMaturityDate(DateUtility.setCurrentDateByOne(1));
									data.setEarlstExrcDt(DateUtility.setPreviousDate(1));
									data.setHeaderCreationDate(DateUtility.setPreviousDate(1));
									data.setRefPrdFromDateTime(DateUtility.setPreviousDate(1));
									data.setRefPrdToDateTime(DateUtility.setPreviousDate(1));
									return data;
								}).collect(Collectors.toList());

						transactionList.addAll(listOfLastDayValidRecords);
					}

				}
			}
			if (mapper.getInValidRecords() > 0) {

				Query queryInvalidRecords = session.createQuery(
						"from TransactionReport model where model.reportAgentId =:agentId and model.validRecord=:validRecord");
				queryInvalidRecords.setFirstResult(0);
				queryInvalidRecords.setMaxResults(invalidRecordSize);
				queryInvalidRecords.setParameter("agentId", reportAgentId).setParameter("validRecord", "N");

				List<TransactionReport> resultOfInValidRecords = queryInvalidRecords.list();

				if (resultOfInValidRecords != null && !resultOfInValidRecords.isEmpty()) {
					List<TransactionReport> listOfInValidRecords = resultOfInValidRecords.stream().map((data) -> {
						// log.info("Streams count :::: " + data.getTransactionId());
						data.setTradeDate(DateUtility.setPreviousDate(1));
						data.setTradeDateTime(DateUtility.setPreviousDate(1));
						data.setSettlementDate(DateUtility.setPreviousDate(1));
						data.setMaturityDate(DateUtility.setCurrentDateByOne(1));
						data.setEarlstExrcDt(DateUtility.setPreviousDate(1));
						data.setHeaderCreationDate(DateUtility.setPreviousDate(1));
						data.setRefPrdFromDateTime(DateUtility.setPreviousDate(1));
						data.setRefPrdToDateTime(DateUtility.setPreviousDate(1));
						return data;
					}).collect(Collectors.toList());
					log.info("Size of last day invalid records :::  " + listOfInValidRecords.size());
					transactionList.addAll(listOfInValidRecords);
				}
			}
			log.info("Size of final transaction list ::: " + transactionList.size());

		} catch (Exception e) {
			log.error(":: Exception in getUnsecuredTransactionRecords ::::" + e.getMessage());
			throw e;
		}
		return transactionList;
	}

	@Override
	public List<Integer> getReportAgentId() {
		Session session = sessionFactory.getCurrentSession();

		Query getReportingAgent = session
				.createQuery("select model.reportAgentId from TransactionReport model ");
		getReportingAgent.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return getReportingAgent.list();
	}

}
