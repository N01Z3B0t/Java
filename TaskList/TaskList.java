package edu.orangecoastcollege.ereynoso7.IC25;

import java.io.Serializable;

public class TaskList implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8341544057691139025L;
	private String deadline;
	private String dueDate;
	private String name;
	private int priority;
	
	public TaskList(String name, String dueDate, String deadline, int priority)
	{
		this.name = name;
		this.dueDate = dueDate;
		this.deadline = deadline;
		this.priority = priority;
	}
	
	public TaskList(TaskList other)
	{
		name = other.name;
		dueDate = other.dueDate;
		deadline = other.deadline;
		priority = other.priority;
	}
	
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Task [name = " + name + ", dueDate = " + dueDate + ", deadline = " + deadline + ", priority " + priority + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priority;
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
		TaskList other = (TaskList) obj;
		if (deadline == null) {
			if (other.deadline != null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority != other.priority)
			return false;
		return true;
	}
	
	
}
