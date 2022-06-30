package com.revature.models;

import java.util.Objects;

public class Manager {
	private int mgrId;
	private String mgrName;
	private String mgrUsername;
	private String mgrPassword;
	
	
	
	public Manager() {
		super();
	}



	public int getMgrId() {
		return mgrId;
	}



	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}



	public String getMgrName() {
		return mgrName;
	}



	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}



	public String getMgrUsername() {
		return mgrUsername;
	}



	public void setMgrUsername(String mgrUsername) {
		this.mgrUsername = mgrUsername;
	}



	public String getMgrPassword() {
		return mgrPassword;
	}



	public void setMgrPassword(String mgrPassword) {
		this.mgrPassword = mgrPassword;
	}



	@Override
	public String toString() {
		return "Manager [mgrId=" + mgrId + ", mgrName=" + mgrName + ", mgrUsername=" + mgrUsername + ", mgrPassword="
				+ mgrPassword + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(mgrId, mgrName, mgrPassword, mgrUsername);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return mgrId == other.mgrId && Objects.equals(mgrName, other.mgrName)
				&& Objects.equals(mgrPassword, other.mgrPassword) && Objects.equals(mgrUsername, other.mgrUsername);
	}
	


}
