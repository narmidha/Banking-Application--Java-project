package com.narmi.bank.entity;

import java.time.LocalDate;

public class Transaction {
	private LocalDate transcationDate;
	private String transactionuserid;
	private Double transactionAmount;
	private String transactionType;
	private Double initialBalance;
	private Double finalBalance;
	private String transactionPerformedBy;
	public LocalDate getTranscationDate() {
		return transcationDate;
	}
	public void setTranscationDate(LocalDate transcationDate) {
		this.transcationDate = transcationDate;
	}
	public String getTransactionuserid() {
		return transactionuserid;
	}
	public void setTransactionuserid(String transactionuserid) {
		this.transactionuserid = transactionuserid;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public Double getFinalBalance() {
		return finalBalance;
	}
	public void setFinalBalance(Double finalBalance) {
		this.finalBalance = finalBalance;
	}
	public String getTransactionPerformedBy() {
		return transactionPerformedBy;
	}
	public void setTransactionPerformedBy(String transactionPerformedBy) {
		this.transactionPerformedBy = transactionPerformedBy;
	}
	public Transaction(LocalDate transcationDate, String transactionuserid, Double transactionAmount,
			String transactionType, Double initialBalance, Double finalBalance, String transactionPerformedBy) {
		super();
		this.transcationDate = transcationDate;
		this.transactionuserid = transactionuserid;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.initialBalance = initialBalance;
		this.finalBalance = finalBalance;
		this.transactionPerformedBy = transactionPerformedBy;
	}
	@Override
	public String toString() {
		return "Transaction [transcationDate=" + transcationDate + ", transactionuserid=" + transactionuserid
				+ ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType
				+ ", initialBalance=" + initialBalance + ", finalBalance=" + finalBalance + ", transactionPerformedBy="
				+ transactionPerformedBy + "]";
	}
	
	

}
