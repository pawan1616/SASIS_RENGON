package com.technobright.entities.fee;

import com.technobright.entities.StudentInfo;

public class Std_Installment {
	private long stdInstallmentId;
	private StudentInfo stdInfo;
	private Installments installment;
	private boolean isPaid;
	private boolean isSpecial;
	public long getStdInstallmentId() {
		return stdInstallmentId;
	}
	public void setStdInstallmentId(long stdInstallmentId) {
		this.stdInstallmentId = stdInstallmentId;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public Installments getInstallment() {
		return installment;
	}
	public void setInstallment(Installments installment) {
		this.installment = installment;
	}
	public boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public boolean getIsSpecial() {
		return isSpecial;
	}
	public void setIsSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
}
