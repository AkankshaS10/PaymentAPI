package com.rev.apitest.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Akanksha
 * 
 */
public class Transaction {

	@JsonProperty(required = true)
	private long fromAccontId;
	@JsonProperty(required = true)
	private long toAccountId;
	@JsonProperty(required = true)
	private BigDecimal ammount;
	@JsonProperty(required = true)
	private String currency;
	
	public Transaction(){
		
	}
	
	
	public Transaction(long fromAccontId, long toAccountId, BigDecimal ammount, String currency) {
		super();
		this.fromAccontId = fromAccontId;
		this.toAccountId = toAccountId;
		this.ammount = ammount;
		this.currency = currency;
	}


	public long getFromAccontId() {
		return fromAccontId;
	}
	public void setFromAccontId(long fromAccontId) {
		this.fromAccontId = fromAccontId;
	}
	public long getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(long toAccountId) {
		this.toAccountId = toAccountId;
	}
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ammount == null) ? 0 : ammount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + (int) (fromAccontId ^ (fromAccontId >>> 32));
		result = prime * result + (int) (toAccountId ^ (toAccountId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (ammount == null) {
			if (other.ammount != null)
				return false;
		} else if (!ammount.equals(other.ammount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (fromAccontId != other.fromAccontId)
			return false;
		if (toAccountId != other.toAccountId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [fromAccontId=");
		builder.append(fromAccontId);
		builder.append(", toAccountId=");
		builder.append(toAccountId);
		builder.append(", ammount=");
		builder.append(ammount);
		builder.append(", currency=");
		builder.append(currency);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
