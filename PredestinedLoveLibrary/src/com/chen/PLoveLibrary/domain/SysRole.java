package com.chen.PLoveLibrary.domain;

import java.io.Serializable;

/**
   * @类 名： sysRole
   * @功能描述： TODO 角色
   * @作者信息： 陈强
   * @创建时间： 2018年4月21日下午9:35:27
   * @修改备注：
   */
@SuppressWarnings("serial")
public class SysRole implements Serializable{
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
