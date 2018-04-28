package com.chen.PLoveLibrary.domain;

import java.io.Serializable;

/**
   * @类 名： SysRP
   * @功能描述： TODO 角色和权限
   * @作者信息： 陈强
   * @创建时间： 2018年4月21日下午9:29:20
   * @修改备注：
   */
@SuppressWarnings("serial")
public class SysRP implements Serializable{
	private String roleName;
	private String perName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	

}
