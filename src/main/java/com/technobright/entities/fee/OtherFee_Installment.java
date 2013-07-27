package com.technobright.entities.fee;

public class OtherFee_Installment {
	private long otherFeeInstallmentId;
	private OtherFee otherFee;
	private Installments installment;
	public long getOtherFeeInstallmentId() {
		return otherFeeInstallmentId;
	}
	public void setOtherFeeInstallmentId(long otherFeeInstallmentId) {
		this.otherFeeInstallmentId = otherFeeInstallmentId;
	}
	public OtherFee getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(OtherFee otherFee) {
		this.otherFee = otherFee;
	}
	public Installments getInstallment() {
		return installment;
	}
	public void setInstallment(Installments installment) {
		this.installment = installment;
	}
}
