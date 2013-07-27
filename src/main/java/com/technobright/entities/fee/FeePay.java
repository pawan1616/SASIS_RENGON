package com.technobright.entities.fee;

import java.util.Date;

public class FeePay {
	private long feePayId;
	private double amnt;
	private Date date;
	private boolean isLateFee;
	private boolean isScholarship;
	private boolean isOtherFee;
	private Installments installment;
	public long getFeePayId() {
		return feePayId;
	}
	public void setFeePayId(long feePayId) {
		this.feePayId = feePayId;
	}
	public double getAmnt() {
		return amnt;
	}
	public void setAmnt(double amnt) {
		this.amnt = amnt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isLateFee() {
		return isLateFee;
	}
	public void setLateFee(boolean isLateFee) {
		this.isLateFee = isLateFee;
	}
	public boolean isScholarship() {
		return isScholarship;
	}
	public void setScholarship(boolean isScholarship) {
		this.isScholarship = isScholarship;
	}
	public boolean isOtherFee() {
		return isOtherFee;
	}
	public void setOtherFee(boolean isOtherFee) {
		this.isOtherFee = isOtherFee;
	}
	public Installments getInstallment() {
		return installment;
	}
	public void setInstallment(Installments installment) {
		this.installment = installment;
	}
}
