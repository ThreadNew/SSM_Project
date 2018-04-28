package com.chen.PLoveLibrary.domain;

import java.io.Serializable;

/**
   * @类 名： sysPermission
   * @功能描述： TODO 权限
   * @作者信息： 陈强
   * @创建时间： 2018年4月21日下午9:36:22
   * @修改备注：
   */
@SuppressWarnings("serial")
public class SysPermission implements Serializable{
	private String perName;

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}
	

}
