package com.revature.models;

import java.time.LocalDate;

public class Task {
	
	private int id;
	private String taskname;
	private LocalDate duedate;
	//private String user_assigned_id;
	private User userId;
	
	
	public Task() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTaskname() {
		return taskname;
	}


	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}


	public LocalDate getDuedate() {
		return duedate;
	}


	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}


	public User getuserId() {
		return userId;
	}


	public void setuserId(User userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", taskname=" + taskname + ", duedate=" + duedate + ", user_assigned_id="
				+ userId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		result = prime * result + id;
		result = prime * result + ((taskname == null) ? 0 : taskname.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		if (id != other.id)
			return false;
		if (taskname == null) {
			if (other.taskname != null)
				return false;
		} else if (!taskname.equals(other.taskname))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
	
	

}
