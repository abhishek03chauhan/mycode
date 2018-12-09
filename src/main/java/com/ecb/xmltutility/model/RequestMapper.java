package com.ecb.xmltutility.model;


public class RequestMapper {

	private int transactions;
	
	private int inValidRecords;
	
	private int fileSize;
	
	private int lastDayTransactions; 
	
	private String createdBy;
	
	private String labelInfo;

	public int getTransactions() {
		return transactions;
	}

	public void setTransactions(int transactions) {
		this.transactions = transactions;
	}

	public int getInValidRecords() {
		return inValidRecords;
	}

	public void setInValidRecords(int inValidRecords) {
		this.inValidRecords = inValidRecords;
	}


	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getLastDayTransactions() {
		return lastDayTransactions;
	}

	public void setLastDayTransactions(int lastDayTransactions) {
		this.lastDayTransactions = lastDayTransactions;
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
