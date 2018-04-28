package com.chen.PLoveLibrary.domain;

import java.io.Serializable;
import java.util.Date;

/**
   * @类 名： SysUser
   * @功能描述： TODO 系统用户信息相当于shiro的subject
   * @作者信息： 陈强
   * @创建时间： 2018年4月14日下午9:04:39
   * @修改备注：
   */
@SuppressWarnings("serial")
public class SysUser implements Serializable {
	private String username;
	private String password;
	private String identity;
	private Date date;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	

}
