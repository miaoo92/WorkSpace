package com.demo.bean;

public class MessageBean {
	
	private String moduleName;
	private int pageSize;
	private String username;
	private String password;
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute(){
		System.out.println("moduleName="+moduleName);
		System.out.println("pageSize="+pageSize);
		System.out.println("username="+username);
		System.out.println("password="+password);
		System.out.println("----------list信息如下-----------");
		return "success";
	}
	
}
