package com.ram.accounts.service.model;

public class Cards {
	
	private int cardId;
	private int customerId;
	private int cardNumber;
	private String cardType;
	private int totalLimit;
	private int amountUsed;
	private int availableAmount;
	private String createDt;
	
	
	public Cards() {
		// TODO Auto-generated constructor stub
	}
	public Cards(int cardId, int customerId, int cardNumber, String cardType, int totalLimit, int amountUsed,
			int availableAmount, String createDt) {
		this.cardId = cardId;
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.totalLimit = totalLimit;
		this.amountUsed = amountUsed;
		this.availableAmount = availableAmount;
		this.createDt = createDt;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getTotalLimit() {
		return totalLimit;
	}
	public void setTotalLimit(int totalLimit) {
		this.totalLimit = totalLimit;
	}
	public int getAmountUsed() {
		return amountUsed;
	}
	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}
	public int getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	@Override
	public String toString() {
		return "Cards [cardId=" + cardId + ", customerId=" + customerId + ", cardNumber=" + cardNumber + ", cardType="
				+ cardType + ", totalLimit=" + totalLimit + ", amountUsed=" + amountUsed + ", availableAmount="
				+ availableAmount + ", createDt=" + createDt + "]";
	}
	
	

}
