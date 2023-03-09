package com.onlineclass.sysadmin.entity;


public class APIRespone_UserList<T> {
	 private int totalPage;
	 private int currentPage;
	 private String sortType;
	 private T userList;
	 
	public APIRespone_UserList(int totalPage, int currentPage, String sortType, T userList) {
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.userList = userList;
		this.sortType = sortType;
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

	public String getSortType() {
		return sortType;
	}

	public void setSortBy(String sortType) {
		this.sortType = sortType;
	}
	
	
	
}
