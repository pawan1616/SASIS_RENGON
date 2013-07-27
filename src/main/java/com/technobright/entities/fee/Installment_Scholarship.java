package com.technobright.entities.fee;

public class Installment_Scholarship {
	private long installScholarId;
	private Installments installment;
	private Scholarship scholarship;
	public long getInstallScholarId() {
		return installScholarId;
	}
	public void setInstallScholarId(long installScholarId) {
		this.installScholarId = installScholarId;
	}
	public Installments getInstallment() {
		return installment;
	}
	public void setInstallment(Installments installment) {
		this.installment = installment;
	}
	public Scholarship getScholarship() {
		return scholarship;
	}
	public void setScholarship(Scholarship scholarship) {
		this.scholarship = scholarship;
	}
}
