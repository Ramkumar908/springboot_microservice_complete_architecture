package com.ram.accounts.service.model;

public class Loans {
	
	private int loanNumber;
	private int customerId;
	private String startDt;
	private String loanType;
	private long totalLone;
	private long amountPaid;
	private long outstandingAmount;
	private String createDt;
	
	public Loans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loans(int loanNumber, int customerId, String startDt, String loanType, long totalLone, long amountPaid,
			long outstandingAmount, String createDt) {
		super();
		this.loanNumber = loanNumber;
		this.customerId = customerId;
		this.startDt = startDt;
		this.loanType = loanType;
		this.totalLone = totalLone;
		this.amountPaid = amountPaid;
		this.outstandingAmount = outstandingAmount;
		this.createDt = createDt;
	}
	public int getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public long getTotalLone() {
		return totalLone;
	}
	public void setTotalLone(long totalLone) {
		this.totalLone = totalLone;
	}
	public long getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(long amountPaid) {
		this.amountPaid = amountPaid;
	}
	public long getOutstandingAmount() {
		return outstandingAmount;
	}
	public void setOutstandingAmount(long outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	@Override
	public String toString() {
		return "Loans [loanNumber=" + loanNumber + ", customerId=" + customerId + ", startDt=" + startDt + ", loanType="
				+ loanType + ", totalLone=" + totalLone + ", amountPaid=" + amountPaid + ", outstandingAmount="
				+ outstandingAmount + ", createDt=" + createDt + "]";
	}
	
	
	

}
