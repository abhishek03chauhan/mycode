package com.ecb.xmltutility.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

// TODO: Use lombok //

@Entity
@Table(name="TransactionReport")
public class TransactionReport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7621467364785875606L;

	@Id
	@Column(name = "TRANSACTIONID")
	@GenericGenerator(name = "ID_GENERATOR", strategy = "sequence", parameters = @Parameter(value = "ABHISHEK.IDGENERATOR", name = "sequence"))
	@GeneratedValue(generator = "ID_GENERATOR")
	private Integer transactionId;

	@Column(name = "DataSetAction")
	private String dataSetAction;

	@Column(name = "reportedTransactionStatus")
	private String rptdTrxStatus;

	@Column(name = "novationStatus")
	private String novationStatus;

	@Column(name = "BranchIdentification")
	private String branchId;

	@Column(name = "UniqueTransactionIdentifier")
	private String uniqueTrxIdentifier;

	@Column(name = "ProprietaryTrxId")
	private String ProprietaryTrxId;

	@Column(name = "RelatedPrtryTxId")
	private String relatedPrtryTxId;

	@Column(name = "CounterpartyPrtryTxId")
	private String counterPartyPrtryTxId;

	@Column(name = "CounterpartyLEI")
	private String counterPartyLEI;

	@Column(name = "CounterpartySector")
	private String counterPartySector;

	@Column(name = "CounterpartyLocation")
	private String counterPartyLocation;

	@Column(name = "CounterpartyName")
	private String counterPartyName;

	@Column(name = "CounterpartyLocation2")
	private String counterPartySecondLoc;

	@Column(name = "TradeDate")
	@Temporal(TemporalType.DATE)
	private transient Date tradeDate;

	@Column(name = "TradeDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private transient Date tradeDateTime;

	@Column(name = "SettlementDate")
	@Temporal(TemporalType.DATE)
	private transient Date settlementDate;

	@Column(name = "MaturityDate")
	@Temporal(TemporalType.DATE)
	private transient Date maturityDate;

	@Column(name = "TransactionType")
	private String transactionType;

	@Column(name = "InstrumentType")
	private String instrumentType;

	@Column(name = "TrxNominalAmountValue")
	private Double trxNominalAmountValue;

	@Column(name = "TrxNominalAmountCurrency")
	private String TrxNominalAmountCurrency;

	@Column(name = "DealPrice")
	private Double dealPrice;

	@Column(name = "RateType")
	private String rateType;

	@Column(name = "DealRate")
	private Double dealRate;

	@Column(name = "FltgRateNote_RefRateIndx")
	private String refRateIndx;

	@Column(name = "FltgRateNote_BsisPtSprd")
	private Integer bsisPtSprd;

	@Column(name = "BrokeredDeal")
	private String brokeredDeal;

	@Column(name = "CallPutOptionType")
	private String callPutOptionType;

	@Column(name = "CallPutOption_EarlstExrcDt")
	@Temporal(TemporalType.DATE)
	private transient Date earlstExrcDt;

	@Column(name = "CallPutOption_NtcePrd")
	private Integer noticePeriod;

	@Column(name = "ValidRecord")
	private String validRecord;

	@Column(name = "FromOrgID")
	private String fromOrgID;

	@Column(name = "FromSchemaName")
	private String frmSchemaName;

	@Column(name = "ToOrgId")
	private String toOrgID;

	@Column(name = "ToSchemaName")
	private String toSchemaName;

	@Column(name = "BusinessMessageIdentifier")
	private String businessMessageIdentifier;

	@Column(name = "MessageDefinitionIdentifier")
	private String messageDefinitionIdentifier;

	@Column(name = "BusinessService")
	private String businessService;

	@Column(name = "HeaderCreationDate")
	@Temporal(TemporalType.TIMESTAMP)
	private transient Date headerCreationDate;

	@Column(name = "ReportingAgent")
	private String reportingAgent;

	@Column(name = "RefPrdFromDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private transient Date refPrdFromDateTime;

	@Column(name = "RefPrdToDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private transient Date refPrdToDateTime;

	@Column(name = "ReportAgentId")
	private Integer reportAgentId;

	@Column(name = "ErrorDescription")
	private String errorDescription;

	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "LabelInfo")
	private String labelInfo;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getDataSetAction() {
		return dataSetAction;
	}

	public void setDataSetAction(String dataSetAction) {
		this.dataSetAction = dataSetAction;
	}

	public String getRptdTrxStatus() {
		return rptdTrxStatus;
	}

	public void setRptdTrxStatus(String rptdTrxStatus) {
		this.rptdTrxStatus = rptdTrxStatus;
	}

	public String getNovationStatus() {
		return novationStatus;
	}

	public void setNovationStatus(String novationStatus) {
		this.novationStatus = novationStatus;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getUniqueTrxIdentifier() {
		return uniqueTrxIdentifier;
	}

	public void setUniqueTrxIdentifier(String uniqueTrxIdentifier) {
		this.uniqueTrxIdentifier = uniqueTrxIdentifier;
	}

	public String getProprietaryTrxId() {
		return ProprietaryTrxId;
	}

	public void setProprietaryTrxId(String proprietaryTrxId) {
		ProprietaryTrxId = proprietaryTrxId;
	}

	public String getRelatedPrtryTxId() {
		return relatedPrtryTxId;
	}

	public void setRelatedPrtryTxId(String relatedPrtryTxId) {
		this.relatedPrtryTxId = relatedPrtryTxId;
	}

	public String getCounterPartyPrtryTxId() {
		return counterPartyPrtryTxId;
	}

	public void setCounterPartyPrtryTxId(String counterPartyPrtryTxId) {
		this.counterPartyPrtryTxId = counterPartyPrtryTxId;
	}

	public String getCounterPartyLEI() {
		return counterPartyLEI;
	}

	public void setCounterPartyLEI(String counterPartyLEI) {
		this.counterPartyLEI = counterPartyLEI;
	}

	public String getCounterPartySector() {
		return counterPartySector;
	}

	public void setCounterPartySector(String counterPartySector) {
		this.counterPartySector = counterPartySector;
	}

	public String getCounterPartyLocation() {
		return counterPartyLocation;
	}

	public void setCounterPartyLocation(String counterPartyLocation) {
		this.counterPartyLocation = counterPartyLocation;
	}

	public String getCounterPartyName() {
		return counterPartyName;
	}

	public void setCounterPartyName(String counterPartyName) {
		this.counterPartyName = counterPartyName;
	}

	public String getCounterPartySecondLoc() {
		return counterPartySecondLoc;
	}

	public void setCounterPartySecondLoc(String counterPartySecondLoc) {
		this.counterPartySecondLoc = counterPartySecondLoc;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getTradeDateTime() {
		return tradeDateTime;
	}

	public void setTradeDateTime(Date tradeDateTime) {
		this.tradeDateTime = tradeDateTime;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Double getTrxNominalAmountValue() {
		return trxNominalAmountValue;
	}

	public void setTrxNominalAmountValue(Double trxNominalAmountValue) {
		this.trxNominalAmountValue = trxNominalAmountValue;
	}

	public String getTrxNominalAmountCurrency() {
		return TrxNominalAmountCurrency;
	}

	public void setTrxNominalAmountCurrency(String trxNominalAmountCurrency) {
		TrxNominalAmountCurrency = trxNominalAmountCurrency;
	}

	public Double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(Double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public Double getDealRate() {
		return dealRate;
	}

	public void setDealRate(Double dealRate) {
		this.dealRate = dealRate;
	}

	public String getRefRateIndx() {
		return refRateIndx;
	}

	public void setRefRateIndx(String refRateIndx) {
		this.refRateIndx = refRateIndx;
	}

	public Integer getBsisPtSprd() {
		return bsisPtSprd;
	}

	public void setBsisPtSprd(Integer bsisPtSprd) {
		if(bsisPtSprd == null) {
			this.bsisPtSprd = 0;
		}else
		this.bsisPtSprd = bsisPtSprd;
	}

	public String getBrokeredDeal() {
		return brokeredDeal;
	}

	public void setBrokeredDeal(String brokeredDeal) {
		this.brokeredDeal = brokeredDeal;
	}

	public String getCallPutOptionType() {
		return callPutOptionType;
	}

	public void setCallPutOptionType(String callPutOptionType) {
		this.callPutOptionType = callPutOptionType;
	}

	public Date getEarlstExrcDt() {
		return earlstExrcDt;
	}

	public void setEarlstExrcDt(Date earlstExrcDt) {
		this.earlstExrcDt = earlstExrcDt;
	}

	public Integer getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getValidRecord() {
		return validRecord;
	}

	public void setValidRecord(String validRecord) {
		this.validRecord = validRecord;
	}

	public String getFromOrgID() {
		return fromOrgID;
	}

	public void setFromOrgID(String fromOrgID) {
		this.fromOrgID = fromOrgID;
	}

	public String getFrmSchemaName() {
		return frmSchemaName;
	}

	public void setFrmSchemaName(String frmSchemaName) {
		this.frmSchemaName = frmSchemaName;
	}

	public String getToOrgID() {
		return toOrgID;
	}

	public void setToOrgID(String toOrgID) {
		this.toOrgID = toOrgID;
	}

	public String getToSchemaName() {
		return toSchemaName;
	}

	public void setToSchemaName(String toSchemaName) {
		this.toSchemaName = toSchemaName;
	}

	public String getBusinessMessageIdentifier() {
		return businessMessageIdentifier;
	}

	public void setBusinessMessageIdentifier(String businessMessageIdentifier) {
		this.businessMessageIdentifier = businessMessageIdentifier;
	}

	public String getMessageDefinitionIdentifier() {
		return messageDefinitionIdentifier;
	}

	public void setMessageDefinitionIdentifier(String messageDefinitionIdentifier) {
		this.messageDefinitionIdentifier = messageDefinitionIdentifier;
	}

	public String getBusinessService() {
		return businessService;
	}

	public void setBusinessService(String businessService) {
		this.businessService = businessService;
	}

	public Date getHeaderCreationDate() {
		return headerCreationDate;
	}

	public void setHeaderCreationDate(Date headerCreationDate) {
		this.headerCreationDate = headerCreationDate;
	}

	public String getReportingAgent() {
		return reportingAgent;
	}

	public void setReportingAgent(String reportingAgent) {
		this.reportingAgent = reportingAgent;
	}

	public Date getRefPrdFromDateTime() {
		return refPrdFromDateTime;
	}

	public void setRefPrdFromDateTime(Date refPrdFromDateTime) {
		this.refPrdFromDateTime = refPrdFromDateTime;
	}

	public Date getRefPrdToDateTime() {
		return refPrdToDateTime;
	}

	public void setRefPrdToDateTime(Date refPrdToDateTime) {
		this.refPrdToDateTime = refPrdToDateTime;
	}

	public Integer getReportAgentId() {
		return reportAgentId;
	}

	public void setReportAgentId(Integer reportAgentId) {
		this.reportAgentId = reportAgentId;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLabelInfo() {
		return labelInfo;
	}

	public void setLabelInfo(String labelInfo) {
		this.labelInfo = labelInfo;
	}
	
	

}
