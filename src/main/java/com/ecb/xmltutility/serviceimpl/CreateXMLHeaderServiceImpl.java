package com.ecb.xmltutility.serviceimpl;



import org.springframework.stereotype.Service;

import com.ecb.xmltutility.dto.BusinessApplicationHeaderV01;
import com.ecb.xmltutility.dto.GenericOrganisationIdentification1;
import com.ecb.xmltutility.dto.OrganisationIdentification7;
import com.ecb.xmltutility.dto.OrganisationIdentificationSchemeName1Choice;
import com.ecb.xmltutility.dto.Party10Choice;
import com.ecb.xmltutility.dto.Party9Choice;
import com.ecb.xmltutility.dto.PartyIdentification42;
import com.ecb.xmltutility.model.TransactionReport;
import com.ecb.xmltutility.service.CreateXMLHeaderService;
import com.ecb.xmlutility.util.DateUtility;

@Service
public class CreateXMLHeaderServiceImpl implements CreateXMLHeaderService {
	

	@Override
	public BusinessApplicationHeaderV01 createXMLHeader(TransactionReport transactionReport) {
		 Party9Choice frmParty9Choice = new Party9Choice();
		 Party9Choice toParty9Choice = new Party9Choice();
		 PartyIdentification42 frmPartyIdentification = new PartyIdentification42();
		 PartyIdentification42 toPartyIdentification = new PartyIdentification42();
		 Party10Choice frmParty10Choice = new Party10Choice();
		 Party10Choice toParty10Choice = new Party10Choice();
		 OrganisationIdentification7 frmOrganisationIdentification7 = new OrganisationIdentification7();
		 OrganisationIdentification7 toOrganisationIdentification7 = new OrganisationIdentification7();
		 GenericOrganisationIdentification1 frmOrgIdentification = new GenericOrganisationIdentification1();
		 GenericOrganisationIdentification1 toOrgIdentification = new GenericOrganisationIdentification1();
		 OrganisationIdentificationSchemeName1Choice frmName1Choice= new OrganisationIdentificationSchemeName1Choice();
		 OrganisationIdentificationSchemeName1Choice toName1Choice= new OrganisationIdentificationSchemeName1Choice();
		
		
		BusinessApplicationHeaderV01 businessApplicationHeader = new BusinessApplicationHeaderV01();

		frmName1Choice.getCd().add(transactionReport.getToSchemaName());
		frmOrgIdentification.setId(transactionReport.getToOrgID());
		frmOrgIdentification.setSchmeNm(frmName1Choice);
		frmOrganisationIdentification7.getOthr().add(frmOrgIdentification);
		frmParty10Choice.setOrgId(frmOrganisationIdentification7);
		frmPartyIdentification.setId(frmParty10Choice);
		frmParty9Choice.setOrgId(frmPartyIdentification);
		businessApplicationHeader.setFr(frmParty9Choice);
		
		
		toName1Choice.getCd().add(transactionReport.getToSchemaName());
		toOrgIdentification.setId(transactionReport.getToOrgID());
		toOrgIdentification.setSchmeNm(toName1Choice);
		toOrganisationIdentification7.getOthr().add(toOrgIdentification);
		toParty10Choice.setOrgId(toOrganisationIdentification7);
		toPartyIdentification.setId(toParty10Choice);
		toParty9Choice.setOrgId(toPartyIdentification);
		
		businessApplicationHeader.setTo(toParty9Choice);
		
		businessApplicationHeader.setBizMsgIdr(transactionReport.getBusinessMessageIdentifier());
		businessApplicationHeader.setBizSvc(transactionReport.getBusinessService());
		businessApplicationHeader.setCreDt(DateUtility.normalizeDateTimeToXMLGregorianCalendar(transactionReport.getHeaderCreationDate()));
		businessApplicationHeader.setMsgDefIdr(transactionReport.getMessageDefinitionIdentifier());
		
		return businessApplicationHeader;
	}
	 
}
