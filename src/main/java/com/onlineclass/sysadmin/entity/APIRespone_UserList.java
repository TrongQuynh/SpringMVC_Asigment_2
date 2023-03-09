package com.onlineclass.sysadmin.entity;


public class APIRespone_UserList<T> {
	 private int totalPage;
	 private int currentPage;
	 private T userList;
	 
	public APIRespone_UserList(int totalPage, int currentPage, T userList) {
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.userList = userList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public T getUserList() {
		return userList;
	}

	public void setUserList(T userList) {
		this.userList = userList;
	}
	
	
	
}
