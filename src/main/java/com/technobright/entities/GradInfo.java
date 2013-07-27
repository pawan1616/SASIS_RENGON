package com.technobright.entities;

public class GradInfo implements Comparable{
	private long gradId;
	private String gradName;
	private int lowRange;
	private int highRange;
	private float gradPoint;
	private boolean isHistory;
	private InstAdmin instAdmin;
	public long getGradId() {
		return gradId;
	}
	public void setGradId(long gradId) {
		this.gradId = gradId;
	}
	public String getGradName() {
		return gradName;
	}
	public void setGradName(String gradName) {
		this.gradName = gradName;
	}
	public int getLowRange() {
		return lowRange;
	}
	public void setLowRange(int lowRange) {
		this.lowRange = lowRange;
	}
	public int getHighRange() {
		return highRange;
	}
	public void setHighRange(int highRange) {
		this.highRange = highRange;
	}
	public float getGradPoint() {
		return gradPoint;
	}
	public void setGradPoint(float gradPoint) {
		this.gradPoint = gradPoint;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
	public int compareTo(Object o) {
		if(this.getLowRange()<((GradInfo)o).getLowRange())
			return -1;
		else if(this.getLowRange()==((GradInfo)o).getLowRange())
			return 0;
		else if((this.getLowRange()>((GradInfo)o).getLowRange()))
			return 1;
		return 0;
	}
	
	
}
