package com.technobright.actions;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class RWEHelper {

	private int pageId;
	private boolean read;
	private boolean write;
	private boolean edit;
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public boolean getRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean getWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
	}
	public boolean getEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
}
