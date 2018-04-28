package com.chen.PLoveLibrary.domain;

import java.io.Serializable;

/**
   * @类 名： SysUR
   * @功能描述： TODO 用户和角色
   * @作者信息： 陈强
   * @创建时间： 2018年4月21日下午9:20:29
   * @修改备注：
   */
@SuppressWarnings("serial")
public class SysUR implements Serializable{
	private int id;
	private String userName;
	private String roleName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
