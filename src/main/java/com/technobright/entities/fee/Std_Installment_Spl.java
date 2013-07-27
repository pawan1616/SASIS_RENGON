package com.technobright.entities.fee;

import com.technobright.entities.StudentInfo;

public class Std_Installment_Spl {
	private long stdInstallmentSplId;
	private StudentInfo stdInfo;
	private Installments installment;
	private boolean isPaid;
	public long getStdInstallmentSplId() {
		return stdInstallmentSplId;
	}
	public void setStdInstallmentSplId(long stdInstallmentSplId) {
		this.stdInstallmentSplId = stdInstallmentSplId;
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
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
}
