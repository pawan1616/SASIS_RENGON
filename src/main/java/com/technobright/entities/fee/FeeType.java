package com.technobright.entities.fee;

public class FeeType {
	private long feeTypeId;
	private String feeTypeName;
	private String displayName;
	public long getFeeTypeId() {
		return feeTypeId;
	}
	public void setFeeTypeId(long feeTypeId) {
		this.feeTypeId = feeTypeId;
	}
	public String getFeeTypeName() {
		return feeTypeName;
	}
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
