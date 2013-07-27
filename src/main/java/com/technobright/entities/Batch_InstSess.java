package com.technobright.entities;

public class Batch_InstSess {
	private long pk;
	private BatchInfo batchInfo;
	private InstSessionInfo instSess;
	private boolean isHistory;
	public long getPk() {
		return pk;
	}
	public void setPk(long pk) {
		this.pk = pk;
	}
	public BatchInfo getBatchInfo() {
		return batchInfo;
	}
	public void setBatchInfo(BatchInfo batchInfo) {
		this.batchInfo = batchInfo;
	}
	public InstSessionInfo getInstSess() {
		return instSess;
	}
	public void setInstSess(InstSessionInfo instSess) {
		this.instSess = instSess;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
}
